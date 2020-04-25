package com.httppoolmanager.singleton;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

//1st http pool manager obj
//2nd http client and return
public class ClosableHttpClientObj {

	private static CloseableHttpClient httpclient;

	public static CloseableHttpClient getInstance(){
		if(httpclient == null) {
			synchronized (CloseableHttpClient.class) {
				if (httpclient == null) {
					createHttpClient();
				}
			}
		}
		return httpclient;
	}

	private static void createHttpClient() {
		try {
			SSLContext sslContext = SSLContextBuilder
					.create()
					.loadTrustMaterial(new TrustSelfSignedStrategy())
					.build();

			HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
			
			SSLConnectionSocketFactory connectionFactory = 
					new SSLConnectionSocketFactory(sslContext, allowAllHosts);
			
			PoolingHttpClientConnectionManager httpClientConnectionManager = 
					new PoolingHttpClientConnectionManager();

			httpclient = HttpClients
					.custom()
					.setSSLSocketFactory(connectionFactory)
					.setConnectionManager(httpClientConnectionManager)//2
					.build();
			
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
	}

}

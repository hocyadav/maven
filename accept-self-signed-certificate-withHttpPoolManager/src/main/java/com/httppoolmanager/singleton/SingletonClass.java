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
//2nd http cline
public class SingletonClass {
	//1. private instance
	//private static SingletonClass instance;

	private static PoolingHttpClientConnectionManager httpClientConnectionManager;
	private static CloseableHttpClient httpclient;

	private SingletonClass() {

		SSLContext sslContext;
		try {
			sslContext = SSLContextBuilder
					.create()
					.loadTrustMaterial(new TrustSelfSignedStrategy())
					.build();
			
			HostnameVerifier allowAllHosts = new NoopHostnameVerifier();
			
			SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);
			
			httpClientConnectionManager = new PoolingHttpClientConnectionManager();
			httpClientConnectionManager.setMaxTotal(200);
			httpClientConnectionManager.setDefaultMaxPerRoute(20);
			
			httpclient = HttpClients
					.custom()
					.setSSLSocketFactory(connectionFactory)
					.setConnectionManager(httpClientConnectionManager)//2
					.build();
		} catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e) {
			e.printStackTrace();
		}


	}

	private static class SingletonHelper{
		private static final SingletonClass INSTANCE = new SingletonClass();
	}

	public static SingletonClass getInstance(){
		return SingletonHelper.INSTANCE;
	}

}

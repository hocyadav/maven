package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class HttpClientAcceptSelfSignedCertificate {
	public static void main(String... args) throws JsonProcessingException, UnsupportedEncodingException  {

		try (CloseableHttpClient httpclient = createAcceptSelfSignedCertificateClient()) {
			HttpGet httpget = new HttpGet("https://example.com");//DONE

			CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpget);
			System.out.println("status line : "+closeableHttpResponse.getStatusLine());

			HttpEntity httpEntity = closeableHttpResponse.getEntity();
			String body = EntityUtils.toString(httpEntity);
			System.out.println(body);

			System.out.println("----------------------------------------");
		} catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static CloseableHttpClient createAcceptSelfSignedCertificateClient()
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

		SSLContext sslContext = SSLContextBuilder
				.create()
				.loadTrustMaterial(new TrustSelfSignedStrategy())
				.build();

		HostnameVerifier allowAllHosts = new NoopHostnameVerifier();

		SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);

		//TODO : add http pool manager
		//1.create pool obj
		//2. add to httpclient obj
		
		PoolingHttpClientConnectionManager httpClientConnectionManager = 
				new PoolingHttpClientConnectionManager();//1
		
		return HttpClients
				.custom()
				.setSSLSocketFactory(connectionFactory)
				.setConnectionManager(httpClientConnectionManager)//2
				.build();
	}
}

package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.httppoolmanager.singleton.ClosableHttpClientObj;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class HttpClientAcceptSelfSignedCertificate2 {
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

		CloseableHttpClient instance = ClosableHttpClientObj.getInstance();
		
		return instance;
	}
}

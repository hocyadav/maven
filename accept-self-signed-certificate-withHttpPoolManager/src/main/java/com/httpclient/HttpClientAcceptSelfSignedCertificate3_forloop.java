package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.httppoolmanager.singleton.ClosableHttpClientObj;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class HttpClientAcceptSelfSignedCertificate3_forloop {
	public static void main(String... args) throws JsonProcessingException, UnsupportedEncodingException  {

		for(int i = 0; i < 2; i++) {
			try {
				CloseableHttpClient httpclient = ClosableHttpClientObj.getInstance();
				System.out.println("\nhttpclient obj "+httpclient);
				HttpGet httpget = new HttpGet("https://example.com");//DONE
				
				CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpget);
				
				System.out.println("status line : "+closeableHttpResponse.getStatusLine());
				HttpEntity httpEntity = closeableHttpResponse.getEntity();
				
				String body = EntityUtils.toString(httpEntity);
				System.out.println(body);
				closeableHttpResponse.close();
				System.out.println("----------------------------------------");
				
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

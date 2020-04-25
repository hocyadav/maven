package com.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.httppoolmanager.singleton.ClosableHttpClientObj;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
/**
 * 
 * @author Hariom Yadav | 25-Apr-2020
 *
 */
public class HttpClientAcceptSelfSignedCertificate4_forloop_thread {
	public static void main(String... args) throws JsonProcessingException, UnsupportedEncodingException  {

		for (int i = 0; i < 2; i++) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					try {
						CloseableHttpClient httpclient = ClosableHttpClientObj.getInstance();//always get same obj
						System.out.println("\nThread name : "+Thread.currentThread().getName()+"\nhttpclient obj : "+httpclient);
						
						HttpGet httpget = new HttpGet("http://example.com");//DONE
						CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpget);
						
						System.out.println("status line : "+closeableHttpResponse.getStatusLine());
						HttpEntity httpEntity = closeableHttpResponse.getEntity();
						
						String body = EntityUtils.toString(httpEntity);
						System.out.println(body);
						closeableHttpResponse.close();
						System.out.println("----------------------------------------");
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			thread.start();
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}
}

package com.httpclient;

import org.apache.http.impl.client.CloseableHttpClient;

import com.httppoolmanager.singleton.ClosableHttpClientObj;

public class TestSingleton {
	public static void main(String[] args) {
		CloseableHttpClient instance = ClosableHttpClientObj.getInstance();
		CloseableHttpClient instance2 = ClosableHttpClientObj.getInstance();
		
		System.out.println(instance);
		System.out.println(instance2);
		
		for (int i = 0; i < 10; i++) {
			CloseableHttpClient instance3 = ClosableHttpClientObj.getInstance();
			System.out.println(instance3);
		}
	}
}

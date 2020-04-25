package http_pool_manager.pooling;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class SingleThread_usingPooling3_forloopThread2 {
	public static void main(String[] args) throws ClientProtocolException, IOException, InterruptedException {
		//1 - two url - ouside for loop : common for all req since here req is same url, but we can send this url inside for loop also
		HttpGet httpget = new HttpGet("http://www.example.com");//working
		
		//2 - pool obj - common for all thread
//		HttpClientConnectionManager httpClientConnectionManager = 
//				new PoolingHttpClientConnectionManager();//not working
		
		PoolingHttpClientConnectionManager httpClientConnectionManager = 
				new PoolingHttpClientConnectionManager();//working
		
		//updating - pool manager obj values
		//1st change type  HttpClientConnectionManager --> PoolingHttpClientConnectionManager
		//A. Increase max total connection to 200
		httpClientConnectionManager.setMaxTotal(200);
		
		//B. Increase default max connection per route to 20
		httpClientConnectionManager.setDefaultMaxPerRoute(20);
		
		//TODO :dont know what C step will do
		//C: Increase max connections for localhost:80 to 50
//		HttpHost localhost = new HttpHost("http://www.example.com", 80);
//		httpClientConnectionManager.setMaxPerRoute(new HttpRoute(localhost), 50);
		

		CloseableHttpClient client = HttpClients.custom()
				.setConnectionManager(httpClientConnectionManager)
				.build();
		
		for (int i = 0; i < 5; i++) {
			MultiHttpClientConnThread thread = 
					new MultiHttpClientConnThread(client, httpget);
			thread.start();
			thread.join();//TODO : what is use in conn manager and what it will effect if we comment
		}
		
	}
}


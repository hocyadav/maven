package http_pool_manager.pooling;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class SingleThread_usingPooling2thread {
	public static void main(String[] args) throws ClientProtocolException, IOException, InterruptedException {
		//1 - two url
		HttpGet httpget1 = new HttpGet("http://www.example.com");//working
		HttpGet httpget2 = new HttpGet("http://www.example.com");//working
		
		//2 - pool obj
		HttpClientConnectionManager httpClientConnectionManager = 
				new PoolingHttpClientConnectionManager();//working

		//3 - two http clinet obj  - each for each url
		CloseableHttpClient client1 = HttpClients.custom()
				.setConnectionManager(httpClientConnectionManager)
				.build();
		CloseableHttpClient client2 = HttpClients.custom()
				.setConnectionManager(httpClientConnectionManager)
				.build();
		//4. two thread
		MultiHttpClientConnThread thread1 = 
				new MultiHttpClientConnThread(client1, httpget1);
		MultiHttpClientConnThread thread2 = 
				new MultiHttpClientConnThread(client2, httpget2);
		//5. start two thread
		thread1.start();
		thread2.start();
		
		//6. join 
		thread1.join();
		thread2.join();
	}
}

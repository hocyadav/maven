package http_pool_manager.pooling;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class MultiHttpClientConnThread extends Thread{
	private CloseableHttpClient client;
	private HttpGet httpget;

	public MultiHttpClientConnThread(CloseableHttpClient client, HttpGet get) {
		super();
		this.client = client;
		this.httpget = get;
	}

	//1. cleint.execute()
	//2. consume that response object - i think after this automaticaly conn close
//	public void run() {
//		try {
//			System.out.println("\nThread name "+Thread.currentThread().getName());
//			HttpResponse response = client.execute(httpget);  
//			//CloseableHttpResponse response = client.execute(httpget);  
//		
//			//2. consume response Method 1 - this consume response and conenction is release to pool
//			//EntityUtils.consume(response.getEntity());//if below is running then comment this part
//			
//			//2. consume response method 2 - not sure conn is release back to pool or not
//			HttpEntity entity = response.getEntity();
//			String body = EntityUtils.toString(entity);
//			System.out.println(body);
//			System.out.println("################### Server Response Completed #####################\n");
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	public void run() {
		try {
			System.out.println("\nThread name "+Thread.currentThread().getName());
			//HttpResponse response = client.execute(httpget);  
			CloseableHttpResponse response = client.execute(httpget);//working 
			
			//EntityUtils.consume(response.getEntity());//if below is running then comment this part
			
			HttpEntity entity = response.getEntity();
			String body = EntityUtils.toString(entity);
			System.out.println(body);
			System.out.println("################### Server Response Completed #####################\n");
			//response.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}

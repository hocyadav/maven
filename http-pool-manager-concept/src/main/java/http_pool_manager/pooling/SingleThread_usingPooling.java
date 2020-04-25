package http_pool_manager.pooling;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class SingleThread_usingPooling {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClientConnectionManager httpClientConnectionManager = 
											new PoolingHttpClientConnectionManager();//working
		
//		PoolingHttpClientConnectionManager httpClientConnectionManager = 
//				new PoolingHttpClientConnectionManager();//working
		
		CloseableHttpClient client = HttpClients.custom()
					.setConnectionManager(httpClientConnectionManager)
					.build();
		
		HttpGet httpget = new HttpGet("http://www.example.com");//working
		//HttpGet httpget = new HttpGet("https://www.example.com");//working
		CloseableHttpResponse response = client.execute(httpget);
		
		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		System.out.println(body);
		
	}
}

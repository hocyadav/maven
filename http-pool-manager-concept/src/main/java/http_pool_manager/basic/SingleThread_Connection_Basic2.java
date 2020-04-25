package http_pool_manager.basic;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

public class SingleThread_Connection_Basic2 {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		BasicHttpClientConnectionManager connManager
		 = new BasicHttpClientConnectionManager();
		HttpRoute route = new HttpRoute(new HttpHost("www.example.com", 80));
		
		ConnectionRequest connRequest = connManager.requestConnection(route, null);
		
		//body from pooling -- start : working : but connreq obj where to use
		CloseableHttpClient client = HttpClients.custom()
				.setConnectionManager(connManager)
				.build();
		
		HttpGet httpget = new HttpGet("http://www.example.com");//working
		CloseableHttpResponse response = client.execute(httpget);
		
		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		System.out.println(body);
		//-- end
		
		
	}
}

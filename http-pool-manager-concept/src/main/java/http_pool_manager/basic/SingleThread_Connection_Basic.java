package http_pool_manager.basic;

import org.apache.http.HttpHost;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;

public class SingleThread_Connection_Basic {
	public static void main(String[] args) {
		BasicHttpClientConnectionManager connManager
		 = new BasicHttpClientConnectionManager();
		HttpRoute route = new HttpRoute(new HttpHost("www.example.com", 80));
		
		ConnectionRequest connRequest = connManager.requestConnection(route, null);
		
		
		
	}
}

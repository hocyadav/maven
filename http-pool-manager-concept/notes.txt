HTTP Pool managermet - ahrish

TODAY :
1.- HttpClient Connection Management - article
	- PoolingHttpClientConnectionManager


2.- search %% HttpClient Connection Management

3.- search %% PoolingHttpClientConnectionManager

4.- read official doc about - PoolingHttpClientConnectionManager
	- https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/conn/PoolingHttpClientConnectionManager.html

##################################################
-- https://www.codota.com/code/java/methods/org.apache.http.impl.conn.BasicHttpClientConnectionManager/%3Cinit%3E

private HttpClientConnectionManager getHttpConnManager(Config config) {
 HttpClientConnectionManager httpConnManager;
 String connMgrStr = config.getString(HTTP_CONN_MANAGER);
 switch (ConnManager.valueOf(connMgrStr.toUpperCase())) {
  case BASIC:
   httpConnManager = new BasicHttpClientConnectionManager();
   break;
  case POOLING:
   PoolingHttpClientConnectionManager poolingConnMgr = new PoolingHttpClientConnectionManager();
   poolingConnMgr.setMaxTotal(config.getInt(POOLING_CONN_MANAGER_MAX_TOTAL_CONN));
   poolingConnMgr.setDefaultMaxPerRoute(config.getInt(POOLING_CONN_MANAGER_MAX_PER_CONN));
   httpConnManager = poolingConnMgr;
   break;
  default:
   throw new IllegalArgumentException(connMgrStr + " is not supported");
 }
 LOG.info("Using " + httpConnManager.getClass().getSimpleName());
 return httpConnManager;
}

Q : after above code - check how to use http conn manager obj

1. above method return type HttpClientConnectionManager 
	--> store both BasicHttpClientConnectionManager + PoolingHttpClientConnectionManager obj

------------------------------------------------
GOAL :  input  HttpClientConnectionManager obj ~ (BasicHttpClientConnectionManager / PoolingHttpClientConnectionManager)
		output : CloseableHttpClient obj / http clinet obj

1: if object is BasicHttpClientConnectionManager 

Method 1 :BasicHttpClientConnectionManager --> CloseableHttpClient

private CloseableHttpClient createHttpClient() throws AzkabanClientException {
 try {
 // SSLSocketFactory using custom TrustStrategy that ignores warnings about untrusted certificates
 // Self sign SSL
 SSLContextBuilder sslcb = new SSLContextBuilder();
 sslcb.loadTrustMaterial(null, (TrustStrategy) new TrustSelfSignedStrategy());
 SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcb.build());
 HttpClientBuilder builder = HttpClientBuilder.create();
 RequestConfig requestConfig = RequestConfig.copy(RequestConfig.DEFAULT)
    .setSocketTimeout(10000)
    .setConnectTimeout(10000)
    .setConnectionRequestTimeout(10000)
    .build();
  builder.disableCookieManagement()
    .useSystemProperties()
    .setDefaultRequestConfig(requestConfig)
    .setConnectionManager(new BasicHttpClientConnectionManager())
    .setSSLSocketFactory(sslsf);
  return builder.build();
 } catch (Exception e) {
  throw new AzkabanClientException("HttpClient cannot be created", e);
 }
}

Method 2: BasicHttpClientConnectionManager --> HttpClientConnection --> ?? CloseableHttpClient
INFO : HttpClientConnection by using this we can execute request

HttpClientContext context = HttpClientContext.create();
HttpClientConnectionManager connMrg = new BasicHttpClientConnectionManager();
HttpRoute route = new HttpRoute(new HttpHost("localhost", 80));
// Request new connection. This can be a long process
ConnectionRequest connRequest = connMrg.requestConnection(route, null);
// Wait for connection up to 10 sec
HttpClientConnection conn = connRequest.get(10, TimeUnit.SECONDS);
try {
    // If not open
    if (!conn.isOpen()) {
        // establish connection based on its route info
        connMrg.connect(conn, route, 1000, context);
        // and mark it as route complete
        connMrg.routeComplete(conn, route, context);
    }
    // Do useful things with the connection.
} finally {
    connMrg.releaseConnection(conn, null, 1, TimeUnit.MINUTES);
}

---------
2 if Object is PoolingHttpClientConnectionManager --> http://hc.apache.org/httpcomponents-client-ga/tutorial/html/connmgmt.html
Solution : 

PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
// Increase max total connection to 200
cm.setMaxTotal(200);
// Increase default max connection per route to 20
cm.setDefaultMaxPerRoute(20);
// Increase max connections for localhost:80 to 50
HttpHost localhost = new HttpHost("locahost", 80);
cm.setMaxPerRoute(new HttpRoute(localhost), 50);

CloseableHttpClient httpClient = HttpClients.custom()
        .setConnectionManager(cm)
        .build();

Method 2: shortcut 
PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
CloseableHttpClient httpClient = HttpClients.custom()
        .setConnectionManager(cm)
        .build();

INFO:we can add after pool obj -- below line
cm.setMaxTotal(200);
cm.setDefaultMaxPerRoute(20);
HttpHost localhost = new HttpHost("locahost", 80);
cm.setMaxPerRoute(new HttpRoute(localhost), 50);

-------



package com.memorynotfound.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.memorynotfound.httpclient.beans.Body;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * This example demonstrates the use of {@link HttpGet} request method.
 */
public class HttpClientAcceptSelfSignedCertificate {

    public static void main(String... args) throws JsonProcessingException, UnsupportedEncodingException  {
    	//1. body obj : DONE
    	//2. obj to jason string
    	//3. jason string to string Entity obj
    	//4. add string Entity obj in httpPost.setEntity
    		
    	Body obj = new Body();//1
    	obj.setName("name 1");
    	obj.setId(123);
    	
    	String jStr = Util.bodyToJsonStr(obj);//2
    	System.out.println("jstr : "+jStr);
    	
    	StringEntity stringEntity = new StringEntity(jStr);//3

        try (CloseableHttpClient httpclient = createAcceptSelfSignedCertificateClient()) {
            //HttpGet httpget = new HttpGet("https://example.com");//DONE
            //HttpGet httpget = new HttpGet("https://localhost:8081/hello");//DONE
            HttpPost httpget = new HttpPost("https://localhost:8081/hello");//DONE
            //HttpGet httpget = new HttpGet("https://www.google.com");//DONE
            httpget.setEntity(stringEntity);//4
            httpget.setHeader("Accept", "application/json");//5 if we are sending json as request then this is required else error
    		httpget.setHeader("Content-type", "application/json");//5 if we are sending json then this is also required 
            
            System.out.println("Executing request : " + httpget.getRequestLine());

            CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpget);
            System.out.println("status line : "+closeableHttpResponse.getStatusLine());
            
            HttpEntity httpEntity = closeableHttpResponse.getEntity();
            String body = EntityUtils.toString(httpEntity);
            System.out.println(body);
            
            System.out.println("----------------------------------------");
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static CloseableHttpClient createAcceptSelfSignedCertificateClient()
            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {

    	//1.
        // use the TrustSelfSignedStrategy to allow Self Signed Certificates
        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial(new TrustSelfSignedStrategy())
                .build();

        //2.
        // we can optionally disable hostname verification.
        // if you don't want to further weaken the security, you don't have to include this.
        HostnameVerifier allowAllHosts = new NoopHostnameVerifier();

        //3.
        // create an SSL Socket Factory to use the SSLContext with the trust self signed certificate strategy
        // and allow all hosts verifier.
        SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);

        // finally create the HttpClient using HttpClient factory methods and assign the ssl socket factory
        return HttpClients
                .custom()
                .setSSLSocketFactory(connectionFactory)
                .build();
    }
}

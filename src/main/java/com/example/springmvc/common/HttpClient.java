package com.example.springmvc.common;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        get();
    }


    /**
     * 不带参数的get请求
     * @throws IOException
     */
    public static void get() throws IOException {
        //创建一个httpClient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建get请求对象
        HttpGet get = new HttpGet("http://www.baidu.com");
        //发送请求，获取响应
        CloseableHttpResponse response = client.execute(get);
        //获取相应内容
        HttpEntity entity = response.getEntity();
        String s = EntityUtils.toString(entity,"utf-8");
        System.out.println(s);
        client.close();
    }
}

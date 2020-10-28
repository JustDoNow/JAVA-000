package com.qz;

import java.io.IOException;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * HttpClientTest
 *
 * @author qizhi
 * @date 2020/10/28
 */
public class HttpClientTest {

	public static void main(String[] args) {
		System.out.println(test());
	}

	public static Object test() {
		OkHttpClient httpClient = new OkHttpClient();
//		String url = "http://localhost:8801";
		String url = "http://www.baidu.com";
		Request request = new Request.Builder().url(url).build();
		Call call = httpClient.newCall(request);
		try {
			Response response = call.execute();
			return response.body().string();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}

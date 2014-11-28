package com.adj.spider.wspider;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class DownLoadFile {

	public String getFileNameByUrl(String url, String contentType) {
		// 移除http：
		url = url.substring(7);

		// text/html类型
		if (contentType.indexOf("heml") != -1) {
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
			return url;
		} else {
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + "."
					+ contentType.substring(contentType.lastIndexOf("/") + 1);
			return url;
		}
	}

	/**
	 * 保存网页字节数组到本地
	 */
	private void saveToLocale(byte[] data, String filePath) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(
					new File(filePath)));
			for (int i = 0; i < data.length; i++)
				out.write(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 下载url指向的网页
	public String downLoadFile(String url) {
//		String filePath = null;
		String result = null;
		HttpClient httpClient = HttpClientBuilder.create().build();
		// 设置http链接超时5s  java.lang.UnsupportedOperationException
//		httpClient.getParams().setParameter("http.socket.timeout", 5 * 1000);
//		httpClient.getParams()
//				.setParameter("http.connection.timeout", 5 * 1000);
		// 生成GetMethod对象
		HttpGet getMethod = new HttpGet(url);

		try {
			HttpResponse response = httpClient.execute(getMethod);
			// 获取服务器端返回的状态码是否等于200
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				result = EntityUtils.toString(response.getEntity());// 调用getEntity获取返回值，需通过EntityUtils把实体转成String
			} else {
				result = response.getStatusLine().toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getMethod.releaseConnection();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(new DownLoadFile().downLoadFile("http://www.baidu.com"));
	}

}

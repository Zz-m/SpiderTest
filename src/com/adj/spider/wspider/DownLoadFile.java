package com.adj.spider.wspider;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.client.HttpClient;

public class DownLoadFile {
	
	public String getFileNameByUrl(String url, String contentType) {
		//�Ƴ�http��
		url = url.substring(7);
		
		//text/html����
		if(contentType.indexOf("heml") != -1) {
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
			return url;
		} else {
			url = url.replaceAll("[\\?/:*|<>\"]", "_") + "." + 
					contentType.substring(contentType.lastIndexOf("/") + 1);
			return url;
		}
	}
	
	/**
	 * ������ҳ�ֽ����鵽����
	 */
	private void saveToLocale(byte[] data, String filePath) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(filePath)));
			for (int i = 0; i < data.length; i++)
				out.write(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//����urlָ�����ҳ
	public String downLoadFile(String url) {
		String filePath = null;
		//HttpClient httpClient = new ;
		return null;
	}

}

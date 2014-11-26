package com.adj.spider.wspider;

import java.util.HashSet;
import java.util.Set;

public class LinkQueue {
	
	//�ѷ���url����
	private static Set<String> visitedUrl = new HashSet<String>();
	
	//������url����
	private static Queue unVisitedUrl = new Queue();
	
	//���url����
	public static Queue getUnVisitedUrl() {
		return unVisitedUrl;
	}
	
	//��ӵ����ʹ���url��
	public static void addVisitedUrl(String url) {
		visitedUrl.add(url);
	}
	
	//�Ƴ����ʹ���url
	public static void removeVisitedUrl(String url) {
		visitedUrl.remove(url);
	}
	
	//δ���ʵ�url������
	public static Object unVisitedUrlDeQueue() {
		return unVisitedUrl.deQueue();
	}
	
	//��֤ÿ��urlֻ������һ��
	public static void addUnVisitedUrl(String url) {
		if(url != null && !url.trim().equals("") && !visitedUrl.contains(url) && !unVisitedUrl.contains(url)) {
			unVisitedUrl.enQueue(url);
		}
	}
	
	//��ȡ�ѷ���url��Ŀ
	public static int getVisitedUrlNum() {
		return visitedUrl.size();
	}
	
	//�ж�δ����url�����Ƿ�Ϊ��
	public static boolean unVisitedUrlEmpty() {
		return unVisitedUrl.isEmpty();
	}

}

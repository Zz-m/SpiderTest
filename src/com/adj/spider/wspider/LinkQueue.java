package com.adj.spider.wspider;

import java.util.HashSet;
import java.util.Set;

public class LinkQueue {
	
	//已访问url集合
	private static Set<String> visitedUrl = new HashSet<String>();
	
	//待访问url集合
	private static Queue unVisitedUrl = new Queue();
	
	//获得url队列
	public static Queue getUnVisitedUrl() {
		return unVisitedUrl;
	}
	
	//添加到访问过的url中
	public static void addVisitedUrl(String url) {
		visitedUrl.add(url);
	}
	
	//移除访问过的url
	public static void removeVisitedUrl(String url) {
		visitedUrl.remove(url);
	}
	
	//未访问的url出队列
	public static Object unVisitedUrlDeQueue() {
		return unVisitedUrl.deQueue();
	}
	
	//保证每个url只被访问一次
	public static void addUnVisitedUrl(String url) {
		if(url != null && !url.trim().equals("") && !visitedUrl.contains(url) && !unVisitedUrl.contains(url)) {
			unVisitedUrl.enQueue(url);
		}
	}
	
	//获取已访问url数目
	public static int getVisitedUrlNum() {
		return visitedUrl.size();
	}
	
	//判断未访问url队列是否为空
	public static boolean unVisitedUrlEmpty() {
		return unVisitedUrl.isEmpty();
	}

}

package com.adj.spider.prefspider;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 偏好爬虫，PriorityQueue实现
 * @author adj
 *
 */
public class LinkQueue {
	private static Set<String> visitedUrl = new HashSet<String>();
	private static Queue<String> unVisitedUrl = new PriorityQueue<String>();
	
	public static Queue getUnVisitedUrl() {
		return unVisitedUrl;
	}
	
	public static void addVisitedUrl(String url) {
		visitedUrl.add(url);
	}
	
	public static void removeVisitedUrl(String url) {
		visitedUrl.remove(url);
	}
	
	public static String unVisitedUrlDeQueue() {
		return unVisitedUrl.poll();
	}
	
	public static void addUnVisitedUrl(String url) {
		if(url != null && !url.trim().equals("") && !visitedUrl.contains(url) && !unVisitedUrl.contains(url)) {
			unVisitedUrl.add(url);
		}
	}
	
	public static int getVisitedUrlNum() {
		return visitedUrl.size();
	}
	
	public static boolean unVisitedUrlEmpty() {
		return unVisitedUrl.isEmpty();
	}

}

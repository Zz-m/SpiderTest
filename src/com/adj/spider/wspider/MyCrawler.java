package com.adj.spider.wspider;

import java.util.Set;

public class MyCrawler {
	/**
	 * 使用种子初始化 URL 队列
	 * @return
	 * @param seeds 种子 URL
	 */
	private void initCrawlerWithSeeds(String[] seeds) {
		for (String seed : seeds) {
			LinkQueue.addUnVisitedUrl(seed);
		}
	}
	
	/**
	 * 抓取过程
	 */
	public void crawling(String[] seeds) {
		// 自定义过滤器，可以过滤 url
		LinkFilter filter = new LinkFilter() {

			@Override
			public boolean accept(String url) {
				return true;
			}
			
		};
		
		initCrawlerWithSeeds(seeds);
		
		while(!LinkQueue.unVisitedUrlEmpty() && LinkQueue.getVisitedUrlNum() <= 1000) {
			try {
				String url = (String) LinkQueue.unVisitedUrlDeQueue();
				System.out.println("当前访问：" + url);
				if (url == null)
					continue;
				DownLoadFile downLoader = new DownLoadFile();
				//下载网页
				downLoader.downLoadFile(url);
				//放入已访问 url
				LinkQueue.addVisitedUrl(url);
				//提取出该网页中的url
				Set<String> links = HtmlParserTool.extracLinks(url, filter);
				//新的未访问 url 入队
				for (String link : links)
					LinkQueue.addUnVisitedUrl(link);

				System.out.println("已访问：" + LinkQueue.getVisitedUrlNum() + " 条");
				System.out.println("访问队列有：" + LinkQueue.getUnVisitedUrlNum() + " 条");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyCrawler crawler = new MyCrawler();
		crawler.crawling(new String[] {"http://www.163.com"});
	}

}

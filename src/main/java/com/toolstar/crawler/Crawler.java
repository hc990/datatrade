package com.toolstar.crawler;

import java.net.URL;
import java.util.List;

public interface Crawler extends Runnable {
	
	
	/**
	 * ����ĳһ��page
	 * @author noname
	 * @param Url
	 * @return String
	 * */
	String downloadPage(URL pageUrl);
	
	
	/**
	 * ִ�й������̽���������õ�url��¼��׼������Set������
	 * @author noname
	 * @param String
	 * @return   
	 * */
	List<String> search(String mainUrl);
	
	
	/**
	 * ִ�й������̽���������õ�url��¼��׼������Set������
	 * @author noname
	 * @param String
	 * @return   
	 * */
	void getPageInfo(List<String> urls);
	
	
	/**
	 * ���URL��ʽ(ֻ����HTTP)
	 * @param String
	 * @return URL
	 * */
	URL verifyUrl(String url);
}

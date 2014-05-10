package com.toolstar.crawler;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mongodb.BasicDBObject;
import com.toolstar.crawler.dto.Commodity;
import com.toolstar.crawler.dto.DomInfo;


public interface CrawlerPage {

	/**
	 * ��ȡhtml���������
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<DomInfo> getMainHtmlInfo(Document doc,String className, String delim);

	/**
	 * ��ȡhtml���������
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<DomInfo> getHtmlInfo(Element link, String className, String delim);

	/**
	 * ��ȡhtml���������
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<DomInfo> getHtmlInfo(Element link, String delim);

	/**
	 * ��ȡ������ҳ��������
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<DomInfo> getSubHtmlInfo(Document doc,String id, String delim);

	/**
	 * ��ȡ����ҳ��������
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<Commodity> getSubSubHtmlInfo(Document doc,String id, String delim, String delim2);

	/**
	 * ��ȡ(���)��ҳ��������
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	void getSubMoreHtmlInfo(Document doc,List<DomInfo> rtnList,
			String id, String delim);
	
	
	BasicDBObject getDetailHtmlInfo(Document doc, String id);

}

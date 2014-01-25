package crawler;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.mongodb.BasicDBObject;

import crawler.dto.Commodity;
import crawler.dto.DomInfo;

public interface CrawlerPage {

	/**
	 * 提取html中有用数据
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<DomInfo> getMainHtmlInfo(Document doc,String className, String delim);

	/**
	 * 提取html中有用数据
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<DomInfo> getHtmlInfo(Element link, String className, String delim);

	/**
	 * 提取html中有用数据
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<DomInfo> getHtmlInfo(Element link, String delim);

	/**
	 * 提取二级子页面分类数据
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<DomInfo> getSubHtmlInfo(Document doc,String id, String delim);

	/**
	 * 提取三级子页面分类数据
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	List<Commodity> getSubSubHtmlInfo(Document doc,String id, String delim, String delim2);

	/**
	 * 提取(更多)子页面分类数据
	 * 
	 * @author noname
	 * @param String
	 * @return
	 * */
	void getSubMoreHtmlInfo(Document doc,List<DomInfo> rtnList,
			String id, String delim);
	
	
	BasicDBObject getDetailHtmlInfo(Document doc, String id);

}

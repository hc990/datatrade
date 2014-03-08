package crawler;

import java.net.URL;
import java.util.List;

import com.mongodb.BasicDBObject;

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
	BasicDBObject getPageInfo(String url);
	
	
	/**
	 * ���URL��ʽ(ֻ����HTTP)
	 * @param String
	 * @return URL
	 * */
	URL verifyUrl(String url);
	
	/**
	 * 最终分类
	 * @param String
	 * @return void
	 * */
	void getSubCategoryInfo(List<String> urls);
	
	/**
	 * 缩略商品数据
	 * @param String
	 * @return void
	 * */
	void getAbstractPageInfo(List<String> urls);
}

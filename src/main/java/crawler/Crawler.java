package crawler;

import java.net.URL;
import java.util.List;

public interface Crawler extends Runnable {
	
	
	/**
	 * 下载某一个page
	 * @author noname
	 * @param Url
	 * @return String
	 * */
	String downloadPage(URL pageUrl);
	
	
	/**
	 * 执行广度优先探索，将有用的url记录到准备爬的Set集合中
	 * @author noname
	 * @param String
	 * @return   
	 * */
	List<String> search(String mainUrl);
	
	
	/**
	 * 执行广度优先探索，将有用的url记录到准备爬的Set集合中
	 * @author noname
	 * @param String
	 * @return   
	 * */
	void getPageInfo(List<String> urls);
	
	
	/**
	 * 检测URL格式(只处理HTTP)
	 * @param String
	 * @return URL
	 * */
	URL verifyUrl(String url);
}

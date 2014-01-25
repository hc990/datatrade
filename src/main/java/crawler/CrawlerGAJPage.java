package crawler;

//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

import crawler.dto.Commodity;
import crawler.dto.DomInfo;

public class CrawlerGAJPage implements CrawlerPage {

	private String mainUrl = "http://item.grainger.cn";

	// @Override
	// public void getUrlInfo(URL url) {
	// String host = url.getHost().toLowerCase();
	// URL robotsFileUrl = new URL("http://" + host + "/robots.txt");
	// BufferedReader reader = new BufferedReader(new InputStreamReader(
	// robotsFileUrl.openStream()));
	// String line;
	// while ((line = reader.readLine()) != null) {
	// if (line.indexOf("Disallow:") == 0) {// 是否包含"Disallow:"
	// String disallowPath = line.substring("Disallow:".length());// 获取不允许访问路径
	//
	// // 检查是否有注释。
	// int commentIndex = disallowPath.indexOf("#");
	// if (commentIndex != -1) {
	// disallowPath = disallowPath.substring(0, commentIndex);// 去掉注释
	// }
	//
	// disallowPath = disallowPath.trim();
	// disallowList.add(disallowPath);
	// }
	// }
	// // TODO Auto-generated method stub

	@Override
	public List<DomInfo> getMainHtmlInfo(Document doc, String className,
			String delim) {
		List<DomInfo> returnList = new ArrayList<DomInfo>();
		Elements categorys = doc.getElementsByClass(className);
		for (Element category : categorys) {
			DomInfo di = new DomInfo();
			StringBuffer itemUrl = new StringBuffer(mainUrl);
			Element link = category.select(delim).first();
			String href = link.attr("href");
			String categoryUrl = itemUrl.append(href).toString();// 子超链
			String name = link.attr("name"); // 子超链编号
			String text = link.text(); // 子超链名称
			di.setCategory(category);
			di.setCategoryName(text);
			di.setGajCategory(name);
			di.setUrlAddress(categoryUrl);
			returnList.add(di);
		}
		return returnList;
	}

	@Override
	public List<DomInfo> getHtmlInfo(Element element, String delim) {
		List<DomInfo> returnList = new ArrayList<DomInfo>();
		Elements links = element.select("li > a");
		for (Element link : links) {
			DomInfo di = new DomInfo();
			StringBuffer itemUrl = new StringBuffer(mainUrl);
			String href = link.attr("href");
			String categoryUrl = itemUrl.append(href).toString();// 子超链
			String name = link.attr("name"); // //子超链编号
			String text = link.text(); // 子超链名称
			di.setCategory(link);
			di.setCategoryName(text);
			di.setGajCategory(name);
			di.setUrlAddress(categoryUrl);
			returnList.add(di);
		}
		return returnList;
	}

	// @Override
	// public void getCategoryInfo(String sb, String className, String delim) {
	// Document doc = Jsoup.parse(sb);
	// Elements categorys = doc.getElementsByClass("mall_category_list");
	// for (Element category : categorys) {
	// StringBuffer url = new StringBuffer(mainUrl);
	// Element link = category.select("h4 > a").first();
	// String href = link.attr("href");
	// String categoryUrl = url.append(href).toString();// 一级子超链
	// String name = link.attr("name"); // //一级子超链编号
	// String text = link.text(); // 一级子超链名称
	// /****/
	// System.out.println(categoryUrl);
	// System.out.println(name);
	// System.out.println(text);
	// /****/
	// Elements link2s = category.getElementsByClass("category_list");
	// for (Element link2 : link2s) {
	// url = new StringBuffer(mainUrl);
	// Element link3 = link2.select("h5 > a").first();
	// String href2 = link3.attr("href");
	// String categoryUrl2 = url.append(href2).toString();// 二级子超链
	// String name2 = link3.attr("name"); // //二级子超链编号
	// String text2 = link3.text(); // 二级子超链名称
	// /****/
	// System.out.println(categoryUrl2);
	// System.out.println(name2);
	// System.out.println(text2);
	// /****/
	// Elements link4s = link2.select("li > a");
	// for (Element link4 : link4s) {
	// String href3 = link4.attr("href");
	// url = new StringBuffer(mainUrl);
	// String categoryUrl3 = url.append(href3).toString();// 三级子超链
	// String name3 = link4.attr("name"); // //三级子超链编号
	// String text3 = link4.text(); // 三级子超链名称
	// /****/
	// System.out.println(categoryUrl3);
	// System.out.println(name3);
	// System.out.println(text3);
	// /****/
	// }
	// }
	// }
	// }

	@Override
	public List<DomInfo> getHtmlInfo(Element element, String className,
			String delim) {
		// TODO Auto-generated method stub
		List<DomInfo> returnList = new ArrayList<DomInfo>();
		Elements categorys = element.getElementsByClass(className);
		for (Element category : categorys) {
			DomInfo di = new DomInfo();
			StringBuffer itemUrl = new StringBuffer(mainUrl);
			Element link = category.select(delim).first();
			String href = link.attr("href");
			String categoryUrl = itemUrl.append(href).toString();// 子超链
			String name = link.attr("name"); // 子超链编号
			String text = link.text(); // 子超链名称
			di.setCategory(category);
			di.setCategoryName(text);
			di.setGajCategory(name);
			di.setUrlAddress(categoryUrl);
			returnList.add(di);
		}
		return returnList;
	}

	@Override
	public List<Commodity> getSubSubHtmlInfo(Document doc, String id,
			String delim, String delim2) {
		List<Commodity> commodities = new ArrayList<Commodity>();
		Elements categorys = doc.select(id);
		for (Element category : categorys) {
			Commodity commodity = new Commodity();
			Element productImage = category.select(delim).first();
			Element productNum = category.select(delim2).first();
			Element productPrice = category.select("div.grid_price_fromto")
					.first();
			Element productBrand = category.select("div.grid_manufacturers")
					.first();
			String href = productImage.select("a").first().attr("href");
			String imgUrl = productImage.select("img").first().attr("abs:src");
			String title = productImage.select("img").first().attr("title");
			StringBuffer itemUrl = new StringBuffer(mainUrl);
			String categoryUrl = itemUrl.append(href).toString();// 子超链
			String price = productPrice.text();
			String brand = productBrand.text();
			String number = productNum.text();
			commodity.setBrand(brand);
			commodity.setCategoryUrl(categoryUrl);
			commodity.setImgUrl(imgUrl);
			commodity.setNumber(number);
			commodity.setPrice(price);
			commodity.setTitle(title);
			commodities.add(commodity);
		}
		// TODO Auto-generated method stub
		return commodities;
	}

	@Override
	public void getSubMoreHtmlInfo(Document doc, List<DomInfo> rtnList,
			String id, String delim) {
		Element element = doc.getElementById(id);// split_list
		Elements categorys = element.select(delim);
		for (Element category : categorys) {
			DomInfo di = new DomInfo();
			StringBuffer itemUrl = new StringBuffer(mainUrl);
			String href = category.attr("href");
			String categoryUrl = itemUrl.append(href).toString();// 子超链
			String text = category.text(); // 子超链名称
			di.setCategory(category);
			di.setCategoryName(text);
			di.setCategoryNum(-1);
			di.setUrlAddress(categoryUrl);
			rtnList.add(di);
		}
	}

	@Override
	public List<DomInfo> getSubHtmlInfo(Document doc, String id, String delim) {
		List<DomInfo> returnList = new ArrayList<DomInfo>();
		Element element = doc.getElementById(id);// split_list
		Elements categorys = element.select(delim);
		for (Element category : categorys) {
			DomInfo di = new DomInfo();
			StringBuffer itemUrl = new StringBuffer(mainUrl);
			String href = category.attr("href");
			String categoryUrl = itemUrl.append(href).toString();// 子超链
			String text = category.text(); // 子超链名称
			// if (text != null && !"更多>>".equals(text)) {
			di.setCategory(category);
			di.setCategoryName(text);
			di.setCategoryNum(-1);
			di.setUrlAddress(categoryUrl);
			returnList.add(di);
			// }
		}
		return returnList;
	}

	@Override
	public BasicDBObject getDetailHtmlInfo(Document doc, String id) {
		//List<DomInfo> returnList = new ArrayList<DomInfo>();
		Element element = doc.getElementById(id);// product-intro
		String name = element.getElementById("name").text();//commodity name
		String price = element.select("li#summary-price div.dd").text(); 
		String brand = element.select("li#summary-brand div.dd").text();
		String salesnumber = element.select("li#summary-salesnumber div.dd").text();
		
		System.out.print(name);
		System.out.print(price);
		System.out.print(brand);
		System.out.print(salesnumber);
		
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("dname",name);
		basicDBObject.put("dprice",price);
		basicDBObject.put("dbrand",brand);
		basicDBObject.put("dsalesnumber",salesnumber);
		
		BasicDBList subtitlelist = new BasicDBList();
		BasicDBList subDetaillist = new BasicDBList();
		Element pds = doc.getElementById("pd_table");
		Elements titles = pds.select("thead tr:not(.select_thead) th");
		//Elements pdlist = pds.select("tbody tr td");
//		for(int i=0;i<titles.size();i++){
//			BasicDBObject bo = new BasicDBObject();
//			basicDBObject.put(titles.get(i).text().toString(),pdlist.get(i).text().toString());			
//			System.out.print(titles.get(i).text().toString()+":"+pdlist.get(i).text().toString());
//			sublist.add(bo);
//		}
//		basicDBObject.put("detail", sublist);
		for (Element title : titles) {
			BasicDBObject bo = new BasicDBObject();
			bo.put("title",title.text().toString());
			subtitlelist.add(bo);
		}	
		Elements pdlist = pds.select("tbody tr td");
		for (Element pd : pdlist) {
			BasicDBObject bo = new BasicDBObject();
			bo.put("detail",pd.text().toString());	
			subDetaillist.add(bo);
		}
		basicDBObject.put("title", subtitlelist);
		basicDBObject.put("detail", subDetaillist);
		System.out.println("\n");	
		Element content = doc.getElementById("content_product");// product-intro
		Elements property = content.getElementsByClass("property").select("div:not(#productImageDesc)");
		//System.out.print(property.html());//.attr("abs:src");
		System.out.println("\n");	
		basicDBObject.put("dcontent",property.first().html());
		BasicDBList imgList = new BasicDBList();
		Elements imgs = content.select("div.p-img");
		for (Element img : imgs) {
			BasicDBObject bo = new BasicDBObject();
			bo.put("img",img.select("img").attr("abs:src"));
			imgList.add(bo);
			System.out.println(img.select("img").attr("abs:src"));	
			//System.out.println("\n");	
		}
		basicDBObject.put("imgs", imgList);
		System.out.println("\n");	
		return basicDBObject;
//		Elements categorys = element.select(delim);
//		for (Element category : categorys) {
//			DomInfo di = new DomInfo();
//			StringBuffer itemUrl = new StringBuffer(mainUrl);
//			String href = category.attr("href");
//			String categoryUrl = itemUrl.append(href).toString();// 子超链
//			String text = category.text(); // 子超链名称
//			if (text != null && !"更多>>".equals(text)) {
//				di.setCategory(category);
//				di.setCategoryName(text);
//				di.setCategoryNum(-1);
//				di.setUrlAddress(categoryUrl);
//				returnList.add(di);
//			}
//		}
//		return returnList;
	}
}

package com.toolstar.crawler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.WriteConcern;
import com.toolstar.crawler.dto.Commodity;
import com.toolstar.crawler.dto.DomInfo;
import com.toolstar.mongodb.MongoUtil;


/**
 *
 * 
 * */
public class CrawlerGAJImpl implements Crawler {

	private int deapth;

	private CrawlerPage crawlerPage;

	private Set<String> crawlings;

	private Set<String> crawleds;

	public CrawlerPage getCrawlerPage() {
		return crawlerPage;
	}

	public void setCrawlerPage(CrawlerPage crawlerPage) {
		this.crawlerPage = crawlerPage;
	}

	public void setCrawlings(Set<String> crawlings) {
		this.crawlings = crawlings;
	}

	public void setCrawleds(Set<String> crawleds) {
		this.crawleds = crawleds;
	}

	public int getDeapth() {
		return deapth;
	}

	public void setDeapth(int deapth) {
		this.deapth = deapth;
	}

	public Set<String> getCrawlings() {
		return crawlings;
	}

	public Set<String> getCrawleds() {
		return crawleds;
	}

	@Override
	public void run() {

		// Document doc = Jsoup.parse(sb);
		crawlings = new HashSet<String>();
		crawleds = new HashSet<String>();
		// crawlerPage = new CrawlerGAJPage();

		StringTokenizer st = new StringTokenizer("");

		// getHrefs(doBreadthSearch(mainUrl));
		// for(String crawling:crawlings){
		// while (crawleds.size()<crawlings.size()) {
		// getInfos(crawling);
		// crawleds.add(crawling);
		// }
		// }
		// TODO Auto-generated method stub
	}

	@Override
	public URL verifyUrl(String url) {
		if (!url.toLowerCase().startsWith("http://"))
			return null;
		URL verifiedUrl = null;
		try {
			verifiedUrl = new URL(url);
		} catch (Exception e) {
			return null;
		}
		return verifiedUrl;
	}

	@Override
	public String downloadPage(URL pageUrl) {
		HttpURLConnection conn = null;
		StringBuffer sb = new StringBuffer();
		try {
//			Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP,
//					new InetSocketAddress("172.31.1.246", 8080));
//			conn = (HttpURLConnection) pageUrl.openConnection(proxy);
			conn = (HttpURLConnection) pageUrl.openConnection();
			conn.connect();
			// ��ӡ������Ӧ��ͷ���ļ�
			Map<String, List<String>> headers = conn.getHeaderFields();
			List<String> header = headers.get(null);
			if (header.get(0) != null
					&& "HTTP/1.1 200 OK".equals(header.get(0))) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						conn.getInputStream(), "UTF-8"));
				String str = null;
				while ((str = br.readLine()) != null) {
					sb.append(str);
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return sb.toString();
	}

	@Override
	public List<String> search(String mainHtml) {
		final File file = new File("d:/urls.txt");
		final List<String> rtns = new ArrayList<String>();
		try {
			final DBCollection category = MongoUtil.getDBCollection("category");
			final FileWriter fw = new FileWriter(file);
			Document doc = Jsoup.parse(mainHtml);
			List<DomInfo> domInfos = crawlerPage.getMainHtmlInfo(doc,
					"mall_category_list", "h4 > a");
			for (final DomInfo domInfo : domInfos) {
				Thread aa = new Thread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						List<DomInfo> domInfos2 = crawlerPage.getHtmlInfo(
								domInfo.getCategory(), "category_list",
								"h5 > a");
						BasicDBObject basicDBObject = new BasicDBObject();
						basicDBObject.put("categoryNo",
								domInfo.getGajCategory());
						basicDBObject.put("categoryName",
								domInfo.getCategoryName());
						basicDBObject.put("categoryUrl",
								domInfo.getUrlAddress());
						List<BasicDBObject> sublist = new ArrayList<BasicDBObject>();
						for (DomInfo domInfo2 : domInfos2) {
							List<DomInfo> domInfos3 = crawlerPage.getHtmlInfo(
									domInfo2.getCategory(), "category_list");
							BasicDBObject basicDBObject2 = new BasicDBObject();
							basicDBObject2.put("subCategoryNo",
									domInfo2.getGajCategory());
							basicDBObject2.put("subCategoryName",
									domInfo2.getCategoryName());
							basicDBObject2.put("subCategoryUrl",
									domInfo2.getUrlAddress());
							List<BasicDBObject> sublist2 = new ArrayList<BasicDBObject>();
							for (DomInfo domInfo : domInfos3) {
								try {
									fw.write("url:");
									fw.write(domInfo.getUrlAddress());
									fw.write("\n");
									BasicDBObject basicDBObject3 = new BasicDBObject();
									basicDBObject3.put("subsubCategoryNo",
											domInfo.getGajCategory());
									basicDBObject3.put("subsubCategoryName",
											domInfo.getCategoryName());
									basicDBObject3.put("subsubCategoryUrl",
											domInfo.getUrlAddress());
									sublist2.add(basicDBObject3);
									rtns.add(domInfo.getUrlAddress());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							basicDBObject2.put("subsubCtl", sublist2);
							sublist.add(basicDBObject2);
						}
						basicDBObject.put("subCtl", sublist);
						category.insert(basicDBObject);
					}
				});
				try {
					aa.start();
					aa.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
		return rtns;
	}

	@Override
	public void getPageInfo(List<String> urls) {
		// TODO Auto-generated method stub
		try {
			final DBCollection biz = MongoUtil.getDBCollection("biz");
			for (final String url : urls) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						String pageInfo = downloadPage(verifyUrl(url));
						if(pageInfo!=null&&!"".equals(pageInfo)){
							Document doc = Jsoup.parse(pageInfo);
							List<DomInfo> domInfos = crawlerPage
									.getSubHtmlInfo(doc, "summary_category_list",
											"div.split_list a:not(.more_open_btn more_open_slide)");
							crawlerPage.getSubMoreHtmlInfo(doc, domInfos,
									"summary_category_list",
									"div.split_more_list a");
							for (DomInfo domInfo : domInfos) {
								String subPageInfo = downloadPage(verifyUrl(domInfo
										.getUrlAddress()));
								Document subdoc = Jsoup.parse(subPageInfo);
								List<Commodity> commoditys = crawlerPage
										.getSubSubHtmlInfo(subdoc,
												"div.product_grid_box",
												"div.product_grid_image", 
												"div.product_grid_number");
								for (Commodity commodity : commoditys) {
									String detailInfo = downloadPage(verifyUrl(commodity.getCategoryUrl()));
									Document detailDoc = Jsoup.parse(detailInfo);
									BasicDBObject basicDBObject = crawlerPage.getDetailHtmlInfo(detailDoc, "product-intro");
									biz.insert(basicDBObject);
								}
							}
						}						
					}
				}).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



import junit.framework.TestCase;
import etl.ETLMongoToMysql;

public class CrawlerImplTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDoSearch() {
		
		ETLMongoToMysql ss = new ETLMongoToMysql();
		ss.doEtl();
		
//		Crawler cl = new CrawlerGAJImpl();
//		CrawlerPage crawlerPage = new CrawlerGAJPage();
//		try {
//			DBCollection commodity = MongoUtil.getDBCollection("commodity");
//			DBCollection biz = MongoUtil.getDBCollection("biz");
//			DBCursor cur = commodity.find();
//			while (cur.hasNext()) {
//				List<DBObject> dbos = (List<DBObject>) cur.next().get(
//						"commoditys");
//				for (DBObject dbo : dbos) {
//					String aa = cl.downloadPage(cl.verifyUrl((String) dbo
//							.get("categoryUrl")));
//					if (aa != null && !"".equals(aa)) {
//						Document doc = Jsoup.parse(aa);
//						BasicDBObject basicDBObject = crawlerPage
//								.getDetailHtmlInfo(doc, "product-intro");
//						biz.insert(basicDBObject);
//					}
//				}
//			}
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		/**
		 * first step
		 **/
		// String aa = cl.downloadPage(cl.verifyUrl("http://item.grainger.cn"));
		// cl.search(aa);
		/**
		 * end first step
		 **/
		/**
		 * directly get information
		 **/
		// cl.getPageInfo(cl.search(aa));
		/**
		 * end directly get information
		 **/
		/**
		 * process
		 **/
		// String aa = cl.downloadPage(cl.verifyUrl("http://item.grainger.cn"));
		// cl.getPageInfo(cl.search(aa));
		/**
		 * process
		 **/
		// BufferedReader reader = null;
		// File file = new File("d:/url_html.txt");
		// try {
		// FileReader fr = new FileReader(file);
		// String line = null;
		// reader = new BufferedReader(fr);
		// StringBuffer sb = new StringBuffer();
		// while ((line = reader.readLine()) != null) {
		// sb.append(line);
		// }
		// Document doc = Jsoup.parse(sb.toString());
		// List<DomInfo> domInfos =
		// crawlerPage.getSubHtmlInfo(doc,"summary_category_list",
		// "div.split_list a");
		// crawlerPage.getSubMoreHtmlInfo(doc,domInfos, "summary_category_list",
		// "div.split_more_list a");
		// for(DomInfo domInfo:domInfos){
		// String subPageInfo =
		// cl.downloadPage(cl.verifyUrl(domInfo.getUrlAddress()));
		// Document subdoc = Jsoup.parse(subPageInfo);
		// crawlerPage.getSubSubHtmlInfo(subdoc,"div.product_grid_box",
		// "div.product_grid_image", "div.product_grid_number");
		// }
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally{
		// try {
		// reader.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

		//
		// BufferedReader reader = null;
		// File file = new File("d:/pages.txt");
		// try {
		// FileReader fr = new FileReader(file);
		// String line = null;
		// reader = new BufferedReader(fr);
		// StringBuffer sb = new StringBuffer();
		// while ((line = reader.readLine()) != null) {
		// sb.append(line);
		// }
		// Document doc = Jsoup.parse(sb.toString());
		// List<DomInfo> domInfos = crawlerPage.getSubHtmlInfo(doc,
		// "summary_category_list", "div.split_list a");
		// crawlerPage.getSubMoreHtmlInfo(doc, domInfos,
		// "summary_category_list", "div.split_more_list a");
		// for (DomInfo domInfo : domInfos) {
		// String subPageInfo = cl.downloadPage(cl.verifyUrl(domInfo
		// .getUrlAddress()));
		// Document subdoc = Jsoup.parse(subPageInfo);
		// crawlerPage.getSubSubHtmlInfo(subdoc, "div.product_grid_box",
		// "div.product_grid_image", "div.product_grid_number");
		// }
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally {
		// try {
		// reader.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }

	}
}

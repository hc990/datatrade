package com.toolstar.etl;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.toolstar.mongodb.MongoUtil;

public class ETLMongoToMysql {

	public void doEtl() {
		try {
			DBCollection biz = MongoUtil.getDBCollection("biz");
			DBCursor cur = biz.find();
			int i = 0;
			int j = 0;
			int z = 0;
			String p = null;
			String q = null;
			while (cur.hasNext()) {
				i++;
				DBObject dbo = (DBObject) cur.next();
				System.out.println(dbo.get("dname"));
				System.out.println(dbo.get("dprice"));
				String price = (String)dbo.get("dprice");
				if(price.indexOf("~")>0){
					j++;
				}
				System.out.println(dbo.get("dsalesnumber"));  
				String number = (String)dbo.get("dsalesnumber");
				int num = Integer.parseInt(number.substring(0, number.indexOf("")));
				if(num>z){
					z = num;
					p=(String)dbo.get("dname");
					q=(String)dbo.get("dbrand");
				}
				System.out.println(dbo.get("dbrand"));
			}
			System.out.println(i);
			System.out.println(j);
			System.out.println(z);
			System.out.println(p);
			System.out.println(q);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
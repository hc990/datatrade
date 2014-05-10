package com.toolstar.mongodb;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoUtil {

	public static DBCollection getDBCollection(String collectionName)
			throws Exception {
		Mongo m = new Mongo("localhost", 27017);
		DB db = m.getDB("zongdb");
		DBCollection coll = db.getCollection(collectionName);
		return coll;
	}

}

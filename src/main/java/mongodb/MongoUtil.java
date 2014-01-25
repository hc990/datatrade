package mongodb;

import com.mongodb.DB;
import com.mongodb.DBAddress;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoUtil {

	public static DBCollection getDBCollection(String collectionName)
			throws Exception {
		DBAddress addr = new DBAddress("localhost", 27017, "zongdb");
		DB m = Mongo.connect(addr);
		DBCollection coll = m.getCollection(collectionName);
		return coll;
	}

}

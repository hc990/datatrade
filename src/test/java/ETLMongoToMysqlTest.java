

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import etl.ETLMongoToMysql;

public class ETLMongoToMysqlTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoEtl() {
		ETLMongoToMysql emtm = new ETLMongoToMysql();
		emtm.doEtl();
	}

}

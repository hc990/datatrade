package com.toolstar.etl;

import org.junit.Test;

public class ETLMongodbTest {

	@Test
	public void testDoCtgEtl() {
		ETLMongodb eTLMongodb = new ETLMongodb();
		eTLMongodb.doCtgEtl();
	}
}

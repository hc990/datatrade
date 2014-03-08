package timer;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestTimer {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationContext.xml");
		ctx.refresh();
		ctx.close();
		while (true) {
			
		}
		
	}
}

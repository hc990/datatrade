package timer;

import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FixedTimeTask {
	
private static final Logger logger = LoggerFactory.getLogger(FixedTimeTask.class);
	
	public void doSth(){
		logger.info("FixedRateTask Begin......" + DateTime.now(DateTimeZone.getDefault()));
		
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("-----");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info("FixedRateTask End......" + DateTime.now(DateTimeZone.getDefault()));
	}

}

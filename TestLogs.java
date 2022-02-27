package Testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLogs {
	
	
	
	public static Logger log = Logger.getLogger(TestLogs.class);

	public static void main(String[] args) {
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
		log.info("first message");
		
		log.info("second  message");
		log.info("third message");
	}

}

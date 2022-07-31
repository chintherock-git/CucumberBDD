package Utilities;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.cucumber.java.Scenario;

public class Log {

	
	private static final Logger Log = LogManager.getLogger(Log.class);
	//Date Time = new Date();
	
	public static void startStep() {
		try {
			Log.info("Step Started ••••••••••••••••Scenario Step execution Start Time "+new Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void endStep() {
		Log.info("Step Started ••••••••••••••••Scenario Step execution End Time "+new Date());
	}
	
	public static void skipScenario(Scenario s) {
		Log.info("Scenario Skipped is  •••••••••••••••• "+s+" >>>>>>>>>>>>>>>>>>>>>>>>>s");
	}
	
	
	public static void info(String message) {Log.info(message);}
	
	public static void warn(String message) {Log.warn(message);}
	
	public static void error(String message) {Log.error(message);}
	
	public static void fatal(String message) {Log.fatal(message);}
	
	public static void debug(String message) {Log.debug(message);}

}

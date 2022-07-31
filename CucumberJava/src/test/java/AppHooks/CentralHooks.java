package AppHooks;

import org.openqa.selenium.WebDriver;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Driver.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import Utilities.Log;

//This class is specifically for hooks and step definations 
//Hooks will be common across the feature 
//Step defination willl be called Before and After Scenario

public class CentralHooks {

	private Driverfactory driverfactory= new Driverfactory();;
	private WebDriver driver;


	//this is the Scenario hooks that runs before every scenario across all the feature files
	//order is 0 then 1


	@Before(order =1)
	public void setProperty() {
		driverfactory.readProperty();
	}

	@Before(order =2)
	public void initializeDriver() {

		driverfactory.setDriver();
		//driver=driverfactory.getDriver();
	}

	@BeforeStep
	public void  reportStartTime() {
		Log.startStep();
	}
	//this is the Scenario hooks that runs after every scenario.
	@AfterStep
	public void reportEndTime(Scenario scenario) {
		Log.endStep();
	}

	//The order of hooks is 1 then 0
	@After(order = 0)
	public void closeBrowser() {
		driverfactory.quitDriver();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		driver=driverfactory.getDriver();
		if(scenario.isFailed()) {
			//take screenshot

			String screenshotName= scenario.getName().replaceAll(" ","_");
			byte[] srcPath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);         
			scenario.attach(srcPath,"image/png",screenshotName);
		}
	}

}

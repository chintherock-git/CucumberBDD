package StepDefination;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

import Driver.Driverfactory;
import PageFactory.Home_PF;
import PageFactory.Login_PF;
import io.cucumber.java.en.*;


public class Login_DataProvider {

	//	public static  WebDriver driver;
	//	Login_PF login_pf;
	//	Home_PF home_pf;
	//	public static Properties prop;
	//	
	public  String URL="https://www.saucedemo.com/";
	public static  WebDriver driver;
	Login_PF login_pf;
	Home_PF home_pf;




	//this is the Scenario hooks that runs before every scenario.
	//	@After
	//	public void closes_the_browser() {
	//		// Write code here that turns the phrase above into concrete actions
	//		driver.quit();  
	//		
	//	}

	//this is the Scenario hooks that runs before every scenario.
	/*
	
	@Before
	public void start() {
		setup();
	}
	
	@After
	public void end() {
		setup();
	}
	@BeforeStep
	public void  reportStartTime() {
		Log.startStep();
	}
	//this is the Scenario hooks that runs after every scenario.
	@AfterStep
	public void reportEndTime() {
		Log.endStep();
	}

	@Given("Browser is open")
	public void browser_is_open() {
		Driverfactory.getDriver();
		//assertEquals(driver.equals(null),false);
		// driver.get("ht;
	}*/

	@Given("User opens the web page URL")
	public void user_opens_the_web_page_url() {
		try {
			String URL_actual=Driverfactory.getDriver().getCurrentUrl();
			assertEquals(URL_actual,URL);
		}
		catch(Exception e){

		}
	}

	@Then("User views login form with username and password")
	public void user_views_login_form_with_username_and_password() {
		login_pf=new Login_PF(Driverfactory.getDriver());
		assertEquals(login_pf.checkVisibility_username_password_login(),true);
	}


	@When("User enters {string} and {string} in username and password field")

	public void User_enters_username_and_password_in_username_and_password_field(String username, String password) {
		// Write code here that turns the phrase above into concrete actions

		try {
			Thread.sleep(5000);
			login_pf.enterUsermame(username);
			login_pf.enterPassword(password);
			login_pf.clickLogin();
			Thread.sleep(7000);
		}
		catch(Exception e) {

		}
	}

	@Then("verifies the cart icon in homepage")
	public void verifies_the_cart_icon_in_homepage() {
		home_pf= new Home_PF(Driverfactory.getDriver());
		assertEquals(home_pf.check_cartIcon(), true);
	}


}

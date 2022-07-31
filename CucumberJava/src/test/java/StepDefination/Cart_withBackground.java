package StepDefination;


import org.openqa.selenium.WebDriver;

import Driver.Driverfactory;

import static org.junit.Assert.*;

import PageFactory.Cart_PF;
import PageFactory.CheckoutComplete_PF;
import PageFactory.Fill_Information_PF;
import PageFactory.Home_PF;
import PageFactory.Login_PF;
import PageFactory.Checkout_PF;

import io.cucumber.java.en.*;

import java.util.Properties;

public class Cart_withBackground {

	public static  WebDriver driver;
	Login_PF login_pf;
	Home_PF home_pf;
	Cart_PF cart_pf;
	Checkout_PF check_pf;
	Fill_Information_PF form_pf;
	CheckoutComplete_PF check_checkout_pf;
	public String config_path = System.getProperty("user.dir")+System.getProperty("file.separator")+"src/main/java/Utilities/config.properties";
	public static String URL="https://www.saucedemo.com/";
	public static Properties prop;



	@Given("user is in login page")
	public void user_is_in_login_page() {
		System.out.println("User is in login page "+Driverfactory.getDriver().getCurrentUrl());
		assertEquals(Driverfactory.getDriver().getCurrentUrl(),Cart_withBackground.URL);
		// driver.get("https://phptravels.net/admin");
	}

	@Then("views login and password and login button")
	public void views_login_and_password_and_login_button() {
		try {
			login_pf=new Login_PF(Driverfactory.getDriver());
			assertEquals(login_pf.checkVisibility_username_password_login(),true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Then("enters username and Password and clicks on login button")
	public void enters_username_and_Password_and_clicks_on_login_button() {
		String username=Driverfactory.getpropValues("username");
		String password=Driverfactory.getpropValues("password");

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


	@And("user lands to Home page and views Empty cart")
	public void user_lands_to_Home_page_and_views_Empty_cart() {
		// Write code here that turns the phrase above into concrete actions
		home_pf= new Home_PF(Driverfactory.getDriver());
		assertTrue(home_pf.check_cartIcon());


	}

	@And("adds item to cart")
	public void adds_item_to_cart() {
		// Write code here that turns the phrase above into concrete actions
		home_pf.check_and_Add_bikelight_item();
	}

	@And("checks the count of the cart")
	public void checks_the_count_of_the_cart() {
		assertEquals(home_pf.return_cartCount(),"1");
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////

	@When("user is in landing page")
	public void user_is_in_landing_page() {

		assertTrue(home_pf.check_cartIcon());
	}

	@And("clicks the cart and removes item from the cart and makes its empty")
	public void clicks_the_cart_and_removes_item_from_the_cart_and_makes_its_empty() {

		assertEquals(home_pf.return_cartCount(),"1");
		cart_pf=home_pf.clickCart();
		assertEquals(cart_pf.check_cartURL(),"https://www.saucedemo.com/cart.html");
		cart_pf.remove_item();
		home_pf=cart_pf.click_continueShopping();
		assertEquals(home_pf.check_homeURL(),"https://www.saucedemo.com/inventory.html");
		assertEquals(home_pf.check_Add_bikelight_item(),true);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	@When("user is in home page navigates to cart page")
	public void user_is_in_home_page_navigates_to_cart_page() {
		cart_pf=home_pf.clickCart();
		assertEquals(cart_pf.check_cartURL(),"https://www.saucedemo.com/cart.html");	
	}

	@Then("clicks checkout")
	public void clicks_checkout() {

		form_pf=cart_pf.click_checkout();
		form_pf.check_formURL();
		assertEquals(form_pf.check_formURL(),"https://www.saucedemo.com/checkout-step-one.html");	
	}

	@Then("enters details in your Information page and clicks continue")
	public void enters_details_in_your_Information_page_and_clicks_continue () {
		assertEquals(form_pf.checkVisibility_firstName_lastName_code(),true);
		check_pf=form_pf.click_continue();
	}
	@And("navigates to Checkout Overview page and clicks finish")
	public void navigates_to_Checkout_Overview_page_and_clicks_finish() {
		assertEquals(check_pf.check_checkoutURL(),"https://www.saucedemo.com/checkout-step-two.html");
		check_checkout_pf=check_pf.verifyandClickFinish();

	}
	@And("completes the checkout")
	public void completes_the_checkout() {
		assertEquals(check_checkout_pf.check_checkoutURL(),"https://www.saucedemo.com/checkout-complete.html");
		assertEquals(check_checkout_pf.verifycompleteOrder(),"THANK YOU FOR YOUR ORDER");
	}

}



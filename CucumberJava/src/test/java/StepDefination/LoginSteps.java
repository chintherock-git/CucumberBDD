package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	   
		System.out.println("Function user_is_on_home_page");
	}

	@When("user enters valid username and password in username and password field")
	public void user_enters_valid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Function user_enters_valid_username_and_password");
	}

	@When("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Function user_clicks_on_the_login_button");
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Function user_is_navigated_to_home_page");
	}

	@Then("User views the content of homepage")
	public void user_views_the_content_of_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Function user_views_the_content_of_homepage");
	}

}

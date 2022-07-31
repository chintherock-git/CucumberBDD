package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Driver.Driverfactory;

public class Login_PF {

	@FindBy(id="user-name")
	private WebElement userName;

	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="login-button")
	private WebElement loginbutton;

	WebDriver driver;

	public  Login_PF(WebDriver driver) {
		//this.driver=driver;
		//This is the lazy load concept of Page Factory pattern 
		//used to identify elements only when they are used in any operation
		//Page Factory pattern is the implementation of POM
			this.driver=driver;
			AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver, Integer.parseInt(Driverfactory.getpropValues("Time_Unit_SECONDS")));
			PageFactory.initElements(ajax,this);
		}



	public void enterUsermame(String username) {
		userName.sendKeys(username);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
   
	public void clickLogin() {
		loginbutton.click();
	}
	
	//Utility function
	public boolean isVisible(WebElement we) {
		return we.isDisplayed();
	}
	
	public boolean  checkVisibility_username_password_login() {
		if(isVisible(userName) && isVisible(password) &&isVisible(loginbutton))
			return true;
		return false;
	}

}

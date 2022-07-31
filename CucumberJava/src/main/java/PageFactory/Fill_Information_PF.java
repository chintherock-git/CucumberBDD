package PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Driver.Driverfactory;

public class Fill_Information_PF {

	@FindBy(id="first-name")
	private WebElement firstName;

	@FindBy(id="last-name")
	private WebElement lastName;

	@FindBy(id="postal-code")
	private WebElement code;

	@FindBy(id="continue")
	private WebElement form_continue;


	WebDriver driver;

	public Fill_Information_PF(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver, Integer.parseInt(Driverfactory.getpropValues("Time_Unit_SECONDS")));
		PageFactory.initElements(ajax,this);
	}

	public String check_formURL()
	{
		return Driverfactory.getDriver().getCurrentUrl();
	}
	
	public boolean checkVisibility_firstName_lastName_code() {
		if(firstName.isDisplayed() && (lastName.isDisplayed()) &&(code.isDisplayed())) {
			firstName.sendKeys(Driverfactory.getpropValues("first"));
			lastName.sendKeys(Driverfactory.getpropValues("last"));
			code.sendKeys(Driverfactory.getpropValues("code"));
			return true;
		}
		return false;
	}

	public Checkout_PF click_continue()
	{
		if (form_continue.isDisplayed()) {
			form_continue.click();
			return new Checkout_PF(Driverfactory.getDriver());
		}
		return null;
	}

}

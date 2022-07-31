package PageFactory;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Driver.Driverfactory;

	 public class Checkout_PF {

		@FindBy(xpath="//div[contains(text(),'Sauce Labs Bike Light')]")
		private WebElement description;

		@FindBy(id="finish")
		private WebElement finish;
		
	
		WebDriver driver;

		public Checkout_PF(WebDriver driver) {
			this.driver=driver;
			AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver, Integer.parseInt(Driverfactory.getpropValues("Time_Unit_SECONDS")));
			PageFactory.initElements(ajax,this);
		}

		public String check_checkoutURL()
		{
			return Driverfactory.getDriver().getCurrentUrl();
		}
		
		public CheckoutComplete_PF verifyandClickFinish() {
			description.isDisplayed();
			finish.isDisplayed();
			finish.click();
			return new CheckoutComplete_PF(Driverfactory.getDriver());
		}

}

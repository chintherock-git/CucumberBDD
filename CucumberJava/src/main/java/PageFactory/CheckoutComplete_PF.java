package PageFactory;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Driver.Driverfactory;

	public class CheckoutComplete_PF {

		@FindBy(className="complete-header")
		private WebElement completeCheckout;


		WebDriver driver;

		public CheckoutComplete_PF(WebDriver driver) {
			this.driver=driver;
			AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver, Integer.parseInt(Driverfactory.getpropValues("Time_Unit_SECONDS")));
			PageFactory.initElements(ajax,this);
		}

		public String check_checkoutURL()
		{
			return Driverfactory.getDriver().getCurrentUrl();
		}
		
		public String verifycompleteOrder() {
			completeCheckout.isDisplayed();
			return completeCheckout.getText();
		}

}

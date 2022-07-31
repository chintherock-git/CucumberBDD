package PageFactory;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Driver.Driverfactory;

	public class Cart_PF {

		@FindBy(id="remove-sauce-labs-bike-light")
		private WebElement remove_button;

		@FindBy(id="continue-shopping")
		private WebElement continueShopping;

		@FindBy(id="item_0_title_link")
		private WebElement item_bikeLight;

		@FindBy(id="checkout")
		private WebElement cart_checkout;
		

		private WebDriver driver;

		public Cart_PF(WebDriver driver) {
			this.driver=driver;
			AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver, Integer.parseInt(Driverfactory.getpropValues("Time_Unit_SECONDS")));
			PageFactory.initElements(ajax,this);
		}

		public String check_cartURL()
		{
			return Driverfactory.getDriver().getCurrentUrl();
		}
		

		public Home_PF click_continueShopping()
		{
			if (continueShopping.isDisplayed()) {
				continueShopping.click();
				return new Home_PF(Driverfactory.getDriver());
				}
				return null;
			}

		public Fill_Information_PF click_checkout() {
			if(cart_checkout.isDisplayed()) {
				 cart_checkout.click();
			return new Fill_Information_PF(Driverfactory.getDriver());
			}
			return null;
		}
		public boolean remove_item() {
			if (remove_button.isDisplayed()) {
			 remove_button.click();
			 return true;
			}
			return false;
	 }
			 


}

package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import Driver.Driverfactory;

public class Home_PF  {

	@FindBy(className="shopping_cart_link")
	private WebElement cart_Icon;

	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	private WebElement add_item_bikeLight;

	@FindBy(id="item_0_title_link")
	private WebElement item_bikeLight;

	@FindBy(className="shopping_cart_badge")
	private WebElement cart_count;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cart_withitem;

	WebDriver driver;

	public Home_PF(WebDriver driver) {
		this.driver=driver;
		AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver, Integer.parseInt(Driverfactory.getpropValues("Time_Unit_SECONDS")));
		PageFactory.initElements(ajax,this);
	}

	public boolean check_cartIcon()
	{
		return cart_Icon.isDisplayed();
	}

	public void check_and_Add_bikelight_item()
	{
		if (item_bikeLight.isDisplayed()) {
			if(add_item_bikeLight.isDisplayed()) {
				add_item_bikeLight.click();
			}
		}
	}
	
	public boolean check_Add_bikelight_item()
	{
		if (item_bikeLight.isDisplayed()) {
			if(add_item_bikeLight.isDisplayed()) {
				return true;
			}
		}
		return false;
	}

	public String return_cartCount() {
		if(cart_count.isDisplayed())
			return cart_count.getText();
		return "0";	
	}
	
	public Cart_PF clickCart() {
		if (cart_withitem.isDisplayed()) {
			cart_withitem.click();
			return new Cart_PF(Driverfactory.getDriver());
			}
		else
			return null;
		}
	
	public String check_homeURL()
	{
		return Driverfactory.getDriver().getCurrentUrl();
	}
	
	}


package pages;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import app.support.keywords;
import templates.pageTemplate;

public class pageCheckout extends pageTemplate{
	
	public static final String URL = "https://www.advantageonlineshopping.com/";
	
	private String xpathLoginIcon = " //nav/ul/li[3]/a";
	private String xpathCheckoutIcon = "//nav/ul/li[5]/a\";";
	private String xpathUserLogin = "//div//input[@name='username']";
	private String xpathPasswordLogin = "//div//input[@name='password']";
	private String xpathLoginButton = "//*[@id='sign_in_btnundefined']";
	private String xpathShipFirstName = "//div//input[@name='first_name']";
	private String xpathShipLastName = "//div//input[@name='last_name']";
	private String xpathShipPhone = "//div//input[@name='phone_number']";
	private String xpathShipCountry = "//div//select[@name='countryListbox']";
	private String xpathShipCity = "//div//input[@name='city']";
	private String idCheckoutIcon = "shoppingCartLink";
	private String idCheckoutButton = "shoppingCartLink";
	
	
	
	public pageCheckout(WebDriver driver) {
		super(driver);
	}
	
	public void Login (String userName, String userPassword) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver,By.xpath(xpathLoginIcon));
		keywords.writeElement(driver, By.xpath(xpathUserLogin), "demo123A");
		keywords.writeElement(driver, By.xpath(xpathPasswordLogin), "Demo123A");
		keywords.clickElement(driver,By.xpath(xpathLoginButton));
	}
	
	public void gotoCheckout() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver,By.id(idCheckoutIcon));
	}
	
	public void fillShippingDetails() {
		keywords.clickElement(driver,By.id(idCheckoutButton));
		keywords.writeElement(driver, By.xpath(xpathShipFirstName), "User");
		keywords.writeElement(driver, By.xpath(xpathShipLastName), "Tester");
		keywords.writeElement(driver, By.xpath(xpathShipPhone),"1234567890");
		keywords.selectElementByName(driver, By.xpath(xpathShipCountry), "China");
	}
		
	
}

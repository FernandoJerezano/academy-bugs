package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.support.keywords;
import templates.pageTemplate;

public class pageContactUs extends pageTemplate{
	
	private String xpathContactLink = "//nav/ul/li[5]/a";
	//nav/ul//a[@href='javascript:void(0)' and @class='menu navLinks roboto-regular ng-scope']";
	//nav/ul/li[5]/a]
	private String xpathCategoryList = "//div//section//article[@id='contact_us']//div//select[@name='categoryListboxContactUs']";
	private String xpathProductList = "//div//section//article[@id='contact_us']//div//select[@name='productListboxContactUs']";
	private String xpathEmailContact = "//div//section//article[@id='contact_us']//div//div//div//input[@name='emailContactUs']";
	private String xpathSubject = "//div//section//article[@id='contact_us']//div//div//div//textarea[@name='subjectTextareaContactUs']";
	private String xpathSendButton = "//div//section//article[@id='contact_us']//div//div//div//button[@id='send_btnundefined']";
	//private String xpathCorrectMessage = ""
	public static final String URL = "https://www.advantageonlineshopping.com/";
	
	public pageContactUs(WebDriver driver) {
		super(driver);
	}

	public void goToContactUs()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.print("Encontre el elemento");
		keywords.clickElement(driver,By.xpath(xpathContactLink));
	}
	
	public void sendSubject() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		keywords.selectElementByName(driver, By.xpath(xpathCategoryList), "Laptops");	
		keywords.selectElementByName(driver, By.xpath(xpathProductList), "HP Pavilion 15z Laptop");
		keywords.writeElement(driver, By.xpath(xpathEmailContact), "blabla@gmail.com");
		keywords.writeElement(driver, By.xpath(xpathSubject), "No me gusta como se ve la pagina, esta bien fea");
		keywords.clickElement(driver, By.xpath(xpathSendButton));
	}
	
	public void verifySendSubject() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//keywords.getText(driver, )
	}
	
}

package app.tsd;

import org.testng.annotations.Test;

import pages.pageCheckout;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class tsdCheckoutProcess {
	public String baseUrl = "https://www.advantageonlineshopping.com/";
	String driverPath = "C:\\Academia SDET\\libs\\chromedriver.exe";
	String excelPath = "C:\\Academia SDET\\libs\\data_and_configuration.xlsx";
	public WebDriver driver;
	
  @Test
  public void f() {
	  System.out.println("Test Case Create a new Account");
		try {
			pageCheckout newCheckout = new pageCheckout(driver);
			System.out.print("Login");
			newCheckout.Login("demo123A", "Demo123A");
			System.out.print("Entra al checkout");
			newCheckout.gotoCheckout();
			System.out.print("Llena Shipping Data");
			
			
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//Assert.assertEquals(keywords.getText(driver, By.xpath(xpathSignUpAlert)), "Welcome! You have signed up successfully.");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
  }

  @AfterClass
  public void afterClass() {
		//driver.close();
  }

}

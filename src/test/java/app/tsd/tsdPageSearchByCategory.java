package app.tsd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.pageSearchByCategory;

public class tsdPageSearchByCategory {

	public String baseUrl = "https://www.advantageonlineshopping.com/#/";
	String driverPath = "C:\\Academia2206\\libs\\webdrivers\\chromedriver-102.0.5.exe";
	String excelPath = "C:\\Academia2206\\libs\\demosite_parameters.xlsx";
	
	public WebDriver driver;
	
	@Test
	public void filterByPrice() {
		pageSearchByCategory searchByCategory = new pageSearchByCategory(driver);
		searchByCategory.filterByPrice();
	}
	
	@Test
	public void filterByWeight() {
		try {
			pageSearchByCategory searchByCategory = new pageSearchByCategory(driver);
			searchByCategory.filterByWeight();
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void filterByColor() {
		try {
			pageSearchByCategory searchByCategory = new pageSearchByCategory(driver);
			searchByCategory.filterByColor();
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void buyHighlightedProduct() {
		try {
			pageSearchByCategory searchByCategory = new pageSearchByCategory(driver);
			searchByCategory.buyHighlightedProduct();
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void checkCategoryName() {
		try {
			pageSearchByCategory searchByCategory = new pageSearchByCategory(driver);
			searchByCategory.checkCategoryName();
			
			String urlCategory = driver.getCurrentUrl().split("/")[5];
			
			Assert.assertTrue(searchByCategory.getCategoryName().equalsIgnoreCase(urlCategory));
			
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
	
}

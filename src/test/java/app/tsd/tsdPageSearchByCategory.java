package app.tsd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.pageSearchByCategory;
/**
 * Author: Fernando Rafael Jerezano Balderas
 * Script description: In this script we define and run the diferent test cases 
 * 	and use the methods defined in the pageSearchByCategory class 
 * Creation date: 07/07/2022
 * Modification date: 07/07/2022
 * */
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

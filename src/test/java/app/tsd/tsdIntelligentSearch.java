package app.tsd;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import app.support.excelPropertiesLoader;
import app.support.keywords;
import pages.pageIntelligentSearch;
public class tsdIntelligentSearch {
	public String baseUrl = "";
	String driverPath = "";
	String excelPath = "C:\\Academia2206\\libs\\demosite_parameters.xlsx";
	String dataPath = "";
	String sheetData = "";
	
	public WebDriver driver;
	excelPropertiesLoader excelData;
	@DataProvider(name = "excel-data")
	public Object[][] excelDP() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] userObject = excelData.getExcelData(dataPath, sheetData);
		return userObject;
	}
	@Test(dataProvider = "excel-data", description = "Found a product", priority = 1)
	public void searchingProducts(String userName, String email, String password, String confirmPassword,
			String firstName, String lastName, String phoneNumber, String country, String city, String address,
			String state, String postalCode, String product,String category,String product1, String subject) {
		System.out.println("Test Case Found a product");
		try {
			pageIntelligentSearch foundProduct = new pageIntelligentSearch(driver);
			driver.get(foundProduct.URL);
			foundProduct.SearchProducts(product);
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			//Assert.assertEquals(keywords.getText(driver, By.xpath(xpathUserText)), userName);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	@BeforeClass
	public void beforeClass() {
		// Load test data required
		excelData = new excelPropertiesLoader();
		excelData.LoadFile(excelPath);
		baseUrl = excelData.getValue("baseUrl");
		driverPath = excelData.getValue("driverPath");
		dataPath = excelData.getValue("dataPath");
		sheetData = excelData.getValue("sheetData");
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions options= new ChromeOptions();
	    // add Incognito parameter
	    options.addArguments("--incognito");
	    // DesiredCapabilities object
	    DesiredCapabilities c = DesiredCapabilities.chrome();
	    //set capability to browser
	    c.setCapability(ChromeOptions.CAPABILITY, options);
	    
		driver = new ChromeDriver(options);
		driver.get(baseUrl);
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void afterClass() {
		//driver.close();
		System.out.println("Test Cases Terminados");
	}
}

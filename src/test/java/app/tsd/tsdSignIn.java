package app.tsd;

import java.io.IOException;

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
import pages.pageSignIn;


public class tsdSignIn {
	public String baseUrl = "";
	String driverPath = "";
	String excelPath = "C:\\Academia2206\\libs\\demosite_parameters.xlsx";
	String dataPath = "";
	String sheetData = "";
	public WebDriver driver;
	excelPropertiesLoader excelData;
	String messageOfErrorFacebook = "403 FORBIDDEN Sorry, connecting to Facebook is currently unavailable. Please try again later.";
	@DataProvider(name = "excel-data")
	public Object[][] excelDP() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] userObject = excelData.getExcelData(dataPath, sheetData);
		return userObject;
	}

	

	@Test(dataProvider = "excel-data", description = "User's sign in", priority = 1)
	public void userSignin(String userName, String password) {
		System.out.println("Test Case Sign in");
		pageSignIn signIn = new pageSignIn(driver);
		try {		
			String userNameObtained = signIn.userSignIn(userName, password);
			signIn.userSignOut();
			Assert.assertEquals(userNameObtained, userName);
		} catch (Exception e) {
			signIn.closePopup();
			Assert.fail(e.getMessage());
		}
	}
	

	@Test(description = "User's sign out", priority = 1)
	public void userSignOut() {
		System.out.println("Test Case Sign out");
		try {
			pageSignIn signOut = new pageSignIn(driver);
			signOut.userSignIn("demo123A", "Demo123A");
			signOut.userSignOut();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test(description = "", priority = 2) 
	public void signInWithFacebook() {
		System.out.println("Test Case Sign out");
		try {
			pageSignIn signInFace = new pageSignIn(driver);
			String facebookMessage = signInFace.userSignInWithFacebook();
			Assert.assertEquals(facebookMessage, messageOfErrorFacebook);
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
		dataPath = excelData.getValue("dataPath2");
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
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}

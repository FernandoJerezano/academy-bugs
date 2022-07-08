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
import pages.pageSignIn;

/**
 * @Author: Paola Ferrer
 * description: In this script define different test cases for user's sign in scenario
 * Creation date: 07/07/2022
 * */
public class tsdSignIn {
	public String baseUrl = "";
	String driverPath = "";
	String excelPath = "C:\\Academia2206\\libs\\demosite_parameters.xlsx";
	String dataPath = "";
	String sheetData = "";
	public WebDriver driver;
	excelPropertiesLoader excelData;
	String messageOfErrorFacebook = "403 FORBIDDEN Sorry, connecting to Facebook is currently unavailable. Please try again later.";
	
	
	//Definition of the data provider to work with
	@DataProvider(name = "excel-data")
	public Object[][] excelDP() throws IOException {
		// We are creating an object from the excel sheet data by calling a method that
		// reads data from the excel stored locally in our system
		Object[][] userObject = excelData.getExcelData(dataPath, sheetData);
		return userObject;
	}

	
	//A test case that proves the correct sign in
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
	
	//A test case that proves the correct sign out
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
	
	//a test case that tests error when trying to log in with Facebook
	@Test(description = "User's Facebook sign in", priority = 2) 
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

package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.keywords;
import templates.pageTemplate;
/*
 * @Autor: Paola Ferrer
 * Description: Class with methods that allows testing different ways to sign in to the page
 */
public class pageSignIn extends pageTemplate {

	public pageSignIn(WebDriver driver) {
		super(driver);

	}

	private String xpathUserMenu = "//*[@id='menuUser']";
	private String xpathUserName = "//input[@name='username']";
	private String xpathUserPassword = "//input[@name='password']";
	private String xpathSignIn = "//*[@id='sign_in_btnundefined']";
	private String xpathNameOfUser = "//*[@id='menuUserLink']/span";
	private String xpathSignOut = "//*[@id='loginMiniTitle']/label[3]";
	private String xpathSignInFacebook = "//span[@class = 'facebook ng-scope']";
	private String xpathFacebookSignInResponse = "//*[@id='signInResultMessage' and @class ='or center invalid']";
	private String xpathForgotPassword = "//a[@class = 'forgot-Passwowd ng-scope']";
	private String xpathClosePopup = "//div[@class= 'closeBtn loginPopUpCloseBtn']";
	
	//Steps to go to the user menu and / or user's sign in pop-up
	public void goToSignInPopup() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver,By.xpath(xpathUserMenu));
	}
	//Steps to user's sign in
	public String userSignIn(String username, String password) {
		goToSignInPopup();
		keywords.writeElement(driver, By.xpath(xpathUserName), username);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.writeElement(driver, By.xpath(xpathUserPassword), password);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xpathSignIn));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return keywords.getText(driver, By.xpath(xpathNameOfUser));
	
	}
	//Steps to user's sign out
	public void userSignOut () {	
		goToSignInPopup();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xpathSignOut));
	}
	//Steps to user's sign in with Facebook;
	public String userSignInWithFacebook() {
		goToSignInPopup();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xpathSignInFacebook));
		return keywords.getText(driver, By.xpath(xpathFacebookSignInResponse));
	}
	

	public void resetPassword() {
		goToSignInPopup();
		keywords.clickElement(driver, By.xpath(xpathForgotPassword));
		
	}

	public void closePopup() {
		keywords.clickElement(driver, By.xpath(xpathClosePopup));
	}
}

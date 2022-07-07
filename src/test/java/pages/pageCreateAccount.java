package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.keywords;
import templates.pageTemplate;

public class pageCreateAccount extends pageTemplate{

	private String xpathEmailField = "//input[@id='spree_user_email']";
	private String xpathPasswordField = "//input[@id='spree_user_password']";
	private String xpathConfirmPasswordField = "//input[@id='spree_user_password_confirmation']";
	private String xpathCreateAccountButton = "//input[@name='commit']";
	private String xpathLoginLink = "//a[@href='/login']";
	public static final String URL = "https://demosite.appvance.com/signup";
	
	public pageCreateAccount(WebDriver driver) {
		super(driver);
	}
	
	public void createAccount(String email, String password, String confirmPassword) {
		keywords.writeElement(driver, By.xpath(xpathEmailField), email);
		keywords.writeElement(driver, By.xpath(xpathPasswordField), password);
		keywords.writeElement(driver, By.xpath(xpathConfirmPasswordField), password);
		keywords.clickElement(driver, By.xpath(xpathCreateAccountButton));
	}
	
	public void goToLoginPage() {
		keywords.clickElement(driver, By.xpath(xpathLoginLink));
	}
	
}

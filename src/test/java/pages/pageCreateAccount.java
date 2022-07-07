package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.keywords;
import templates.pageTemplate;

public class pageCreateAccount extends pageTemplate{

	//XPaths Account Details
	private String xpathUserField = "//input[@name='usernameRegisterPage']";
	private String xpathEmailField = "//input[@name='emailRegisterPage']";
	private String xpathPasswordField = "//input[@name='passwordRegisterPage']";
	private String xpathConfirmPasswordField = "//input[@name='confirm_passwordRegisterPage']";
	
	//XPaths Personal Details
	private String xpathFirstNameField = "//input[@name='first_nameRegisterPage']";
	private String xpathLastNameField = "//input[@name='last_nameRegisterPage']";
	private String xpathPhoneNumberField = "//input[@name='phone_numberRegisterPage']";
	
	//XPaths Address
	private String xpathCityField = "//input[@name='cityRegisterPage']";
	private String xpathAddressField = "//input[@name='addressRegisterPage']";
	private String xpathStateField = "//input[@name='state_/_province_/_regionRegisterPage']";
	private String xpathPostalCodeField = "//input[@name='postal_codeRegisterPage']";
	
	//XPaths Additional Buttons
	private String xpathCheckAgreement = "//input[@name='i_agree']";
	private String xpathButtonRegister = "//button[@id='register_btnundefined']";
	private String xpathLinkHaveAccount = "//a[@translate='ALREADY_HAVE_AN_ACCOUNT']";
	
	public static final String URL = "https://www.advantageonlineshopping.com/#/register";
	
	public pageCreateAccount(WebDriver driver) {
		super(driver);
	}
	
	public void createAccount(String userName, String email, String password, String confirmPassword,
			String firstName, String lastName, String phoneNumber, String country, String city, String address,
			String state, String postalCode) {
		keywords.clickElement(driver, By.xpath(xpathUserField));
		keywords.writeElement(driver, By.xpath(xpathUserField), userName);
		keywords.writeElement(driver, By.xpath(xpathEmailField), email);
		keywords.writeElement(driver, By.xpath(xpathPasswordField), password);
		keywords.writeElement(driver, By.xpath(xpathConfirmPasswordField), confirmPassword);
		keywords.writeElement(driver, By.xpath(xpathFirstNameField), firstName);
		keywords.writeElement(driver, By.xpath(xpathLastNameField), lastName);
		keywords.writeElement(driver, By.xpath(xpathPhoneNumberField), phoneNumber);

		keywords.writeElement(driver, By.xpath(xpathCityField), city);
		keywords.writeElement(driver, By.xpath(xpathAddressField), address);
		keywords.writeElement(driver, By.xpath(xpathStateField), state);
		keywords.writeElement(driver, By.xpath(xpathPostalCodeField), postalCode);
		keywords.clickElement(driver, By.xpath(xpathCheckAgreement));
		keywords.clickElement(driver, By.xpath(xpathButtonRegister));
	}
	
	public void goToHaveAccount() {
		keywords.clickElement(driver, By.xpath(xpathLinkHaveAccount));
	}
	
}

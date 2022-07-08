package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.support.keywords;
import templates.pageTemplate;

public class pageUseFollowSection extends pageTemplate{
	//XPaths Icons of the section
	private String xpathTitle = "//div[@id='follow']";
	private String xpathFbIcon="//div/a[@href='https://www.facebook.com/MicroFocus/']";
	
	public pageUseFollowSection(WebDriver driver) {
		super(driver);
		
	}
	public void goToFacebook() {
		keywords.clickElement(driver, By.xpath(xpathTitle));
		keywords.clickElement(driver, By.xpath(xpathFbIcon));
		
	}

}

/**
 * @Author Shelssy Elizabeth Ortiz
 * @Description Verify differents ways to use the intelligent searcher
 * @Creation Date 08/07/2022
 */
package pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import app.support.keywords;
import templates.pageTemplate;
public class pageIntelligentSearch extends pageTemplate {
	public String XPathBtnFounder="//nav/ul/li[4]/a";
	public String XpathInputFounder="//*[@id='autoComplete']";
	public String XPathViewAll="//*[@id='roboto-medium viewAll ng-scope']";
	public static final String URL = "https://www.advantageonlineshopping.com/#";
	public pageIntelligentSearch(WebDriver driver) {
		super(driver);
	}
	//Happy path to use keywords in this test case, the parameter is from a test data
	public void SearchProducts(String product) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(XPathBtnFounder));
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		keywords.writeElement(driver, By.xpath(XpathInputFounder),product);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//keywords.clickElement(driver, By.xpath(XPathViewAll));
		WebElement m=driver.findElement(By.xpath(XpathInputFounder));
	    m.sendKeys(Keys.ENTER);	
	}
}
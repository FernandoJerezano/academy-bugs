package templates;

import org.openqa.selenium.WebDriver;

public class pageTemplate {

	protected WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public pageTemplate(WebDriver driver) {
		this.driver = driver;
	}

	public void goBack() {
		this.driver.navigate().back();
	}

	public void goForward() {
		this.driver.navigate().forward();
	}
	
}

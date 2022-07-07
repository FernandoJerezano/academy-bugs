package pages;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.support.keywords;
import templates.pageTemplate;

public class pageSearchByCategory extends pageTemplate {

	private String xPathLaptopCategory 	 = "//*[@id='laptopsImg']";
	private String xPathLaptopMice 		 = "//*[@id='miceImg']";
	private String xPathLaptopHeadphones = "//*[@id='headphonesImg']";
	
	private String xPathOptionPrice 	= "//*[@id='accordionPrice']";
	private String xPathOptionWeight = "//*[@id='accordionAttrib3']";
	private String xPathOptionColor  = "//*[@id='accordionColor']";
	
	private String xPathCbxLaptopWeight1 = "//*[@id='weight_0']";
	private String xPathCbxLaptopWeight3 = "//*[@id='weight_3']";
	private String xPathCbxLaptopWeight6 = "//*[@id='weight_6']";
	
	private String xPathColorRed 	= "//*[@id='productsColorsDD3A5B']";
	private String xPathColorGrey 	= "//*[@id='productsColorsC3C3C3']";
	private String xPathColorPurple 	= "//*[@id='productsColors545195']";
	
	private String xPathHighlightedProduct = "//*[@name='buy_now']";
	private String xPathCategoryHeader = "//*[contains(@class,'categoryTitle')]";
	private String xPathSlider = "//*[@id='slider']";
	
	private String categoryName;
	
	public pageSearchByCategory(WebDriver driver) {
		super(driver);
		categoryName = "";
	}
	
	public void filterByPrice() {
		
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathLaptopCategory));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathOptionPrice));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.moveSliderLeft(driver, By.xpath(xPathSlider), 5);
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.moveSliderLeft(driver, By.xpath(xPathSlider), 10);
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.moveSliderLeft(driver, By.xpath(xPathSlider), 1);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.moveSliderLeft(driver, By.xpath(xPathSlider), 20);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Presiona una tecla");
		sc.nextLine();
	}
	
	public void filterByWeight() {
		
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathLaptopMice));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathOptionWeight));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathCbxLaptopWeight1));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathCbxLaptopWeight3));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathCbxLaptopWeight6));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Presiona una tecla");
		sc.nextLine();
	}
	
	public void filterByColor() {

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathLaptopCategory));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathOptionColor));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathColorRed));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathColorGrey));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathColorPurple));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Presiona una tecla");
		sc.nextLine();
		
	}
	
	public void buyHighlightedProduct() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathLaptopHeadphones));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathHighlightedProduct));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Presiona una tecla");
		sc.nextLine();
	}
	
	public void checkCategoryName() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		keywords.clickElement(driver, By.xpath(xPathLaptopCategory));	
		categoryName = keywords.getText(driver,By.xpath(xPathCategoryHeader));
	}
	
	
	
	
	public String getCategoryName() {
		return categoryName;
	}
	
	
}

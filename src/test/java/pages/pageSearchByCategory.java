package pages;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import app.support.keywords;
import templates.pageTemplate;

/**
 * Author: Fernando Rafael Jerezano Balderas
 * Script description: In this script we deal with the actions we can perform 
 * 	while we navigate the product by category section
 * 	In this page we can do the following:
 * 		Filter products by Price
 * 		Filter products by Weight
 * 		Filter products by Color
 * 		Check the name of the category
 * 		...among other things
 * Creation date: 07/07/2022
 * Modification date: 07/07/2022
 * */

public class pageSearchByCategory extends pageTemplate {

	// here we define the xpaths to get the web elements
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
	
	// here we store the name of the category
	private String categoryName;
	
	public pageSearchByCategory(WebDriver driver) {
		super(driver);
		categoryName = "";
	}
	
	// we select the price section and start moving the slider by the left side
	public void filterByPrice() {
		
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathLaptopCategory));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathOptionPrice));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.moveSliderLeft(driver, By.xpath(xPathSlider), 5);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.moveSliderLeft(driver, By.xpath(xPathSlider), 10);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.moveSliderLeft(driver, By.xpath(xPathSlider), 1);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.moveSliderLeft(driver, By.xpath(xPathSlider), 20);
	}
	
	// we select the Weight section and start clicking on some check boxes
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
	}
	
	// we select the Color section and start selecting some color options
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
	}
	
	// we select the highlighted product
	public void buyHighlightedProduct() {
		
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathLaptopHeadphones));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathHighlightedProduct));
	}
	
	// we check the category's name
	public void checkCategoryName() {
		
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		keywords.clickElement(driver, By.xpath(xPathLaptopCategory));	
		categoryName = keywords.getText(driver,By.xpath(xPathCategoryHeader));
	}
		
	// accessor method to get the category's name
	public String getCategoryName() {
		return categoryName;
	}
		
}

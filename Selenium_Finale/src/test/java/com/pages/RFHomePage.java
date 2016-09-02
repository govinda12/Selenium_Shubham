package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RFHomePage extends BasePage{
	Actions actions = new Actions(driver);
	public RFHomePage(WebDriver driver){
		super(driver);
		
	}
	
	public void clickSubMenuOption() throws InterruptedException{
		WebElement shopSkinCare = driver.findElement(By.xpath("//span[@class='icon-search']/preceding::a[@id='our-products']"));
		actions.moveToElement(shopSkinCare).build().perform();
		driver.findElement(By.xpath("//div[@id='header-middle-top']//following::a[@title='All Products'][1]")).click();
		Thread.sleep(2000);
	}
	
	public String getCurrentUrl(){
		String getQuickShopUrl = driver.getCurrentUrl();
		System.out.println(getQuickShopUrl + "<<<==== quick shop url");
		return getQuickShopUrl;
	}

	public void clickSelectDropDownValues(){
		driver.findElement(By.xpath("//input[@value='- Product(s) -']")).click();
		driver.findElement(By.xpath("//div[@id='quick-refine']/div[2]/div[1]/ul/li[1]/form/div/div[1]/div[2]/div")).click();
		driver.findElement(By.xpath("//input[@value='- Product(s) -']")).click();
		driver.findElement(By.xpath("//div[@id='quick-refine']/div[2]/div[1]/ul/li[2]/form/div/div[1]/div[2]/div")).click();
		driver.findElement(By.xpath("//input[@value='- Price -']")).click();
		driver.findElement(By.xpath("//div[@id='quick-refine']/div[2]/div[2]/ul/li[2]/form/div/div[1]/div[2]/div")).click();
	}

	public String verifyCheckboxChecked(){
		String verifyCheckboxChecked = driver.findElement(By.xpath("//div[@id='quick-filtered']//li/form/div")).getAttribute("class");
		return verifyCheckboxChecked;
	}
	
	public Boolean verifyPriceInCorrectRange(){
		WebElement priceElement =driver.findElement(By.xpath("//a[text()='REDEFINE Multi-Function Eye Cream']/../following-sibling::p/span"));
		String getPrice[] =priceElement.getText().split(" ");
		Float price = Float.parseFloat(getPrice[1]);
		System.out.println("getprice ====>> "+ getPrice[1]);
		
		if(price > 50.00 && price < 199.99 ){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isElementPresent(String str) {
		return isElementPresent(By.xpath("//div[@id='quick-filtered']//li/form/label[text()='"+str+"']"));
	}
	
	


}

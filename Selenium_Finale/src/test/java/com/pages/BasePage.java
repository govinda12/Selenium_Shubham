package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	public WebDriver driver;
	

	public BasePage(WebDriver driver){
		this.driver=driver;
	}

	public boolean isElementPresent(By by) {
		List<WebElement> le =  driver.findElements(by);
	     if(le.size()==0){
	    	 return false;
	     }
	    	return true;
	}
	
}

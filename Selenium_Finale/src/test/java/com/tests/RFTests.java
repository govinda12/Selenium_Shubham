package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.RFHomePage;

public class RFTests extends BaseTest{
	
	
	@Test
	public void testScenario1() throws InterruptedException{
		RFHomePage rfPage = new RFHomePage(driver);
		
		rfPage.clickSubMenuOption();
		String getCurrentUrl = rfPage.getCurrentUrl();
		Assert.assertTrue(getCurrentUrl.contains("quickShop"), "Url contains Quickshop");
		rfPage.clickSelectDropDownValues();
		
		String verifyCheckboxChecked = rfPage.verifyCheckboxChecked();
		Assert.assertTrue(verifyCheckboxChecked.contains("checked"), " Check box not Selected");
		
		Assert.assertTrue(rfPage.isElementPresent("REDEFINE")," REDEFINE ELEMENT NOT PRESENT");
		Assert.assertTrue(rfPage.isElementPresent("REVERSE")," REVERSE ELEMENT NOT PRESENT");
		Assert.assertTrue(rfPage.isElementPresent("CAD$50 TO CAD$199.99")," CAD$50 TO CAD$199.99 ELEMENT NOT PRESENT");
		
		Assert.assertTrue(rfPage.verifyPriceInCorrectRange(), " Price is Not Correct");
		
		
	}
	


}

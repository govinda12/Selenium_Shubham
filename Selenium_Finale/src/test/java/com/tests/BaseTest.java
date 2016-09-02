package com.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;


public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.rodanandfields.com/ca/");
	}
	
	@AfterSuite
	public void quit(){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String ImageFileName = new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
        String destDir = System.getProperty("user.dir") + "/" + "test-output/screenshots";
        new File(destDir ).mkdirs();
        String destFile = destDir + "/" + ImageFileName;
		try {
			FileUtils.copyFile(file, new File(destFile ));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}

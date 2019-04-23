package com.google.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.qa.base.TestBase;


public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	
	public static void takeScreenshotAtEndOfFailedTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
	}
	
	public static void explicitWaitElementToBeClickable(WebDriver driver, By locator, int timeout) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static void explicitWaitPresenceOfElement(WebDriver driver, By locator, int timeout) 
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	
	/*public static void acceptCookie() {
		WebElement acceptCookieButton = driver.findElement(By.xpath("//div[@id='hs-en-cookie-confirmation-buttons-area']//a[contains(text(),'Accept')]"));
		if(acceptCookieButton!=null) {
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(acceptCookieButton));
			acceptCookieButton.click();
		}
	}*/

}

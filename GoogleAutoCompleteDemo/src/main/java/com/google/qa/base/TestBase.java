package com.google.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.qa.util.TestUtil;
import com.google.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver efdriver;
	public static WebEventListener eventListener;
	
	
	//Base Class Constructor
	public TestBase() {
		try {
			prop = new Properties();
			InputStream fis = new FileInputStream("C:\\Users\\ankur\\eclipse-workspace\\GoogleAutoCompleteDemo\\src\\main\\java\\com\\google\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		//Read the desired browser properties
		String browsername = prop.getProperty("browser");
		switch (browsername) {
		
		case"chrome":
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankur\\eclipse-workspace\\GoogleAutoCompleteDemo\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		break;
		
		case"firefox":
			System.setProperty("webdriver.gecko.driver", "PATH TO GECKO DRIVER");
			driver = new ChromeDriver();
			break;
			
		case"ie":
			System.setProperty("webdriver.ie.driver", "PATH TO IE DRIVER");
			driver = new ChromeDriver();
			break;
			
		default:
			System.out.println("No browser selected, exiting the system....");
			System.exit(0);
		}
		
		efdriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		efdriver.register(eventListener);
		driver = efdriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	

}

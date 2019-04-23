package com.google.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.HomePage;
import com.google.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void verifyMaximumNumberOfAutoSuggestItemsForAValidText() {
		homePage.clickSearchField();
		homePage.enterTextInSearchField(prop.getProperty("ValidText"));
		homePage.waitForAutoSuggestPanelToLoad();
		Assert.assertEquals(homePage.getListOfAutoSuggestedItems().size(), 10);
	}
	
	@Test
	public void verifyNoAutoSuggestItemsAreAvailableForInvalidValidText() {
		homePage.clickSearchField();
		homePage.enterTextInSearchField(prop.getProperty("InvalidText"));
		Assert.assertEquals(homePage.getListOfAutoSuggestedItems().size(), 0);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

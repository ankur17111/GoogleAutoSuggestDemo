package com.google.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.qa.base.TestBase;
import com.google.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	//Page Factory - Object Repository
	@FindBy(name="q")
	WebElement SearchField;
	
	By SearchFieldLocator = By.name("q");
	
	@FindBy(className="erkvQe")
	WebElement AutoSuggestPane;
	
	By AutoSuggestPaneLocator = By.className("erkvQe");
	
	@FindAll({@FindBy(xpath="//ul[@class='erkvQe']//li")})
	List<WebElement> AutoSuggestList;
	//Initialize Page Objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions or methods on HomePage
	
	public void clickSearchField() {
		TestUtil.explicitWaitElementToBeClickable(driver, SearchFieldLocator, 5);
		SearchField.click();
	}
	
	public void enterTextInSearchField(String str) {
		SearchField.sendKeys(str);
	}
	
	public void waitForAutoSuggestPanelToLoad() {
		TestUtil.explicitWaitPresenceOfElement(driver, AutoSuggestPaneLocator, 5);
	}
	
	public List<WebElement> getListOfAutoSuggestedItems() {
		return AutoSuggestList;
	}

}

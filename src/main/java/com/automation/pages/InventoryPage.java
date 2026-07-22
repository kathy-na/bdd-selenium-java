package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class InventoryPage extends BasePage {
	
	private By pageTitle = By.className("title");
	
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	
	public String getPageTitle() {
		return getText(pageTitle);
	}
	
	public boolean isInventoryPageDisplayed() {
		return getPageTitle().equals("Products");
	}

}

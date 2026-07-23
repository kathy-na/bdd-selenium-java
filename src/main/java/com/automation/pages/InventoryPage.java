package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class InventoryPage extends BasePage {
	
	private By pageTitle = By.className("title");
	private By cartBadge = By.className("shopping_cart_badge");
	
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	
	public String getPageTitle() {
		return getText(pageTitle);
	}
	
	public boolean isInventoryPageDisplayed() {
		return getPageTitle().equals("Products");
	}
	
	
	public void addProductToCart(String productName) {
		
		By addButton = By.xpath("//div[text()='"+productName+"']"+"/ancestor::div[@class='inventory_item']"+"//button");
		click(addButton);
		
	}
	
	public String getCartBadgeCount() {
		return getText(cartBadge);
	}
	

}

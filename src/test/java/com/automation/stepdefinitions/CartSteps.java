package com.automation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.automation.factory.DriverFactory;
import com.automation.pages.InventoryPage;

import io.cucumber.java.en.*;

public class CartSteps{
	private InventoryPage inventoryPage;
	
	@When("I add the {string} product to the cart")
	public void i_add_the_product_to_the_cart(String productName) {
		
		inventoryPage = new InventoryPage(DriverFactory.getDriver());
		inventoryPage.addProductToCart(productName);
	}
	
	@Then("the shopping cart badge should display {string}")
	public void the_shopping_cart_badge_should_display(String expectedCount) {
		 inventoryPage = new InventoryPage(DriverFactory.getDriver());
		assertEquals(expectedCount, inventoryPage.getCartBadgeCount());
	}
	
}
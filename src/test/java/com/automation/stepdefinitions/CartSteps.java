package com.automation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.automation.factory.DriverFactory;
import com.automation.pages.CartPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.CheckoutPage;


import io.cucumber.java.en.*;

public class CartSteps{
	private InventoryPage inventoryPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	
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
	 
	@When("I remove the {string} product from the cart")
	public void i_remove_the_product_from_the_cart(String productName) {
		inventoryPage = new InventoryPage(DriverFactory.getDriver());
		inventoryPage.removeProduct(productName);
	}
	
	@Then("the shopping cart badge should disappear")
	public void the_shopping_cart_badge_should_disappear() {
		assertTrue(inventoryPage.waitUntilCartBadgeDisappears());
	}
	
	@When("I open the shopping cart")
	public void i_open_the_shopping_cart() {
		inventoryPage = new InventoryPage(DriverFactory.getDriver());
		inventoryPage.openShoppingCart();
	}

	@When("I proceed to checkout")
	public void i_proceed_to_checkout() {
		 cartPage =new CartPage(DriverFactory.getDriver());
	        cartPage.proceedToCheckout();
	}

	@When("I enter checkout information with first name {string}, last name {string}, and postal code {string}")
	public void i_enter_checkout_information_with_first_name_last_name_and_postal_code(
		    String firstName,
	        String lastName,
	        String postalCode) {

	    checkoutPage = new CheckoutPage(DriverFactory.getDriver());

	    checkoutPage.enterCheckoutInformation(
	            firstName,
	            lastName,
	            postalCode
	    );
	}
	
	@When("I complete the order")
	public void i_complete_the_order() {
		checkoutPage = new CheckoutPage(DriverFactory.getDriver());
		checkoutPage.clickContinue();
		checkoutPage.clickFinish();
	}

	@Then("the order should be completed successfully")
	public void the_order_should_be_completed_successfully() {
		checkoutPage = new CheckoutPage(DriverFactory.getDriver());
		
		assertTrue(checkoutPage.isOrderCompleted());
	}
	
	
}
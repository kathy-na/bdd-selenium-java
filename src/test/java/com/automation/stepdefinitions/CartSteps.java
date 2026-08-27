package com.automation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.automation.factory.DriverFactory;
import com.automation.pages.CartPage;
import com.automation.pages.InventoryPage;
import com.automation.pages.CheckoutPage;

import java.util.List;
import io.cucumber.datatable.DataTable;


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
		
		System.out.println("First name received: [" + firstName + "]");
	    System.out.println("Last name received: [" + lastName + "]");
	    System.out.println("Postal code received: [" + postalCode + "]");

	    checkoutPage = new CheckoutPage(DriverFactory.getDriver());
	    
	    checkoutPage.enterCheckoutInformation(
	            firstName,
	            lastName,
	            postalCode
	    );

	}
	
	@When("I click the Continue button")
	public void i_click_the_countinue_button() {
		checkoutPage = new CheckoutPage(DriverFactory.getDriver());
		checkoutPage.clickContinue();
		
		System.out.println(
	            "Current URL: " +
	            DriverFactory.getDriver().getCurrentUrl()
	    );

	    System.out.println(
	            "Page title: " +
	            checkoutPage.getPageTitle()
	    );
		
	}
	
	/* 오류 보기 위해 추가 */
	@Then("I should be on the checkout overview page")
	public void i_should_be_on_the_checkout_overview_page() {
	    assertTrue(
	        checkoutPage.isOverviewPageDisplayed(),
	        "Checkout Overview 화면으로 이동하지 않았습니다."
	    );
	}
	
	
	@When("I finish the order")
	public void i_finish_the_order() {
		checkoutPage = new CheckoutPage(DriverFactory.getDriver());
		checkoutPage.clickFinish();
	}
	
	@Then("the order should be completed successfully")
	public void the_order_should_be_completed_successfully() {
		checkoutPage = new CheckoutPage(DriverFactory.getDriver());
		
		assertTrue(checkoutPage.isOrderCompleted(),"Order completion message was not displayed as expected.");
	}

	@Then("the checkout error message should be {string}")
	public void the_checkout_error_message_should_be(String expectedMessage) {
		checkoutPage = new CheckoutPage(DriverFactory.getDriver());
		String actualMessage = checkoutPage.getErrorMessage();
		
		assertEquals(expectedMessage, actualMessage);
	}
	
	@Then("the cart should contain the following products:")
	public void the_cart_should_contain_the_following_products(io.cucumber.datatable.DataTable dataTable) {
	    cartPage = new CartPage(DriverFactory.getDriver());
	    
	    List<String> expectedProducts = dataTable.asList();
	    
	    List<String> actualProducts = cartPage.getCartProductNames();
	    
	    assertEquals(expectedProducts, actualProducts);

	}
	
	@Then("the item total should equal the sum of the individual product prices")
	public void the_item_total_should_equal_the_sum_of_the_individual_product_prices() {
		checkoutPage = new CheckoutPage(DriverFactory.getDriver());
		
		List<Double> individualPrices = checkoutPage.getIndividualProductPrices();
		
		double expectedItemTotal = individualPrices.stream().mapToDouble(Double::doubleValue).sum();
		
		double actualItemTotal = checkoutPage.getItemTotal();
		
		System.out.println("Expected Item Total:" + expectedItemTotal);
		System.out.println("Actual Item Total:" + actualItemTotal);
		
		assertEquals(expectedItemTotal,actualItemTotal,0.01);
	}

	@Then("the total amount should equal the item total plus tax")
	public void the_total_amount_should_equal_the_item_total_plus_tax() {
		checkoutPage = new CheckoutPage(DriverFactory.getDriver());
		
		double itemTotal = checkoutPage.getItemTotal();
		double tax = checkoutPage.getTax();
		double expectedTotal = itemTotal + tax;
		double actualTotal = checkoutPage.getTotal();
		System.out.println("Item Total:"+ itemTotal);
		System.out.println("Tax:"+ tax);
		System.out.println("Expected Total:"+ expectedTotal);
		System.out.println("Actual Total:"+ actualTotal);
		assertEquals(expectedTotal, actualTotal, 0.01);
	}
	
	
	
}
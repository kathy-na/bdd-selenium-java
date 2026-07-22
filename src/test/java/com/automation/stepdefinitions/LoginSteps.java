package com.automation.stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.automation.factory.DriverFactory;
import com.automation.pages.InventoryPage;
import com.automation.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	private LoginPage loginPage;
	private InventoryPage inventoryPage;
    
	@Given("I open the SauceDemo login page")
	public void i_open_the_sauce_demo_login_page(){
		loginPage = new LoginPage(DriverFactory.getDriver());
		loginPage.openLoginPage();
	}
	
	@When("I login with username {string} and password {string}")
	public void i_login_with_username_and_password(String username, String password) {
		loginPage.login(username, password);
	}
	
	@Then("I should be redirected to the inventory page")
	public void i_should_be_redirected_to_the_inventory_page() {
		inventoryPage = new InventoryPage(DriverFactory.getDriver());
		
		assertTrue(inventoryPage.isInventoryPageDisplayed());
	}
	
}

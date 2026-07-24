Feature: Shopping Cart

Scenario: Add a product to the shopping cart

Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
When I add the "Sauce Labs Backpack" product to the cart
Then the shopping cart badge should display "1"

Scenario: Remove a product from the shopping cart

Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
And I add the "Sauce Labs Backpack" product to the cart
When I remove the "Sauce Labs Backpack" product from the cart
Then the shopping cart badge should disappear

Scenario: Complete checkout successfully

Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
And I add the "Sauce Labs Backpack" product to the cart
When I open the shopping cart
And I proceed to checkout
And I enter checkout information with first name "Juliet", last name "Kim", and postal code "56789"
And I complete the order
Then the order should be completed successfully

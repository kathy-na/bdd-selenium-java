Feature: Shopping Cart
@TC-CART-001
Scenario: Add a product to the shopping cart

Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
When I add the "Sauce Labs Backpack" product to the cart
Then the shopping cart badge should display "1"

@TC-CART-002
Scenario: Remove a product from the shopping cart

Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
And I add the "Sauce Labs Backpack" product to the cart
When I remove the "Sauce Labs Backpack" product from the cart
Then the shopping cart badge should disappear

@TC-ORDER-001
Scenario: Complete checkout successfully

Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
And I add the "Sauce Labs Backpack" product to the cart
When I open the shopping cart
And I proceed to checkout
And I enter checkout information with first name "Juliet", last name "Kim", and postal code "56789"
And I click the Continue button
Then I should be on the checkout overview page
And I finish the order
Then the order should be completed successfully

@TC-ORDER-002
Scenario: Checkout fails when postal code is missing
Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
And I add the "Sauce Labs Backpack" product to the cart
And I open the shopping cart
And I proceed to checkout
When I enter checkout information with first name "Juliet", last name "Kim", and postal code ""
And I click the Continue button
Then the checkout error message should be "Error: Postal Code is required"

@TC-ORDER-003
Scenario: Complete checkout with multiple products and verify total amount
Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
And I add the "Sauce Labs Bike Light" product to the cart
And I add the "Sauce Labs Bolt T-Shirt" product to the cart
Then the shopping cart badge should display "2"

When I open the shopping cart
Then the cart should contain the following products:
|Sauce Labs Bike Light|
|Sauce Labs Bolt T-Shirt|

When I proceed to checkout
And I enter checkout information with first name "Juliet", last name "Kim", and postal code "56789"
And I click the Continue button
Then I should be on the checkout overview page
And the item total should equal the sum of the individual product prices
And the total amount should equal the item total plus tax
And I finish the order
Then the order should be completed successfully



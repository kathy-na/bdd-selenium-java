Feature: Shopping Cart

Scenario: Add a product to the shopping cart

Given I open the SauceDemo login page
And I login with username "standard_user" and password "secret_sauce"
When I add the "Sauce Labs Backpack" product to the cart
Then the shopping cart badge should display "1"
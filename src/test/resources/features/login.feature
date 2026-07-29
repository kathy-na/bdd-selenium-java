Feature: Login functionality
@TC-LOGIN-001
  Scenario: Successful login with valid credentials
  
     Given I open the SauceDemo login page
     When I login with username "standard_user" and password "secret_sauce"
     Then I should be redirected to the inventory page
     

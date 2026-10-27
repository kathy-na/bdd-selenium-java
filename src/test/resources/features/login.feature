Feature: Login functionality
@TC-LOGIN-001
  Scenario: Successful login with valid credentials
  
     Given I open the SauceDemo login page
     When I login with username "standard_user" and password "secret_sauce"
     Then I should be redirected to the inventory page
     
@TC-LOGIN-002
  Scenario: Login wiith a locked out user
     Given I open the SauceDemo login page
     When I login with username "locked_out_user" and password "secret_sauce"
	 Then I should see the login error message "Epic sadface: Sorry, this user has been locked out."
	 And I should remain on the login page
  
@TC-LOGIN-003
  Scenario: Login fails with an incorrect password
     Given I open the SauceDemo login page
     When I login with username "standard_user" and password "wrong_password"
     Then I should see the login error message "Epic sadface: Username and password do not match any user in this service"
     And I should remain on the login page
     
@TC-LOGIN-004
  Scenario: Login fails with and empty password
    Given I open the SauceDemo login page
    When I login with username "standard_user" and password ""
    Then I should see the login error message "Epic sadface: Password is required"
    And I should remain on the login page
    
@TC-LOGIN-005
  Scenario: Login fails with and empty username
	Given I open the SauceDemo login page   
    When I login with username "" and password "secret_sauce"
    Then I should see the login error message "Epic sadface: Username is required"
    And I should remain on the login page
    
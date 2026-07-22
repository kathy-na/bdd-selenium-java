package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.utils.Constants;

public class LoginPage extends BasePage {
	
	private By usernameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.cssSelector("[data-test='error']");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

    public void enterUsername(String username) {
    	type(usernameInput, username);
    }
	
    public void enterPassword(String password) {
    	type(passwordInput, password);
    }
    
    public void clickLogin() {
    	click(loginButton);
    }
    
    public void login(String username, String password) {
    	enterUsername(username);
    	enterPassword(password);
    	clickLogin();
    }
    
    public void openLoginPage() {
    	open(Constants.BASE_URL);
    }
    
    public String getErrorMessage() {
    	return getText(errorMessage);
    }
  
}

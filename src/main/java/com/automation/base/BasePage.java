package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(
				driver,
				Duration.ofSeconds(10)
				);
	}
	
	public void open(String url) {
		driver.get(url);
	}
	
	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	
	protected void type(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	protected String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	protected boolean isDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}

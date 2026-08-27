package com.automation.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.stream.Collectors;

import com.automation.base.BasePage;

public class CheckoutPage extends BasePage {

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By completeMessage = By.className("complete-header");
    private By errorMessage = By.cssSelector("[data-test='error']");
    private By individualProductPrices = By.className("inventory_item_price");
    private By pageTitle = By.className("title");
    private By itemTotalLabel = By.className("summary_subtotal_label");
    private By taxLabel = By.className("summary_tax_label");
    private By totalLabel = By.className("summary_total_label");
    private double parsePrice(String priceText) {
    	String numericText = priceText.replaceAll("[^0-9.]", "");
    	return Double.parseDouble(numericText);
    }
    
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    
    
    public String getPostalCodeValue() {
        return driver.findElement(postalCodeInput)
                .getAttribute("value");
    }
        
    public void enterCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode) {

        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
        
        System.out.println(
                "First name field value: [" +
                driver.findElement(firstNameInput).getAttribute("value") +
                "]"
        );

        System.out.println(
                "Last name field value: [" +
                driver.findElement(lastNameInput).getAttribute("value") +
                "]"
        );

        System.out.println(
                "Postal code field value: [" +
                driver.findElement(postalCodeInput).getAttribute("value") +
                "]"
        );
        
    }

    public void clickContinue() {
        click(continueButton);
    }
    
    public boolean isOverviewPageDisplayed() {
        try {
            wait.until(
                ExpectedConditions.urlContains("checkout-step-two.html")
            );
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    
    
    public void clickFinish() {
        click(finishButton);
    }

    public String getCompleteMessage() {
        return getText(completeMessage);
    }

    public boolean isOrderCompleted() {
        return getCompleteMessage().equals("Thank you for your order!");
    }
    
    public String getErrorMessage() {
    	return getText(errorMessage);
    }
    
    

	public String getPageTitle() {
	    return getText(pageTitle);
	}

	public boolean isCheckoutOverviewDisplayed() {
	    return getPageTitle().equals("Checkout: Overview");
	}
	
	public List<Double> getIndividualProductPrices() {
		return driver.findElements(individualProductPrices)
				.stream().map(element -> element.getText())
				.map(priceText ->priceText.replace("$",""))
				.map(Double::parseDouble)
				.collect(Collectors.toList());
	}
	
	public double getItemTotal() {
		
		String itemTotalText = driver.findElement(itemTotalLabel).getText();
		return parsePrice(itemTotalText);
	}
	
	public double getTax() {
		String taxText = driver.findElement(taxLabel).getText();
		return parsePrice(taxText);
	}
	
	public double getTotal() {
		String totalText = driver.findElement(totalLabel).getText();
		return parsePrice(totalText);
		
	}
}
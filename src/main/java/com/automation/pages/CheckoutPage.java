package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class CheckoutPage extends BasePage {

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By completeMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode) {

        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(postalCodeInput, postalCode);
    }

    public void clickContinue() {
        click(continueButton);
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
}
package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class CartPage extends BasePage {

    private By pageTitle = By.className("title");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isCartPageDisplayed() {
        return getPageTitle().equals("Your Cart");
    }

    public boolean isProductDisplayed(String productName) {
        By productNameLocator = By.xpath(
                "//div[@class='inventory_item_name' and text()='"
                + productName
                + "']"
        );

        return isDisplayed(productNameLocator);
    }

    public void removeProduct(String productName) {
        By removeButton = By.xpath(
                "//div[text()='" + productName + "']"
                + "/ancestor::div[@class='cart_item']"
                + "//button[text()='Remove']"
        );

        click(removeButton);
    }

    public void proceedToCheckout() {
        click(checkoutButton);
    }

    public void continueShopping() {
        click(continueShoppingButton);
    }
}
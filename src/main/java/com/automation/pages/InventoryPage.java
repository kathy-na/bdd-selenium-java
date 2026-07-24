package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.BasePage;

public class InventoryPage extends BasePage {

    private By pageTitle = By.className("title");
    private By cartBadge = By.className("shopping_cart_badge");
    private By shoppingCartLink = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isInventoryPageDisplayed() {
        return getPageTitle().equals("Products");
    }

    public void addProductToCart(String productName) {

        By addButton = By.xpath(
                "//div[text()='" + productName + "']"
                + "/ancestor::div[@class='inventory_item']"
                + "//button"
        );

        click(addButton);
    }

    public void removeProduct(String productName) {

        By removeButton = By.xpath(
                "//div[text()='" + productName + "']"
                + "/ancestor::div[@class='inventory_item']"
                + "//button[text()='Remove']"
        );

        click(removeButton);
    }

    public String getCartBadgeCount() {
        return getText(cartBadge);
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(cartBadge).isEmpty();
    }

    public boolean waitUntilCartBadgeDisappears() {
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(5));

        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(cartBadge)
        );
    }

    public void openShoppingCart() {
        click(shoppingCartLink);
    }
}
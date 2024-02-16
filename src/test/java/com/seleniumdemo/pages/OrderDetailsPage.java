package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    @FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")
    private WebElement orderNotice;

    @FindBy(xpath = "//td[contains(@class,'woocommerce-table__product-name product-name')]")
    private WebElement purchasedProductName;

    public WebElement getPurchasedProductName() {
        return purchasedProductName;
    }

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public WebElement getOrderNotice() {
        return orderNotice;
    }
}

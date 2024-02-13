package com.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    @FindBy(id = "reg_email")
    private WebElement regEmailInput;
    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;
    @FindBy(xpath = "//button[@name='register']")
    private WebElement regButton;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public LoggedUserPage registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
        regButton.click();
        return new LoggedUserPage(driver);
    }
}

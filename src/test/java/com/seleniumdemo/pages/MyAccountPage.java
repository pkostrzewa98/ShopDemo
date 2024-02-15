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
    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement logInButton;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public LoggedUserPage registerUserValidData(String email, String password) {
        registerUser(email,password);
        return new LoggedUserPage(driver);
    }
    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email,password);
        return this;
    }

    public LoggedUserPage logInUserValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInUserInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }

    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        logInButton.click();
    }

private void registerUser(String email, String password) {
    regEmailInput.sendKeys(email);
    regPasswordInput.sendKeys(password);
    regButton.click();
}
    public WebElement getError() {
        return error;
    }
}

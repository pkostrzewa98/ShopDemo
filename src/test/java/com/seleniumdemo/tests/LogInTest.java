package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInUserValidData("test1@mnn.vn", "TesttEst123@1!")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInInvalidPassword() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInUserInvalidData("test1@mnn.vn", "TesttEst123@4!")
                .getError();

        Assert.assertTrue(error.getText().contains(": Incorrect username or password."), "Expected error doesn't match");
    }
}



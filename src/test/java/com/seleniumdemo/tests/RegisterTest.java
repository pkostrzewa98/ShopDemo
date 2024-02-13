package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void registerUserTest() {
        WebElement dashboardLink = new HomePage(driver).openMyAccountPage()
                .registerUser("test5@mnn.vn", "TesttEst123@1!").getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }
}

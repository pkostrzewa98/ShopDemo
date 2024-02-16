package com.seleniumdemo.pages;

import com.seleniumdemo.models.Customer;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement conmapnyNameInput;

    @FindBy(id = "billing_country")
    private WebElement billingCountrySelect;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressInput;

    @FindBy(id = "billing_address_2")
    private WebElement billingAddressInputOptional;

    @FindBy(id = "billing_postcode")
    private WebElement billingPostcodeInput;

    @FindBy(id = "billing_city")
    private WebElement cityInput;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;

    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;

    @FindBy(id = "order_comments")
    private WebElement commentsInput;
    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage     fillCustomerDetails(Customer customer, String comments) throws InterruptedException {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        conmapnyNameInput.sendKeys(customer.getCompanyName());
        Select contrySelect = new Select(billingCountrySelect);
        contrySelect.selectByVisibleText(customer.getCountry());
        billingAddressInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostcodeInput.sendKeys(customer.getZipCode());
        cityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        commentsInput.sendKeys(comments);
        Thread.sleep(1500);
        placeOrderButton.click();

            return new OrderDetailsPage(driver);
        }
    }



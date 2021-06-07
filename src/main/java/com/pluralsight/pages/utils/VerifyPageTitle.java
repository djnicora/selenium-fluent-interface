package com.pluralsight.pages.utils;

import static com.pluralsight.DriverFactory.getDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public enum VerifyPageTitle {

    HOMEPAGETITLE("Selenium Easy - Best Demo website to practice Selenium Webdriver Online"),
    SIMPLEFORMPAGETITLE("Selenium Easy Demo - Simple Form to Automate using Selenium"),
    CHECKBOXPAGETITLE("Selenium Easy - Checkbox demo for automation using selenium"),
    RADIOBUTTONSPAGETITLE("Selenium Easy Demo - Radio buttons demo for Automation");

    private String title;
    WebDriver driver = getDriverInstance();

    VerifyPageTitle(String title) {
        this.title = title;
    }

    public void verify() {
        Assert.assertTrue(driver.getTitle().equals(title), "The title is not right!!");

    }

}

package com.pluralsight.pages.utils;

import static com.pluralsight.DriverFactory.getDriverWaitInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum Navigation {

    SIMPLEFORMPAGE("Simple Form Demo"),
    CHECKBOXPAGE("Checkbox Demo"), 
    RADIOBUTTONSPAGE("Radio Buttons Demo");

    private String page;
    WebDriverWait wait = getDriverWaitInstance();

    Navigation(String page) {
        this.page = page;
    }

    public void navigate() {
        WebElement navigateToSimple = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id]//a[contains(text(),'" + page + "')]")));
        navigateToSimple.click();

    }

}

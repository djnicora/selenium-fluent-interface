package com.pluralsight.pages;

import static com.pluralsight.DriverFactory.getDriverInstance;
import static com.pluralsight.DriverFactory.getDriverWaitInstance;
import static com.pluralsight.pages.Verifications.*;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pluralsight.pages.utils.FieldEntries;

public class Acts {

    private WebDriver driver = getDriverInstance();
    private WebDriverWait wait = getDriverWaitInstance();


    WebElement imputField;
    WebElement button;
    String message;

    public Acts imputField(FieldEntries value) {
        imputField = driver.findElement(By.id("user-message"));
        imputField.sendKeys(value.toString());
        return this;
    }

    public Acts clickButton() {
        button = driver.findElement(withTagName("button").below(imputField));
        button.click();
        return this;
    }
    
    public Verifications andThen() {
         return getVerificationsController(); //returning verification class methods 
        
    }

  
    
}

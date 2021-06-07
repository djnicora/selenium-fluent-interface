package com.pluralsight.pages;

import static com.pluralsight.DriverFactory.getDriverInstance;
import static com.pluralsight.DriverFactory.getDriverWaitInstance;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pluralsight.BaseTestClass;

public class RadioButtonsPage {
    
    
    private WebDriver driver = getDriverInstance();
    private WebDriverWait wait = getDriverWaitInstance();
    WebElement radioButtonResult;
    WebElement femaleRadioButton;
    
    private RadioButtonsPage() {
        // hide it
    }

    public static RadioButtonsPage getRadioButtonsPage() {
        return new RadioButtonsPage(); // returns the class object
    }
    
    public RadioButtonsPage clickFemaleRadioButton() {
        femaleRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Radio Button Demo')]/..//input[@value='Female']")));
        femaleRadioButton.click();
        return this;
    }
    
    public RadioButtonsPage clickRadioButtonResult() {
        radioButtonResult = driver.findElement(withTagName("button").below(femaleRadioButton));
        radioButtonResult.click();
        return this;
    }
    
    public void verifyRadioButtonResultDisplay() {
        String isRadioButtonDisplayed = driver.findElement(withTagName("p").below(radioButtonResult)).getText();
        Assert.assertTrue(isRadioButtonDisplayed.contains("Female"));
    }
   
    
    
}

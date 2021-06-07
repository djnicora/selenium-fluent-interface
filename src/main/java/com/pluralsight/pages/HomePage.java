package com.pluralsight.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.pluralsight.DriverFactory.getDriverInstance;
import static com.pluralsight.DriverFactory.getDriverWaitInstance;;

public class HomePage {

    private WebDriver driver = getDriverInstance();
    private WebDriverWait wait = getDriverWaitInstance();
    
    private HomePage() {
        // hide it
    }
    
    public static HomePage getHomePage() {
        return new HomePage(); // returns the class object
    }

    public void ClosePopup() {
        By closePopup = (By.xpath("//a[@title='Close']"));
        wait.until(ExpectedConditions.elementToBeClickable(closePopup));
        driver.findElement(closePopup).click();
        
    }
    
    

}

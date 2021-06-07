package com.pluralsight;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static com.pluralsight.DriverFactory.getDriverInstance;
import static com.pluralsight.DriverFactory.getDriverWaitInstance;

public class BaseTestClass {
    
    static final Logger logger = LogManager.getLogger(BaseTestClass.class);
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://www.seleniumeasy.com/test/";
    

    @BeforeSuite
    public void startUpBrowser() {
        logger.info("Driver created");
        driver = getDriverInstance();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = getDriverWaitInstance();
        
    }

    @BeforeTest
    public void goToHomePage() {
        driver.get(url);
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        driver.close();
    }

    public void openNavigationTree() {
        WebElement openImportFormsNavigationTree = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id]//a[contains(text(),'Input Forms')]")));
        openImportFormsNavigationTree.click();
    }

    public void navigateTo(String page) {
        WebElement navigateToSimple = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id]//a[contains(text(),'" + page + "')]")));
        navigateToSimple.click();
    }


}

package com.pluralsight;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;
    

    private DriverFactory() {
        // private prevent instantiation of the class and makes
        // us able to use the pattern singleton
        // by instantiating only one instance to the webDriver

    }

    public static WebDriver getDriverInstance() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/browserDrivers/chromedriver.exe");
            driver = new ChromeDriver();

        }
        return driver;
    }

    public static WebDriverWait getDriverWaitInstance() {

        if (wait == null) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/browserDrivers/chromedriver.exe");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }
        return wait;
    }

}

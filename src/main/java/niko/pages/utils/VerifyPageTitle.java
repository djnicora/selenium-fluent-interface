package niko.pages.utils;

import static niko.DriverFactory.getDriverInstance;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public enum VerifyPageTitle {

    HOMEPAGETITLE("Selenium Easy - Best Demo website to practice Selenium Webdriver Online"),
    SIMPLEFORMPAGETITLE("Selenium Easy Demo - Simple Form to Automate using Selenium"),
    CHECKBOXPAGETITLE("Selenium Easy - Checkbox demo for automation using selenium"),
    RADIOBUTTONSPAGETITLE("Selenium Easy Demo - Radio buttons demo for Automation"),
    SELECTDROPDOWNLIST("Selenium Easy Demo - Automate All Scenarios"),
    AJAXFROMSUBMIT("Selenium Easy - Ajax Form submit demo for automation"),
    JQUERYSELECTTEST("Selenium Easy - JQuery Select and Multi Select Demo");

    private String title;
    WebDriver driver = getDriverInstance();

    VerifyPageTitle(String title) {
        this.title = title;
    }

    public void verify() {
        Assert.assertTrue(driver.getTitle().equals(title), "The title is not right!!");
    }

}

package niko.pages;

import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckboxPage {

    private WebDriver driver = getDriverInstance();
    private WebDriverWait wait = getDriverWaitInstance();
    WebElement checkBox;
    
    private CheckboxPage() {
        //hide it
    }

    public static CheckboxPage getCheckboxPage() {
        return new CheckboxPage(); // returns the class object
    }
    
    /*
     * Returning the methods like this makes us able to implements the pattern
     * method chaining
     */
    public CheckboxPage clickCheckBox() {
        checkBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='isAgeSelected']")));
        checkBox.click();
        return this;
    }
    
    public void verifycheckBoxchecked() {
        WebElement isCheckBoxDisplayed = driver.findElement(withTagName("div").below(checkBox));
        Assert.assertTrue(isCheckBoxDisplayed.isDisplayed());
    }
    
}

package niko.pages;

import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import niko.pages.utils.FieldEntries;

public class Verifications {
    
    private WebDriver driver = getDriverInstance();
    private WebDriverWait wait = getDriverWaitInstance();
    
    
    public static Verifications getVerificationsController() {  //method that returns Verifications class object
        return new Verifications();
    }
    

    public void verifyMessage(FieldEntries value) {
      String  message = driver.findElement(By.xpath("//span[@id='display']")).getText();
        Assert.assertTrue(message.equals(value.toString()), "The message: "+message +" is not equal to: "+value.toString()+" !!!");
    }
    
    
    
}

package com.pluralsight.pages;

import static com.pluralsight.DriverFactory.getDriverInstance;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExamplesController {

    WebDriver driver = getDriverInstance();
    
    public List<String> examples() {
        
        List<WebElement> examples = driver.findElements(By.xpath("(//ul[@id='treemenu']//li)//ul//i/following-sibling::a"));
 
        assertTrue(examples.size() !=0,"List is empty, failed to collect examples");//checking if the list is empty

        
      //transforming WebElement to elements getText and collecting it as a list
        return examples.stream().map(WebElement::getText).collect(Collectors.toList());   
    }
    
}

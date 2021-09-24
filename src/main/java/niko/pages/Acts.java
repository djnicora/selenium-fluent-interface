package niko.pages;

import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;
import static niko.pages.Verifications.*;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import niko.pages.utils.FieldEntries;
import niko.pages.utils.Utilities;

public class Acts {

	private WebDriver driver = getDriverInstance();
	private WebDriverWait wait = getDriverWaitInstance();
	Utilities utilities = new Utilities(driver);

	WebElement imputField;
	WebElement button;
	String imputFieldA = "document.getElementById('sum1')";
	String imputFieldB = "document.getElementById('sum2')";
	String totalButton = "document.getElementsByClassName('btn btn-default')[1]";
	By showMessage = By.xpath("(//button[@class='btn btn-default'])[1]");

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

	public Acts clickTotalButton() {
		button = driver.findElement(withTagName("button").below(button));
		button.click();
		return this;
	}

	public Verifications andThen() {
		return getVerificationsController(); // returning verification class methods

	}

	public Acts imputFieldA(String value) {
		utilities.typeJSKeyword(imputFieldA, value);
		return this;
	}

	public Acts imputFieldB(String value) {
		utilities.typeJSKeyword(imputFieldB, value);
		return this;
	}
	
	public Acts highlightButtons() {
		
		utilities.highlightElement(utilities.findElement(showMessage));
		utilities.highlightJSElement(totalButton);
		return this;
	}
	
	
	
	
	

}

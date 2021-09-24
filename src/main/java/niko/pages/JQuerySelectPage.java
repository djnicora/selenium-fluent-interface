package niko.pages;

import static niko.BaseTestClass.logger;
import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import niko.pages.utils.Utilities;

public class JQuerySelectPage {

	private WebDriver driver = getDriverInstance("CHROME");
	private WebDriverWait wait = getDriverWaitInstance();
	Utilities utilities = new Utilities(driver);

	String day;
	By selectCountryFieldDropdown = By.cssSelector("*[aria-labelledby='select2-country-container']");
	By countryField = By.cssSelector("span[class*='above'] input");

	By selectState = By.cssSelector("li[class*='inline'] input");

	private JQuerySelectPage() {
		// hide it
	}

	public static JQuerySelectPage getJQuerySelectPage() {
		return new JQuerySelectPage();// returns the class object
	}

	public JQuerySelectPage clickCountryDropDown() {
		utilities.click(selectCountryFieldDropdown);
		return this;
	}

	public JQuerySelectPage enterCountry(String name) {
		utilities.clearAndType(countryField, name);
		driver.findElement(countryField).sendKeys(Keys.ENTER);
		return this;
	}

	public JQuerySelectPage selectState(String state) {
		utilities.clearAndType(selectState, state);
		driver.findElement(selectState).sendKeys(Keys.ENTER);
		return this;
	}

//	public JQuerySelectPage enterName(String name) {
//		utilities.clearAndType(nameField,name);
//		return this;
//	}
//	
//	public JQuerySelectPage enterdescription(String desc) {
//		utilities.clearAndType(description,desc);
//		return this;
//	}
//	
//	public JQuerySelectPage verifyMessage() {
//		
//		WebElement messageElement = utilities.findElement(submitControl);
//		Boolean messageProcessing = wait.until(ExpectedConditions.textToBePresentInElement(messageElement,"Ajax Request is Processing!"));
//		logger.info(messageElement.getText());
//		Boolean messageSuccessfully = wait.until(ExpectedConditions.textToBePresentInElement(messageElement,"Form submited Successfully!"));
//		logger.info(messageElement.getText());
//		return this;
//	}
//	
//	public String verifyNameField() {
//		String nameFieldElement = driver.findElement(nameField).getAttribute("style").toString();
//		logger.info("Border has been changes to RED: "+nameFieldElement.toString());
//		return nameFieldElement;
//	}
//	

}

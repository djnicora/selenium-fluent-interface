package niko.pages;

import static niko.BaseTestClass.logger;
import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import niko.pages.utils.Utilities;

public class AjaxFormSubmitPage {

	private WebDriver driver = getDriverInstance("CHROME");
	private WebDriverWait wait = getDriverWaitInstance();
	Utilities utilities = new Utilities(driver);

	String day;
	By nameField = By.id("title");
	By submit = By.id("btn-submit");
	By description = By.id("description");
	By submitControl = By.id("submit-control");

	private AjaxFormSubmitPage() {
		// hide it
	}

	public static AjaxFormSubmitPage getAjaxFormSubmitPage() {
		return new AjaxFormSubmitPage();// returns the class object
	}

	public AjaxFormSubmitPage clickSubmit() {
		utilities.click(submit);
		return this;
	}
	
	public AjaxFormSubmitPage enterName(String name) {
		utilities.clearAndType(nameField,name);
		return this;
	}
	
	public AjaxFormSubmitPage enterdescription(String desc) {
		utilities.clearAndType(description,desc);
		return this;
	}
	
	public AjaxFormSubmitPage verifyMessage() {
		
		WebElement messageElement = utilities.findElement(submitControl);
		Boolean messageProcessing = wait.until(ExpectedConditions.textToBePresentInElement(messageElement,"Ajax Request is Processing!"));
		logger.info(messageElement.getText());
		Boolean messageSuccessfully = wait.until(ExpectedConditions.textToBePresentInElement(messageElement,"Form submited Successfully!"));
		logger.info(messageElement.getText());
		return this;
	}
	
	public String verifyNameField() {
		String nameFieldElement = driver.findElement(nameField).getAttribute("style").toString();
		logger.info("Border has been changes to RED: "+nameFieldElement.toString());
		return nameFieldElement;
	}
	
	

}

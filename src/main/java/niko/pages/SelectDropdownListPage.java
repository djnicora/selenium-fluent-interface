package niko.pages;

import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import niko.pages.utils.Utilities;

public class SelectDropdownListPage {

	private WebDriver driver = getDriverInstance("CHROME");
	private WebDriverWait wait = getDriverWaitInstance();
	Utilities utilities = new Utilities(driver);

	String day;

	By selectDropdown = (By.id("select-demo"));
	By selectedDay = (By.xpath("//p[@class='selected-value']"));
	By multiSelect = By.id("multi-select");
	By printButton = By.id("printAll");
	By print = By.id("printMe");

	private SelectDropdownListPage() {
		// hide it
	}

	public static SelectDropdownListPage getDropdownListPage() {
		return new SelectDropdownListPage();// returns the class object
	}

	public SelectDropdownListPage selectFromList(String day) {
		this.day = day;
		utilities.selectByVisibleText(selectDropdown, day);
		return this;
	}

	public void verifySelectedDay() {
		Assert.assertTrue(utilities.findElement(selectedDay).getText().contains(day), "Selected day does not match!!!");
	}

	public SelectDropdownListPage selectFromMultiList(String[] states) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL).perform();
		for (String state : states) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			utilities.selectByVisibleText(multiSelect, state);
		}
		a.keyUp(Keys.CONTROL).perform();
		return this;
	}

	public SelectDropdownListPage pressPrintAll() {
		utilities.click(printButton);
		return this;
	}

	public void verifyMultiSelectedStates() {
		Assert.assertTrue(utilities.findElement(selectedDay).getText().contains(day), "Selected day does not match!!!");
	}

}

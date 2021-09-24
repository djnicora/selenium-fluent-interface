package niko.pages.utils;

import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	private WebDriver driver = getDriverInstance();
	private WebDriverWait wait = getDriverWaitInstance();
	private JavascriptExecutor jsExec = (JavascriptExecutor) driver;
	

	public Utilities(WebDriver driver) {

		this.driver = driver;

	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public WebElement findElement(By l) {

		return wait(20).until(ExpectedConditions.visibilityOfElementLocated(l));

	}

	public WebElement findClickableElement(By l) {

		return wait(20).until(ExpectedConditions.elementToBeClickable(l));

	}

	public WebElement findHiddenElement(By l) {

		return wait(20).until(ExpectedConditions.presenceOfElementLocated(l));

	}

	public List<WebElement> findElements(By l) {

		return driver.findElements(l);

	}

	public boolean urlContains(String keyword) {

		return wait(20).until(ExpectedConditions.urlContains(keyword));

	}

	public boolean urlToBe(String url) {

		return wait(20).until(ExpectedConditions.urlToBe(url));

	}

	public boolean titleContains(String keyword) {

		return wait(20).until(ExpectedConditions.titleContains(keyword));

	}

	public boolean titleIs(String title) {

		return wait(20).until(ExpectedConditions.titleIs(title));

	}

	public String getWindowHandle() {

		return driver.getWindowHandle();

	}

	public Set getWindowHandles() {

		return driver.getWindowHandles();

	}

	public void switchToFrame(int i) {

		driver.switchTo().frame(i);

	}

	public void switchToFrame(String name) {

		driver.switchTo().frame(name);

	}

	public void switchToFrame(WebElement frame) {

		driver.switchTo().frame(frame);

	}

	public void click(By l) {

		WebElement element = findElement(l);

		element.click();

	}

	public void clearAndType(By l, String text) {

		WebElement element = findElement(l);

		element.clear();

		element.sendKeys(text);

	}

	public void selectByVisibleText(By l, String text) {

		WebElement element = findElement(l);

		Select list = new Select(element);

		list.selectByVisibleText(text);

	}

	public WebDriverWait wait(int n) {

		return new WebDriverWait(driver, Duration.ofSeconds(n));

	}
	
	public WebElement findJSElement(String element) {
		String jsQuery =  "return "+element;
		return (WebElement) jsExec.executeScript(jsQuery);
	}
	
	public void typeKeyword(RelativeBy relativeBy, String word) {
		

		String jsQuery = "document.getElementById('"+relativeBy+"').value='"+word+"'";

				jsExec.executeScript(jsQuery);

	}
	
	public void typeJSKeyword(String element, String word) {
		String jsQuery = "return "+element+".value='"+word+"'";
				jsExec.executeScript(jsQuery);
	}
	
	public void clickJSElement(String element) {
		String jsQuery =  "return "+element+".click()";
				jsExec.executeScript(jsQuery);
	}
	
	
	public String getJSElementValue(String element) {
		String jsQuery =  "return "+element+".innerHTML;";
			String	elementValue = jsExec.executeScript(jsQuery).toString();
				return elementValue;
	}
	
	public void highlightJSElement(String element) {
		String jsQuery =  "return "+element+".style.backgroundColor='red'";
		jsExec.executeScript(jsQuery);
		
	}
	
	public void highlightElement(WebElement webElement) {
            jsExec.executeScript("arguments[0].style.backgroundColor='red'", webElement);
    }
	
	

}

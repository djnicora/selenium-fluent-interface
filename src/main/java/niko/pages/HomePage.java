package niko.pages;

import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;
import static niko.BaseTestClass.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import niko.pages.utils.Utilities;

public class HomePage {

	private WebDriver driver = getDriverInstance("CHROME");
	private WebDriverWait wait = getDriverWaitInstance();
	Utilities utilities = new Utilities(driver);

	String url = "https://www.seleniumeasy.com/test/";
	By closePopup = (By.xpath("//a[@title='Close']"));
	By treeRoot = (By.xpath("//ul[@id='treemenu']//ul//a[@href='#']"));
	By closePopupText =  By.xpath("//[@id='at-cv-lightbox-message']//span");

	private HomePage() {
		// hide it
	}

	public static HomePage getHomePage() {
		return new HomePage(); // returns the class object
	}

	public HomePage navigateToHomePage() {
		driver.get(url);
		return this;
	}

	public void ClosePopup() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(closePopup));
			utilities.click(closePopup);
		} catch (Exception e) {
			logger.info("No Popup Showed!");
		}
	}

	public List<String> allCategoryTitles() {
		List<WebElement> treeRoot = utilities.findElements(this.treeRoot);
		List<String> values = new ArrayList<>();
		for (WebElement e : treeRoot)
			values.add(e.getText());
		return values;
	}

	public List<String> allSubCategoryTitles(String groupName) {
		List<String> subCategoryTitles = new ArrayList<>();
		List<WebElement> childElement = driver.findElements(
				By.xpath("//a[contains(text(),'All Examples')]//following-sibling::ul//a[contains(text(),'" + groupName
						+ "')]//following-sibling::ul//li//a"));
		for (WebElement e : childElement) {
			subCategoryTitles.add(e.getAttribute("innerHTML"));
		}
		return subCategoryTitles;
	}

	public List<String> displayGroupsAndSubCategory() {
		List<String> orderedList = new ArrayList<>();
		for (String item : allCategoryTitles()) {
			System.out.println("Group name****: " + item);
			for (String subItem : allSubCategoryTitles(item)) {
				System.out.println("Sub Group name: " + subItem);
			}
		}
		return orderedList;
	}
	
	
	public void handleSelect() {
	   Select s = new Select(driver.findElement(By.xpath("//select[@name=’selType’]")));
	      // getting the list of options in the dropdown with getOptions()
	      List <WebElement> op = s.getOptions();
	      int size = op.size();
	      
	      for(int i =0; i<size ; i++){
	         String options = op.get(i).getText();
	         System.out.println(options);
	      }
	
    
}

}

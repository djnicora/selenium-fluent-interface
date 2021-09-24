package niko.pages.utils;

import static niko.DriverFactory.getDriverWaitInstance;
import static niko.BaseTestClass.logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum Navigation {

    SIMPLEFORMPAGE("Input Forms/Simple Form Demo"),
    CHECKBOXPAGE("Input Forms/Checkbox Demo"), 
    RADIOBUTTONSPAGE("Input Forms/Radio Buttons Demo"),
	SELECTDROPDOWNLIST("Input Forms/Select Dropdown List"),
	AJAXFROMSUBMIT("Input Forms/Ajax Form Submit"),
	JQUERYSELECTTEST("Input Forms/JQuery Select dropdown");
	
	

    private String[] page;
    WebDriverWait wait = getDriverWaitInstance();

    Navigation(String page) {
        this.page = page.split("/");
    }

    public void navigate() {
    	logger.info("Navigate to Parent: "+page[0]+" child: "+page[1]);
    	openParentNavigationTree();
        WebElement navigateToSimple = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id]//a[contains(text(),'" + page[1].toString() + "')]")));
        navigateToSimple.click();

    }
    
    public Navigation openParentNavigationTree() {
		WebElement openImportFormsNavigationTree = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id]//a[contains(text(),'"+page[0].toString()+"')]")));
		openImportFormsNavigationTree.click();
		return this;
	}

}

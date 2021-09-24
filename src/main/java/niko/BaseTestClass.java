package niko;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static niko.DriverFactory.getDriverInstance;
import static niko.DriverFactory.getDriverWaitInstance;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;


import niko.pages.HomePage;
import niko.pages.utils.VerifyPageTitle;
import static niko.pages.HomePage.getHomePage;

public class BaseTestClass {

	public static final Logger logger = LogManager.getLogger(BaseTestClass.class);
	WebDriver driver;
	WebDriverWait wait;
	HomePage homePage = getHomePage();

	private static final String IMG_NAME = "screenshot.png";

//	// A static image stored under classpath
//	private static final String IMG_PATH = "src/test/resources/" + IMG_NAME;
//
//	// Using the same OUTPUT_PATH as set in extent.properties
//	// [extent.reporter.html.out]
//	private static final String OUTPUT_PATH = "test-output/HtmlReport/";

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite(alwaysRun = true)
	public void startUpBrowser() {
		driver = getDriverInstance("CHROME");
		logger.info("Driver created");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = getDriverWaitInstance();
	}
	
	@BeforeTest
	public void navigateToHome() {
		// homePage
		homePage.navigateToHomePage();
		VerifyPageTitle.HOMEPAGETITLE.verify();
		homePage.ClosePopup();
		
		
	}
	


	@AfterSuite(alwaysRun = true)
	public void cleanUp() {
		driver.close();
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) throws IOException {
		switch (result.getStatus()) {
		case ITestResult.FAILURE:
			ExtentTestManager.getTest(result).fail("ITestResult.FAILURE, event afterMethod",
					MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(driver)).build());
			break;
		case ITestResult.SKIP:
			ExtentTestManager.getTest(result).skip("ITestResult.SKIP, event afterMethod");
			break;
		default:
			break;
		}
	}



//	public void openNavigationTree() {
//		WebElement openImportFormsNavigationTree = wait.until(
//				ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id]//a[contains(text(),'Input Forms')]")));
//		openImportFormsNavigationTree.click();
//	}

	public void navigateTo(String page) {
		
		WebElement navigateToSimple = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id]//a[contains(text(),'" + page + "')]")));
		navigateToSimple.click();
	}

	public static String getScreenshot(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) getDriverInstance();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

}

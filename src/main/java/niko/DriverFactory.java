package niko;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory implements WebDriver, TakesScreenshot {

	private static WebDriver driver;
	private static WebDriverWait wait;
//    private final String browserName;
//    private final int timeout = 30; 
	private final static String chromeDriverPath = "./src/main/resources/browserDrivers/chromedriver.exe";

	private DriverFactory() {
		// private prevent instantiation of the class and makes
		// us able to use the pattern singleton
		// by instantiating only one instance to the webDriver

	}

//    public DriverFactory(String browserName) { 
//        this.browserName = browserName; 
//        driver = createDriver(browserName); 
//     } 

	public static WebDriver getDriverInstance(String browserName) {
		if (driver == null) {
			if (browserName.toUpperCase().equals("FIREFOX") ) {
//    to be continued 
			}
			if (browserName.toUpperCase().equals("CHROME") ) {
				driver = chromeDriver();
			} else {
				throw new RuntimeException("invalid browser name");
			}
		}
		return driver;
	}

	public static WebDriver getDriverInstance() {

//        if (driver == null) {
//            System.setProperty("webdriver.chrome.driver", "./src/main/resources/browserDrivers/chromedriver.exe");
//            driver = new ChromeDriver();
//
//        }
		return driver;
	}

	public static WebDriverWait getDriverWaitInstance() {

		if (wait == null) {
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		}
		return wait;
	}

	private static WebDriver chromeDriver() {
		if (!new File(chromeDriverPath).exists())
			throw new RuntimeException("chromedriver.exe does not exist!");

		try {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			return new ChromeDriver();
		}

		catch (Exception ex) {
			throw new RuntimeException("couldnt create chrome driver");
		}
	}

	private static WebDriver firefoxDriver() {
		try {
			return new FirefoxDriver();
		} catch (Exception ex) {
			throw new RuntimeException("could not create the firefox driver");
		}
	}

//    @Override 
//    public String toString() { 
//       return this.browserName; 
//    } 

//	public WebDriver driver() {
//		return this.driver;
//	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	@Override
	public List findElements(By arg0) {
		return driver.findElements(arg0);
	}

	@Override
	public void get(String arg0) {
		driver.get(arg0);
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override

	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public Set getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return ((TakesScreenshot) driver).getScreenshotAs(target);
	}

}

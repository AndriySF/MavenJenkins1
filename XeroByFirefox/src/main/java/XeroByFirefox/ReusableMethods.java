package main.java.XeroByFirefox;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableMethods {

	static WebDriver driver;
	static ExtentReports report;
	static ExtentTest logger;

	public static WebDriver LaunchApp(String BrowserName, String url) throws InterruptedException {
		LaunchBrowser(BrowserName);
		OpenURL(url);
		return driver;
	}

	public static void OpenURL(String url) {
		driver.get(url);
	}

	public static WebDriver LaunchBrowser(String browsername) throws InterruptedException {
		if (browsername == "Chrome") {
			System.setProperty("webdriver.chrome.driver", "/Users/andriyshegera/AutomationDATA/Selenium/chromedriver");
			driver = new ChromeDriver();
			// driver.manage().window().maximize();
			System.out.println("Pass:  Chrome Browser launch Successfully");
			logger.log(LogStatus.PASS, "Chrome Browser launch Successfully");
		} else if (browsername == "Firefox") {
			System.setProperty("webdriver.gecko.driver", "/Users/andriyshegera/AutomationDATA/Selenium/geckodriver");
			driver = new FirefoxDriver();
			System.out.println("Pass:  Firefox Browser launch Successfully");
			logger.log(LogStatus.PASS, "Firefox Browser launch Successfully");
			driver.manage().window().maximize();
		} else if (browsername == "Safari") {
			driver = new SafariDriver();
			System.out.println("Safari:  Firefox Browser launch Successfully");
			logger.log(LogStatus.PASS, "Safari Browser launch Successfully");
			driver.manage().window().maximize();
		} else {
			logger.log(LogStatus.FAIL, "Browser could not launch");
		}
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		return driver;
	}

	public static void StartReport() {
		// String path = "/Users/andriyshegera/AutomationDATA/ReportsHTML/Report4.html";
		//report = new ExtentReports(path);
		report = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report.html", true);

	}

	public static void ReporTest(String ReportTestName) {
		// Initialize logger
		logger = report.startTest(ReportTestName);
	}

	public static void endReport() {
		report.endTest(logger);
		report.flush();
	}

	public static void enterText(WebElement element, String textValue, String objName) throws InterruptedException {
		if (element == null)
			return;
		if (element.isDisplayed()) {
			element.sendKeys(textValue);
			System.out.println("Pass: " + "'" + textValue + "'" + " - Entered in " + objName + " Seccesfully");
			logger.log(LogStatus.PASS, "'" + textValue + "'" + " - Entered in " + objName + " Seccesfully");
		} else {
			System.out.println("Fail: " + objName + " could not be found");
			logger.log(LogStatus.FAIL, objName + " could not be found");
		}
	}

	public static void clickObject(WebElement element, String objName) throws InterruptedException {
		if (element == null)
			return;
		Thread.sleep(1000);
		if (element.isDisplayed()) {
			if (!element.isSelected()) {
				element.click();
			}
			System.out.println("Pass: " + objName + " clicked");
			logger.log(LogStatus.PASS, objName + " clicked");
		} else {
			System.out.println("Fail: " + objName + " could not be found");
			logger.log(LogStatus.FAIL, objName + " could not be found");
		}
	}

	public static void selectByValue(WebElement element, String Value) {
		{
			if (element == null)
				return;
			if (element.isDisplayed()) {

				Select val = new Select(element);
				val.selectByValue(Value);

				System.out.println("Pass:  Element from Drop down is selected by Value - " + "'" + Value + "'");
				logger.log(LogStatus.PASS, "Username Exter Successfully");
			} else {
				System.out.println("Fail: " + Value + " could not be found");
				logger.log(LogStatus.FAIL, "Password field foes not exist");
			}
		}
	}

	public static void selectByIndex(WebElement element, int index) {
		{
			if (element == null)
				return;
			if (element.isDisplayed()) {
				Select ind = new Select(element);
				ind.selectByIndex(index);
				System.out.println("Pass:  Element from Drop down is selected by Index - " + "'" + index + "'");
			} else {
				System.out.println("Fail: " + index + " could not be found");
			}
		}
	}

	public static void selectByVisibleText(WebElement element, String Value) {
		{
			if (element == null)
				return;
			if (element.isDisplayed()) {
				Select tex = new Select(element);
				tex.selectByVisibleText(Value);
				System.out.println("Pass:  Element from Drop down is selected by Text - " + "'" + Value + "'");
			} else {
				System.out.println("Fail: " + Value + " could not be found");
			}
		}
	}

	public static void verifyText(WebElement element, String expectedText, String actionName) {
		{
			if (element == null)
				return;
			String actualText = element.getText();
			if (element.getText().equalsIgnoreCase(expectedText)) {
				System.out.println(actionName + "Pass:  Expected Text - '" + expectedText
						+ "' is equal to actual text - '" + actualText + "'");
				logger.log(LogStatus.PASS, actionName + "Expected Text - '" + expectedText
						+ "' is equal to actual text - '" + actualText + "'");
			} else {
				System.out.println(actionName + "False: Expected Text - '" + expectedText
						+ "' is not equal to actual text - '" + actualText + "'");
				logger.log(LogStatus.FAIL, actionName + "Expected Text - '" + expectedText
						+ "' is not equal to actual text - '" + actualText + "'");
			}
		}
	}

	public static void waitToLoad(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	/*
	 * 
	 */
	/**
	 * Code for reference: WebElement checkColor =
	 * driver.findElement(By.xpath("//label[@class='form-label text']"));
	 * GetColor(checkColor, "Original text color is (43, 59, 76, 1)");
	 */
	public static void getColor(WebElement element, String originalColor) throws InterruptedException {
		if (element == null)
			return;
		Thread.sleep(1000);
		if (element.isDisplayed()) {
			String actualColor = element.getCssValue("color");
			;
			System.out.println("Pass: " + originalColor + " Actual text color is : " + actualColor);
			logger.log(LogStatus.PASS, originalColor + " Actual text color is : " + actualColor);
		} else {
			System.out.println("Fail: " + element + " could not be found");
			logger.log(LogStatus.FAIL, element + " could not be found");
		}
	}

	public static void verifyTitle(String ecspectedTitle) throws InterruptedException {
		if (driver == null)
			return;
		String actualTitle = driver.getTitle();
		if (driver.getTitle().contains(ecspectedTitle)) {
			System.out.println(
					"Pass:  Expected page title - '" + ecspectedTitle + "' is equal to Actual page title - '" + actualTitle + "'");
			logger.log(LogStatus.PASS,
					"Actual page title - '" + actualTitle + "' is equal to Expected page title - '" + ecspectedTitle + "'");
		} else {
			System.out.println("False: Actual page title - '" + actualTitle + "' is not equal to Expected page title - '"
					+ ecspectedTitle + "'");
			logger.log(LogStatus.FAIL,
					" Actual page title - '" + actualTitle + "' is not equal to Expected page title - '" + ecspectedTitle + "'");
		}
	}

	public static void switchToTab() throws InterruptedException {
		// Recourse to learn more - https://www.youtube.com/watch?v=sbWkOiBGsG0//
		Set<String> handles = driver.getWindowHandles();
		for (String newTab : handles) {
			driver.switchTo().window(newTab);
			System.out.println("Switched to new Tab Successfully");
		}
	}

}

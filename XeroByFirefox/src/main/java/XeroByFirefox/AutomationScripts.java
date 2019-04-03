package main.java.XeroByFirefox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AutomationScripts extends ReusableMethods {

	public static void main(String[] args) throws InterruptedException {
	}

	public static void testCase_01() throws InterruptedException {

		/* Starting Report */
		StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID01/A - Navigate to XERO");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://login.xero.com/");

		/* Enter UserName */
		WebElement emailUserName = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
		emailUserName.clear();
		enterText(emailUserName, "andriyshegera@Gmail.com", "Login Feald ");

		/* Enter Password */
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		enterText(password, "Marta#21", "Password Feald ");

		/* Click on Log in Button */
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(loginButton, "'Log in' batton ");
		Thread.sleep(2000);

		/* Verify correct User Name if Login was Successfully */
		WebElement userButton = driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-7']"));
		userButton.click();
		WebElement userName = driver.findElement(By.xpath("//h4[@class='xrh-verticalmenuitem--heading']"));
		verifyText(userName, "Andriy Shegera", "Login Verification - ");

		/* End Report */
		// endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}

	public static void testCase_02() throws InterruptedException {
		/* Starting Report */
		// StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID01/B - Incorrect Password");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://login.xero.com/");

		/* Enter UserName */
		WebElement emailUserName = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
		emailUserName.clear();
		enterText(emailUserName, "andriyshegera@Gmail.com", "Login Feald ");

		/* Enter Password */
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		enterText(password, "Incorect Password", "Password Feald ");

		/* Click on Log in Button */
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(loginButton, "'Log in' batton ");
		Thread.sleep(1000);

		WebElement errorMesage = driver
				.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"));
		verifyText(errorMesage, "Your email or password is incorrect", "Error Mesage Verification - ");

		/* End Report */
		// endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}

	public static void testCase_03() throws InterruptedException {

		/* Starting Report */
		// StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID01/C - Incorrect Email");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://login.xero.com/");

		/* Enter UserName */
		WebElement emailUserName = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
		emailUserName.clear();
		enterText(emailUserName, "IncorrectEmail@gmail.com", "Login Feald ");

		/* Enter Password */
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		enterText(password, "Marta#21", "Password Feald ");

		/* Click on Log in Button */
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(loginButton, "'Log in' batton ");
		Thread.sleep(1000);

		WebElement errorMesage = driver
				.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect')]"));
		verifyText(errorMesage, "Your email or password is incorrect", "Error Mesage Verification - ");

		/* End Report */
		// endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}

	public static void testCase_04() throws InterruptedException {
		/* Starting Report */
		// StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID01/D - Forgot Password");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://login.xero.com/");

		/* Click on Forgot Password link */
		WebElement forgotPass = driver.findElement(By.xpath("//a[@class='forgot-password-advert']"));
		clickObject(forgotPass, "'Forgot Password link ");
		Thread.sleep(1000);

		WebElement entrEmail = driver.findElement(By.xpath("//input[@id='UserName']"));
		enterText(entrEmail, "noBody@gmail.com", "Chech Email ");

		/* Click on Send Link Button */
		WebElement sendLinkB = driver.findElement(By.xpath("//span[@class='text']"));
		clickObject(sendLinkB, "'Send Link Button ");

		/* Verify Check Email */
		WebElement checkEmail = driver.findElement(By.xpath("//h2[contains(text(),'Please check your email')]"));
		verifyText(checkEmail, "Please check your email", "Page Title Verification - ");

		/* End Report */
		// endReport();

		/* Close Browser and Quit Driver */
		Thread.sleep(2000);
		driver.quit();
	}

	public static void testCase_05() throws InterruptedException {
		/* Starting Report */
		// StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID02/A - Sign Up to XDC");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://www.xero.com/us");

		/* Click on Log in Button */
		WebElement freeTrailButton = driver
				.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrailButton, "'Free Trail Button ");
		Thread.sleep(2000);

		/* Verify correct Title "Try Xero FREE for 30 days!" */
		WebElement userName = driver.findElement(By.xpath("//h2[@class='title title-2']"));
		verifyText(userName, "Try Xero FREE for 30 days!", "Title Verification - ");

		/* Enter First Name */
		WebElement firstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
		firstName.clear();
		enterText(firstName, "Alex", "First Name ");

		/* Enter Last Name */
		WebElement lastName = driver.findElement(By.xpath("//input[@name='LastName']"));
		lastName.clear();
		enterText(lastName, "Mora", "Last Name ");

		/* Enter Email */
		WebElement Email = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		Email.clear();
		enterText(Email, "moraola@gmail.com", "Email ");

		/* Enter Phone Number */
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='PhoneNumber']"));
		phoneNumber.clear();
		enterText(phoneNumber, "9175922946", "Phone Number ");

		/* Click on "Get Started" button */
		WebElement checgetStartedButt = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(checgetStartedButt, "Get Started ");

		/* End Report */
		// endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}

	public static void testCase_06() throws InterruptedException {
		/* Starting Report */
		// StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID02/B - Sign Up to XDC 2");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://www.xero.com/us");

		/* Click on Free Trail Button */
		WebElement freeTrailButton = driver
				.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrailButton, "'Free Trail Button ");
		Thread.sleep(2000);

		/* Verify correct Title "Try Xero FREE for 30 days!" */
		WebElement userName = driver.findElement(By.xpath("//h2[@class='title title-2']"));
		verifyText(userName, "Try Xero FREE for 30 days!", "Title Verification - ");

		/* Click on "Get Started" button" without entering DATA */
		WebElement getStartNoDtata = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(getStartNoDtata, "Get Started button with no DATA");

		/* Verify error message First name can't be empty */
		WebElement erMessage = driver.findElement(By.xpath("//span[contains(text(),\"First name can't be empty\")]"));
		verifyText(erMessage, "First name can't be empty", "Error Message Verification - ");

		/* Verify error message Last name can't be empty */
		WebElement erMessage2 = driver.findElement(By.xpath("//span[@id='signup-form-error-message-2']"));
		verifyText(erMessage2, "Last name can't be empty", "Error Message Verification - ");

		/* Verify error message Email address can't be empty */
		WebElement erMessage3 = driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']"));
		verifyText(erMessage3, "Email address can't be empty", "Error Message Verification - ");

		/* Verify error message Phone number can't be empty */
		WebElement erMessage4 = driver.findElement(By.xpath("//span[@id='signup-form-error-message-4']"));
		verifyText(erMessage4, "Phone number can't be empty", "Error Message Verification - ");

		/* Enter Invalid Email */
		WebElement Email = driver.findElement(By.xpath("//input[@name='EmailAddress']"));
		Email.clear();
		enterText(Email, "invalid email", "Email field ");

		/* Click on "Get Started" button" without entering DATA */
		WebElement getStartNoDtata2 = driver.findElement(By.xpath("//span[@class='g-recaptcha-submit']"));
		clickObject(getStartNoDtata2, "Get Started button with no DATA");

		/* Verify error message Email address is invalid */
		WebElement erMessage5 = driver.findElement(By.xpath("//span[@id='signup-form-error-message-3']"));
		verifyText(erMessage5, "Email address is invalid", "Error Message Verification - ");

		/* Verify color if highlighted... */
		WebElement checkColor = driver.findElement(By.xpath("//label[@class='form-label text']"));
		getColor(checkColor, "Original text color is (43, 59, 76, 1)");

		/* End Report */
		// endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}

	public static void testCase_07() throws InterruptedException {
		/* Starting Report */
		// StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID02/C - Sign Up to XDC 3");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://www.xero.com/us");

		/* Click on Free Trail Button */
		WebElement freeTrailButton = driver
				.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrailButton, "'Free Trail Button ");
		Thread.sleep(2000);

		/* Click the terms of use link */
		WebElement termOfUse = driver.findElement(By.xpath("//a[contains(text(),'terms of use')]"));
		clickObject(termOfUse, "Terms of use link");
		Thread.sleep(3000);

		/* Switch to new Tab */
		switchToTab();

		/* Verify Title in new Tab */
		verifyTitle("Terms of Use | Xero US");

		/* End Report */
		// endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}

	public static void testCase_08() throws InterruptedException {
		/* Starting Report */
		// StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID02/D - Sign Up to XDC 4");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://www.xero.com/us");

		/* Click on Free Trail Button */
		WebElement freeTrailButton = driver
				.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrailButton, "'Free Trail Button ");
		Thread.sleep(2000);

		/* Click the privacy notice link */
		WebElement termOfUse = driver.findElement(By.xpath("//a[contains(text(),'privacy notice')]"));
		clickObject(termOfUse, "Terms of use link");
		Thread.sleep(3000);

		/* Switch to new Tab */
		switchToTab();

		/* Verify Title in new Tab */
		verifyTitle("Privacy Notice | Xero US");

		/* End Report */
		// endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}

	public static void testCase_09() throws InterruptedException {
		/* Starting Report */
		// StartReport();
		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID02/E - Sign Up to XDC 5");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://www.xero.com/us");

		/* Click on Free Trail Button */
		WebElement freeTrailButton = driver
				.findElement(By.xpath("//a[@class='btn btn-primary global-ceiling-bar-btn']"));
		clickObject(freeTrailButton, "'Free Trail Button ");
		Thread.sleep(2000);

		/* Click the offer details link */
		WebElement termOfUse = driver.findElement(By.xpath("//a[contains(text(),'offer details')]"));
		clickObject(termOfUse, "Terms of use link");
		Thread.sleep(3000);

		/* Switch to new Tab */
		switchToTab();

		/* Verify Title in new Tab */
		verifyTitle("Offer details | Xero US");

		/* End Report */
		endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}

	public static void testCase_10() throws InterruptedException {

		/* Starting Report */
		//StartReport();

		/* Name of Test Case in HTML Extent Report */
		ReporTest("Test ID03/A - Test all tabs page");

		/* Open Application with "Chrome" or "Firefox" or "Safari" */
		LaunchApp("Firefox", "https://login.xero.com/");

		/* Enter UserName */
		WebElement emailUserName = driver.findElement(By.xpath("//input[@placeholder='Email address']"));
		emailUserName.clear();
		enterText(emailUserName, "andriyshegera@Gmail.com", "Login Feald ");

		/* Enter Password */
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		enterText(password, "Marta#21", "Password Feald ");

		/* Click on Log in Button */
		WebElement loginButton = driver.findElement(By.xpath("//button[@id='submitButton']"));
		clickObject(loginButton, "Log in' batton ");
		Thread.sleep(2000);

		/* Verify correct Page Text */
		WebElement userName = driver.findElement(By.xpath("//span[@class='xrh-banner--text']"));
		verifyText(userName, "You are currently using a trial account.", "Text Verification - ");

		/* lick on dashboard of Xero */
		WebElement dashboard = driver
				.findElement(By.xpath("//a[@class='xrh-focusable xrh-tab--body xrh-tab--body-is-selected']"));
		clickObject(dashboard, "Dashboard Tab");
		Thread.sleep(2000);

		/* Verify page title "you are now in dashboard page" */
		verifyTitle("Xero | Dashboard | Test");

		/* Click on Business Tab */
		WebElement business = driver.findElement(By.xpath("//button[contains(text(),'Business')]"));
		clickObject(business, "Business Tab ");
		Thread.sleep(1000);

		/* Click on Accounting Tab */
		WebElement Accounting = driver.findElement(By.xpath("//button[contains(text(),'Accounting')]"));
		clickObject(Accounting, "Accounting Tab ");
		Thread.sleep(1000);

		/* Click on Contacts Tab */
		WebElement Contacts = driver.findElement(By.xpath("//button[contains(text(),'Contacts')]"));
		clickObject(Contacts, "Contacts Tab ");
		Thread.sleep(1000);

		/* Click click on "+" /(new)tab of Xero */
		WebElement newTab = driver
				.findElement(By.xpath("//button[@title='Create new']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(newTab, "\"+\" /(new)tab ");
		Thread.sleep(1000);

		/* Click on Search icon */
		WebElement searchIcon = driver
				.findElement(By.xpath("//button[@title='Search']//*[@class='xrh-icon xrh-icon-svg']"));
		clickObject(searchIcon, "Search Icon ");
		Thread.sleep(1000);

		/* Click on Contacts Tab */
		WebElement Notifications = driver.findElement(
				By.xpath("//button[@title='Notifications']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
		clickObject(Notifications, "Notifications Icon ");
		Thread.sleep(1000);

		/* Click on Contacts Tab */
		WebElement questionMark = driver
				.findElement(By.xpath("//button[@title='Help']//div[@class='xrh-focusable--child xrh-iconwrapper']"));
		clickObject(questionMark, "Question mark ? ");
		Thread.sleep(1000);

		/* End Report */
		endReport();

		/* Close Browser and Quit Driver */
		driver.quit();
	}
}
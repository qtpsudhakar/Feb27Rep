package com.wd.tng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.wd.util.DataUtils;
import com.wd.util.DriverFactory;
import com.wd.util.WebUtil;

public class OhrmAddEmpTest_Reports {
	WebDriver driver;
	ExtentReports extent;
	ExtentHtmlReporter reporter;

	@BeforeSuite
	public void initReport() {
		extent = new ExtentReports();
		reporter = new ExtentHtmlReporter(
				"src/../Reports/" + this.getClass().getSimpleName() + DataUtils.getUniqueId() + ".html");
		extent.attachReporter(reporter);
	}

	@AfterSuite
	public void closeReport() {
		extent.flush();
	}

	@BeforeClass
	public void openApplication() {

		ExtentTest openAppTest = extent.createTest("openApplication");

		try {
			driver = DriverFactory.getDriverFor("chrome");

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			// goto Application
			driver.get("https://opensource-demo.orangehrmlive.com/");

			Assert.assertTrue(WebUtil.isElementExist(driver, By.id("txtUsername")), "isApplicationOpened");
			openAppTest.log(Status.PASS, "Application Opened");
		} catch (Throwable e) {
			openAppTest.log(Status.FAIL, "Failed to open Application " + e.getMessage());
			Assert.fail();
		}

		finally {
			extent.flush();
		}
	}

	@Test
	public void login() {
		ExtentTest loginTest = extent.createTest("Login");

		try {

			SoftAssert sa = new SoftAssert();

			sa.assertTrue(WebUtil.isElementExist(driver, By.id("txtUsername")), "IsUserNameExist");
			sa.assertTrue(WebUtil.isElementExist(driver, By.name("txtPassword")), "IsPasswordExist");
			sa.assertTrue(WebUtil.isElementExist(driver, By.id("btnLogin")), "IsLoginExist");

			sa.assertAll(); // throws error

			// enter username
			driver.findElement(By.id("txtUsername")).sendKeys("admin");
			loginTest.log(Status.PASS, "admin entered in login");
			// enter password
			WebElement password = driver.findElement(By.name("txtPassword"));
			password.clear();
			password.sendKeys("admin123");
			loginTest.log(Status.PASS, "admin123 entered in password");

			// click on login
			driver.findElement(By.id("btnLogin")).click();
			loginTest.log(Status.PASS, "clicked on login button");
			Assert.assertTrue(WebUtil.isElementExist(driver, By.linkText("PIM")), "isLoginSuccessful");
			loginTest.log(Status.PASS, "Login successful");
		} catch (Exception t) {
			loginTest.log(Status.FAIL, "failed to login because of element identification");
			Assert.fail("Failed To Login" + t.getMessage());
		} catch (Error e) {
			loginTest.log(Status.FAIL, "failed to login because of verification failure");
			Assert.fail("Failed To Login" + e.getMessage());
		} finally {
			extent.flush();
		}
	}

	@Test(dependsOnMethods = "login")
	public void addEmployee() {
		try {

			driver.findElement(By.linkText("PIM")).click();
			driver.findElement(By.partialLinkText("Add Emp")).click();
			driver.findElement(By.id("firstName")).sendKeys("selenium");
			driver.findElement(By.id("lastName")).sendKeys("hq");
			driver.findElement(By.xpath("//input[@value='Save']")).click();

			Assert.assertTrue(WebUtil.isElementExist(driver, By.linkText("PIM")), "isLoginSuccessful");
			Reporter.log("Employee added");
		} catch (Exception t) {
			Reporter.log("failed to add employee because of element identification");
			Assert.fail("Failed To add employee" + t.getMessage());
		} catch (Error e) {
			Reporter.log("failed to add employee because of verification failure");
			Assert.fail("Failed To add employee" + e.getMessage());
		}

	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
	}
}

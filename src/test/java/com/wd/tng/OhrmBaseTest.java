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

public class OhrmBaseTest {
	WebDriver driver;
	ExtentReports extent;
	ExtentHtmlReporter reporter;
	ExtentTest test;

	@BeforeSuite
	public void initReport() {
		extent = new ExtentReports();
		reporter = new ExtentHtmlReporter(
				"src/../Reports/OhrmReports_"  + DataUtils.getUniqueId() + ".html");
		extent.attachReporter(reporter);

	}

	@AfterSuite
	public void closeReport() {
		extent.flush();
	}

	@BeforeClass
	public void openApplication() {
		test = extent.createTest(this.getClass().getSimpleName());

		try {
			driver = DriverFactory.getDriverFor("chrome");

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			// goto Application
			driver.get("https://opensource-demo.orangehrmlive.com/");

			Assert.assertTrue(WebUtil.isElementExist(driver, By.id("txtUsername")), "isApplicationOpened");
			test.log(Status.PASS, "Application Opened");
		} catch (Throwable e) {
			test.log(Status.FAIL, "Failed to open Application " + e.getMessage());
			Assert.fail();
		}

		finally {
			extent.flush();
		}
	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
		extent.flush();
	}
}

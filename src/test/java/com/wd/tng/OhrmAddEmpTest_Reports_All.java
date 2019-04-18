package com.wd.tng;

import java.io.IOException;
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

public class OhrmAddEmpTest_Reports_All extends OhrmBaseTest {

	@Test
	public void login() throws IOException {
		ExtentTest loginTest = test.createNode("Login");

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
			Assert.assertTrue(WebUtil.isElementExist(driver, By.linkText("PIM1")), "isLoginSuccessful");
			loginTest.log(Status.PASS, "Login successful");
		} catch (Exception t) {
			
			try {
				loginTest.log(Status.FAIL, "failed to login because of element identification").addScreenCaptureFromPath(WebUtil.getScreen(driver));
			} catch (IOException e) {
				loginTest.log(Status.FAIL, "failed to login because of element identification: Screen capture not found");
				e.printStackTrace();
			}
			Assert.fail("Failed To Login" + t.getMessage());
		} catch (Error e) {
			loginTest.log(Status.FAIL, "failed to login because of verification failure").addScreenCaptureFromPath(WebUtil.getScreen(driver));
			Assert.fail("Failed To Login" + e.getMessage());
		} finally {
			extent.flush();
		}
	}

	@Test(dependsOnMethods = "login")
	public void addEmployee() throws IOException {
		ExtentTest addEmpTest = test.createNode("AddEmp");
		try {

			driver.findElement(By.linkText("PIM")).click();
			driver.findElement(By.partialLinkText("Add Emp")).click();
			driver.findElement(By.id("firstName")).sendKeys("selenium");
			driver.findElement(By.id("lastName")).sendKeys("hq");
			driver.findElement(By.xpath("//input[@value='Save']")).click();

			Assert.assertTrue(WebUtil.isElementExist(driver, By.linkText("PIM")), "isLoginSuccessful");
			addEmpTest.log(Status.PASS, "Employee added");
		} catch (Exception t) {
			addEmpTest.log(Status.FAIL, "failed to add employee because of element identification").addScreenCaptureFromPath(WebUtil.getScreen(driver));
			Assert.fail("Failed To add employee" + t.getMessage());
		} catch (Error e) {
			addEmpTest.log(Status.FAIL, "failed to add employee because of verification failure").addScreenCaptureFromPath(WebUtil.getScreen(driver));
			Assert.fail("Failed To add employee" + e.getMessage());
		} finally {
			extent.flush();
		}

	}
}

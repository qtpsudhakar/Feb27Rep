package com.wd.tng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.wd.util.DriverFactory;
import com.wd.util.WebUtil;

public class OhrmAddEmpTest {
	WebDriver driver;

	@BeforeClass
	public void openApplication() {

		try {
			driver = DriverFactory.getDriverFor("chrome");

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			// goto Application
			driver.get("https://opensource-demo.orangehrmlive.com/");
			/*
			 * if(WebUtil.isElementExist(driver, By.id("txtUsername"))) {
			 * System.out.println("Login successful"); }else {
			 * //System.out.println("Login failed"); Assert.fail("Login failed"); }
			 */
			Assert.assertTrue(WebUtil.isElementExist(driver, By.id("txtUsername")), "isApplicationOpened");
			Reporter.log("Application Opened");
		} catch (Throwable e) {
			Reporter.log("Failed to open application" + e.getMessage());
			Assert.fail();
		}
	}

	@Test
	public void login() {

		try {
			
			SoftAssert sa = new SoftAssert();
			
			sa.assertTrue(WebUtil.isElementExist(driver, By.id("txtUsername1")), "IsUserNameExist");
			sa.assertTrue(WebUtil.isElementExist(driver, By.name("txtPassword")), "IsPasswordExist");
			sa.assertTrue(WebUtil.isElementExist(driver, By.id("btnLogin1")), "IsLoginExist");
			
			sa.assertAll(); //throws error
			
			// enter username
			driver.findElement(By.id("txtUsername")).sendKeys("admin");

			// enter password
			WebElement password = driver.findElement(By.name("txtPassword"));
			password.clear();
			password.sendKeys("admin123");

			// click on login
			driver.findElement(By.id("btnLogin")).click();
			Assert.assertTrue(WebUtil.isElementExist(driver, By.linkText("PIM")), "isLoginSuccessful");
			Reporter.log("Login successful");
		} catch (Exception t) {
			Reporter.log("failed to login because of element identification");
			Assert.fail("Failed To Login" + t.getMessage());
		} catch (Error e) {
			Reporter.log("failed to login because of verification failure");
			Assert.fail("Failed To Login" + e.getMessage());
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

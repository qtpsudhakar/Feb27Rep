package com.tng.retry;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wd.util.DriverFactory;

public class OhrmAddEmployee extends Retry {
	WebDriver driver;

	@BeforeClass
	public void openApplication() {
		// get driver
		driver = DriverFactory.getDriverFor("chrome");

		// specify page load timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		// specify findelement time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// maximize browser window
		driver.manage().window().maximize();

		// goto application
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@Test()
	public void login() {
		// enter text in user name
		driver.findElement(By.id("txtUsername")).sendKeys("admin");

		// enter text in password
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");

		// click on login
		driver.findElement(By.id("btnLogin")).click();

		System.out.println("Logged in to application");
	}

	
	@Test(dependsOnMethods = "login",retryAnalyzer=Retry.class)
	public void addEmployee() {
		System.out.println("executed");
		// click on pim link
		//driver.findElement(By.linkText("PIM")).click();

		// click on add employee
		//driver.findElement(By.partialLinkText("Add Emp")).click();

		// enter text on first name
		driver.findElement(By.id("firstName")).sendKeys("selenium");

		// enter last name
		driver.findElement(By.id("lastName")).sendKeys("hq");

		// click on save
		driver.findElement(By.id("btnSave")).click();

		System.out.println("Employee Added");
	}

	@AfterClass
	public void CloseApplication() {
		driver.quit();
		System.out.println("application closed");
	}

}

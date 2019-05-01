package com.wd.ang;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.wd.util.DriverFactory;

public class TestAngular {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getDriverFor("chrome");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// goto Application
		driver.get("https://qtpsudhakarnew-trials646.orangehrmlive.com");

		NgWebDriver ngDriver = new NgWebDriver((JavascriptExecutor)driver);
		
		// enter username
		driver.findElement(By.id("txtUsername")).sendKeys("admin");

		// enter password
		WebElement password = driver.findElement(By.name("txtPassword"));
		password.clear();
		password.sendKeys("admin123");

		// click on login
		driver.findElement(By.id("btnLogin")).click();

		ngDriver.waitForAngularRequestsToFinish();
		
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.partialLinkText("Employee List")).click();
		
		ngDriver.waitForAngularRequestsToFinish();
		
		List<WebElement> lstRows = driver.findElement(By.id("employeeListTable")).findElements(By.tagName("tr"));
		System.out.println(lstRows.size());
		
	}

}

package com.wd.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class C4Apsrtc_Web {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// dumpsys window windows | grep -E 'mCurrentFocus'

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("browserName", "chrome");
		
		AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://apsrtconline.in");

		driver.findElement(By.id("fromPlaceName")).sendKeys("hyderabad");
		driver.findElement(By.linkText("HYDERABAD")).click();
		
		driver.findElement(By.id("toPlaceName")).sendKeys("vijayawada");
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("VIJAYAWADA"))).click();
		//driver.findElement(By.linkText("VIJAYAWADA")).click();
		
		driver.hideKeyboard();
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.linkText("30")).click();
		driver.findElement(By.id("searchBtn")).click();
		
	}

}









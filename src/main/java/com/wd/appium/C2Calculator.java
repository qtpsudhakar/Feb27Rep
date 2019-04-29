package com.wd.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class C2Calculator {

	public static void main(String[] args) throws MalformedURLException {

		// dumpsys window windows | grep -E 'mCurrentFocus'

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

		AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(MobileBy.id("com.android.calculator2:id/digit_2")).click();
		driver.findElement(MobileBy.AccessibilityId("plus")).click();
		driver.findElement(MobileBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(MobileBy.AccessibilityId("equals")).click();
		System.out.println(driver.findElement(By.id("com.android.calculator2:id/result")).getText());

		driver.quit();
		
		//driver.context(name);
	}

}

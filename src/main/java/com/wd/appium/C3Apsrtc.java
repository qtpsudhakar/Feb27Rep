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

public class C3Apsrtc {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// dumpsys window windows | grep -E 'mCurrentFocus'

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "7.1.1");

		capabilities.setCapability("appPackage", "com.apsrtc.online");
		capabilities.setCapability("appActivity", "com.abhibus.app.apsrtc.DashBoardActivity");

		AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(MobileBy.id("com.apsrtc.online:id/bookTextView")).click();
		
		Thread.sleep(5000);;
		
		System.out.println(driver.getContext());
		Set<String> cntHandles = driver.getContextHandles();
		
		for(String cnt:cntHandles) {
			System.out.println(cnt);
		}
	
	}

}

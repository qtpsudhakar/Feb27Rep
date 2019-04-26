package com.wd.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class C1AppiumDemoEmulator {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("appPackage","com.app.tsrtc");
		capabilities.setCapability("appActivity","com.tsrtc.online.mini.WelcomeScreen");
		
		AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.app.tsrtc:id/btn_skip")).click();
		
		new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Book for Inter City / State']"))).click();
		//driver.findElement(By.xpath("//android.widget.TextView[@text='Book for Inter City / State']")).click();
	}

}

package com.wd.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class C5SafariBrowserTest {

	public static final String USERNAME = "tempsauce1";
	public static final String ACCESS_KEY = "0ea7f9d7-5788-4c24-9ba9-17db2d64e6ea";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws MalformedURLException {
		// https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/

		/*
		 * DesiredCapabilities caps = DesiredCapabilities.iphone();
		 * caps.setCapability("appiumVersion", "1.12.1");
		 * caps.setCapability("deviceName", "iPhone 8 Simulator");
		 * caps.setCapability("deviceOrientation", "portrait");
		 * caps.setCapability("platformVersion", "12.2");
		 * caps.setCapability("platformName", "iOS"); caps.setCapability("browserName",
		 * "Safari");
		 */
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName(BrowserType.SAFARI);
		caps.setCapability("platform", "macOS 10.13");
		caps.setCapability("version", "11.1");
		
		//WebDriver driver = new IOSDriver(new URL(URL), caps);
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://apsrtconline.in");

		driver.findElement(By.id("fromPlaceName")).sendKeys("hyderabad");
		driver.findElement(By.linkText("HYDERABAD")).click();

		driver.findElement(By.id("toPlaceName")).sendKeys("vijayawada");
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("VIJAYAWADA"))).click();
		// driver.findElement(By.linkText("VIJAYAWADA")).click();

		//driver.hideKeyboard();
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.linkText("30")).click();
		driver.findElement(By.id("searchBtn")).click();

	}

}

package com.wd.util;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.wd.pom.OhrmConstants;

public class DriverFactory {

	public static WebDriver getDriverFor(String brName) {

		WebDriver driver;
		switch (brName.toLowerCase()) {
		case "chrome":
			// configure driver exe file
			System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--disable-notifications");

			// open chrome browser
			driver = new ChromeDriver(co);

			break;
		case "firefox":
			// configure driver exe file
			System.setProperty("webdriver.gecko.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\geckodriver.exe");

			FirefoxOptions fo = new FirefoxOptions();
			fo.addPreference("dom.webnotifications.enabled", "false");

			// open firefox browser
			driver = new FirefoxDriver(fo);
			break;
		case "ie":
			// configure driver exe file
			System.setProperty("webdriver.ie.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\IEDriverServer.exe");
			// open ie browser
			driver = new InternetExplorerDriver();
			break;
		default:
			// configure driver exe file
			System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");
			// open chrome browser
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

	public static WebDriver getRemoteDriverFor(String brName, String osName) {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		switch (brName.toLowerCase()) {
		case "chrome":
			capabilities.setBrowserName(BrowserType.CHROME);
			break;
		case "firefox":
			capabilities.setBrowserName(BrowserType.FIREFOX);
			break;
		case "ie":
			capabilities.setBrowserName(BrowserType.IE);
			break;
		default:
			capabilities.setBrowserName(BrowserType.CHROME);
		}

		switch (osName.toLowerCase()) {
		case "windows":
			capabilities.setPlatform(Platform.WINDOWS);
			break;
		case "win10":
			capabilities.setPlatform(Platform.WIN10);
			break;
		case "mac":
			capabilities.setPlatform(Platform.MAC);
			break;
		default:
			capabilities.setPlatform(Platform.WINDOWS);
		}

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(OhrmConstants.GRID_URL), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}

	public static WebDriver getRemoteDriverFor(String brName, String osName, String nUrl) {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		switch (brName.toLowerCase()) {
		case "chrome":
			capabilities.setBrowserName(BrowserType.CHROME);
			break;
		case "firefox":
			capabilities.setBrowserName(BrowserType.FIREFOX);
			break;
		case "ie":
			capabilities.setBrowserName(BrowserType.IE);
			break;
		default:
			capabilities.setBrowserName(BrowserType.CHROME);
		}

		switch (osName.toLowerCase()) {
		case "windows":
			capabilities.setPlatform(Platform.WINDOWS);
			break;
		case "win10":
			capabilities.setPlatform(Platform.WIN10);
			break;
		case "mac":
			capabilities.setPlatform(Platform.MAC);
			break;
		default:
			capabilities.setPlatform(Platform.WINDOWS);
		}

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(nUrl), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}
	
	public static WebDriver getSauceDriverFor(String brName, String osName) {

		String sauceUserName = "qtpsudhakar2019";
        String sauceAccessKey = "7343f16c-0290-4b4f-b6b5-781a807e8c70";
        
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//set your user name and access key to run tests in Sauce
        capabilities.setCapability("username", sauceUserName);

        //set your sauce labs access key
        capabilities.setCapability("accessKey", sauceAccessKey);
        
		switch (brName.toLowerCase()) {
		case "chrome":
			capabilities.setBrowserName(BrowserType.CHROME);
			break;
		case "firefox":
			capabilities.setBrowserName(BrowserType.FIREFOX);
			break;
		case "ie":
			capabilities.setBrowserName(BrowserType.IE);
			break;
		default:
			capabilities.setBrowserName(BrowserType.CHROME);
		}

		switch (osName.toLowerCase()) {
		case "windows":
			capabilities.setPlatform(Platform.WINDOWS);
			break;
		case "win10":
			capabilities.setPlatform(Platform.WIN10);
			break;
		case "mac":
			capabilities.setPlatform(Platform.MAC);
			break;
		default:
			capabilities.setPlatform(Platform.WINDOWS);
		}

		WebDriver driver = null;
		try {			
			driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver;
	}

}

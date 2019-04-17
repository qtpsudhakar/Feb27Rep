package com.wd.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.wd.util.DriverFactory;

public class OhrmBase {

	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	
	public LoginPage openApplication(String brName) {
		driver.set(DriverFactory.getDriverFor(brName));
		
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// goto Application
		getDriver().get(OhrmConstants.APP_URL);
		System.out.println("Application Opened");
		
		return new LoginPage();
	}

	public LoginPage openApplication(String brName, String osName) {
		driver.set(DriverFactory.getRemoteDriverFor(brName, osName));
		
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// goto Application
		getDriver().get(OhrmConstants.APP_URL);
		System.out.println("Application Opened");
		
		return new LoginPage();
	}
	public LoginPage openApplicationSauce(String brName, String osName) {
		driver.set(DriverFactory.getSauceDriverFor(brName, osName));
		
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// goto Application
		getDriver().get(OhrmConstants.APP_URL);
		System.out.println("Application Opened");
		
		return new LoginPage();
	}
	public LoginPage openApplication(String brName, String osName, String nodeUrl) {
		driver.set(DriverFactory.getRemoteDriverFor(brName, osName,nodeUrl));
		
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// goto Application
		getDriver().get(OhrmConstants.APP_URL);
		System.out.println("Application Opened");
		
		return new LoginPage();
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public void closeApplication() {
		getDriver().quit();
	}
}

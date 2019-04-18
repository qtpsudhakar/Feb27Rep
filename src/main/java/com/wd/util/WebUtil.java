package com.wd.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebUtil {

	public static boolean isElementExist(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception n) {
			return false;
		}
	}

	public boolean isElementExist1(WebDriver driver, By locator) {

		if (driver.findElements(locator).size() > 0) {
			return true;
		} else {
			return false;
		}

	}
	
	public static String getScreen(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("src\\..\\Reports\\ErrImg\\"+DataUtils.getUniqueId()+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dst.getAbsolutePath();
	}
}

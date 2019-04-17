package com.wd.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
}

package com.wd.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wd.util.DriverFactory;

public class OhrmAddEmpPOM {

	public static void main(String[] args) {

		OhrmBase ohrmBase = new OhrmBase();

		LoginPage loginPage = ohrmBase.openApplication("chrome");

		loginPage.enterUserName("admin");
		loginPage.enterPassword("admin123");

		WelcomePage welcomePage = loginPage.clickLoginButton();
		welcomePage.clickOnPIMLink();

		AddEmployeePage addEmployeePage = welcomePage.clickOnAddEmpLink();
		addEmployeePage.enterFirstName("selenium");
		addEmployeePage.enterLastName("hq");
		addEmployeePage.clickSaveButton();

		ohrmBase.closeApplication();

	}

}

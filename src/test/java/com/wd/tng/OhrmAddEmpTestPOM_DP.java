package com.wd.tng;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wd.pom.AddEmployeePage;
import com.wd.pom.LoginPage;
import com.wd.pom.OhrmBase;
import com.wd.pom.WelcomePage;
import com.wd.util.DriverFactory;

public class OhrmAddEmpTestPOM_DP {
	LoginPage loginPage;
	OhrmBase ohrmBase;
	WelcomePage welcomePage;
	AddEmployeePage addEmployeePage;

	@BeforeClass
	public void openApplication() {
		ohrmBase = new OhrmBase();
		loginPage = ohrmBase.openApplication("chrome");
	}

	@Test
	public void login() {
		loginPage.enterUserName("admin");
		loginPage.enterPassword("admin123");
		welcomePage = loginPage.clickLoginButton();
	}

	@Test(dependsOnMethods = "login", dataProvider="getEmpDataFromExcel", dataProviderClass=OhrmDP.class)
	public void addEmployee(HashMap<String, String> tcMap) {
		welcomePage.clickOnPIMLink();
		addEmployeePage = welcomePage.clickOnAddEmpLink();
		addEmployeePage.enterFirstName(tcMap.get("fname"));
		addEmployeePage.enterLastName(tcMap.get("lname"));
		addEmployeePage.clickSaveButton();
	}

	@AfterClass
	public void closeApplication() {
		ohrmBase.closeApplication();
	}
}

package com.wd.tng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wd.pom.AddEmployeePage;
import com.wd.pom.LoginPage;
import com.wd.pom.OhrmBase;
import com.wd.pom.WelcomePage;
import com.wd.util.DriverFactory;

public class OhrmAddEmpTestPOM_Parameters {
	LoginPage loginPage;
	OhrmBase ohrmBase;
	WelcomePage welcomePage;
	AddEmployeePage addEmployeePage;

	@BeforeClass
	@Parameters({"browser"})
	public void openApplication(String brName) {
		ohrmBase = new OhrmBase();
		loginPage = ohrmBase.openApplication(brName);
	}

	@Test
	public void login() {
		loginPage.enterUserName("admin");
		loginPage.enterPassword("admin123");
		welcomePage = loginPage.clickLoginButton();
	}

	@Test(dependsOnMethods = "login")
	public void addEmployee() {
		welcomePage.clickOnPIMLink();
		addEmployeePage = welcomePage.clickOnAddEmpLink();
		addEmployeePage.enterFirstName("selenium");
		addEmployeePage.enterLastName("hq");
		addEmployeePage.clickSaveButton();
	}

	@AfterClass
	public void closeApplication() {
		ohrmBase.closeApplication();
	}
	
}

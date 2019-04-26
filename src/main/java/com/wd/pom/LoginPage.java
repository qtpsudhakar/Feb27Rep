package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wd.util.WebUtil;

public class LoginPage extends OhrmBase{

	private By txt_UserName = By.id("txtUsername");
	private By txt_Password = By.name("txtPassword");
	private By btn_Login = By.id("btnLogin");
	
	private WebElement txtUserName() {
		return getDriver().findElement(txt_UserName);
	}

	private WebElement txtPassword() {
		return getDriver().findElement(txt_Password);
	}

	private WebElement btnLogin() {
		return getDriver().findElement(btn_Login);
	}

	private void waitForElementPresence(By locator, int seconds) {
		new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void enterUserName(String userName) {
		waitForElementPresence(txt_UserName, 10);
		txtUserName().sendKeys(userName);
		System.out.println(userName + " entered on UserName textbox");
	}

	public void enterPassword(String password) {
		txtPassword().sendKeys(password);
		System.out.println(password + " entered on Password textbox");
	}

	public WelcomePage clickLoginButton() {
		//btnLogin().click();
		WebUtil.click(btn_Login,"Login Button");
		System.out.println("Clicked on Login Button");
		return new WelcomePage();
	}
}

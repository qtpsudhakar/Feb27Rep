package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage extends OhrmBase{
	
	private By lnk_PIM = By.linkText("PIM");
	private By lnk_AddEmployee = By.partialLinkText("Add Emp");
	
	private WebElement lnkPIM() {
		return getDriver().findElement(lnk_PIM);
	}
	
	private WebElement lnkAddEmployee() {
		return getDriver().findElement(lnk_AddEmployee);
	}
	
	public void clickOnPIMLink() {
		lnkPIM().click();
		System.out.println("Clicked on PIM Link");
	}
	
	public AddEmployeePage clickOnAddEmpLink() {
		lnkAddEmployee().click();
		System.out.println("Clicked on Add Employee Link");
		return new AddEmployeePage();
	}
}

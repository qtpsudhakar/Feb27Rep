package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeePage extends OhrmBase{
	
	private By txt_FirstName = By.id("firstName");
	private By txt_LastName = By.id("lastName");
	private By btn_Save = By.xpath("//input[@value='Save']");
	private By lst_Country = By.id("country");
	
	private WebElement txtFirstName() {
		return getDriver().findElement(txt_FirstName);
	}

	private WebElement txtLastName() {
		return getDriver().findElement(txt_LastName);
	}

	private WebElement btnSave() {
		return getDriver().findElement(btn_Save);
	}

	private WebElement lstCountry() {
		return getDriver().findElement(lst_Country);
	}
	public void enterFirstName(String firstName) {

		txtFirstName().sendKeys(firstName);
		System.out.println(firstName + " entered on FirstName textbox");
	}

	public void enterLastName(String lastName) {
		txtLastName().sendKeys(lastName);
		System.out.println(lastName + " entered on LastName textbox");
	}

	public void clickSaveButton() {
		btnSave().click();
		System.out.println("Clicked on Save Button");
	}
	
	public void selectCountry(String countryName) {
		new Select(lstCountry()).selectByVisibleText(countryName);
		System.out.println(countryName+" is selected from country list");
	}
	
	public void selectCountry(int index) {
		new Select(lstCountry()).selectByIndex(index);
		System.out.println("countryName is selected by index from country list");
	}
}







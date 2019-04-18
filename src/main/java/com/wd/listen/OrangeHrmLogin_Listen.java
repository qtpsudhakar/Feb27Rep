package com.wd.listen;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.wd.util.DriverFactory;

public class OrangeHrmLogin_Listen {

	public static void main(String[] args) {
		WebDriver wDriver = DriverFactory.getDriverFor("chrome");
		
		EventFiringWebDriver driver = new EventFiringWebDriver(wDriver);
		driver.register(new WdEvents());
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");		
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("qtpsudhakar");
		
		driver.findElement(By.id("btnLogin")).click();
		
		driver.quit();
	}

}












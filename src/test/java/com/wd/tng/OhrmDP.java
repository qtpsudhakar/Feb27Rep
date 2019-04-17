package com.wd.tng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class OhrmDP {
	@DataProvider
	public String[][] getEmpData() {
		
		
		String[][] tcData = new String[2][2];
		tcData[0][0]="selenium";
		tcData[0][1]="hq";
		tcData[1][0]="web";
		tcData[1][1]="driver";
		return tcData;
		
	}
	
	
	@DataProvider
	public Object[][] getEmpDataFromExcel() throws IOException {				
		
		String flPath = "src/../Resources/Ohrm.xlsx";
		//workbook, worksheet, rows, columns, cells
		
		Workbook workbook;
		if(flPath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(flPath);
		}else {
			workbook = new HSSFWorkbook(new FileInputStream(flPath));
		}
		Sheet sheet = workbook.getSheet("Sheet1");
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();
		
		Object[][] tcData = new Object[rc][1];

		for(int r=1;r<=rc;r++) {
			HashMap<String, String> rowMap = new HashMap<String, String>();
			for(int c=0;c<cc;c++) {
				String key = sheet.getRow(0).getCell(c).toString();
				String value = sheet.getRow(r).getCell(c).toString();
				
				rowMap.put(key, value);				
			}
			tcData[r-1][0]=rowMap;
		}
		
		workbook.close();
		
		return tcData;
		
	}
}

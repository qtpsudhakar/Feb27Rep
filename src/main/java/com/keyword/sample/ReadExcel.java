package com.keyword.sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	Workbook wbWorkbook;
	Sheet shSheet;

	public void openSheet(String filePath) {
		FileInputStream fs;
		try {
			fs = new FileInputStream(filePath);
			wbWorkbook = new HSSFWorkbook(fs);
			shSheet = wbWorkbook.getSheetAt(0);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValueFromCell(int iColNumber, int iRowNumber) {
		return shSheet.getRow(iRowNumber).getCell(iColNumber,MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
	}

	public int getRowCount() {
		return shSheet.getLastRowNum()+1;
	}

	public int getColumnCount() {
		return shSheet.getRow(0).getLastCellNum();
	}
}

package com.learn.automation.dataprovider;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook wb;

	public static Object[][] getdatafromsheet(String Sheetname) {

		try {
			wb = new XSSFWorkbook(new File("./testdata/data.xlsx"));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int row = wb.getSheet(Sheetname).getPhysicalNumberOfRows();
		int column = wb.getSheet(Sheetname).getRow(0).getPhysicalNumberOfCells();

		Object arr[][] = new Object[row - 1][column];

		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < column; j++) {
				arr[i - 1][j] = wb.getSheet(Sheetname).getRow(i).getCell(j).getStringCellValue();
			}
		}

		return arr;
	}

	public static void getdata(String Sheetname, int Row, int column) {
		XSSFCell cell = wb.getSheet(Sheetname).getRow(Row).getCell(column);

		if (cell.getCellType() == CellType.STRING) {
			String value = cell.getStringCellValue();
			System.out.println(value);
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			boolean status = cell.getBooleanCellValue();
			String value = String.valueOf(status);
		}

		else if (cell.getCellType() == CellType.NUMERIC) {
			double status = cell.getNumericCellValue();
			String value = String.valueOf(status);
		}
	}
}

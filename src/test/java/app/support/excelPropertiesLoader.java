package app.support;

import java.io.File;
import java.io.FileInputStream;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Author: Bernardo Salinas Jaquez
 * Script description: In this script we define the functions to read de .xlsx files that contains our parameters and
 * the file that contains our test data 
 * Creation date: 07/07/2022
 * Modification date: 08/07/2022
 * */

public class excelPropertiesLoader {
	private Dictionary<String, String> dic;

	//Load the parameters file and save it in a dictionary to use it in our test cases
	public void LoadFile(String rutaArchivoExcel) {
		try {
			FileInputStream inputStream = new FileInputStream(new File(rutaArchivoExcel));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator iterator = firstSheet.iterator();
			DataFormatter formatter = new DataFormatter();

			dic = new Hashtable<String, String>();
			String key = "";
			String value = "";
			while (iterator.hasNext()) {
				Row nextRow = (Row) iterator.next();
				key = nextRow.getCell(0).getStringCellValue();
				value = formatter.formatCellValue(nextRow.getCell(1));
				dic.put(key, value);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		return dic.get(key);
	}
	
	//Function to load the data file to use it after in any dataprovider needed in our test cases
	public String[][] getExcelData(String fileName, String sheetName) {

		String[][] data = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet(sheetName);
			XSSFRow row = sh.getRow(0);
			int noOfRows = sh.getLastRowNum() + 1; // Add 1 because the functions doesn't detect the last row 
	  	   	int noOfCols = row.getLastCellNum();
			Cell cell;
			data = new String[noOfRows - 1][noOfCols - 1];
			for (int i = 1; i < noOfRows; i++) {
				for (int j = 1; j < noOfCols; j++) {
					row = sh.getRow(i);
					cell = row.getCell(j);
					data[i - 1][j - 1] = cell.getStringCellValue().toString();
				}
			}
		} catch (Exception e) {
			System.out.println("The exception is: " + e.getMessage());
		}
		return data;
	}
	
	
	
}

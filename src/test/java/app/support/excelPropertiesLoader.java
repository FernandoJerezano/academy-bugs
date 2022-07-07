package app.support;

import java.io.File;
import java.io.FileInputStream;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelPropertiesLoader {
	private Dictionary<String, String> dic;

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
	
}

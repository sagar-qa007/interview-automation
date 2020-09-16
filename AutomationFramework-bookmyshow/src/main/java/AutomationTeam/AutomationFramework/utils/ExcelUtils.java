package AutomationTeam.AutomationFramework.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	XSSFWorkbook wb = null;
	XSSFSheet sheet = null;

	public ExcelUtils(String excelPath) {
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getRowCount(String sheetname) {
		return wb.getSheet(sheetname).getPhysicalNumberOfRows();
	}

	public String getRowData(String sheetname, int row, int col) {
		
		sheet = wb.getSheet(sheetname);
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

	

}

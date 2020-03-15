package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public ArrayList<String> getData(String sheetName, String testCaseName) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\Swaran\\Desktop\\testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int numOfSheets = workbook.getNumberOfSheets();
		System.out.println(numOfSheets);
		ArrayList<String> al = new ArrayList<String>();

		for (int i = 0; i < numOfSheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell cellValue = ce.next();
					if (cellValue.getStringCellValue().equalsIgnoreCase("TestCase")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);

				while (rows.hasNext()) {
					Row testCaseColRows = rows.next();
					if (testCaseColRows.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> testCaseRow = testCaseColRows.cellIterator();
						while (testCaseRow.hasNext()) {
							Cell testCaseCellValues = testCaseRow.next();
							if(testCaseCellValues.getCellType()== CellType.STRING) {
								al.add(testCaseCellValues.getStringCellValue());
							}else {
								al.add(NumberToTextConverter.toText(testCaseCellValues.getNumericCellValue()));
							}
							
						}
					}
				}

			}

		}
		return al;

	}

	public static void main(String[] args) throws IOException {
		ExcelData data = new ExcelData();
		ArrayList cellData = data.getData("testdata", "Login");
		System.out.println(cellData.get(0));
		System.out.println(cellData.get(1));
		System.out.println(cellData.get(2));
		System.out.println(cellData.get(3));
		
		
		
	}
}
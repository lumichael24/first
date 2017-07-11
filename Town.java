package net.codejava.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Town {
	public static void main(String[] args) throws IOException {
		String excelFilePath = "C:/users/gongm/Desktop/Java Workspace/Research/Book1.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        map = getTowns(sheet);
//        System.out.println(map.get("Worcester"));
        workbook.close();
	}
	public static Result getTowns(Sheet sheet) {
		HashMap<String, Integer> townSet = new HashMap<String, Integer>();
		StringBuilder builder = new StringBuilder();
		String name = "";
		String townName = "";
		for (int i = 13; i < sheet.getRow(0).getLastCellNum(); i++) {
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(i);
			if (cell == null) {
				name = null;
			}
			else {
				name = cell.getStringCellValue();
			}
		}
		for (int i = 0; i < name.length(); i++) {
			builder.append(name.charAt(i));
			if (name.charAt(i + 1) == ',') {
				break;
			}
		}
		String uppercase = builder.toString();
		String lowercase = uppercase.toLowerCase();
		townName = lowercase.substring(0, 1).toUpperCase() + lowercase.substring(1);	
		if (townSet.containsKey(townName)) {
			int count = townSet.get(townName) + 1;
			townSet.put(townName, count);
		}
		else {
			townSet.put(townName, 1);
		}
		return new Result(townSet, townName);
	}
}

package net.codejava.excel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Keyword {
	public static void main(String[] args) throws IOException {
		//HashMap<String, Integer> townSet = new HashMap<String, Integer>();
		String excelFilePath = "C:/users/gongm/Desktop/Java Workspace/Research/Book1.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Result result = Town.getTowns(sheet);
        String search_string = "";
        String parsed = SearchString.parse(search_string);
		search(parsed, result.map, result.town);
		workbook.close();
	}
	public static void find(String parsed) {
		String lowercase = parsed.toLowerCase();
		if (lowercase.contains("meet") || lowercase.contains("meetings") || 
				lowercase.contains("met")) {
			//put one in the corresponding column;
		}
		if (lowercase.contains("marches") || lowercase.contains("marched")){
			//put one in the corresponding column;
		}
		if (lowercase.contains("petitions") || lowercase.contains("petitioned")){
			//put one in the corresponding column;
		}
	}
	
	public static void search(String parsed, HashMap<String, Integer> townSet, String town) {
		String lowercase = parsed.toLowerCase();
		if (lowercase.contains(town)) {
			//false-positives
			if (Character.isUpperCase(town.charAt(0))) {
				//only one of these towns
				if (townSet.get(town) == 1) {
					//put one is corresponding column
				}
				else {
					//put one over townSet.get(town)
				}
			}
		}
		
		
	}
}

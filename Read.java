package net.codejava.excel;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
public class Read {
     
    public static void main(String[] args) throws IOException {
       
    }
    
    public static void read() throws IOException {
    	 String excelFilePath = "C:/users/gongm/Desktop/Java Workspace/Research/Book1.xlsx";
         FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
          
         Workbook workbook = new XSSFWorkbook(inputStream);
         Sheet sheet = workbook.getSheetAt(0);
         for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
         	  Row row = sheet.getRow(rowIndex);
         	  Cell cell = row.getCell(1);
         	  if (cell != null) {
         	          String search = cell.getStringCellValue();
         	          System.out.println(SearchString.parse(search));
         	  }
         }
         workbook.close();
         inputStream.close();
    }
    
 
}
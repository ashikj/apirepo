package com.api.apitester.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excel {
	
    public static String getExcelData(String sheetName, int rowNum, int cellNum){
		String returnVal=null;
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\ashjagad\\Documents\\apitester\\apitester\\JsonTestdata\\Deal_Data.xlsx");
			
			
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheetName);
			Row r = s.getRow(rowNum);
			Cell c = r.getCell(cellNum);
			returnVal=(c.getStringCellValue()); 
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return returnVal;
		
	}
    
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    //File Path = new File("C:\\Users\\satekuma\\Pro\\Fund.xlsx");
    public void setCelldata(String data, int RowNum, int ColNum, File Path) throws Exception {

        try {
            Row = ExcelWSheet.createRow(RowNum - 1);
            Cell = Row.createCell(ColNum - 1);
            Cell.setCellValue(data);
            FileOutputStream fileOut = new FileOutputStream(Path);
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {

            throw (e);

        }

    }
    
    private static Workbook wb ; 
    private static Sheet sh ; 
    private static FileInputStream fis ; 
    private static FileOutputStream fos  ; 
    private static Row row  ; 
    private static Cell cell  ;
    private static String ExcelPath ;
    
    	 public void setCellData(String text , int rowno , int colno){
    		    try{
    		        row = sh.getRow(rowno);
    		        if(row == null){
    		            row = sh.createRow(rowno);
    		        }
    		        cell = row.getCell(colno);
    		        if(cell!=null){
    		            cell.setCellValue(text);

    		        }
    		        else{
    		            cell = row.createCell(colno);
    		            cell.setCellValue(text);

    		        }
    		        fos = new FileOutputStream("C:\\Users\\ashjagad\\Desktop\\yo.xlsx");
    		        wb.write(fos);
    		        fos.flush();
    		        fos.close();
    		    }catch(Exception e){
    		        System.out.println(e.getMessage());
    		    }
    }
    	 
    	 public void writeToExcel(String sheetName, int rowNum, int cellNum, String val){
    			try {
    				FileInputStream fis = new FileInputStream("C:\\Users\\ashjagad\\Documents\\apitester\\apitester\\testdata.xlsx");
    				Workbook wb = WorkbookFactory.create(fis);
    				Sheet s = wb.getSheet(sheetName);
    				Row r = s.getRow(rowNum);
    				Cell c = r.createCell(cellNum);
    				//c.setCellType(Cell.CELL_TYPE_STRING);
    				c.setCellValue(val);
    				FileOutputStream fos = new FileOutputStream("C:\\Users\\ashjagad\\Documents\\apitester\\apitester\\testdata.xlsx");
    				wb.write(fos);
    				fos.close();
    				fis.close();
    			} catch (FileNotFoundException e) {
    				
    				e.printStackTrace();
    			} catch (InvalidFormatException e) {
    				
    				e.printStackTrace();
    			} catch (IOException e) {
    				
    				e.printStackTrace();
    			}
    		}
    	 
    	 public static String readFileAsString(String fileName)throws Exception 
    	  { 
    	    String data = ""; 
    	    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    	   
    	    return data; 
    	  } 

}


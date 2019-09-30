package com.api.apitester;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sr250345 on 2/7/17.
 */

public class ExcelReader {

	static File pathExcel = new File("testdata.xlsx");
   // private static final String excelFilePath = "C:\\Software\\apitester\\testdata.xlsx";
    private static final String excelFilePath = pathExcel.getAbsolutePath();


    public static void main(String args[])
    {
        read();
    }
    public static List<RequestData> read()
    {
        List<RequestData> requestDataList = new ArrayList<RequestData>();
        try {

            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(1);
            Iterator<Row> iterator = firstSheet.iterator();


            while (iterator.hasNext())
            {
                Row nextRow = iterator.next();
                Cell mCell = nextRow.getCell(0);
                String payload = "";
              
                if(mCell != null)
                {
                	  String method = mCell.getStringCellValue();
                	  if(method!= "")
                	  {
	               
	                String url = nextRow.getCell(1).getStringCellValue();
	                if( nextRow.getCell(2) != null)
	                {
	                	payload = nextRow.getCell(2).getRichStringCellValue().getString();
	                }
	                String headers = "";
	                if( nextRow.getCell(3) != null)
	                {
	                	headers = nextRow.getCell(3).getStringCellValue();
	                }
	                RequestData requestData = new RequestData(method, url, payload,headers,"","","");
	                requestDataList.add(requestData);
                }
                	  else
                      {
                      	break;
                      }
                }
                else
                {
                	break;
                }

            }
            workbook.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return requestDataList;
        }
    
     }
  
    public static List<RequestData> read(String invalidsessionid)
    {
        List<RequestData> requestDataList = new ArrayList<RequestData>();
        try {

            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(2);
            Iterator<Row> iterator = firstSheet.iterator();


            while (iterator.hasNext())
            {
                Row nextRow = iterator.next();
                Cell mCell = nextRow.getCell(0);
                
                if(mCell != null )
                	{
                	String method = mCell.getStringCellValue();
                	if(method!="" )
                	{
	                
	                String url = nextRow.getCell(1).getStringCellValue();
	                String payload = nextRow.getCell(2).getRichStringCellValue().getString();
	                
	                //String encodedPayload = new String(payload.getBytes(),"UTF-8");
	                String headers = nextRow.getCell(3).getStringCellValue();
	                RequestData requestData = new RequestData(method, url, payload,headers,"","","");
	                requestDataList.add(requestData);
                }
                else
                {
                	break;
                }
                	}
            else
            {
            	break;
            }
            }
            workbook.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return requestDataList;
        }
        
        
    }
    public static  void writeExcel(List<RequestData> requestData) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(1);

		for (int c = 1; c < requestData.size(); c++) 
		{
			RequestData rd = requestData.get(c);
			Row row = firstSheet.getRow(c);
			//firstSheet.createRow(c).createCell(5);
			writeBook(rd, row);
		}

		try 
		{
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
		}
		catch(Exception e)
		{
			  e.printStackTrace();
		}
	}
    public static  void writeExcel(List<RequestData> requestData,String invalidsessionid) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(4);

		for (int c = 1; c < requestData.size(); c++) 
		{
			RequestData rd = requestData.get(c);
			Row row = firstSheet.getRow(c);
			//firstSheet.createRow(c).createCell(5);
			writeBook(rd, row);
		}

		try 
		{
			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
		}
		catch(Exception e)
		{
			  e.printStackTrace();
		}
	}

	private static void writeBook(RequestData reqdata, Row row) {
	//	Row.MissingCellPolicy.CREATE_NULL_AS_BLANK
		Cell statuscodecell = row.getCell(4,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		Cell statuslinecell = row.getCell(5,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		Cell responsbodycell = row.getCell(6,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
	
		
		statuscodecell.setCellValue(reqdata.getStatuscode());
		
		statuslinecell.setCellValue(reqdata.getStatusline());
		responsbodycell.setCellValue(reqdata.getResponsebody());
		
	}
}

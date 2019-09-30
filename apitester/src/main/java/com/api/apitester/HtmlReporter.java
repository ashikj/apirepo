package com.api.apitester;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import FrameUtility.UIFrame;

public class HtmlReporter {//EXTENDS TestUtility
	File directory = new File (".");
	public String _EXEC_Start_Time;
	public String _EXEC_End_Time;
	public String _TC_EXEC_End_Time;
	public String _TC_EXEC_Start_Time;
	public int _TC_PASS_Count=0;
	public int _TC_FAIL_Count=0;
	public int _Steps_PASS_Count=0;
	public int _Steps_WARN_Count=0;
	public int _Steps_FAIL_Count=0;
	public int _STEP_ROW = 0;
	public int _TC_ROW = 0;
	public int _TC_COUNT = 0;
	public int _TC_STEP;
	
	public String _PASS_IMG = "<img alt=\"Passed\" title=\"Passed\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAiCAYAAACjv9J3AAAABGdBTUEAALGPC/xhBQAAAAlwSFlzAAAGDwAABg8B+/bxNgAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAPZSURBVFhHvVdZaxNhFD3RuFdcUKsoVVFccEMiItoyNsmktRZBbcEHffDBB31QERQfxEhFbFHB9UFBai1NZzKt1lIEQa1bVRAUd22bpovLg7/Ap3rul0lNW0ubNGPg8g3JzD3fOXPuvV9c+B+fbrg81+CemYGM327kOwpZHMZI/SYm+KqxyGdhP+OZz8QhZ0CDGOEPY5LfwhquRxkPfWH8IugD7w3MdgTUG0JmwMBBshJmHYzvuolmr4kirRHutIOKpATZTFZPya6L121+E+1+A5cDJqamHVASeu8gk3KWML4yIgSOkuFTbzVyHGGpBeHOrUaA7O4TMEqGEV43Mw5rtzHZEZY5lZhFoJMEaVEsTQVscV0R7MaItIN6rmKUbiFAkEaRlGsbgV/zu53aZWSkHVASarWYo9fgDF0aEVkVUwuX8m5jnjOA5RhLs2yljK8IGLXfZ6O/BgV082gnQF1kN59gFVIaUiI+A18o8TF2oxlOAELaXK6JPQT7LJIKS17XagbWBdmZ0g4qjtxEZ6oSMdgALLK08Iab2Oupx/i0A0pC/R4m6AZKVccJo9Wuy3LfLSxyBFCky2WJeC18oomUecj4pdfADmmFjoBq5ZhMkAay61QMw2jmejH7OqanBsihW2RinF6L5TILpfATE8m7lJEl00NkVY418ZiM9eQBKVkhDZBnYRmTBbnzJsaB9XWYmJiM02ItQT5QWpkg0u6+MMrEyUMHJTMFZmKxgMjQtWX7xmRnyaBn8GY3YEogjErK2anMwzLRef9GAxuGDKjq7BYW5BrYTaB6Wj5K60tCaWftjDqCeJjQJd2Fcu9lP5WxFXersDxR/CGJzuOvxjbaPsQH5d102QUuDFrZWaS7vGFsz7+AMf4Qjx+mUkGauQKVBp8fwuohs5QbKVMpwX6qMRST628YTEpgRgk3t5T3nI+PLdtALZT+eF+jDboByrqKu33N+uroBxrbgIypu2pzYbwS9nHHcn1CM60cFKTvDaw3mRDnmFDZv1/Y7iTwR0ZMUnsz0tRTOoJI92AijYneqkPUwMCJv0Up+fNADZYkzTL+gFaFaZTpCp07kMR/FYgx76D5jgyr3alSkGOjiXc9zvwX47hjWZcyQ1NmaT/ooqxZBCxnsgHZ8t1HvDxa0kz75OQ3XFBIR2JZ7JKWllirie9YHZ4tVPkrkCXNYtigYCsU+xPkbs987C1xFzvRI/6enZJjB9qh/Achm1O9QGPGkb8HL/j9Fpk+w2eYkGEhWx2Bi+yalNOAHLR+MB5Q1sLkpkgSWyuowVw2/DKa5j1ZNxHwtJzQ0ynpH4mXI2alYol/AAAAAElFTkSuQmCC\" />";
	public String _WARN_IMG = "<img alt=\"Warning\" title=\"Warning\" src=\"data:image/png;base64,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\" />";
	public String _FAIL_IMG = "<img alt=\"Failed\" title=\"Failed\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAiCAYAAABIiGl0AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAgY0hSTQAAeiYAAICEAAD6AAAAgOgAAHUwAADqYAAAOpgAABdwnLpRPAAAAAd0SU1FB9kHERMODV0yR7cAAASNSURBVFhHrZdPiFVVHMd/WlFJmJWbGoSEMXBjCropqlXLNhEoESgEQpHQSgQF165EFy7a2EIIohZDEkFgGM6YWjPjNDpmNTXqjI45pqbj3+fr83nvHLnZ8717Zxz4cc7ce87v++ece87vzYkOf/sjnn88YhPDbt+M2PFGxOlOc2b9vi/i2YMR/YMR9Z+IIxFTP0Ssr5r4UMRy5n/UG/FKqbkHIlYCXD+cYoj2aJPAB2USQPxJ5m9j/tVh5vVHXOfZux3nypS48WNSzMS6CSBwCwWvt0vAEi1i7rc/M975CpA0jk3xbnFb8IGILiadcYJ226r6V4KERyHxVKsEgCyF2JAkAWqAGvZ/I7B8TVvgesRcwPtGmkD1Y8Rxwv/Hmv9vvD8BgMsgd/JEUorqe8DmwPYBiXW0myTbZSmgyX4hThKjTeWTxKKcBCIrGDf6e3LIpWE/NJQmm3u+jpjfEdQBsHxLYAG12L6JBT7XbHc5jmereDeWnGg4lL8G+4D3fveApWlJBFtfAPTcHwnM1uQGH3T9z4hrxAaej00kN3RGh9wPLg/LNY69S0opLQ5Cyd7xAtgZ+v5ve5Y4n1pJ6YbOZHCA76L87cqgTiDhhyYXSFWCaXMxJHKq6UAD3H2QbN85I1AnYekyEk8LNJkU/kWbQ1K+y+AqdxlQfQwST88YmITziOGLCWyK9u8UPrtQsFtX0trXAH1zxqB5IvZ+8Q9JBbpEXElxORGQjG64FPZR/cmsQU2AnVuvJlAJXEvhM0nogNarHncmWO+uhwJMwnXTCUTQGwTXZP06kQmpVAcA/vihgJoE4M2CqNb2NnEngUtEQN/hzAhHbcszvDIZFLyGmotaqjrVClxLwEUnWOcNlQFaTWCXvkSyMdW4jrYCafOtRELFaeNdQXH1E+p+YECfI45oo9+qO9q+qrXbkISgPuf9NCRfnpVi7uHHuAC+EsyDwU/FHatqLRdMAgXQRp9x/7sqKxHhYtjlaeQRWDyT8+Hht2xIJB8stowd4ht+ohJYHkzlsCmfuR5/nsGqloiWq1wChn2/Xx3JZzgnV/VLgQpiDVdazfvX8MCXhMdgBlelBAwBJeSJpTPpjj7I3ftoadWArhyMuORdar1kieMVl8FVrjoAJlWrQgElJDFvo+wQF8T7pYBhuJB6aFhALu57l7j3agZXIer7INBNfKlyAfN1aFVihWKLW+MQf7EjOJXfHisGa2iLd5Q3ypdca5mchKOQ6DaZFSbqvtEBgXIB4PLolMrJ9ymn2JwHglNkrxXIosywQLNQs0ATXMUkvEzC//wSwJkFAO7Tci9+3RFU1yTA+/62a009dEBluf61JLUIzwU85UsNAqtbMQdsISC9OmJ9lQr+Rh/n3mtrNTavV10GthVcy1Ox1vZQQFkXxAdyWasIXNuHzXPbAm9lAOA92l2s+lMBXqpmwp0lzD/hskD4DmRe7bixHMDaLiYm8u8cNxpr/9nnEY+USsAgAJcCOEie3WXnNMZ9H/GOG0t7Ae1hY1Q++vZGPANwuV8LRXZYvYVPajfK51ViXXHwv6QpW5xz+5FGAAAAAElFTkSuQmCC\" />";
	public final String _header = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /><meta name=\"Case Study Automation Report\" content=\"homepage v1.0\" /><meta name=\"powered by\" content=\"Sangita Mohanty\" /><title>Automation Report</title><style type=\"text/css\">body {	float: center;	font-family: Trebuchet MS, Geneva, sans-serif;	font-size: 14px;	background: #A9D0F5;	margin:0px;margin-top: -3px;}#titletable{	float: center;}#titlelogo{	width:200px;}#titlelogo > a > img {width: 150px;border:0px;}#titletext{padding: 0px 0px 0px 50px;width:874px;font-weight:bold;font-size:22px;color: #0B3861;}#title_row{height:60px;}#body_table{float:center; width:1024px;background-color:#FFF;	border-bottom-left-radius:1.5em;border-bottom-right-radius:1.5em;border:2px solid #A4A4A4;-webkit-box-shadow: 0px 10px 30px 0px rgba(50, 50, 50, 0.8);-moz-box-shadow:    0px 10px 30px 0px rgba(50, 50, 50, 0.8);box-shadow:         0px 10px 30px 0px rgba(50, 50, 50, 0.8);}#form_page{width:500px;}#form_label{color:#0B3861; font-family:  verdana;font-weight:none;font-size:14;padding: 0px 8px 0px 8px;}#form_detail{color:#A4A4A4; font-family:  verdana;font-weight:none;font-size:14;padding: 0px 0px 0px 8px;}#menu {	float: left;	display: block;	height: 20px;	margin: 0;	padding: 0px 0px 0px 7px;	list-style: none;}#menu li {	display: inline;}#menu a {	display: block;	float: left;	height: 20px;	padding: 2px 10px 0px 10px;		text-decoration: none;	font-size: 12px;	font-weight: bold;	color: #FFFFFF;	border:1px solid #cccccc; 	background:#0B3861;}#menu a:hover {	color:#0B3861;	border:2px solid #0B3861;	background-color:#fff;}#headerrow, th{	background:#0B3861;	float:center;text-align:center;border-radius: 2px;	padding: 3px 0px 3px 8px;	font-family:  verdana;	font-weight:bold;	font-size:14;	color: #FFFFFF;}#oddrow{	background:#CEE3F6;	vertical-align:text-top;	float:center;	text-align:left;	border-radius: 2px;	padding: 3px 0px 3px 8px;	font-family:  verdana;	font-weight:none;	font-size:12;	color: #000000;}#evenrow{	background:#A9D0F5;	float:center;	vertical-align:text-top;	text-align:left;	border-radius: 2px;	padding: 3px 0px 3px 8px;	font-family:  verdana;	font-weight:none;	font-size:12;	color: #000000;}#Passrow{background:#CEE3F6;	float:center;	text-align:left;	border-radius: 2px;	padding: 3px 0px 3px 8px;	font-family:  verdana;	font-weight:bold;	font-size:12;	color: #0B6121;}" +
						"#Warnrow{	background: #CEE3F6;	float:center;	text-align:left;	border-radius: 2px;	padding: 3px 0px 3px 8px;	font-family:  verdana;	font-weight:bold;	font-size:12;	color: #FF8000;}" +
						"#Failrow{	background:#A9D0F5;	float:center;	text-align:left;	border-radius: 2px;	padding: 3px 0px 3px 8px;	font-family:  verdana;	font-weight:bold;	font-size:12;	color: #FF0000;}#displaystatus{	display: block;	float: left;	height: 20px;	font-family:  Arial;	width:1024px;	padding: 2px 10px 0px 10px;		text-decoration: none;	font-size: 13px;	font-weight: bold;	background:#FFFFFF;	color: #FF0000;	border:1px solid #F5A9A9; }#errormsg{	display: block;	float: left;	height: 15px;	font-family:  verdana;	width:600px;	padding: 2px 10px 0px 10px;		text-decoration: none;	font-size: 11px;	font-weight: none;	background:#F6CECE;color: #000000;	border:1px solid #F5A9A9; }</style></head><body align=\"center\"><table id =\"body_table\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\"><tr height=\"14px\"><td style=\"height:10px;\"><tr><td>	<table border=\"0\"  cellspacing=\"0\" cellpadding=\"0\" align=\"center\"  id=\"titletable\" width=\"100%\">		<tr cellspacing=\"0\" cellpadding=\"0\" id=\"title_row\">		<td align=\"center\" valign=\"middle\" id=\"titlelogo\"><A href=\"index.html\">			<img border=\"0\" alt=\"\" src=\"		</a>		<td id=\"titletext\"> Automation Execution Report		<tr><td colspan=\"2\"><hr>";
	public final String _footer ="</table><tr height=\"14px\"><td height=\"10px\"><tr ><td colspan=\"2\"><div style=\"font: normal normal bold 10px/12px arial,helvetica,sans-serif;text-align:left;font-weight:normal;width:100%;color:#848484;padding-left:15px;padding-bottom:3px;\">&nbsp;&nbsp;Copyright &copy; 2016 by Accenture . All rights reserved.</div></table><br><br></body></html>";
		
	public String _TC_UPDATE_STEP_PATH;
	public String _MASTER_UPDATE_STEP_PATH;
	 
	public String _TC_NAME;
	public String _TC_LINK;
	public String _ATTACH_LINK="";

	public String _TestSetPath;
	public String _TestSetName;
	public String _TestName;
	
	
	
	public static HtmlReporter HTMLReporter;
	/*
	public static void main(String[] args) {
		
		
		HTMLReporter = new HtmlReporter();
		
		
		
		File f = new File("Drivers\\IEDriverServer.exe");
		  System.setProperty("webdriver.ie.driver", f.getAbsolutePath());
		  WebDriver driver = new InternetExplorerDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		driver.get("http://www.google.com/");
		
		HTMLReporter.Initiate_Master_Report("C:\\test");
			HTMLReporter.Initiate_TC_Report("TC Name");
				HTMLReporter.Insert_TC_Step("Description", "Expected", "Actual", "Pass", null);
				HTMLReporter.Insert_TC_Step( "Description", "Expected", "Actual", "fail", driver);
			HTMLReporter.Close_TC_Report();
			

			
		HTMLReporter.Close_Master_Report();
		driver.close();
	}
	*/
  

	
	/***********************************************************************************************************
	 * 	 * @version			1.0
	 * @param filepath file path of the Report to be created
	 * @return			void
	 
 **********************************************************************************************************/
 
	public void Initiate_Master_Report(String filepath) 
	        {              
	                FileOutputStream out; // declare a file output object
	                PrintStream p; // declare a print stream object
	                FileOutputStream out2; // declare a file output object
	                PrintStream p2; // declare a print stream object
	            	String filename = "index.html";
	            	      	
	            	java.util.Date date= new java.util.Date();
		   			 Timestamp Times = new Timestamp(date.getTime());
		   			_EXEC_Start_Time = Times.toString();
		   			_MASTER_UPDATE_STEP_PATH = filepath; 	
		   			
		   			

	                try
	                {
	                	Thread.sleep(1000);
	                	new File(filepath).mkdir();
                	    
	                	/* new File(filepath + "\\images").mkdir();
                	    
                	    File source = new File(directory.getCanonicalPath()+ "\\Support Docs\\images");
                	    File desc = new File(filepath + "\\images");
                	    	 
                	    	 
                	    	 
                	    	 try {
                	    	     FileUtils.copyDirectory(source, desc);
                	    	 } catch (IOException e) {
                	    	     System.err.println("IOException : " + e.getMessage());
                	    	 }*/
	                	 	
	                	 	
	                	 	out = new FileOutputStream((filepath + "\\" + filename),false);
	                	 	
	                	 	out2 = new FileOutputStream((filepath + "\\Execution Details.html"),false);
	                	 	p = new PrintStream( out );
	                	 	p2 = new PrintStream( out2 );
	                	 	
	                	 	//FileInputStream fstream = new FileInputStream(directory.getCanonicalPath()+ "\\Support Docs\\header.html");
	                	 	//DataInputStream in = new DataInputStream(fstream);
	                	 	//BufferedReader br = new BufferedReader(new InputStreamReader(in));
	                	 	//String strLine;
	                	 	
	                	 	//Read File Line By Line
	                	 	  //while ((strLine = br.readLine()) != null)   {
	                	 	  // Print the content on the console
	                	 	  //System.out.println (strLine);
	                	 		  //p.println (strLine);
	                	 		// p2.println (strLine);
	                	 	  //}
	                	 	  //Close the input stream
	                	 	  //in.close();
	                	 	p.println(_header);
	                	 	p2.println(_header);
	                	 	
	                	 	p.println ("<table width=\"95%\" align=\"center\" border=\"0\"><tr><td>");
	                	 	p.println ("<ul id=\"menu\">");
	                	 	p.println ("<li><a href=\"index.html\">Summary</a></li><li></li>");			
	                	 	p.println ("</ul>");
	                	 	p.println ("<ul id=\"menu\">");
	                	 	p.println ("<li><a href=\"Execution Details.html\">Execution Details</a></li><li></li>");			
	                	 	p.println ("</ul>");
	                	 	p.println ("</table>");
	                	 	p.println ("<tr><td colspan=\"2\" align=\"center\"><hr>");
	         		
	                	 	p2.println ("<table width=\"95%\" align=\"center\" border=\"0\"><tr><td>");
	                	 	p2.println ("<ul id=\"menu\">");
	                	 	p2.println ("<li><a href=\"index.html\">Summary</a></li><li></li>");			
	                	 	p2.println ("</ul>");
	                	 	p2.println ("<ul id=\"menu\">");
	                	 	p2.println ("<li><a href=\"Execution Details.html\">Execution Details</a></li><li></li>");			
	                	 	p2.println ("</ul>");
	                	 	p2.println ("</table>");
	                	 	p2.println ("<tr><td colspan=\"2\" align=\"center\"><hr>");
	         		
	                	 	  p.close();
	                 	p2.println("<table border=\"0\" width=\"80%\" align=\"center\">");
	                	p2.println("<tr height = \"25\" id=\"headerrow\" style=\"background:#CEE3F6;color:#0B3861;\"><td colspan = \"3\" align=\"center\">Test Case Execution Details");
	                	p2.println("<tr height = \"25\" ><td id=\"headerrow\" style=\"font-size:13;\"  width=\"10%\">Execution No<td id=\"headerrow\"  style=\"font-size:13;\" width=\"80%\"> Test Case Name <td id=\"headerrow\"  style=\"font-size:13;\" width=\"10%\"> Execution Status");
	                	
	  //              	p2.println("</table>");
	                	p2.close();
	                	System.out.println("Master Html Report Files Initiated Successfully!");
	                }
	                catch (Exception e)
	                {
	                	if(e.getMessage()!=null){
	                     System.err.println("Exception : " + e.getMessage());
	                	}
	                }
	        }
	
	 /***********************************************************************************************************
	 * <i><b>Note : </b></i><font color="blue">Initiate_Master_Report(filepath)</font> must be Called 
	 * before calling this function/method
	 *</pre>
	 * @version			1.0
	 * @return			void
	
	**********************************************************************************************************/
	public void Close_Master_Report()
	{
		String filepath = _MASTER_UPDATE_STEP_PATH;
		_MASTER_UPDATE_STEP_PATH = "";
	    FileOutputStream out; // declare a file output object
	    PrintStream p; // declare a print stream object
	    FileOutputStream out2; // declare a file output object
	    PrintStream p2; // declare a print stream object
	    String filename = "index.html";
		
		
		java.util.Date date= new java.util.Date();
		Timestamp Times = new Timestamp(date.getTime());
		_EXEC_End_Time = Times.toString();
		
		try{
		out = new FileOutputStream((filepath + "\\" + filename),true);
	 	p = new PrintStream( out );
	 	out2 = new FileOutputStream((filepath + "\\Execution Details.html"),true);
	 	p2 = new PrintStream( out2 );
	 	
	 	
	 	 p.println("<table border=\"0\" width=\"40%\" align=\"center\">");
	 	 p.println("<tr height = \"25\" id=\"headerrow\"><td colspan = \"2\" align=\"center\">Execution Summary");
	 	 p.println("<tr height = \"25\"><td id=\"oddrow\">Environment <td id=\"oddrow\"> " + InetAddress.getLocalHost().getHostName() );
	 	 p.println("<tr height = \"25\"><td id=\"evenrow\">Execution Start Time<td id=\"evenrow\">" + _EXEC_Start_Time );
	 	 p.println("<tr height = \"25\"><td id=\"oddrow\">Execution End Time<td id=\"oddrow\">" + _EXEC_End_Time );
	 	 p.println("<tr height = \"25\"><td id=\"evenrow\">Total Test Cases <td id=\"evenrow\">" + (_TC_FAIL_Count+ _TC_PASS_Count));
	 	 p.println("<tr height = \"25\"><td id=\"oddrow\">Passed <td id=\"Passrow\">"+ _TC_PASS_Count );
	 	 p.println("<tr height = \"25\"><td id=\"evenrow\">Failed <td id=\"Failrow\">" + _TC_FAIL_Count);
	 	 p.println("</table><Br>" );
	 	 
	 	 p2.println("</table><br>");
	 	 
	 	/*FileInputStream fstream = new FileInputStream(directory.getCanonicalPath()+ "\\Support Docs\\footer.html");
	 	DataInputStream in = new DataInputStream(fstream);
	 	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	 	String strLine;
	 	
	 	
	 	
	 	//Read File Line By Line
	 	  while ((strLine = br.readLine()) != null)   {
	 	  // Print the content on the console
	 	  //System.out.println (strLine);
	 		  p.println (strLine);
	 		  p2.println (strLine);
	 	  }
	 	  //Close the input stream
	 	  in.close();
		*/
	 	 
	 	p.println(_footer);
	 	p2.println(_footer);
	 	
	 	  p.close();
	 	 System.out.println("Master Html Report Files Created Successfully!");
		} catch (IOException e) {
			System.err.println("IOException : " + e.getMessage());
		 }
	}
	
	/***********************************************************************************************************
	 * Initializing the Test Case Report, Insert Test Case Step, Close the Test Case Report
	 * mandatory for this method
	 *</pre>
	 * @version			1.0
	 * @return			void
	 
	 **********************************************************************************************************/
	 public void Insert_Master_Step(){
		 _TC_COUNT++;
		 String filepath = _MASTER_UPDATE_STEP_PATH;
		    
	        FileOutputStream out; // declare a file output object
	        PrintStream p; // declare a print stream object
	        String filename = "Execution Details.html";
	    	
			try{
			out = new FileOutputStream((filepath + "\\" + filename),true);
			//System.out.println(filepath + "\\" + filename);
		 	p = new PrintStream( out );
		 		String rowidl;
		 		String Statusrowidl;
		 		String Status;
		 		
		 		if (_TC_ROW==0){
		 			rowidl = "oddrow";
		 			_TC_ROW=1;
		 		}else{
		 			rowidl = "evenrow";
		 			_TC_ROW=0;
		 		}

		 		
		 		if(_Steps_FAIL_Count > 0){
		 			Status = "Fail";
		 		}else{
			 		Status = "Pass";
			 	 }
			
		 		if(Status.equalsIgnoreCase("PASS")){
		 			Statusrowidl = _PASS_IMG+"<br><B><font color=\"green\">Passed</font></B>";
		 			_TC_PASS_Count++;
		 			
		 		}else{
		 			Statusrowidl = _FAIL_IMG+"<br><B><font color=\"red\">Failed</font></B>";
		 			_TC_FAIL_Count++;
		 		}
		 	
		 		java.util.Date date= new java.util.Date();
		    	Timestamp Times = new Timestamp(date.getTime());
				String Actual =   "<br><hr><font size=\"1\">Time : <i>"+Times.toString()+"</i></font>";
				
		 		p.println("<tr height = \"25\">"+
		 			 	"<td  style=\"text-align:center;\" id=\""+rowidl+"\">" + _TC_COUNT +
		 			 	"<td id=\""+rowidl+"\"><a href=\""+_TC_LINK+"\\index.html\" >" + _TC_NAME +
		 			 	"</a>"+Actual +"<td  style=\"vertical-align: middle;text-align:center;\"  id=\""+rowidl+"\">" + Statusrowidl);
	
		 	  p.close();
		 	 System.out.println("Test Case ':"+  _TC_NAME+"' Html Master Report File, Inserted Successfully! - Status : '"+ Status +"'");
			} catch (IOException e) {
	   	     	System.err.println("IOException : " + e.getMessage());
	   	 	}		 		 
	 }
	 
	 /***********************************************************************************************************

		 * <i><b>Note : </b></i><font color="blue">Initiate_Master_Report(String filepath)</font> must be Called 
		 * before calling this function/method
		 *</pre>
		 * @version			1.0
		 * @param strTCName Test Case Name
		 * @param DataNumber Test  
		 * @return			void
		
	 **********************************************************************************************************/
	 public void Initiate_TC_Report(String strTCName){
		 FileOutputStream out; // declare a file output object
      PrintStream p; // declare a print stream object
      _Steps_FAIL_Count=0;
      _Steps_PASS_Count=0;
      _TC_NAME = strTCName;
      _TC_STEP=0;
      _TC_LINK = _TC_NAME ;
      _TC_UPDATE_STEP_PATH = _MASTER_UPDATE_STEP_PATH + "\\" + _TC_NAME ;
      String filepath = _TC_UPDATE_STEP_PATH;
     
  	String filename = "index.html";
  	
  	
  	java.util.Date date= new java.util.Date();
			 Timestamp Times = new Timestamp(date.getTime());
			_TC_EXEC_Start_Time = Times.toString();
			 

      try
      {

      	new File(filepath).mkdir();
  		
      	 	out = new FileOutputStream((filepath + "\\" + filename),false);
      	 	p = new PrintStream( out );
      	 	
      	 	
/*      	 	FileInputStream fstream = new FileInputStream(directory.getCanonicalPath()+ "\\Support Docs\\header.html");
      	 	DataInputStream in = new DataInputStream(fstream);
      	 	BufferedReader br = new BufferedReader(new InputStreamReader(in));
      	 	String strLine;
      	 	
      	 	//Read File Line By Line
      	 	  while ((strLine = br.readLine()) != null)   {
      	 	  // Print the content on the console
      	 	  //System.out.println (strLine);
      	 		  p.println (strLine);
      	 	  }
      	 	  //Close the input stream
      	 	  in.close();
      	 	  
      	 	  */
      	 	p.println(_header);

    	 	p.println ("<table width=\"95%\" align=\"center\" border=\"0\"><tr><td>");
    	 	p.println ("<ul id=\"menu\">");
    	 	p.println ("<li><a href=\"..\\index.html\">Summary</a></li><li></li>");			
    	 	p.println ("</ul>");
    	 	p.println ("<ul id=\"menu\">");
    	 	p.println ("<li><a href=\"..\\Execution Details.html\">Execution Details</a></li><li></li>");			
    	 	p.println ("</ul>");
    	 	p.println ("</table>");
    	 	
	         	 	 p.println("<hr><table border=\"0\" width=\"95%\" align=\"center\">");

	    		 	 p.println("<tr height = \"25\">" +
	    		 	 			"<td id=\"headerrow\" width=\"10%\">Step No" +
	    		 	 			"<td id=\"headerrow\" width=\"30%\">Description" +
	    		 	 			"<td id=\"headerrow\" width=\"25%\">Expected Result" +
	    		 	 			"<td id=\"headerrow\" width=\"25%\">Actual Result" +
	    		 	 			"<td id=\"headerrow\" width=\"10%\">Status");
      	 	  p.close();
      	 	System.out.println("Test Case ':"+ filepath + "\\" + filename +"' Html Report Files Initiated Successfully!");
      //	 	QC.InitiateQCExecution(_TestSetPath, _TestSetName, _TestName);
              
      }
      catch (Exception e)
      {
     	 if(e.getMessage()!=null){
	             System.err.println("Exception : " + e.getMessage());
     	 }
      }

	 }
	 
	 
	 
	 /***********************************************************************************************************
		 * <li><b>Method : <font color="#0000ff">Close_TC_Report</font></b>
		 * <pre>
		 * The Function will Close the Test case Summary Execution Report
		 * 
		 * Quality Center Method <font color="blue">CloseQCExecution()</font> 
		 * called in this function Not necessary to call externally 
		 * 
		 * <i><b>Note : </b></i><font color="blue">Initiate_TC_Report(strTCName, DataNumber)</font> must be Called 
		 * before calling this function/method
		 *</pre>
		 * @version			1.0
		 * @return			void
		
		 **********************************************************************************************************/
	 public void Close_TC_Report(){
		    String filepath = _TC_UPDATE_STEP_PATH;
	        FileOutputStream out; // declare a file output object
	        PrintStream p; // declare a print stream object
	        String filename = "index.html";
	        
	    	
	    	java.util.Date date= new java.util.Date();
	    	Timestamp Times = new Timestamp(date.getTime());
			_TC_EXEC_End_Time = Times.toString();
			
			try{
			out = new FileOutputStream((filepath + "\\" + filename),true);
		 	p = new PrintStream( out );
		 	
		 		p.println("</table>");
		 	 p.println("<br><hr><table border=\"0\" width=\"40%\" align=\"center\">");
		 	 p.println("<tr height = \"25\" id=\"headerrow\"><td colspan = \"2\" align=\"center\">Execution Summary");
		 	 p.println("<tr height = \"25\"><td id=\"oddrow\">Test Case Name <td id=\"oddrow\"> " + _TC_NAME );
		 	 p.println("<tr height = \"25\"><td id=\"evenrow\">Execution Start Time<td id=\"evenrow\">" + _TC_EXEC_Start_Time );
		 	 p.println("<tr height = \"25\"><td id=\"oddrow\">Execution End Time<td id=\"oddrow\">" + _TC_EXEC_End_Time );
		 	 p.println("<tr height = \"25\"><td id=\"evenrow\">Total Steps <td id=\"evenrow\">" + (_Steps_PASS_Count+ _Steps_FAIL_Count));
		 	 p.println("<tr height = \"25\"><td id=\"oddrow\">Passed Steps<td id=\"Passrow\">"+ _Steps_PASS_Count );
		 	 p.println("<tr height = \"25\"><td id=\"evenrow\">Failed Steps<td id=\"Failrow\">" + _Steps_FAIL_Count);
		 	p.println("<tr height = \"25\"><td id=\"oddrow\">Warnings<td id=\"Warnrow\">" + _Steps_WARN_Count);
		 	
		 	 p.println("</table><Br>" );
		 	 
		 	//INSERT
		 	Insert_Master_Step();
		 	_TC_NAME = "";
		 	_TC_UPDATE_STEP_PATH = "";
		 	_Steps_FAIL_Count = 0;
		 	_Steps_PASS_Count = 0;
		 	_Steps_WARN_Count =0;
		 	/*FileInputStream fstream = new FileInputStream(directory.getCanonicalPath()+ "\\Support Docs\\footer.html");
		 	DataInputStream in = new DataInputStream(fstream);
		 	BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 	String strLine;
		 	
		 	//Read File Line By Line
		 	  while ((strLine = br.readLine()) != null)   {
		 		  p.println (strLine);
		 	  }
		 	  //Close the input stream
		 	  in.close();
*/
		 	p.println(_footer);
    	 	
		 	  p.close();
		 	  System.out.println("Test Case ':"+ filepath + "\\" + filename +"' Html Report Files Created Successfully!");
			 	 //Compress Files
			 	 
				/*
		 	 System.out.println("Compression " + System.getProperty("java.io.tmpdir") + "Report.zip");
					try {
						zipFolder(filepath,System.getProperty("java.io.tmpdir") + "Report.zip");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						if(e.getMessage()!=null){
							System.err.println(errCode + "012 :" + "Compression Folder Exception!");
							System.err.println("Exception : " + e.getMessage());
						}
					}

*/
		 	 	
		 	 			 
			} catch (IOException e) {
				System.err.println("IOException : " + e.getMessage());
	   	 }		 
	 }
	 
	 
	 /***********************************************************************************************************
		 * <li><b>Method : <font color="#0000ff">Insert_TC_Step</font></b>

		 * <i><b>Note : </b></i><font color="blue">Initiate_TC_Report(strTCName, DataNumber)</font> must be Called 
		 * before calling this function/method
		 *</pre>
		 * @version			1.0
		 * @param StepNo 	Step Number
		 * @param Description Description for the step to be entered in HTML Report
		 * @param Expected	Expected Result for the step to be entered in HTML Report
		 * @param Actual Actual Result for the step to be entered in HTML Report/Quality Center Report
		 * @param Status	Execution Status (Defined : Pass/Fail)
		 * @param ScreenShot	Firefox Driver to attach Screenshot (null -wont capture the Screen shot) 
		 * @return			void
		
		 **********************************************************************************************************/
	 
	 public  void Insert_TC_Step( String Description, String Expected, String Actual, String Status, WebDriver driver){
		// System.out.println("_TC_UPDATE_STEP_PATH " + _TC_UPDATE_STEP_PATH);
		 //new UIFrame().ConsoleLog(Actual);
		 
		  String filepath = _TC_UPDATE_STEP_PATH;
		    //System.out.println(_TC_UPDATE_STEP_PATH);
	        FileOutputStream out; // declare a file output object
	        PrintStream p; // declare a print stream object
	        String filename = "index.html";
	        
	        _TC_STEP = _TC_STEP+1;
	        int StepNo = _TC_STEP;
			try{
			out = new FileOutputStream((filepath + "\\" + filename),true);
			//System.out.println(filepath + "\\" + filename);
		 	p = new PrintStream( out );
		 		String rowidl;
		 		String Statusrowidl;
		 		
		 		if (_STEP_ROW==0){
		 			rowidl = "oddrow";
		 			_STEP_ROW=1;
		 		}else{
		 			rowidl = "evenrow";
		 			_STEP_ROW=0;
		 		}
			
		 		String strActual = Actual + "<br><br><hr><table width=\"90%\" align=\"right\" border=\"0\"><tr><td align=\"right\">";
		 		String _ATTACH_LINK1 = "";
		 		if(driver!=null){
		 			java.util.Date date= new java.util.Date();
		 			Timestamp Times = new Timestamp(date.getTime());
		 			String _Unique_stamp = Times.toString().replaceAll(":", "-");
		 			_Unique_stamp = _Unique_stamp.replaceAll("[.]+", "-");
		 			
		 			
		 			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 			_ATTACH_LINK1 =  StepNo + "_screenshot_"+_Unique_stamp+".png";
		 			FileUtils.copyFile(scrFile, new File(filepath + "\\"+ _ATTACH_LINK1));
		 			strActual = strActual + "<ul id=\"menu\" style=\"float:right;\"><li><a href=\""+ _ATTACH_LINK1 +"\"  target=\"_blank\">Screen Shot</a></li><td>";

		 		}
		 		
		 		if(_ATTACH_LINK.equals("")==false){
		 			strActual = strActual + "<ul id=\"menu\" style=\"float:right;\"><li><a href=\""+_ATTACH_LINK+"\" >Details</a></li>";
		 			
		 		}
		 		
			
		 		strActual = strActual + "<tr height=\"15\"><td colspan=\"2\" align=\"right\">";
		 				
		 		java.util.Date date= new java.util.Date();
		    	Timestamp Times = new Timestamp(date.getTime());
		    	strActual = strActual + "<font size=\"1\">Time : <i>"+Times.toString()+"</i></font></table>";
				
		 		
		 		if(Status.equalsIgnoreCase("PASS")){
		 			Statusrowidl = _PASS_IMG + "<br><B><font color=\"green\">Passed</font></B>";
		 			_Steps_PASS_Count++;
		 		}else if(Status.equalsIgnoreCase("WARN")){
		 			Statusrowidl = _WARN_IMG + "<br><B><font color=\"#FF8000\">Warning</font></B>";
		 			_Steps_WARN_Count++;
		 		}else{
		 			Statusrowidl = _FAIL_IMG + "<br><B><font color=\"red\">Failed</font></B>";
		 			_Steps_FAIL_Count++;
		 		}
		 	
		 	
		 		p.println("<tr height = \"25\">"+
		 			 	"<td  style=\"text-align:center;\" id=\""+rowidl+"\">" + StepNo +
		 			 	"<td id=\""+rowidl+"\">" + Description +
		 			 	"<td id=\""+rowidl+"\">" + Expected +
		 			 	"<td id=\""+rowidl+"\">" + strActual +
		 			 	"<td  style=\"vertical-align: middle;text-align:center;\"  id=\""+rowidl+"\">" + Statusrowidl);
		 	  p.close();
		 	 System.out.println("Test Case ':"+ _TC_NAME+ "' Html Test Case Report File, \nStep :'"+StepNo+"' Inserted Successfully!\nDescription : '"+Description + "'\nStatus : '"+ Status +"'");
		 	 
		 	
	 		if(driver!=null){
	 			//QC.InsertStep(StepNo, Actual, Status, filepath + "\\"+ _ATTACH_LINK1);
	 		}else if(_ATTACH_LINK.equals("")==false){
	 		//	QC.InsertStep(StepNo, Actual, Status, filepath + "\\"+ _ATTACH_LINK);
	 		}else{
	 		//	QC.InsertStep(StepNo, Actual, Status, "");
	 		}
	 		_ATTACH_LINK = "";
		 	 
		 	
			} catch (IOException e) {
	   	     	System.err.println("IOException : " + e.getMessage());
	   	     
	   	 }		 
	 }

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void Insert_DB_Results(String[][] DB1, String[][] DB2, String[] header, String DB1_Name, String DB2_Name, String Description, String Expected, String Actual){
		
		 if((DB1==null) && (DB2==null)){
			 Insert_TC_Step(Description, Expected, Actual + "and both the queries returned null value", "Pass", null);
		 }else{
		 	if(DB1==null){
			//	System.out.println("Result1 NULL ");
				DB1 = new String[1][DB2[0].length];
				for(int t=0;t<DB2[0].length;t++){
					DB1[0][t]="<i>null</i>";
				}
			}
		 	
		 	if(DB2==null){
			//	System.out.println("Result2 NULL ");
				DB2 = new String[1][DB1[0].length];
				for(int t=0;t<DB1[0].length;t++){
					DB2[0][t]="<i>null</i>";
				}
			}
		 
		 
		 //Initiate_TC_Report(strTCName)
		 	FileOutputStream out; // declare a file output object
	      	PrintStream p; // declare a print stream object
	      	boolean tmpStatus = true;
		 	java.util.Date date= new java.util.Date();
			Timestamp Times = new Timestamp(date.getTime());
			String _Unique_stamp = Times.toString().replaceAll(":", "-");
			_Unique_stamp = _Unique_stamp.replaceAll("[.]+", "-");

			String filepath = _TC_UPDATE_STEP_PATH;
		  	String filename = "DB_Report_"+_Unique_stamp+".html";
		  	
		  	System.out.println("Creating... " + filename);
		  	String rowidl;
		  	int intmaxCount;
		  	String data1 , data2;
		  	
			_TC_EXEC_Start_Time = Times.toString();
			
			int intDB1length = 0;
			if (DB1!=null){
				intDB1length = DB1.length;
	 		}
			

			
			int intDB2length = 0;
			if (DB2!=null){
				intDB2length = DB2.length;
	 		}

			
			if (intDB1length > intDB2length){
				intmaxCount =  intDB1length;
			}else{
				intmaxCount =  intDB2length;
			}
			
		      try
		      {
		      	out = new FileOutputStream((filepath + "\\" + filename),false);
		      	p = new PrintStream( out );
		      	p.println(_header);
			    
		      //	System.out.println("DB1.length... " + intDB1length);
		      //	System.out.println("DB2.length... " + intDB2length);
		    //	System.out.println("intmaxCount... " + intmaxCount);
		    	
		      	for(int data=0;data<intmaxCount;data++){	
			      	String DBheader = "<table border=\"0\" align=\"center\" width=\"80%\"><tr><th width=\"25%\">Column Names<th width=\"30%\">"+DB1_Name+"<th width=\"30%\">"+DB2_Name+"<th width=\"15%\">Result";
			      	String Status,Statusrowidl;
			   //   	System.out.println("data... " + data);
		      		for(int _rr=0;_rr<header.length;_rr++){	
		      			if (data<intDB1length){
		      				data1 = DB1[data][_rr];
		      			//	System.out.println("data1... " + data1);
		      			}else{
		      				data1 = "<i>null</i>";
		      			}
		      			
		      			if (data<intDB2length){
		      				data2 = DB2[data][_rr];
		      				//System.out.println("data2... " + data2);
		      			}else{
		      				data2 = "<i>null</i>";
		      				
		      			}

		      			
		      			if(data1.equalsIgnoreCase(data2)){
		      				Status = "PASS";
		      				tmpStatus = tmpStatus && true;
		      			}else{
		      				Status="FAIL";
		      				tmpStatus = false;
		      			}
		      			
		      			if(Status.equalsIgnoreCase("PASS")){
				 			Statusrowidl ="<B><font color=\"green\">Passed</font></B>";
				 			//_TC_PASS_Count++;
				 			
				 		}else{
				 			Statusrowidl = "<B><font color=\"red\">Failed</font></B>";
				 		}
		      			
		      			if((_rr%2)==0){
		      				rowidl = "evenrow";
		      			}else{
		      				rowidl = "oddrow";
		      			}
			      		DBheader = DBheader +"<tr><td id=\""+rowidl+"\"  style=\"font-weight:bold;\">"+ header[_rr].trim()+"<td id=\""+rowidl+"\">"+data1+"<td id=\""+rowidl+"\">"+data2+"<td id=\""+rowidl+"\" style=\"text-align: center;\">"+ Statusrowidl;
					}
		      		DBheader = DBheader +"</table><br>";
		      		p.println(DBheader);
		      	}
			      		
		      	p.println(_footer);
		      	
		      	p.close();
		      	
		      	System.out.println("DB Report ':"+ filepath + "\\" + filename +"' Html Report Files added Successfully!");
		      	_ATTACH_LINK = filename;
		      	System.out.println("Attaching " + _ATTACH_LINK);
		      	System.out.println("_TC_UPDATE_STEP_PATH " + _TC_UPDATE_STEP_PATH);
		      	
		      	String status = "Fail";
		      	if (tmpStatus==true){
		      		status = "Pass";
		      		Actual = Actual +", comparsion success";
		      	}else{
		      		Actual = Actual +", comparsion failed";
		      	}
		      	Insert_TC_Step(Description, Expected, Actual, status, null);
		      	 	
		      }catch (IOException e) {
		   	     	System.err.println("IOException : " + e.getMessage());
		      }
		 }
	 }
	 
	
	 
	 
}

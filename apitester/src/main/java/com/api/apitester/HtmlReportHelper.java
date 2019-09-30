package com.api.apitester;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlReportHelper 
{
	static HtmlReporter report;
	
	//ExtentTest logger; 
	//static File pathReport = new File("TestResults\\TestResults.html");
	//static String reportFilePath = "C:\\MavenProj\\HPSPProject\\TestResults\\TestResults.html";
	
	
	
	public static HtmlReporter getHtmlReporter()
	{
		if(report == null)
		{
			
			boolean replaceExisting = false;
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy-HH-mm-SS");
			System.out.println(df.format(new Date()));
			// initialize HtmlReporter and attach the HtmlReporter
			report = new HtmlReporter();	
			//Give the path till the folder. 	
			report.Initiate_Master_Report("TestResults"+df.format(new Date()).toString());
			
		}
		return report;
	}

}

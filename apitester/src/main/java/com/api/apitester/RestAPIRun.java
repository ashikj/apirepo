package com.api.apitester;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAPIRun{
	
	

	@BeforeClass
	public void beforeClass() {
		HtmlReportHelper.getHtmlReporter();
		try {

			
		} catch (Exception ex) {
			ex.printStackTrace();
		
		}
	}
	
	@Test
	public void createApi() throws Exception {
		HtmlReportHelper.getHtmlReporter().Initiate_TC_Report("JsonRequestCreation");
		CreateAPI api = new CreateAPI();
		api.createApi();
	}
	
	@Test
	public void testPosts() {
		try {

			HtmlReportHelper.getHtmlReporter().Initiate_TC_Report("APIResult");
            
			RestAPIMethods.getInstance().Send_RestAPI();
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HtmlReportHelper.getHtmlReporter().Close_TC_Report();
		// HtmlReportHelper.getHtmlReporter().Close_Master_Report();
		// given().headers(headersMap).log().all().when().get("http://jsonplaceholder.typicode.com/posts").then().statusCode(200);
	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
		HtmlReportHelper.getHtmlReporter().Close_Master_Report();
	}

}

package com.api.apitester;


		// TODO Auto-generated method stub
		import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static io.restassured.RestAssured.given;

import java.io.IOException;

		public class TestHttp {

		    public static void main(String[] args)
		    {
		        creatCustomer();

		        getCustomers();

		    }
		    private static void creatCustomer()
		    {
		    	OkHttpClient client = new OkHttpClient();
		    	String strbody = "{\r\n" + 
		    			"    \"queries\": [\r\n" + 
		    			"       \r\n" + 
		    			"        {\r\n" + 
		    			"            \"id\": \"reservations\",\r\n" + 
		    			"            \"values\": [\r\n" + 
		    			"                \"94369463\"\r\n" + 
		    			"            ]\r\n" + 
		    			"        },\r\n" + 
		    			"        {\r\n" + 
		    			"            \"id\": \"last-name\",\r\n" + 
		    			"            \"values\": [\r\n" + 
		    			"                \"\"\r\n" + 
		    			"            ]\r\n" + 
		    			"        }, \r\n" + 
		    			"        {\r\n" + 
		    			"            \"id\": \"start-date\",\r\n" + 
		    			"            \"values\": [\r\n" + 
		    			"                \"\"\r\n" + 
		    			"            ]\r\n" + 
		    			"        }\r\n" + 
		    			"        \r\n" + 
		    			"    ]\r\n" + 
		    			"}       \r\n" + 
		    			"  ";

		    	MediaType mediaType = MediaType.parse("application/json");
		    	RequestBody body = RequestBody.create(mediaType, strbody);
		    	Request request = new Request.Builder()
		    	  .url("https://gatewaydsaptst2.marriott.com/v2/queries/trips")
		    	  .post(body)
		    	  .addHeader("Content-Type", "application/json")
		    	  .addHeader("Authorization", "Bearer eyJhbGciOiJSUzUxMiIsImtpZCI6Im9hdXRoMiIsIng1dCI6IkllMDNMX004ZVdkZEVTMTYzc0t3ZnhFWXg3TSJ9.eyJzdWIiOiJzZ29wYTUwNiIsIkFsdEN1c3RJRCI6InNnb3BhNTA2IiwidG9rZW5fdHlwZSI6Ik9JREMtQXNzb2NpYXRlIiwiWC1EZXZpY2UtSUQiOiJHVUVTVDM2MCIsImF6cCI6IkFnZW50RGVza3RvcCIsImV4cCI6MTUzNTczNjUzNiwic2NvcGUiOlsib3BlbmlkIiwiZW1haWwiLCJwcm9maWxlIiwiUkVBRF9DT05TVU1FUlMiLCJXUklURV9DT05TVU1FUlMiLCJSRUFEX1NUQVlTIiwiV1JJVEVfU1RBWVMiLCJXUklURV9UUklQUyIsIlJFQURfVFJJUFMiLCJSRUFEX0xPQ0FUSU9OUyJdLCJjbGllbnRfaWQiOiJBZ2VudERlc2t0b3AiLCJBY2Nlc3NHcmFudElEIjoiWEtVYjdGaFhRUHhPU2p2RElRdFY5Q3lrTHdBcnpTa3UiLCJpc3MiOiJhcGkubWFycmlvdHQuY29tIiwiYXVkIjoid3d3LnJpdHpjYXJsdG9uLmNvbSIsImp0aSI6IlRqN3RhM0ZpRExNNkpIMmdjWmxNdG43M04ifQ.JqoOCxBYMO3B5rHIdTRybvvTkJoxzPXDoae584it31K4MA0Cvp1hwHvIVOa4Y8KXaZvXuQNuu0WsOR6_t0EXP0aryYDTuI_g7YfuZBETdh9G8p6nWCkncZJHdA7nZy2F6dtbiFC7hzjROOsCsMor4W0Btaup-y7cW0WVz-EXsyj92ChtcKFm1-xBUcBIZN4blyVJ598J7OkJiZYDMyUAHpcytMsl6eYiDvUDKP0t1ZZLogCNQrqD9HuR8mOmonzI-sYs5_xhTG9YBXldc6AtKZaUrRVAPa9t68Kl9O-ZMT1F4xpLTC668F-eeAObc7SqXzpVGibssNysH45SyuIYzQ")
		    	  .addHeader("Cache-Control", "no-cache")
		    	  .addHeader("Authorization", "Basic QWdlbnREZXNrdG9wOlJNYnRYTUVUVVRXWEF5eFhQOWgzdlJlZnlxTGgxUEhHcUlaYml1VQ==")
		    	  .addHeader("X-Device-ID", "GUEST360")
		    	  
		    	  .build();

		    	try {
					Response response = client.newCall(request).execute();
					String str1 = new String(response.body().bytes());
					System.out.println(str1);
					//System.out.println(new String(response.body().bytes()));
					
					//System.out.println(body);
					System.out.println(response.code());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		               
		    }
		    private static void getCustomers()
		    {
		        
		    }
		
	}



package com.api.apitester;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given; 

public class Test {
	public static void main(String[] args) { 
		//RequestSpecification req = given()
		RequestSpecification req = given()
				.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.baseUri("https://gatewaydsaptst2.marriott.com")
		.header("Authorization","Bearer eyJhbGciOiJSUzUxMiIsImtpZCI6Im9hdXRoMiIsIng1dCI6IkllMDNMX004ZVdkZEVTMTYzc0t3ZnhFWXg3TSJ9.eyJzdWIiOiJzZ29wYTUwNiIsIkFsdEN1c3RJRCI6InNnb3BhNTA2IiwidG9rZW5fdHlwZSI6Ik9JREMtQXNzb2NpYXRlIiwiWC1EZXZpY2UtSUQiOiJHVUVTVDM2MCIsImF6cCI6IkFnZW50RGVza3RvcCIsImV4cCI6MTUzNTM5MjU5OSwic2NvcGUiOlsib3BlbmlkIiwiZW1haWwiLCJwcm9maWxlIiwiUkVBRF9DT05TVU1FUlMiLCJXUklURV9DT05TVU1FUlMiLCJSRUFEX1NUQVlTIiwiV1JJVEVfU1RBWVMiLCJXUklURV9UUklQUyIsIlJFQURfVFJJUFMiLCJSRUFEX0xPQ0FUSU9OUyJdLCJjbGllbnRfaWQiOiJBZ2VudERlc2t0b3AiLCJBY2Nlc3NHcmFudElEIjoidDRRNWFabE9ldEFwOGxQaGV5SjlqRUlFZTRoOHppNm8iLCJpc3MiOiJhcGkubWFycmlvdHQuY29tIiwiYXVkIjoid3d3LnJpdHpjYXJsdG9uLmNvbSIsImp0aSI6ImZjazg3MzZRajJDeFpLQlkxVFN5YXhHVlcifQ.jlkI-ZGJ4ha3by1055mn3wHUJDQikRgoZArVLAftfbneH33gUUMJ-WGIEZdQ_7FM3v6jQ7tL2pb58vurMNmHBm5sIw7xU-yT7_ceTPYCg3kxtrHdwGYg3LLHzFPLjPPouguZkuzJvflLQn0o1OP1mH2rkDjwsCPVk47NVfGtyl0xc7fUD60gLHQBzkaVJhNKQGbj3oUFcrHrtm1ipUxFazyUieY6qSJd47gRMCP3TFJpHADFBh3abbDjHGBdpuskUAPM5srJQbhLxcHO7ppfTtBsLV3AT7_3qjfDxfZWlOp-DzT8C1OU9WVXDldtH7j0ECpmhjQs9X5x6he1U9Iz4w")
		.header("Authorization","Basic QWdlbnREZXNrdG9wOlJNYnRYTUVUVVRXWEF5eFhQOWgzdlJlZnlxTGgxUEhHcUlaYml1VQ==")
		.header("Content-Type","application/json")
		.header("X-Device-ID", "GUEST360");
		
		System.out.println(req.log().everything());
		Response response = req.get("v2/consumers/9854502491778316042B4D2105F421397.01/trips-history?startDate=2016-05-28&endDate=2017-11-28");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode()); 
			}

}

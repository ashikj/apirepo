package com.api.apitester;


		// TODO Auto-generated method stub
		import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

		public class TestPost {

		    public static void main(String[] args)
		    {
		        creatCustomer();

		        getCustomers();

		    }
		    private static void creatCustomer()
		    {
		        String body = "{\r\n" + 
		        		"    \"queries\": [\r\n" + 
		        		"        {\r\n" + 
		        		"            \"id\": \"exact-match\",\r\n" + 
		        		"            \"values\": [\r\n" + 
		        		"                \"false\"\r\n" + 
		        		"            ]\r\n" + 
		        		"        },\r\n" + 
		        		"        {\r\n" + 
		        		"            \"id\": \"rewards-number\",\r\n" + 
		        		"            \"values\": [\r\n" + 
		        		"                \"\"\r\n" + 
		        		"            ]\r\n" + 
		        		"        },        \r\n" + 
		        		"        {\r\n" + 
		        		"            \"id\": \"emails\",\r\n" + 
		        		"            \"values\": [\r\n" + 
		        		"                \"\"\r\n" + 
		        		"            ]\r\n" + 
		        		"        },       \r\n" + 
		        		"        {\r\n" + 
		        		"            \"id\": \"phones\",\r\n" + 
		        		"            \"values\": [\r\n" + 
		        		"                \"12312334\"\r\n" + 
		        		"            ]\r\n" + 
		        		"        },             \r\n" + 
		        		"        {\r\n" + 
		        		"            \"id\": \"first-name\",\r\n" + 
		        		"            \"values\": [\r\n" + 
		        		"                \"\"\r\n" + 
		        		"            ]\r\n" + 
		        		"        }, \r\n" + 
		        		"        {\r\n" + 
		        		"            \"id\": \"last-name\",\r\n" + 
		        		"            \"values\": [\r\n" + 
		        		"                \"JN\"\r\n" + 
		        		"            ]\r\n" + 
		        		"        },\r\n" + 
		        		"        {\r\n" + 
		        		"            \"id\": \"addresses\",\r\n" + 
		        		"            \"addresses\": [\r\n" + 
		        		"                {\r\n" + 
		        		"                   \"line1\": \"\",\r\n" + 
		        		"                   \"line2\": \"\",\r\n" + 
		        		"                   \"line3\": \"\",\r\n" + 
		        		"                   \"city\": \"\",\r\n" + 
		        		"                   \"stateProvince\": \"\",\r\n" + 
		        		"                   \"postalCode\": \"5600068\",\r\n" + 
		        		"                   \"country\": {\r\n" + 
		        		"                      \"code\": \"CA\"\r\n" + 
		        		"                   }\r\n" + 
		        		"                }\r\n" + 
		        		"            ]\r\n" + 
		        		"        }\r\n" + 
		        		"    ]\r\n" + 
		        		"} ";
		        System.out.println(body);
		        
		       RestAssured.baseURI = "https://gatewaydsaptst2.marriott.com";
		      // RestAssured.config = RestAssured.config(config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)));
		        given().relaxedHTTPSValidation()
		        .config(RestAssuredConfig.config().sslConfig(io.restassured.config.SSLConfig.sslConfig().allowAllHostnames().relaxedHTTPSValidation()))
		        
		        .contentType(ContentType.JSON)
		        .contentType("application/json")
		       
		                .body(body)
		                
		                .header("content-type","application/json")
		                .header("authorization", "Bearer eyJhbGciOiJSUzUxMiIsImtpZCI6Im9hdXRoMiIsIng1dCI6IkllMDNMX004ZVdkZEVTMTYzc0t3ZnhFWXg3TSJ9.eyJzdWIiOiJzZ29wYTUwNiIsIkFsdEN1c3RJRCI6InNnb3BhNTA2IiwidG9rZW5fdHlwZSI6Ik9JREMtQXNzb2NpYXRlIiwiWC1EZXZpY2UtSUQiOiJHVUVTVDM2MCIsImF6cCI6IkFnZW50RGVza3RvcCIsImV4cCI6MTUzNTU2MzE1NCwic2NvcGUiOlsib3BlbmlkIiwiZW1haWwiLCJwcm9maWxlIiwiUkVBRF9DT05TVU1FUlMiLCJXUklURV9DT05TVU1FUlMiLCJSRUFEX1NUQVlTIiwiV1JJVEVfU1RBWVMiLCJXUklURV9UUklQUyIsIlJFQURfVFJJUFMiLCJSRUFEX0xPQ0FUSU9OUyJdLCJjbGllbnRfaWQiOiJBZ2VudERlc2t0b3AiLCJBY2Nlc3NHcmFudElEIjoiU0pYckJsbU1ZUWVFamFabjJlRldjUGNCWXFLWHF1cnkiLCJpc3MiOiJhcGkubWFycmlvdHQuY29tIiwiYXVkIjoid3d3LnJpdHpjYXJsdG9uLmNvbSIsImp0aSI6IjFoNnM5czM5UE5IaFJXMXVXT3Ewb2Y3MGIifQ.Qe4vkfKBnkiIU-lZ_IIp4D-mNnPEHfoRXreuM-qoVPiosHDYML_LAJoXMasq2NnMfV5NK-2Cqo82zl_WTqm_NpFaEnv7gtsmf9kWaBrRrxzYKNlsjnGF9GkeTq7Z1HZ5QG53YXA3Zmy-gei1zSkz4xtJ9vk8U3jcSbZKLOIDmclHislQJU8I5HodlBhhsBZKdgX4fuDogFL6uscp5TZUCsEreiitr10ExARMbJZpyaqsEw6vsnB_nK1__f9E80MD5OyIjg6hr319DjAy-xcT7IBTCQ5aMjsCMPNOtKpvMeArg_mGoZLFODQqREK36awTc6n3chQDQafJD2fBORwM6Q")
		                .header("authorization", "Basic QWdlbnREZXNrdG9wOlJNYnRYTUVUVVRXWEF5eFhQOWgzdlJlZnlxTGgxUEhHcUlaYml1VQ==")
		                .header("X-Device-ID", "GUEST360")
		                .header("Cache-Control", "no-cache")
		                .log().all()
		                .when().post("/v2/queries/consumers/?include=consumers.contact-information,consumers.names,consumers.rewards,consumers.rewards.summary,consumers.preferences,consumers.account-activities,consumers.certificates,consumers.saved-properties,consumers.program-partners,consumers.personal-information").then().log().all()
		                .statusCode(200);
		    }
		    private static void getCustomers()
		    {
		        
		    }
		
	}



package com.api.apitester;

import static io.restassured.RestAssured.given;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.MultiValueMap;

import org.json.JSONObject;

import com.api.apitester.ExcelReader;
import com.api.apitester.RequestData;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;


public class RestAPIMethods {
	private static RestAPIMethods restAPIMethods = new RestAPIMethods();

	public static RestAPIMethods getInstance() {
		return restAPIMethods;
	}
	
	

	public void Send_RestAPI() throws Exception {

		List<RequestData> requestDataList = ExcelReader.read();
		Map<String, String> headersMap = new HashMap<String, String>();
		MultiValueMap map = new MultiValueMap();

		for (int k = 1; k < requestDataList.size(); k++) {
			int statuscode = 0;
			RequestData r = requestDataList.get(k);
			JSONObject jsonObj = null;
			
			if (r.getPayload() != "") {
				jsonObj = new JSONObject(r.getPayload());

			}

			System.out.println("------------------------------------");
			try {
				Response response = null;
				if (r.getMethod().equals("GET")) {
					RequestSpecification req = given()
					.header("Content-Type", "application/json")
					.header("Authorization",
							"Bearer eyJhbGciOiJSUzUxMiIsImtpZCI6Im9hdXRoMiIsIng1dCI6IndwczVMYkdvX2Nub2d0bUk3dkVaRlQ4LUxOOCJ9.eyJzdWIiOiJhamFnYTYyOCIsIkFsdEN1c3RJRCI6ImFqYWdhNjI4IiwidG9rZW5fdHlwZSI6Ik9JREMtQXNzb2NpYXRlIiwiWC1EZXZpY2UtSUQiOiJHVUVTVDM2MCIsImF6cCI6IkFnZW50RGVza3RvcCIsImV4cCI6MTU1NDczNzkwMSwic2NvcGUiOlsib3BlbmlkIiwiZW1haWwiLCJwcm9maWxlIiwiUkVBRF9DT05TVU1FUlMiLCJXUklURV9DT05TVU1FUlMiLCJSRUFEX1NUQVlTIiwiV1JJVEVfU1RBWVMiLCJXUklURV9UUklQUyIsIlJFQURfVFJJUFMiLCJSRUFEX0xPQ0FUSU9OUyJdLCJjbGllbnRfaWQiOiJBZ2VudERlc2t0b3AiLCJBY2Nlc3NHcmFudElEIjoiZjd1RVhvV3ZZdjBXRWM4b2U5Z3ZmclBOdDBiUFEwcloiLCJpc3MiOiJhcGkubWFycmlvdHQuY29tIiwiYXVkIjoid3d3LnJpdHpjYXJsdG9uLmNvbSIsImp0aSI6InlBWFFmWDdISU1Ja3FZOEVoMVllbFVoQTYifQ.rcQ0qJhTcyNQ2pvQzjuSKGf5J-fiNQk-8MS9VOh4nZIp-Hxtip0bWtBwpAk55YkjKC2w1Fzip_CG8LTxlHYtPb5wxPQT3gEtdOAsGEJMJgyVOjdclI8rXv3aGZYMN79kkAwg1PzJvUHKhv7f2wjoO-dbXgCFZyI42ELQLIDlfhGszDH5jLD4on34jgGWfkYOM5P9SnANCDA6OtpTtN8kmXaib1XKnulkC8y4kBtHgiDb6urzGccwdo4i4hyT02Zsn2C_0_EmNRoeujMqXrHN8980C8Fq2z1tB_-LIAhmbg4_8LVf1ijR6N5w0UbBNvLZidEJDc32okpCBlHlcVnnCQ")
					.header("Cache-Control", "no-cache")
					.header("Authorization",
							"Basic QWdlbnREZXNrdG9wOlJNYnRYTUVUVVRXWEF5eFhQOWgzdlJlZnlxTGgxUEhHcUlaYml1VQ==");

					response = req.get(r.getUrl());
					System.out.println(response.asString());
					System.out.println(response.getStatusCode());

					r.setStatuscode(String.valueOf(response.getStatusCode()));
					//r.setStatusline(response.getStatusLine());	
					r.setResponsebody(response.getBody().asString());
					statuscode = response.getStatusCode();
					requestDataList.set(k, r);
					if (statuscode == 200 || statuscode == 207) {
						HtmlReportHelper.getHtmlReporter().Insert_TC_Step(r.getUrl(), r.getPayload(),
								"Status Code:" + statuscode, "Pass", null);
					} else {
						HtmlReportHelper.getHtmlReporter().Insert_TC_Step(r.getUrl(), r.getPayload(),
								"Status Code:" + statuscode, "Fail", null);
					}
				}

				else {

					if (r.getMethod().equals("POST")) {
						OkHttpClient client = new OkHttpClient();
						MediaType mediaType = MediaType.parse("application/json");
						okhttp3.RequestBody postrequestbody = okhttp3.RequestBody.create(mediaType, r.getPayload());
						okhttp3.Request request = new okhttp3.Request.Builder().url(r.getUrl()).post(postrequestbody)
								.addHeader("Content-Type", "application/json")
							
								.addHeader("Authorization",
										"Basic UE1VU0VSOnBhc3N3b3JkMQ==")
								.addHeader("userID", "PMUSER").build();

						okhttp3.Response postresponse = client.newCall(request).execute();
						// System.out.println(new String(postresponse.body().bytes()));

						String postresponsebody = new String((postresponse.body().bytes()));

						int postresponsecode = postresponse.code();
						r.setStatuscode(String.valueOf(postresponsecode));
						//r.setStatusline(postresponse.message());

						r.setResponsebody(postresponsebody);
						System.out.println(postresponsebody);

						System.out.println(postresponsecode);

						requestDataList.set(k, r);

						if (postresponsecode == 200 || postresponsecode == 207) {
							HtmlReportHelper.getHtmlReporter().Insert_TC_Step(r.getUrl(), r.getPayload(),
									"Status Code:" + statuscode, "Pass", null);
						} else {
							HtmlReportHelper.getHtmlReporter().Insert_TC_Step(r.getUrl(), r.getPayload(),
									"Status Code:" + statuscode, "Fail", null);
						}

					}
				}

				// statuscode= statuscode+k;

				ExcelReader.writeExcel(requestDataList);
			} catch (Exception e) {
				e.printStackTrace();

			}

		}

	}
}

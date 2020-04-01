package com.falcon.api.get.testscripts.employeeservice;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.falcon.api.testsuite.TestSuiteBase;

import com.falcon.api.utility.STATUS_CODE;
import com.falcon.api.utility.Util;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class TC_004_Verify_To_Get_Employee_With_ID extends TestSuiteBase {
	Map<String, String> headers = new HashMap<>();
	String url = null;
	

	@SuppressWarnings("unused")
	@Test
	public void GetScheduleWithScheduleUUID() throws Exception {
		report = extent.createTest("TC_018_Verify_To_Get_Schedule_With_ScheduleUUID", "Display-Channel-Service");
		report.info("Verify to Get Schedule with ScheduleUUID");		
		headers.put("Authorization", Util.getAccessToken());
		url = Util.buildURI(config.getString("getSchedule"));
		report.info("INFO:Get the added Schedule");
		Response response = given()
				.headers(headers)
				.contentType(ContentType.JSON)
				.queryParam("scheduleUUID", testdata.getString("scheduleUUID")).queryParam("displayUUID", testdata.getString("displayUUID"))
				.get(url)
				.andReturn();
		assertEquals(response.getStatusCode(), STATUS_CODE.STATUS_200.getValue(),
				"INFO: Status Code Validation Failed.");

	
	}

}

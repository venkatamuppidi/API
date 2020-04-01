package com.falcon.api.post.testscripts.employeeservice;

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

public class TC_003_Verify_To_Create_Employee_With_EmptyPayload extends TestSuiteBase {
	Map<String, String> headers = new HashMap<>();
	String url = null;

	@Test
	public void addScheduleWithEmptyPayload() throws Exception {
		report = extent.createTest("TC_003_Verify_To_Create_Schedule_With_Empty_Payload",
				"Display-Channel-Service");
		report.info("Verify to create Schedule with empty payload");
		headers.put("Authorization", Util.getAccessToken());
		url = Util.buildURI(config.getString("addSchedule"));
		JSONObject scheduleObject = Util.getJSONObjectfromString("{}");
		report.info("Creating Schedule by passing empty body");
		Response response = given().headers(headers).contentType(ContentType.JSON).body(scheduleObject).post(url).andReturn();
		report.info("Validating Status Code");
		assertEquals(response.getStatusCode(), STATUS_CODE.STATUS_500.getValue(), "Status Code Validation Failed.");
	}
}

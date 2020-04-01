package com.falcon.api.post.testscripts.employeeservice;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.falcon.api.testsuite.TestSuiteBase;
import com.falcon.api.utility.STATUS_CODE;
import com.falcon.api.utility.AppConstants;
import com.falcon.api.utility.Util;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class TC_002_Verify_To_Create_Employess_With_id extends TestSuiteBase {
	Map<String, String> headers = new HashMap<>();
	String url = null;

	@SuppressWarnings({ "unchecked", "unused" })
	@Test
	public void addScheduleWithScheduleUUID() throws Exception {
		report = extent.createTest("TC_002_Verify_To_Create_Schedule_With_ScheduleUUID", "Display-Channel-Service");
		report.info("Verify to create Schedule with ScheduleUUID");
		headers.put("Authorization", Util.getAccessToken());
		url = Util.buildURI(config.getString("addSchedule"));
		JSONObject scheduleJson = Util.getJSONObjectFromFilePath(AppConstants.CREATE_SCHEDULE_JSON_FILE);
		scheduleJson.put("scheduleUUID", testdata.getString("scheduleUUID"));
		Response response = given().headers(headers).contentType(ContentType.JSON).body(scheduleJson).post(url)
				.andReturn();
		JSONObject ioResponseObject = Util.getJSONObjectfromString(response.getBody().asString());
		report.info("INFO:Validating Status Code");
		assertEquals(response.getStatusCode(), STATUS_CODE.STATUS_200.getValue());
	}

}

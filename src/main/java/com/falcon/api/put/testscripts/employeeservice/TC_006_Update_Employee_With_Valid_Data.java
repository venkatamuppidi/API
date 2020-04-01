package com.falcon.api.put.testscripts.employeeservice;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.falcon.api.testsuite.TestSuiteBase;

import com.falcon.api.utility.EmployeeServiceHelper;
import com.falcon.api.utility.STATUS_CODE;
import com.falcon.api.utility.Util;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class TC_006_Update_Employee_With_Valid_Data extends TestSuiteBase {
	Map<String, String> headers = new HashMap<>();
	String url = null;

	@SuppressWarnings({ "unchecked", "unused" })
	@Test
	public void UpdateScheduleWithValidData() throws Exception {
	/*	report = extent.createTest("TC_034_Update_Schedule_With_Valid_Data", "Display-Channel-Service");
		report.info("Verify to update Schedule with valid data");
		headers.put("Authorization", Util.getAccessToken());
		url = Util.buildURI(config.getString("updateSchedule"));
		JSONArray scheduleResponseObject = EmployeeServiceHelper.getSchedule(testdata.getString("displayUUID"));
	    JSONObject firstObject = Util.getFirstJsonObject(scheduleResponseObject);
	    
	    firstObject.put("scheduleDescription", "TestScheduleDescription" + Util.getRandomNumber());
	    Response response = given().headers(headers).contentType(ContentType.JSON).body(firstObject).put(url)
				.andReturn();
		report.info("Validating Status Code");
		assertEquals(response.getStatusCode(), STATUS_CODE.STATUS_200.getValue(), "Status Code Validation Failed.");*/
	}
}

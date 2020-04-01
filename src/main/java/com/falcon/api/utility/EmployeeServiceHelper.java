package com.falcon.api.utility;


import static com.jayway.restassured.RestAssured.given;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falcon.api.testsuite.TestSuiteBase;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

@SuppressWarnings("unused")
public class EmployeeServiceHelper extends TestSuiteBase{

	static Map<String, String> headers= new HashMap<>();
	static String url=null;
	
	public static boolean deleteEmployee(String id) throws Exception
	{
		report.info("Verify to delete client");
		Map<String, String> headers= new HashMap<>();	
		headers.put("Authorization",Util.getAccessToken());
		return RestAssured.given().headers(headers)
		.pathParam("id", id)
		.when()
		.delete(Util.buildURI(config.getString("deleteClient"))).getStatusCode()==STATUS_CODE.STATUS_200.getValue();
	}
	
	


	public static void addEmployeeWithValidDataAndReturnEmployeeID() throws Exception, FileNotFoundException{
		report.info("Initiating Employee Creation");
	
		url=Util.buildURI(config.getString("addEmployee"));
		
		System.out.println(url);
	
		report.info("Getting TestData for Employee");
		String name="TestEmployee_"+Util.getRandomNumber();
		System.out.println(name);
		JSONObject employeeObject= Util.getJSONObjectFromFilePath(AppConstants.CREATE_EMPLOYEE);
		
		
		employeeObject.put("name",name);
		
		System.out.println(employeeObject);
		Response response = given()
									.headers(headers)
									.contentType(ContentType.JSON)
									.body(employeeObject)
									.post(url)
									.andReturn();
		System.out.println(response.getStatusCode());
		report.info("Validating Status Code");
		assertEquals(response.getStatusCode(), STATUS_CODE.STATUS_200.getValue());
		JSONObject clientResponseObject= Util.getJSONObjectfromString(response.getBody().asString());
		
		System.out.println(clientResponseObject.get(name));
		
		
		assertEquals(name, clientResponseObject.get("name"));
		String id = (String) clientResponseObject.get("id");
		String stringmessage = response.getStatusCode() == 200 ? "Employee Created Successfully with ID="+id:"";
		
		System.out.println(clientResponseObject.get(id));
		
		System.out.println(stringmessage);
		testdata.setProperty("id", id);
		testdata.save();
		testdata.setProperty("name",name);
		testdata.save();
		
	}
	

	public static JSONObject getJSONObjectOfEmployee(String clientUUID) throws FileNotFoundException, IOException, ParseException {
		headers.put("Authorization",Util.getAccessToken());
		url=Util.buildURI(config.getString("getClientById"));
		// clientUUID = testdata.getString("clientUUID");
		Response response = given()
									.headers(headers)
									.contentType(ContentType.JSON)
									.pathParam("id", clientUUID)
									.get(url)
									.andReturn();
			
		JSONObject clientResponse = Util.getJSONObjectfromString(response.getBody().asString());
		String stringmessage = response.getStatusCode() == 200 ? "Get Client Successfully with ID="+clientUUID:"Client Creation Failed.";
		assertEquals(clientResponse.toString().contains("id"), true);
		assertEquals(clientResponse.toString().contains("name"), true);
		return clientResponse;
	
}
}


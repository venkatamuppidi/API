package com.falcon.api.delete.testscripts.employeeservice;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import com.falcon.api.testsuite.TestSuiteBase;

public class TC_007_Verify_To_Delete_Employee extends TestSuiteBase {
	Map<String, String> headers = new HashMap<>();
	String url = null;

	@Test
	public void DeleteScheduleWithValidData() throws Exception {
		report = extent.createTest("TC_040_Verify_To_Delete_Created_Schedule", "Display-Channel-Service");
		report.info("Verify to delete created Schedule");
		
	}
}

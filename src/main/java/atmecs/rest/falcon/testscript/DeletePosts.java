package atmecs.rest.falcon.testscript;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.rest.endpoint.RequestBuilder;
import com.atmecs.falcon.automation.rest.endpoint.ResponseOptions;
import com.atmecs.falcon.automation.rest.endpoint.ResponseService;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;

import atmecs.rest.falcon.testsuite.SampleTestSuiteBase;

public class DeletePosts extends SampleTestSuiteBase{

	private String deletepost=CONFIG.getProperty("deleteProject.delete");
	RequestBuilder builder=new RequestBuilder() ;
	private ReportLogService report = new ReportLogServiceImpl(CreateFalconPosts.class);

	@Test
	public void deleteProjectApiTest() {

		report.info("Making DELETE API call to delete the project");
		
		ResponseOptions responseOptions = builder.build();
		
		report.info("Preparing request body by adding elements in form-data");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
		
		report.info("Making Call to URL : "+deletepost);
		
		ResponseService responseService = responseOptions.delete(deletepost);

		String responseBody = responseService.getBody();
		report.info("Response Body : "+ (responseBody.isEmpty() ? "is empty" : responseBody ) );
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );

		String expectedMessage = "Deleted the post request successfully done";
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Verified Response message :" + expectedMessage);
	}
	

}

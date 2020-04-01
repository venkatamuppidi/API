package atmecs.rest.falcon.testscript;

import java.io.File;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.rest.endpoint.RequestBuilder;
import com.atmecs.falcon.automation.rest.endpoint.ResponseOptions;
import com.atmecs.falcon.automation.rest.endpoint.ResponseService;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;

import atmecs.rest.falcon.testsuite.SampleTestSuiteBase;

public class CreateFalconPosts extends SampleTestSuiteBase{

	RequestBuilder builder=new RequestBuilder();
	private static String filename = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator + "suitefile"+File.separator
            + "testng-results.xml";
	private static String imgfilename = System.getProperty("user.dir") + File.separator + "src"
            + File.separator + "main" + File.separator + "resources" + File.separator + "suitefile"+File.separator
            + "testng-results.xml";
	File testfile=new File(filename);
	File imagefile=new File(imgfilename);
	private ReportLogService report = new ReportLogServiceImpl(CreateFalconPosts.class);
	private String testreportupload= CONFIG.getProperty("tesreportupload.post");
	private String imageupload= CONFIG.getProperty("imageupload.post");
	
	@Test
	public void  uploadTestngResultFileApiTest()
	{
		report.info("Making POST API call to upload testng-results.xml file");
		
		ResponseOptions responseOptions = builder.queryParam(productNameKey,productNameValue).
				queryParam(ComponentKey, ComponentValue).
				queryParam(EnvironmentKey, EnvironmentValue).
				queryParam(TestPhaseKey, TestPhaseValue).
				queryParam(TestRunatKey, TestRunatValue).
				queryParam(DeviceKey, DeviceValue).
				addMultipart(FileName,testfile).build();
		
		report.info("Preparing request body by adding elements in form-data");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
		
		report.info("Making Call to URL : "+testreportupload);
		
		ResponseService responseService = responseOptions.post(testreportupload);

		String responseBody = responseService.getBody();
		report.info("Response Body : "+responseBody);
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );
	
		String actualMessage = responseService.getJsonPath().getString("message");
		VerificationManager.verifyTrueAndStopTest(actualMessage.equalsIgnoreCase("Upload successfully done"), "Verified Response message : "+actualMessage);
	}

	@Test
	public void uploadImageApiTest()
	{
		report.info("Making POST API call to upload the image");
		
		ResponseOptions responseOptions = builder.queryParam("filename","falconimage" ).
											addMultipart("file",imagefile).build();
		
		report.info("Preparing request body by adding elements in form-data");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
		
		report.info("Making Call to URL : "+imageupload);

		ResponseService responseService = responseOptions.post(imageupload);

		String responseBody = responseService.getBody();
		report.info("Response Body : "+ responseBody);
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );
	
		String actualMessage = responseService.getJsonPath().getString("message");
		VerificationManager.verifyTrueAndStopTest(actualMessage.equalsIgnoreCase("Image upload successfully done : falconimage"), "Verified Response message : "+actualMessage);
	}
	


}

package atmecs.rest.falcon.testscript;


import atmecs.rest.falcon.testsuite.SampleTestSuiteBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.atmecs.falcon.automation.rest.endpoint.RequestBuilder;
import com.atmecs.falcon.automation.rest.endpoint.ResponseOptions;
import com.atmecs.falcon.automation.rest.endpoint.ResponseService;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;


/**
 * 
 *         FalconGetList class is to test the services using links.
 * 
 *         Sample TestSuiteBase is extended. The common functions required for
 *         all the scripts under this suite to be defined in the TestSuiteBase.
 * 
 */
public class FalconGetList extends SampleTestSuiteBase {

	private ReportLogService report = new ReportLogServiceImpl(FalconGetList.class);
	RequestBuilder builder			= new RequestBuilder() ;
	private String getdashboard 	= CONFIG.getProperty("dashboard.get");
	private String testreportview 	= CONFIG.getProperty("viewtestreport.get");
	private String viewreport 		= CONFIG.getProperty("viewreport.get");
	private String recentruns 		= CONFIG.getProperty("getrecentruns.get");
	private String exporttoexcel 	= CONFIG.getProperty("exporttoexcel.get");
	private String downloadimage	= CONFIG.getProperty("downloadImage.get");
	private String failedreport 	= CONFIG.getProperty("failedtestreport.get");

	@Test
	public void getDashboardApiTest() {
		report.info("Making GET API call to get the dashboard");
		
		ResponseOptions responseOptions = builder.build();
		report.info("Preparing request body to get dashboard posts");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
	
		report.info("Making Call to URL : "+getdashboard);
		ResponseService responseService = responseOptions.get(getdashboard);

		String responseBody = responseService.getBody();
		
		report.info("Response Status Line : " + responseService.getStatusLine());
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );
	
		String expectedMessage = "products are present";
		List<String> listOfProducts = responseService.getJsonPath().getList("products");
		VerificationManager.verifyTrueAndStopTest(listOfProducts != null, "Verified Response : "+expectedMessage);
	}

	@Test
	public void reportViewApiTest() {
		report.info("Making GET API call to get the report view");
		
		ResponseOptions responseOptions = builder.build();
		report.info("Preparing request body to get the report view");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
		
		report.info("Making Call to URL : "+testreportview);
		
		ResponseService responseService = responseOptions.get(testreportview);

		responseService.getResponseBody();
		String responseBody = responseService.getBody();
		report.info("Response Status Line : " + responseService.getStatusLine());
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );

		/*	List<String> listOfProducts = responseService.getJsonPath().getList("products");

		String expectedMessage = "products are present";
		System.out.println("====================listOfProducts.size() > 0 " + listOfProducts.size() );
		VerificationManager.verifyTrueAndStopTest((listOfProducts.size() > 0), "Verified Response : "+expectedMessage);*/

	}
	@Test
	public void viewReportApiTest() {

		report.info("Making GET API call to view the report");
		
		ResponseOptions responseOptions = builder.build();
		report.info("Preparing request body to view the report");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
	
		report.info("Making Call to URL : "+viewreport);
		ResponseService responseService = responseOptions.get(viewreport);

		String responseBody = responseService.getBody();
		
		report.info("Response Status Line : " + responseService.getStatusLine());
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );
	}
	
	@Test
	public void recentRunsApiTest() {
		
		report.info("Making GET API call to view the recent runs");
		
		ResponseOptions responseOptions = builder.build();
		report.info("Preparing request body to view the recent runs");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
	
		report.info("Making Call to URL : "+recentruns);
		ResponseService responseService = responseOptions.get(recentruns);

		String responseBody = responseService.getBody();
		
		report.info("Response Status Line : " + responseService.getStatusLine());
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );
	}
	
	@Test(dataProvider = "csvDataAsMap") 
	public void exportToExcelApiTest() {
		
		report.info("Making GET API call to export results to excel");
		Map<String, String > auth = new HashMap();
		
		ResponseOptions responseOptions = builder.headers(auth).				
				build();
		report.info("Preparing request body to export results to excel");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
	
		report.info("Making Call to URL : "+exporttoexcel);
		ResponseService responseService = responseOptions.get(exporttoexcel);

		String responseBody = responseService.getBody();
		
		report.info("Response Status Line : " + responseService.getStatusLine());
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );
	}
	
	@Test
	public void downloadImageApiTest() {
		report.info("Making GET API call to verify download image");
		
		ResponseOptions responseOptions = builder.build();
		report.info("Preparing request body to download image");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
	
		report.info("Making Call to URL : "+downloadimage);
		ResponseService responseService = responseOptions.get(downloadimage);

		String responseBody = responseService.getBody();
		
		report.info("Response Status Line : " + responseService.getStatusLine());
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "Response Status : " + responseCode + (responseCode == 200  ? " Ok" : "") );
	}
	
	@Test
	public void invalidLinkApiTest() {
		
		report.info("Making GET API call to export results to excel, simulated the failure here by providing invalid url");
		
		ResponseOptions responseOptions = builder.build();
		report.info("Preparing request body to export results to excel");
		VerificationManager.verifyTrueAndStopTest(responseOptions != null, "Request Body prepared successfully");
	
		report.info("Making Call to URL : "+failedreport);
		ResponseService responseService = responseOptions.get(failedreport);

		String responseBody = responseService.getBody();
		
		report.info("Response Status Line : " + responseService.getStatusLine());
		
		int responseCode = responseService.getStatusCode();
		VerificationManager.verifyTrueAndStopTest(responseCode==200, "This is to show how it handle the failed exception" );
	}
	

}

/****
 * This is the TestSuite Base for Company Setup configuration.
 * This Class extends the Test Base Class
 * Class has Before & After Suite method to connect/Disconnect Database
 * Class has Before Suite method to get Company setup jersey Client.
 * This is a must file for Company setup testNg script to execute & should not be deleted.
 */
package atmecs.rest.falcon.testsuite;

import java.io.File;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.atmecs.falcon.automation.rest.endpoint.RequestBuilder;
import com.atmecs.falcon.automation.util.logging.LogLevel;
import com.atmecs.falcon.automation.util.logging.LogManager;
import com.atmecs.falcon.automation.util.parser.JsonParser;
import com.atmecs.falcon.automation.util.parser.PropertyParser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import atmecs.rest.falcon.testfunction.PathLocator;

/**
 * 
 *         SampletestSuiteBase class holds the services common for all the
 *         scripts in the suite
 */
public class SampleTestSuiteBase {

	/**
	 * Properties File holds common values which are used across all the scripts
	 */
	public static Properties CONFIG = null;
	private final String configFilePath = new PathLocator().getPathFromResource("config.properties");
	protected ReportLogService report = new ReportLogServiceImpl(SampleTestSuiteBase.class);
	
	protected RequestBuilder builder ;
	protected JsonParser parser = new JsonParser();
	protected JSONObject obj;
	protected String productNameKey;
	protected String productNameValue;
	protected String ComponentKey;
	protected String ComponentValue;
	protected String EnvironmentKey;
	protected String EnvironmentValue;
	protected String TestPhaseKey;
	protected String TestPhaseValue;
	protected String TestRunatKey;
	protected String TestRunatValue;
	protected String DeviceKey;
	protected String DeviceValue;
	protected String FileName;
	protected static ObjectMapper mapper = new ObjectMapper();
	
	
	public SampleTestSuiteBase()  {
		File newFile= new File(System.getProperty("user.dir")+"/src/main/java/atmecs/rest/falcon/testdata/postData.json");

		try {
			CONFIG = new PropertyParser().loadProperty(configFilePath);
			obj=parser.getJsonObject(newFile);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
			}
	


	/*
	 * BeforeSuite process identified here Passing following parameters is must
	 * in the suite execution process
	 * 
	 * Sample code provided
	 */

	@BeforeSuite
	public void preSetup() throws Exception {
		JSONObject falconpost= (JSONObject)obj.get("Falconpost");
		productNameKey = (String) falconpost.get("productnameKey");
		productNameValue = (String) falconpost.get("productnameValue");
	    ComponentKey = (String) falconpost.get("ComponentKey");
		ComponentValue = (String) falconpost.get("ComponentValue");
		EnvironmentKey = (String) falconpost.get("EnvironmentKey");
		EnvironmentValue = (String) falconpost.get("EnvironmentValue");
		TestPhaseKey = (String) falconpost.get("testphaseKey");
		TestPhaseValue = (String) falconpost.get("testphaseValue");
		TestRunatKey = (String) falconpost.get("testrunatkey");
		TestRunatValue = (String) falconpost.get("testrunatValue");
		DeviceKey = (String) falconpost.get("deviceKey");
		DeviceValue = (String) falconpost.get("deviceValue");
		FileName = (String) falconpost.get("fileName");
		LogManager.setLogLevel(LogLevel.INFO);
		builder = new RequestBuilder();
	}

    public static String getFormattedJson(String body) {
        return "</br><pre>" + toPrettyFormat(body) + "</pre>";
    }

    protected String getFormattedJson(JSONObject body) {
        return "</br><pre>" + toPrettyFormat(body.toString()) + "</pre>";
    }

    private static String toPrettyFormat(String jsonString) {
        try {
            Object json = mapper.readValue(jsonString, Object.class);
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            return prettyJson;
        } catch (Exception e) {
            return jsonString;
        }
    }
	
	@AfterSuite
	public void teardown() {
		CONFIG = null;
	}
}

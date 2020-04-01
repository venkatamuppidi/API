package atmecs.rest.falcon.testfunction;

/**
 *
 * SampleTestFunction class provides common functional requirements for the suite if any 
 */
import java.io.File;

public class PathLocator {
	
	private String userDirectoryPath = System.getProperty("user.dir");
	private String separator = File.separator;
	
	/**
	 * Purpose is to provide the path of the given file from src/main/resources package
	 * @param filename
	 * 			eg. SamplePropertires.properties
	 * @return
	 */
	public String getPathFromResource(String filename) {
		return userDirectoryPath+separator+"src"+separator+"main"+separator+"resources"+separator+filename;
	}

}

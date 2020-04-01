package atmecs.rest.falcon.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.testng.annotations.Test;
 
public class Java8Base64Image {
  
 @Test
  public static String encoder(String imagePath) {
    String base64url = "C://Users//venkata.muppidi//Pictures//jpg.png";
//    String imagePath = "C:\\base64\\image.jpg";
    //String base64ImageString = encoder(base64url);
    
//    decoder(base64ImageString, "C:\\base64\\decoderimage.jpg");
    File file = new File(base64url);
   
    String base64Image = null;
	try (FileInputStream imageInFile = new FileInputStream(file)) {
      // Reading a Image file from file system
      byte imageData[] = new byte[(int) file.length()];
      imageInFile.read(imageData);
      base64Image = Base64.getEncoder().encodeToString(imageData);
      String base64ImageString = encoder(base64url);
      System.out.println("Base64ImageString = " + base64ImageString);
    } catch (FileNotFoundException e) {
      System.out.println("Image not found" + e);
    } catch (IOException ioe) {
      System.out.println("Exception while reading the Image " + ioe);
    }
    return base64Image;
  }
}
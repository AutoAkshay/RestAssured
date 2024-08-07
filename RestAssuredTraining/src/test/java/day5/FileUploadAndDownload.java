package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.ResponseBody;

public class FileUploadAndDownload {
	
//	@Test(priority = 1)
	void singleFileUpload() {
		
		File myfile=new File("C:\\Users\\akshayak\\Desktop\\Resume.txt");
		given()
			.multiPart("file",myfile)
			.contentType("multipart/form-data")
		.when()
			.post("https://httpbin.org/post")
			
		.then().log().all().statusCode(200);
	}
	
//	@Test
	void MultiFileUpload() {

		File file=new File("C:\\Users\\akshayak\\Desktop\\Resume.txt");
		
		given()
			.multiPart("file",file)
		.when()
			.post("https://httpbin.org/post")
		.then().statusCode(200).log().all();
	}
	
	@Test
	void uploadImage() {

		File file=new File("C:\\Users\\akshayak\\Desktop\\report.jpg");
		
		given()
			.multiPart("file",file)
		.when()
			.post("https://petstore.swagger.io/v2/pet/1/uploadImage")
		.then().statusCode(200).log().all();
	}


}

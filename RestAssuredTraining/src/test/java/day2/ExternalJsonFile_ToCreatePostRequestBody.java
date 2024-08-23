package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

/*Post request body
 * 
1)using HashMap
2)using org.json
3)using pojo
4)using external json file
*/

public class ExternalJsonFile_ToCreatePostRequestBody {

//	@Test(priority = 1)
	void testPostUsingExternalJsonFile() throws FileNotFoundException {
		
		File f=new File(".\\body.json");
		FileReader fr=new FileReader(f);
		
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject data=new JSONObject(jt);


		given()
				.contentType("application/json")
				.body(data.toString())

		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("scott"))
			.body("location",equalTo("Zimbabwe"))
			.body("phone",equalTo("12345678"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
//			.header("Content-Type","application/json; charset=utf-16")
			.log().all();			
	}
	
	
	
	@Test(priority = 1)
	void testDelete() {
		
		given()
		
		.when()
			.delete("http://localhost:3000/students/3293")		
		.then()
			.statusCode(200);
	}

}

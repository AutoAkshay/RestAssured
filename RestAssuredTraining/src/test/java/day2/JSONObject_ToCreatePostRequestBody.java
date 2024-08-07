package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

/*Post request body
 * 
1)using HashMap
2)using org.json
3)using pojo
4)using external json file
*/

//json-server students.json
public class JSONObject_ToCreatePostRequestBody {

//	@Test(priority = 1)
	void testPostUsingJsonObject() {
		
		JSONObject data=new JSONObject();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "2334566567");

		String courseArr[] = { "C", "C++" };
		data.put("courses", courseArr);

		given()
				.contentType("application/json")
				.body(data.toString())

		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"))
			.body("phone",equalTo("2334566567"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
//			.header("Content-Type","application/json; charset=utf-16")
			.log().all();			
	}
	
	
	
	@Test(priority = 1)
	void testDelete() {
		
		given()
		
		.when()
			.delete("http://localhost:3000/students/b6b5")
		
		.then()
			.statusCode(200);
	}

}

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
class POJO_ToCreatePostRequestBody {
	
	String name;
	String location;
	String phone;
	String courses[];
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	
}
public class POJO_ToCreatePostRequestBody_Ext {

//	@Test(priority = 1)
	void testPostUsingPOJO() {
		
		POJO_ToCreatePostRequestBody data=new POJO_ToCreatePostRequestBody();
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("1234556");

		String courseArr[] = {"C", "C++" };
		data.setCourses(courseArr);

		given()
				.contentType("application/json")
				.body(data)

		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"))
			.body("phone",equalTo("1234556"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
//			.header("Content-Type","application/json; charset=utf-16")
			.log().all();			
	}
	
	
	
	@Test(priority = 1)
	void testDelete() {
		
		given()
		
		.when()
			.delete("http://localhost:3000/students/5fc3")		
		.then()
			.statusCode(200);
	}

}

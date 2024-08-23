package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

public class LoggingDemo {
	
	@Test
	void testLogs() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
//			.log().body()
			.log().cookies();
//			.log().headers();
//			.log().all();
	}

}

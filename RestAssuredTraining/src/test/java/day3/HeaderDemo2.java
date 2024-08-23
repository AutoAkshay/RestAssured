package day3;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

public class HeaderDemo2 {
	
//	@Test(priority = 1)
	void testHeaders() {
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			.log().all()
			.statusCode(200)
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip");
		
		
		
	}
	
	@Test(priority = 2)
	void headers() {
		Response res= given()
		
		.when()
			.get("https://www.google.com/");
		
		String reponse= res.header("Content-Type");
		
		System.out.println("Value of Headers:: "+ reponse);
		
	}
}

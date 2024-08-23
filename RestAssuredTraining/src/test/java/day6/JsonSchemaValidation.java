package day6;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	
	@Test
	void jsonSchemaValidation() {
		
		given()
		
		.when()
			.get("http://localhost:3000/store")
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("store.json"));
		
		System.out.println("Test case is passed");
	}
	
	
	//need xml file to validate
//	@Test
	void XMLSchemaValidation() {
		
		given()
		
		.when()
			.get("https://filesampleshub.com/format/code/xml")//proper URL to be given
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("sample1.sd"));
		
	}

}

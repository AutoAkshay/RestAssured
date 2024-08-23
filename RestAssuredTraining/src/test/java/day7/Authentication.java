package day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*
 * Basic
 * Digest
 * Preemptive
 * 
 * Bearer Token
 * OAuth 1.0
 * OAuth 2.0
 * API Key
 */

public class Authentication {
	
//	@Test
	void testbasicAuthentication() {
		
		
		given()
			.auth().basic("postman", "password")
		.when()
			.get("http://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
		
	}
	
//	@Test
	void testDigestAuthentication() {
		
		given()
		.auth().digest("postman", "password")
	.when()
		.get("http://postman-echo.com/basic-auth")
	.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
	
//	@Test
	void testPreemitiveAuthentication() {
		
		given()
		.auth().preemptive().basic("postman", "password")
	.when()
		.get("http://postman-echo.com/basic-auth")
	.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	//Bearer Token Authentication
	@Test
	void testBearerTokeAuthentication() {
		
		String bearerToken="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";
		given()
			.header("Authorization","Bearer "+ bearerToken)
		.when()
			.get("http://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	//OAuth1 Authentication 1.0
//	@Test
	void testOAuth1Authentication() {
		
		given()
			.auth().oauth("consumeKey", "consumerSecrat", "accessToken", "tokenSecrate")
		
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
	
	//OAuth1 Authentication 2.0
//	@Test
	void testOAuth2Authentication() {
			
		given()
			.auth().oauth2("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")
			
		.when()
				.get("http://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
			
			
	}
	
		// Two methods created for this
//	@Test
	void testAPIKeyAuthentication() {
			
			
		given()
			.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=matric&cnt=7")
		.then()
			.statusCode(200)
			.log().all();
			
	}
		
//	@Test
	void testAPIKeyAuthentication2() {
			
			
		given()
			.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
			.pathParam("mypath", "data/2.5/forecast/daily")
			.queryParam("q", "Delhi")
			.queryParam("units", "matric")
			.queryParam("cnt", "7")
		.when()
			.get("https://api.openweathermap.org/{mypath}")
			.then()
			.statusCode(200)
			.log().all();
			
	}

}

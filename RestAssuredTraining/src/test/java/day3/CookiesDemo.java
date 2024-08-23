package day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import java.util.Map;

public class CookiesDemo {
	
	@Test(priority = 1)
	void testCookies() {
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			.cookies("AEC", "AQTF6Hx8BCviKrFrcDugT53iz6nckfi25zPtwwxptQHAJw70RLIygPNs9g")
			.log().all();
		
	}
	
//	@Test(priority = 2)
	void getCookiesInfo() {
		
		Response res= given()
		
		.when()
			.get("https://www.google.com/");
		
		Map<String, String> cookies=res.getCookies();
		
		System.out.println(cookies);
		
		for(Map.Entry entry:cookies.entrySet()) {
			System.out.println(entry.getValue()+"::"+ entry.getKey());
		}
	}

}

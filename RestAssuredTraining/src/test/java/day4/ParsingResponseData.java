package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingResponseData {
	
	@Test
	void testJsonResponse() {
	
	/*	
		//Approach 1
		given()
			.contentType("contentType.JSON")
		.when()
			.get("http://localhost:3000/store")
		.then()
			.statusCode(200)
//			.headers("Content-Type","application/json; charset=utf-8")
			.body("book[3].title",equalTo("The Lord of the Rings"))
			.body("book[1].author",equalTo("Evelyn Waugh"));
	*/
		
		
	/*
		//Approach 2
		
		Response res= (Response) given()
			.contentType("contentType.JSON")
		.when()
			.get("http://localhost:3000/store");
			Assert.assertEquals(res.getStatusCode(), 200);
//			Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
			String bookname= res.jsonPath().get("book[3].title").toString();
			Assert.assertEquals(bookname,"The Lord of the Rings");
			
	*/
		
		//Approach 3
		Response res= (Response) given()
				.contentType(ContentType.JSON)
			.when()
				.get("http://localhost:3000/store");
		//using JSONObject class "Book Title ::"+
		JSONObject jo=new JSONObject(res.asString()); //converting response to json oject type
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) 
		{
			String booktitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(booktitle);
		}
		
		//to find specific title
		boolean status=false;
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) 
		{
			String booktitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(booktitle.equals("The Lord of the Rings")) 
			{
				status=true;
				break;
			}
		}
		
		Assert.assertEquals(status, true);
		
		//validate total price
		double totalPrice=0;
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) 
		{
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			System.out.println(price);
			totalPrice=totalPrice+Double.parseDouble(price);
			
		}
		
		System.out.println("price::"+totalPrice);
//		
		Assert.assertEquals(totalPrice, 526.0,"Price not matched");
		
	}

}

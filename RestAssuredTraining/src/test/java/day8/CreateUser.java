package day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;


public class CreateUser {

	@Test
	void test_CreateUser(ITestContext context) {
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		//GoRest.in Token
		String bearerToken="a872054262b8dcc9280736d976a73131e93e92670b49cbd10351342dbbb464b5";
		int id= given()
					.header("Authorization","Bearer "+ bearerToken)
					.contentType("application/json")
					.body(data.toString())
				.when()
					.post("https://gorest.co.in/public/v2/users")
					.jsonPath().getInt("id");
		
		System.out.println("Generted id is:"+id);//6854436
		context.setAttribute("userIid", id);
				
		
	}
}

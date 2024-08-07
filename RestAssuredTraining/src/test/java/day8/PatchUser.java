package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PatchUser {
	
	@Test
	void test_updateUser(ITestContext context)
	{
		int id=(Integer) context.getAttribute("userIid");
		
		Faker faker=new Faker();
		
		JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		//GoRest.in Token
		String bearerToken="a872054262b8dcc9280736d976a73131e93e92670b49cbd10351342dbbb464b5";
				given()
					.header("Authorization","Bearer "+ bearerToken)
					.contentType("application/json")
					.pathParam("id", id)
					.body(data.toString())
				.when()
					.put("https://gorest.co.in/public/v2/users/{id}")
					
				.then()
					.statusCode(200)
					.log().all();
				
		
	}

}

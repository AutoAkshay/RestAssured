package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class deleteUser {
	
	@Test
	void test_deletUser(ITestContext context) 
	{
		int id=(Integer) context.getAttribute("userIid");
		String bearerToken="a872054262b8dcc9280736d976a73131e93e92670b49cbd10351342dbbb464b5";
		given()
			.header("Authorization","Bearer "+ bearerToken)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(204)
			.log().all();
	}

}

package day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test
	void test_getUser(ITestContext context) {
		int id = (Integer) context.getAttribute("userIid");
		String bearerToken="a872054262b8dcc9280736d976a73131e93e92670b49cbd10351342dbbb464b5";
		given()
			.header("Authorization","Bearer "+ bearerToken)
			.pathParams("id" ,id)			
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}
}

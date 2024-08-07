package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {
	
	@Test
	void testXMLresponse() {
	
	/*
		//approach 1
		given()
			
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page", equalTo(1))
			.body("TravelerinformationResponse.travelers.page.Travelerinformation[0].name", equalTo("Vijay Bharath Reddy"));
	*/
		
		//approach 2
		
			Response res= given()
				
				.when()
					.get("http://restapi.adequateshop.com/api/Traveler?page=1");
				Assert.assertEquals(res.getStatusCode(), 200);
				Assert.assertEquals("Content-Type", "application/xml; charset=utf-8");
				
				String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
				Assert.assertEquals(pageNo, "1");
				
				String travelName=res.xmlPath().get("TravelerinformationResponse.travelers.page.Travelerinformation[0].name").toString();
				Assert.assertEquals(travelName, "Vijay Bharath Reddy");
				
	}
	
	@Test
	void testXMLresponseBody() {
		
			
				Response res= given()
					
					.when()
						.get("http://restapi.adequateshop.com/api/Traveler?page=1");
					XmlPath xmlObj=new XmlPath(res.asString());
					
					//verify traveler count
					List<String> travelers=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
					Assert.assertEquals(travelers.size(), 10);
					
					//verify traveler names
					List<String> travelersName=xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
					
					boolean status=false;
					for (String travelerName : travelersName) {
						
						System.out.println(travelerName);
						
						if(travelerName.equals("Vijay Bharath Reddy"))
						{
							status=true;
							break;
						}
					}
					
					Assert.assertEquals(status, true);					
		}

}

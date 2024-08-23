package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	

	@Test(priority =1, dataProvider ="Data",dataProviderClass = DataProviders.class)
	public void testPostuser(String userID,String UserName,String fname,String lname,String useremail,String pwd,String ph)
	{
		User usePayload=new User();
		
		usePayload.setId(Integer.parseInt(userID));
		usePayload.setUsername(UserName);
		usePayload.setFirstName(fname);
		usePayload.setLastName(lname);
		usePayload.setEmail(useremail);
		usePayload.setPassword(pwd);
		usePayload.setPhone(ph);
		
		Response response= UserEndPoints.createUser(usePayload);		
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(priority = 2,dataProvider = "userName", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) {
		
		Response response= UserEndPoints.deleteUser(userName);
		
		Assert.assertEquals(response.statusCode(), 200);
		
		System.out.println(response.statusCode());
	}
}

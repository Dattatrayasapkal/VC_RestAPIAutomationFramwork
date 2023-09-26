package Api.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import Api.endpoint.UserEndPoints;
import Api.payload.User;
import Api.utilities.DataProviders;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import Api.endpoint.UserEndPoints;
import Api.payload.User;
import io.restassured.response.Response;

public class UserTestDD {
	
public static Logger Logger;

	
	@Test(priority=1,dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd, String phone)
	{

		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(lname);
		userPayload.setPassword(email);
		userPayload.setPhone(phone);
		Response response = UserEndPoints.CreateUser(userPayload);
		
		Logger = LogManager.getLogger("RestAssuredAutomationFramework");
		
		
		//log response
		response.then().log().all();
		


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		
		Logger.info("Craete User Executed");
	}

	@Test(priority=3,dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username)
	{

		Response response = UserEndPoints.DeletUser(username);

		System.out.println("Delete User Data.");

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);
		Logger.info("Delet  User Executed");


	}

	@Test(priority=2,dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testGetUserData(String username)
	{

		Response response = UserEndPoints.GetUser(username);

		//System.out.println("Get User Data.");

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		Logger.info("Get  User data  Executed");
	}
}
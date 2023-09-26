package Api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import com.github.javafaker.Faker;

import Api.endpoint.UserEndPoints;
import Api.payload.User;
import io.restassured.response.Response;

public class UserTest {
Faker faker;
User userpayload ;
public static Logger Logger;

@BeforeClass
public void GenerateTestData() {
	
	faker= new Faker();
	userpayload = new User();
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().username());
	userpayload.setFirstName(faker.name().firstName());
	userpayload.setLastName(faker.name().lastName());
	userpayload.setEmail(faker.internet().emailAddress());
	userpayload.setPassword(faker.internet().password(5,10));
	userpayload.setPhone(faker.phoneNumber().cellPhone());
	
	Logger = LogManager.getLogger("RestAssuredAutomationFramework");
}

@Test(priority = 1)
public void testCreateUser() {
	Response response =UserEndPoints.CreateUser(userpayload);
	// log response
	response.then().log().all();
	//validation  status 
	Assert.assertEquals(response.getStatusCode(), 200);
	
	//log
	Logger.info("Creater User Executed");
}

@Test(priority = 2)
public void testGetUserData() {
	Response response =UserEndPoints.GetUser(this.userpayload.getUsername());
	System.out.println("Read User Data");
	// log response
	response.then().log().all();
	//validation  status 
	Assert.assertEquals(response.getStatusCode(), 200);
		
	Logger.info("Get User data Executed");
}
@Test(priority = 3)
public void testUpdateUser() {
	
	userpayload.setFirstName(faker.name().firstName());

	Response response =UserEndPoints.UpdateUser (this.userpayload.getUsername(), userpayload);
	// log response
	response.then().log().all();
	//validation  status 
	Assert.assertEquals(response.getStatusCode(), 200);
		//read user data to check if first name is updated
	
	Response responsePostUpdate =UserEndPoints.UpdateUser (this.userpayload.getUsername(), userpayload);
	System.out.println(" After Update user Data");

	responsePostUpdate.then().log().all();
	
	Logger.info("Update User Executed");

}
@Test(priority = 4)
public void testDeletUser() {
	

	Response response =UserEndPoints.DeletUser (this.userpayload.getUsername());
	System.out.println("Delete  User Data");
	// log response
	response.then().log().all();
	//validation  status 
	Assert.assertEquals(response.getStatusCode(), 200);
	
	Logger.info("Delet  User  Executed");

		
}
}

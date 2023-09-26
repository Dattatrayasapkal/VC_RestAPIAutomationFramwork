package Api.endpoint;

import Api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UserEndPoints {

	public static  Response CreateUser(User payload) {
		Response response = given().accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.Post_Url);
		return response;
	}
	
	
	public static  Response GetUser(String userName) {
		Response response = given().accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(Routes.Get_Url);
		return response;
	}
	
	public static  Response UpdateUser(String userName,User payload) {
		Response response = given().accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.put(Routes.Put_Url);
		return response;
	}
	
	public static  Response DeletUser(String userName) {
		        Response response = given()
				.accept(ContentType.JSON)
	            .pathParam("username", userName)
		
		         .when()
	             .delete(Routes.Delet_Url);
		         return response;
	}
}

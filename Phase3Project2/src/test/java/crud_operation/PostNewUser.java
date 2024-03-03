package crud_operation;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostNewUser {

	
	@Test
	public void test1() {
		
		HashMap<String,String> obj = new HashMap<String,String>();
		
		obj.put("name", "morpheus");
		obj.put("job", "leader");
	
			
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(obj)
									.post();
		
		System.out.println("The response code is " + response.getStatusCode());
		
		System.out.println("The response body is " + response.body().asString());
		
	}
		

}
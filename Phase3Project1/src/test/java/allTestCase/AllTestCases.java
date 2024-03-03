package allTestCase;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllTestCases {
	 
	
	@Test  //Test 1 :  01_GetAllEmployee()
	public void GetAllEmployee() {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification  request = RestAssured.given();
		Response response = request.get();
		
		String responseBody = response.body().asString();
		
		System.out.println(responseBody);

		System.out.println("Response code is " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);

}
	
	@Test //02_GetSingleEmployee()
	public void GetSingleEmployee() {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.get("/employee/1");
		
		System.out.println("The Response body is " + response.body().asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String ResponseBody = response.body().asString();
		Assert.assertTrue(ResponseBody.contains("Tiger Nixon"));
		
		
	}

	@Test //03_CreateEmployee()
	public void CreateEmployee() {
		
		HashMap<String,String> obj = new HashMap<String,String>();
		
		obj.put("name", "Rakesh");
		obj.put("salary", "123");
		obj.put("age", "24");
		
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(obj)
									.post("/create");
		
		System.out.println("The response code is " + response.getStatusCode());
		
		System.out.println("The response body is " + response.body().asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	@Test //04_DeleteEmployee()
	public void DeleteEmployee() {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.delete("delete/25");
		
		System.out.println("The Response body is " + response.body().asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test  //05_TestDeletedEmployee()
	public void TestDeletedEmployee() {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.get("/employee/25");
		
		System.out.println("The Response body is " + response.body().asString());
		
		Assert.assertEquals(response.getStatusCode(), 404);
	
	}
	
}	

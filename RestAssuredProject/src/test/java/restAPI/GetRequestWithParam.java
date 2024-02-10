package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParam {
	
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.get("/1");
		
		System.out.println("The Response body is " + response.body().asString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String ResponseBody = response.body().asString();
		Assert.assertTrue(ResponseBody.contains("Pankaj"));
		
		JsonPath json = response.jsonPath();
		
		String actName = json.get("name");
		String expName = "Pankaj";
		Assert.assertEquals(actName, expName);
		
	}

}




package allTestCase;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AllTestCaseBDD {
		
		String BaseURI = "https://dummy.restapiexample.com/api/v1";
		
		@Test //01_GetAllEmployee()
		public void GetAllEmployee() {
			
			RestAssured.given()
						.baseUri(BaseURI)
						.when()
						.get("/employees")
						.then()
						.log()
						.body()
						.statusCode(200);
			
		}
		

		@Test //02_GetSingleEmployee()
		public void GetSingleEmployee() {
			
			RestAssured.given()
						.baseUri(BaseURI)
						.when()
						.get("/employee/1")
						.then()
						.log()
						.body()
						.statusCode(200)
						.body("employee_name", Matchers.equalTo("Tiger Nixon"));
						
			
		}
		
		@Test //03_CreateEmployee()
		public void CreateEmployeeWithHashMap1() {
			
			HashMap<String,String> obj = new HashMap<String,String>();
			
			obj.put("name", "Rakesh");
			obj.put("salary", "123");
			obj.put("age", "23");
			
		
			Response response= RestAssured.given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(obj)
						.baseUri(BaseURI)
						.when()
						.post("/create");
			
			System.out.println("The response code is " + response.getStatusCode());
			
			System.out.println("The response body is " + response.body().asString());
			
		}
				
						/*.then()
						.log()
						.body()
						.statusCode(200)
			            .body("status", Matchers.equalTo("success"));
		}*/
		
		
			
		@Test //04_DeleteEmployee()
		public void DeleteEmployee() {
			
			 /*JSONObject jsonObject = new JSONObject(response.getBody().asString());
			 String accessToken = jsonObject.get("data.ID").toString();*/
			
			RestAssured.given()
						.baseUri(BaseURI)
						.when()
						.delete("/employee/25")
						.then()
						.log()
						.headers()
						.statusCode(200)
			            .body("message", Matchers.equalTo("Successfully! Record has been deleted"));			
			
		}
		
		
		@Test //05_TestDeletedEmployee()
		public void TestDeletedEmployee() {
			
			RestAssured.given()
						.baseUri(BaseURI)
						.when()
						.get("/employee/25")
						.then()
						.log()
						.body()
			            .body("status", Matchers.equalTo("success"));
			
		}
		
		
}

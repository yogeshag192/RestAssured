package RestAssured.RestAssured;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class RestTest {
	
	@Test
	public void checkStatus200() {
	        
	  
	given().get("http://services.groupkt.com/country/get/iso2code/IN").then().statusCode(200).log().all();
	   
	   
	   /*     assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));*/
	}
	
	@Test
	public void test2(){
		RequestSpecification req = RestAssured.given();
		req.header("content-type", "application/json");
		JSONObject json = new JSONObject();
		json.put("userID", "11");
		json.put("id", "102");
		json.put("title", "yogesh");
		json.put("body", "test api2");
		
		req.body(json.toJSONString());
		
		Response resp = req.post("https://jsonplaceholder.typicode.com/posts/");
		System.out.println("Post Response");
		System.out.println(resp.asString());
		int statusCode = resp.getStatusCode();
		System.out.println("StatusCode: " +statusCode);
		Assert.assertEquals(statusCode, 202);
		
		
	}
	
	
}

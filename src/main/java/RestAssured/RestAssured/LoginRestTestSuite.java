package RestAssured.RestAssured;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class LoginRestTestSuite {
	
	@Test
	public void PostRequestValidLogin(){
		RequestSpecification req = RestAssured.given();
		req.header("content-type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "ram");
		json.put("password", "R@111");
		req.body(json.toJSONString());
		
		Response resp = req.post("http://10.117.189.16:8080/loan_app/loanservice/login");
		System.out.println("\nPost Response Valid Login: ");
		System.out.println(resp.asString());
		int statusCode = resp.getStatusCode();
		System.out.println("StatusCode: " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	@Test
	public void PostRequestInValidLogin(){
		RequestSpecification req = RestAssured.given();
		req.header("content-type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "invaliduser");
		json.put("password", "xyz");
		req.body(json.toJSONString());
		
		Response resp = req.post("http://10.117.189.16:8080/loan_app/loanservice/login");
		System.out.println("\nPost Response InValid Login: ");
		System.out.println(resp.asString());
		int statusCode = resp.getStatusCode();
		System.out.println("StatusCode: " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	/*@Test
	public void putRequest(){
		RequestSpecification req = RestAssured.given();
		req.header("content-type", "application/json");
		JSONObject json = new JSONObject();
		json.put("userID", "5");
		json.put("id", "999");
		json.put("title", "yogesh");
		json.put("body", "test api2");
		
		req.body(json.toJSONString());
		
		Response resp = req.put("https://jsonplaceholder.typicode.com/posts/50");
		System.out.println("put Response");
		System.out.println(resp.asString());
		int statusCode = resp.getStatusCode();
		System.out.println("StatusCode: " +statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	
	@Test
	public void deleteRequest(){
	
			RequestSpecification req = RestAssured.given();
			
			Response resp = req.delete("https://jsonplaceholder.typicode.com/posts/102");
			System.out.println("delete Response");
			System.out.println(resp.asString());
			int statusCode = resp.getStatusCode();
			System.out.println("StatusCode: " +statusCode);
			Assert.assertEquals(statusCode, 200);
			
			
		}*/
		
	
	
	
}

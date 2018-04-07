package RestAssured.RestAssured;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class ApproveRejectLoanRestTestSuite {
	
	@Test
	public void PostRequestApproveLoans(){
		RequestSpecification req = RestAssured.given();
		req.header("content-type", "application/json");
		JSONObject json = new JSONObject();
		json.put("username", "ram");
		json.put("action", "APPROVED");
		req.body(json.toJSONString());
		
		Response resp = req.post("http://10.117.189.16:8080/loan_app/loanservice/loandecision");
		if(resp.asString().isEmpty()){
			System.out.println("Request Processed with No Response from API.");
		}
		else{
			System.out.println("\nPost Response : ");
			System.out.println(resp.asString());
		}
		
		
		int statusCode = resp.getStatusCode();
		System.out.println("\nStatusCode: " +statusCode);
		Assert.assertEquals(statusCode, 204);
		
		System.out.println("Assertion passed!");
		
		}
	
		
}

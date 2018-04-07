package RestAssured.RestAssured;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class EMIRestTestSuite {
	
	@Test
	public void checkStatus200() {
	        
	given().get("http://10.117.189.16:8080/loan_app/loanservice/emi/1000/10").then().statusCode(200).log().all();
	
	}
	
	@Test
	public void calculateEMI(){
		RequestSpecification req = RestAssured.given();
		
		int amount = 200000;
		int tenure = 20;
		System.out.println("\nCalculating EMI for Amount: " +amount+ " and tenure " +tenure +" years");
		Response resp = req.get("http://10.117.189.16:8080/loan_app/loanservice/emi/"+amount+"/"+tenure);
		System.out.println("EMI Response: " +resp.asString());
		int statusCode = resp.getStatusCode();
		System.out.println("StatusCode: " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		}		
	
	
	
}

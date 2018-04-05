package RestAssured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class RestTest {
	
	
	public static void main(String args[]) {
	        
	  given().when().get("https://jsonplaceholder.typicode.com/posts/1");
	   
	   
	   /*     assertThat().
	        body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));*/
	}
	
	
}

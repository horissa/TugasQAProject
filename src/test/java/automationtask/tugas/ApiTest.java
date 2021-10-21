package automationtask.tugas;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class ApiTest extends BaseAPI {
	
	@Test
	public void signUp() {
		Faker faker = new Faker();
		String email = faker.name().username()+"@gmail.com";
		String firtsName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String password = "builder123";
		String phoneNumber = faker.phoneNumber().phoneNumber();
		
		String payload = "{\r\n" + 
				"    \"user\": {\r\n" + 
				"        \"first_name\":\""+firtsName+"\",\r\n" + 
				"        \"last_name\":\""+lastName+"\",\r\n" + 
				"        \"email\":\""+email+"\",\r\n" + 
				"        \"password\":\""+password+"\",\r\n" + 
				"        \"phone_number\":\""+phoneNumber+"\"\r\n" + 
				"    }\r\n" + 
				"}";
		System.out.println(payload);
		Response response = given().spec(commonJsonSpec).body(payload).when().post("/users");
		APIUtils.verifyStatusCode(response);
	}
}

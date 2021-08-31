package api.utils;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Employees;

public class RestUtils {
	
	public void getAllEmployees() {
		Response response = given().contentType(ContentType.JSON).get("https://reqres.in/api/users");
		String[] lojson = response.asString().split("data\":");
		String[] myJson = lojson[1].split(",\"support");
		Gson gson = new Gson();
		Type employeeType = new TypeToken<List<Employees>>(){}.getType();
		List<Employees> emp = gson.fromJson(myJson[0], employeeType);
		for(Employees e : emp) {
			System.out.println("Username: "+e.getEfname()+" "+e.getElname());
			System.out.println("Avatar: "+e.getEavatar());
        	System.out.println("------------------------------------------");
		}
	}
	
	public void getEmployeeInformation(String id) {
		String response = given().when().get("https://reqres.in/api/users/"+id+"").then().extract().body().asString();
		String email = from(response).get("data.email");
		System.out.println("Response: "+response);
		System.out.println("The employee's email is: "+email);
		
		
	}
}

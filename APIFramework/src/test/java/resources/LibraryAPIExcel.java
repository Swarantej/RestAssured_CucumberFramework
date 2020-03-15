package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;



import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

@Test
public class LibraryAPIExcel {
	

	
	public void addBook() throws IOException {
		
		ExcelData data = new ExcelData();
		ArrayList testData = data.getData("testdata", "RestAddBook");
		
		
		HashMap<String,Object> map = new HashMap<String, Object>();
		map.put("name", testData.get(1));
		map.put("isbn", testData.get(2));
		map.put("aisle", testData.get(3));
		map.put("author", testData.get(4));
		RestAssured.baseURI="http://216.10.245.166";
		Response res = given().
			header("Content-Type","application/json")
			.body(map)
		.when().
		post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response();
		
	
		String jsonResponse = res.asString();
		JsonPath json = new JsonPath(jsonResponse);
		String ID = json.get("ID"); 
		
		System.out.println(ID);
		
		/*
		 * JsonPath json = ReusableMethods.rawJSONConversion(res); String bookID =
		 * json.get("ID"); System.out.println(bookID); System.out.println(res);
		 */
	}

}

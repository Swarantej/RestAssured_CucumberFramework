package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	//Declareing varibale as null because it should not return null values, it should hold existing value
	public static RequestSpecification request;
	public RequestSpecification reqSpec() throws IOException {
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		//Building Request Spec Builder
		
		//Here we're using this condtion to append the data to the existing log file only not to override it
		if(request==null) {
		PrintStream logDetails = new PrintStream(new FileOutputStream("logFile.txt"));
		 request = new RequestSpecBuilder().setBaseUri(globalData("baseUrl"))
				 	.addFilter(RequestLoggingFilter.logRequestTo(logDetails))
				 	.addFilter(ResponseLoggingFilter.logResponseTo(logDetails))
				 	.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		 
		 return request;
		}
		return request;
	}
	
	public static String globalData(String URL) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Swaran\\apitesting\\APIFramework\\src\\test\\java\\resources\\globalData.properties");
		prop.load(fis);
		return prop.getProperty(URL);
	}
	
	//Creating reusable fucnction to get the responses for the fields
	
	public String getJsonResponse(Response response, String key ) {
		String status = response.asString();
		JsonPath statusDesc = new JsonPath(status);
		return statusDesc.get(key).toString();
	}

}

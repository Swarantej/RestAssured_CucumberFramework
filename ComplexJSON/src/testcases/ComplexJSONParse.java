package testcases;

import io.restassured.path.json.JsonPath;
import reusable.Payload;

/**
 * TestCase
 * 1. Print No of courses returned by API
   2.Print Purchase Amount
   3. Print Title of the first course
   4. Print All course titles and their respective Prices
   5. Print no of copies sold by RPA Course
   6. Verify if Sum of all Course prices matches with Purchase Amount
 * @author Swaran
 *
 */

public class ComplexJSONParse {
	
	public static void main(String[] args) {
		JsonPath js = new JsonPath(Payload.payload());
		//1. Print No of courses returned by API
		int numOfCourses = js.getInt("courses.size()");
		System.out.println("Total Num of Courses "+numOfCourses);
		
		//2.Print Purchase Amount
		
		int totalPurchaseAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Total purchase amount "+totalPurchaseAmount);
		
		//3.Print Title of the first course
		
		String courseTitle = js.get("courses[0].title");
		System.out.println("Course Title "+courseTitle);
		
		//4.Print All course titles and their respective Prices
		int allPrice = 0;
		int purchaseAmt = 0;
		int totalPurchaseAmt=0;
		for(int i =0; i<numOfCourses; i++) {
			String courseTitles= js.get("courses["+i+"].title");
			int coursePrices= js.getInt("courses["+i+"].price");
			System.out.println("Course price for  "+courseTitles+" is "+coursePrices);
			//5.Print no of copies sold by RPA Course
			if(courseTitles.equalsIgnoreCase("RPA")) {
				int numOfCopies = js.getInt("courses["+i+"].copies");
				System.out.println("Num of Copies sold by RPA is "+numOfCopies);
			}
			
			allPrice += coursePrices; 
			System.out.println("Sum of all prices of all courses "+allPrice);
		}
		
		// Total Purchase amount validation
		for(int i =0; i<numOfCourses; i++) {
			String courseTitles= js.get("courses["+i+"].title");
			int coursePrices= js.getInt("courses["+i+"].price");
			int numOfCopies = js.getInt("courses["+i+"].copies");
			purchaseAmt = coursePrices*numOfCopies;
			totalPurchaseAmt+=purchaseAmt;
			
		}
		
		System.out.println("Sum of all prices of all purchased courses "+totalPurchaseAmt);
		
		
	}
	

	

}

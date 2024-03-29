package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.SerializePostGoogleAddPlace;

public class TestData {
	
	public SerializePostGoogleAddPlace addPayLoad(String name,String language,String address) {
		SerializePostGoogleAddPlace postDetails = new SerializePostGoogleAddPlace();
		postDetails.setAccuracy(50);
		postDetails.setAddress(address);
		postDetails.setLanguage(language);
		postDetails.setPhone_number("(+91) 983 893 3937");
		postDetails.setWebsite("https://rahulshettyacademy.com");
		postDetails.setName(name);
		
		//Since the type is LIST so we create a List object and add the details to the list obj and pass the same to SET obj
		
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		postDetails.setTypes(myList);
		
		//Since the location is nested JSON so we created another class, so set the values to the obj of that class
		
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		postDetails.setLocation(loc);
		return postDetails;
	}
	
	public String deletePayLoad(String placeID) {
		//return "{\"+\"\\\"place_id\\\":\\\"\"+placeID+\"\\\"\"+\"}";
		
		return "{\r\n    \"place_id\":\""+placeID+"\"\r\n}";
	}

}

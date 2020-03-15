package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable {
		StepDefinition sd = new StepDefinition();
		if(StepDefinition.place_id==null) {
			sd.add_Place_payload_with("Vuppu", "German", "Berlin");
			sd.user_calls_with_http_request("AddPlaceAPI", "post");
			sd.verify_the_placeId_created_with_using("Vuppu", "getPlaceAPI");
			
		}
		
		
	}
}

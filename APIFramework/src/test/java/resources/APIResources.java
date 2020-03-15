package resources;

public enum APIResources {
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	//Creating constructore to invole method
	//declaring the resource globally
	private String resource;
	
	APIResources(String resource ){
		this.resource=resource;
	}
	
	//We need to return the resource from here and use in Step definition
	
	public String getResource() {
		return resource;
	}
}

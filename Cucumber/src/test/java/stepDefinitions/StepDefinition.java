package stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

public class StepDefinition {

	
	
	@Given("^I login to the page with id \"([^\"]*)\" and pwd \"([^\"]*)\"$")
    public void i_login_to_the_page_with_id_something_and_pwd_something(String strArg1, String strArg2) throws Throwable {
		System.out.println("Login Step"); 
		System.out.println(strArg1);
		System.out.println(strArg2);
    }

	
	 /* @Given("^I login to the page$") 
	  public void I_login_to_the_page() throws Throwable {
		  //Write Code here 
		  
		  }
		 */
	  
	  
	  @When("^I'm navigated to the landing page$") 
	  public void im_navigated_to_the_landing_page() throws Throwable {
		  //Write Code here
	  System.out.println("Landing step step"); }
	  
	  @Then("^I validate the my account details$") 
	  public void i_validate_the_my_account_details() throws Throwable { 
		  //Write Code here
	  System.out.println("Account details step"); }
	  
	  @And("^I see the balance$") public void i_see_the_balance() throws Throwable
	  {
		  //Write Code here 
		  System.out.println("Balance step"); 
		  }
	 
}
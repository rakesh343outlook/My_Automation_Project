package stepDefs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;


public class BuyProductStepDefs {
	
	WebDriver driver = BaseClass.driver;

	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.get("https://www.pizzahut.co.in/");
	}
   
    @When("I enter the location as {string}")
	public void i_enter_the_location_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Location = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
		Location.sendKeys("Pune");
	   
	}

	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_the_list() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement Place = driver.findElement(By.xpath("//*[contains(text(),'Pune Railway Station')]"));
		Place.click();
		Thread.sleep(5000);
	   
	} 

	@Then("I select the View tab")
	public void i_select_the_View_tab() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement ViewDeal = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[5]/div[2]/a/div/span/span"));
		ViewDeal.click();
	}
	
	@Then("I should land on the Deals page")
	public void i_should_land_on_the_Deals_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Deals = driver.findElement(By.xpath("//a[@data-synth='link--deals--side']//span[text()='Deals']"));
		Assert.assertTrue(Deals.isDisplayed());
	}

	@Then("I select the tab as {string}")
	public void i_select_the_tab_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Pizzas = driver.findElement(By.xpath("//a[@data-synth='link--pizzas--side']//span[text()='Pizzas']"));
		Pizzas.click();
	}

	@Then("I select the pizza as {string}")
	public void i_select_the_pizza_as(String myPizza) {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement MyPizza = driver.findElement(By.xpath("//div[text()='"+ myPizza + "']//following::span[text()='Add'][1]"));
		MyPizza.click();
	  
	}

	@Then("I should see the pizza is added to the cart")
	public void i_should_see_the_pizza_is_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement BaseketItem = driver.findElement(By.xpath("//div[@data-testid='basket-item-product']//div[contains(text(),'Personal Schezwan Margherita')]"));
		Assert.assertTrue(BaseketItem.isDisplayed());
	}

	@Then("I click on the Checkout button")
	public void i_click_on_the_Checkout_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Checkout = driver.findElement(By.xpath("//div[@class='basket-checkout']//a"));
		Checkout.click();
	  
	}


	@Then("I should be landed on the secured checkout page")
	public void i_should_be_landed_on_the_secured_checkout_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Secure = driver.findElement(By.xpath("//span[text()='Secure Checkout']"));
		Assert.assertTrue(Secure.isDisplayed());  
	}

	/*
	@And("I enter the personal details")
	public void i_enter_the_personal_details(DataTable persdetails) {

		for(int i=0;i<persdetails.height();i++)
		{
			//dynamic element finding and input
			WebElement PersDetail1 = driver.findElement(By.name(persdetails.cell(i,0)));
			PersDetail1.sendKeys(persdetails.cell(i,1));
		}	
			
		}	
	*/
	
	@Then("I enter the personal details")
	public void i_enter_the_personal_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Name = driver.findElement(By.xpath("//*[@id=\"checkout__name\"]"));
		Name.sendKeys("Rajesh Sharma");
		
		WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"checkout__phone\"]"));
		Mobile.sendKeys("8888888888");
		
		WebElement Email = driver.findElement(By.xpath("//*[@id=\"checkout__email\"]"));
		Email.sendKeys("abc@xyz.com");
	}



	@Then("I enter the address details")
	public void i_enter_the_address_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Address = driver.findElement(By.xpath("//*[@id=\"checkout__deliveryAddress.interior\"]"));
		Address.sendKeys("123 Main Street, Some Landmark"); 
	}
 

	@Then("I should see three payment options")
	public void i_should_see_three_payment_options(List<String> PaymentOptions) {
		
		for(String value:PaymentOptions) 
		{
			//dynamic element find and check whether present or not
			WebElement PaymentOption = driver.findElement(By.xpath("//span[text()='"+value+"']"));
			PaymentOption.isDisplayed();	
		}	
		
	}

	@But("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String PaymentCash) {
	    
		WebElement CashpaymentOption = driver.findElement(By.xpath("//span[text()='Cash']/preceding::i[2]"));
		CashpaymentOption.click();
	
	}
	/*@Then("I select the payment option as {string}")
	public void i_select_the_payment_option_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement PlaceOrder = driver.findElement(By.xpath("//*[@id=\"submit-checkout\"]/span/span[1]"));
		PlaceOrder.click();
	}
 */
	
		
	}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	
	//=================================== Locators =============================
	
	@FindBy(linkText="Log in")
	WebElement loginLink;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="remember-me")
	WebElement rememberMe;
	
	@FindBy(name="btn_login")
	WebElement LoginBtn;
	
	
	// ================================== Functions ==============================
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void LoginFunction(String UserNameVal,String PwdVal) {
		
		// click on the login link
		loginLink.click();
		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PwdVal);
		rememberMe.click();
		LoginBtn.click();



/*
public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
			
	}
	
	public void LoginFunction(String UserNameVal,String PwdVal) {
	
	// click on the login link
			WebElement loginLink = driver.findElement(By.linkText("Log in"));
			loginLink.click();

			WebElement UserName = driver.findElement(By.name("user_login"));
			UserName.sendKeys("abc@xyz.com");

			WebElement Password = driver.findElement(By.id("password"));
			Password.sendKeys("Abc@12345");

			WebElement rememberMe = driver.findElement(By.id("remember-me"));
			rememberMe.click();

			WebElement LoginBtn = driver.findElement(By.name("btn_login"));
			LoginBtn.click();
			
			WebElement errorMessage = driver.findElement(By.className("error_msg"));
			System.out.println("The error message is " + errorMessage.getText());
			
			String actMsg = errorMessage.getText();
			String expMsg = "The email or password you have entered is invalid.";
			Assert.assertEquals(actMsg,expMsg);

	List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("total num of links are " + links.size());
*/


}
}

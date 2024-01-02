package UItest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FbSignUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com//");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement NewAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		NewAccount.click();
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		FirstName.sendKeys("Rahul");
		
		WebElement LastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		LastName.sendKeys("Roy");
		
		WebElement Email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		Email.sendKeys("abc@xyz.com");
		
		WebElement ReEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		ReEmail.sendKeys("abc@xyz.com");
		
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		Password.sendKeys("Abc@12345");
		
			
		WebElement Day = driver.findElement(By.id("day"));
		Select ddDay = new Select(Day);
		ddDay.selectByValue("10");
		
		WebElement Month = driver.findElement(By.id("month"));
		Select ddMonth = new Select(Month);
		//ddMonth.selectByValue("1");
		ddMonth.selectByVisibleText("Jan");

		WebElement Year = driver.findElement(By.id("year"));
		Select ddYear = new Select(Year);
		ddYear.selectByValue("2005");

		WebElement Gender = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		Gender.click();
	
		List<WebElement> Months = driver.findElements(By.xpath("//select[@id='month']/option"));
		for(WebElement mon: Months) {
			
			System.out.println("Month is " + mon.getText());
		}

		List<WebElement> Years = driver.findElements(By.xpath("//select[@id='year']/option"));
		for(WebElement yer: Years) {
			
			System.out.println("Year is " + yer.getText());
		}

driver.close();
		

	}

}
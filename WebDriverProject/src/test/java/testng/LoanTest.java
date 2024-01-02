package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoanTest extends BaseClass {
	
	
	
	@Test(groups= {"sanity"})
	public void TC01_HomeLoanTest() {
		
		System.out.println("Inside HomeLoan");
	}
	
	//@Test(enabled=false) if don't want to run this perticular test
	
	@Test
	public void TC02_CarLoanTest() {
		
		System.out.println("Inside CarLoan");
	}
	
	@Test(groups= {"sanity"})
	public void TC00_PersonalLoanTest() {
		
		System.out.println("Inside PersonalLoan");
	}

}
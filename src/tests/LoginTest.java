package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest {
	LoginPage lp = new LoginPage();
	
	String EmailSpecChar = "abc*&";
	String WrongPass = "wrongPass";
	String EmailNoSPecChar = "abc";
	String SpecCharErr = "Please enter a username or card number without special characters.";
	String EmptyEmailErr = "Please enter your username or card number.";
	String EmptyPassErr = "Please enter your password.";
	
	
  @Test(priority=1)
  public void loginWithSpecialCharacters() throws InterruptedException {
	  	lp.login(EmailSpecChar,WrongPass);

		Thread.sleep(1000);
		
		String ExpextedErr = 	SpecCharErr;
		String ActualErr = lp.readEmailErr();

		Assert.assertEquals(ExpextedErr, ActualErr);

  }
  
	
  @Test(priority=2)
  public void loginWithEmptyUserTest() throws InterruptedException {
	  	
		lp.login("",WrongPass);
		

		Thread.sleep(1000);
		
		String ExpextedErr =EmptyEmailErr;
	
		String ActualErr = lp.readEmailErr();
		System.out.println(ActualErr);

		Assert.assertEquals(ExpextedErr, ActualErr);
	
  }
  
  @Test(priority=3)
  public void loginWithEmptyPassTest() throws InterruptedException {
		lp.login("email","");
	
		Thread.sleep(1000);
		
		String ExpextedErr = EmptyPassErr;
	
		String ActualErr = lp.readPassErr();
		System.out.println(ActualErr);
	
		Assert.assertEquals(ExpextedErr, ActualErr);

  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
		  lp.openBrowser();
		  lp.openLoginPage();
  }
  

  @AfterMethod
  public void afterMethod() {
	  
	  	lp.closeBrowser();
  }

}

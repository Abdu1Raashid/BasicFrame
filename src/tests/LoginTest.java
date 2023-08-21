package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import utilities.Xls_Reader;

public class LoginTest {

	
	Xls_Reader d = new Xls_Reader("/Users/raashidshaikh/Desktop/QA/SeleniumWorkSpace/BasicFrameWork/ValueKeeper.xlsx");
    
	
	LoginPage lp = new LoginPage();
	
	
	
	DataFile df = new DataFile();
	
  @Test(priority=1)
  public void loginWithSpecialCharacters() throws InterruptedException {
	  	lp.login(df.EmailSpecChar,df.WrongPass);

		Assert.assertEquals(lp.readEmailErr(), df.SpecCharErr);

  }
  
	
  @Test(priority=2)
  public void loginWithEmptyUserTest() throws InterruptedException {
	  	
		lp.login("",df.WrongPass);

		Assert.assertEquals(lp.readEmailErr(), df.EmptyEmailErr);
	
  }
  
  @Test(priority=3)
  public void loginWithEmptyPassTest() throws InterruptedException {
		lp.login("email","");
	
	
		Assert.assertEquals(lp.readPassErr(), df.EmptyPassErr);

  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
		  lp.openBrowser();
		  lp.openLoginPage();
  }
  

  @AfterMethod
  public void afterMethod() {
	  
	  	lp.closeBrowser();
  }

}

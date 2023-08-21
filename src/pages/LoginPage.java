package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	/*
	WebElement email = driver.findElement(By.id("usernameInput-input"));
	WebElement pass = driver.findElement(By.id("password-input"));
	WebElement SignIn = driver.findElement(By.id("signIn"));
	WebElement EmailErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	WebElement PassErr = driver.findElement(By.id("PasswordTextField__errors-password"));*/
	
	@FindBy(id="usernameInput-input")
	public WebElement email;
	
	@FindBy(id="password-input")
	public WebElement pass;
	
	@FindBy(id="signIn")
	public WebElement SignIn;
	
	@FindBy(id="UsernameTextField__errors-usernameInput")
	public WebElement EmailErr;
	
	@FindBy(id="PasswordTextField__errors-password")
	public WebElement PassErr;
	
	
	
	public void openBrowser() throws IOException {
		FileInputStream file = new FileInputStream("/Users/raashidshaikh/Desktop/QA/SeleniumWorkSpace/BasicFrameWork/src/prop.properties");
		
		Properties prop = new Properties();
		
		prop.load(file);
		
		String browser = prop.getProperty("Browser");
		
		if(browser.equals("Chrome")) {
			
			driver = new ChromeDriver();
			
		}
		
		else if(browser.equals("Firefox")){
			driver = new FirefoxDriver();
			
		}
		
		else {
			System.out.println("Please input the driver");
		}
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	public void openLoginPage() {
		
		 driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=SWx1pvYyB7s&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5nb29nbGUuY29tXC8iLCJvYXV0aF9rZXkiOiJTV3gxcHZZeUI3cyIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjg3NzEwNzI2LCJpYXQiOjE2ODc3MDk1MjYsImp0aSI6IjU1NmQ1NTBhLTA3MzMtNGQ2NS05MmVmLTYyMmM0ZDE2ZWFjMyIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.dzEMlsfcWMLQxFaGsDJqhaaw5m5mNVZRWblwwVt3-KCmRmmxN9BVpRj8MYIZzZ9dcJ8KqIkjy14N4O3KRi5HDTlaD5wQjcgYXc06XO3fsBudEwHl6STQ49CS8KP7S-8dh7HbuAQzDIXBtA0yGEVxL9MNTc0Kg1yaQLl7Al4XkQreqiLBxp_uP9470ZQpENbgn2jU87YyXXDbfMyBVmoO4dQL0vQJvjBddr5lduK1xswFDyp4oUJA3Rmhd4n_G7xYGAXdgaBybeBWp98rpjR_v6sKkaKEcDzaUYO5xCyp1D6NFqrtMxPYhYTs0Aqeq8ZLaNH6VGMcnVD58gKjyQmi5g&preferred_environment=");

	}
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		pass.sendKeys(b);
		SignIn.click();
		Thread.sleep(1000);
	}
	
	public String readEmailErr() {
				String ActualErr = EmailErr.getText();
				return ActualErr;
		
	}
	
	public String readPassErr() {
		String ActualErr = PassErr.getText();
		return ActualErr;
		
	}
}

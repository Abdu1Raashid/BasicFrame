package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

	
	WebDriver driver;
	
	public void openBrowser() {
		driver = new FirefoxDriver();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	
	public void openLoginPage() {
		
		 driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=SWx1pvYyB7s&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5nb29nbGUuY29tXC8iLCJvYXV0aF9rZXkiOiJTV3gxcHZZeUI3cyIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjg3NzEwNzI2LCJpYXQiOjE2ODc3MDk1MjYsImp0aSI6IjU1NmQ1NTBhLTA3MzMtNGQ2NS05MmVmLTYyMmM0ZDE2ZWFjMyIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.dzEMlsfcWMLQxFaGsDJqhaaw5m5mNVZRWblwwVt3-KCmRmmxN9BVpRj8MYIZzZ9dcJ8KqIkjy14N4O3KRi5HDTlaD5wQjcgYXc06XO3fsBudEwHl6STQ49CS8KP7S-8dh7HbuAQzDIXBtA0yGEVxL9MNTc0Kg1yaQLl7Al4XkQreqiLBxp_uP9470ZQpENbgn2jU87YyXXDbfMyBVmoO4dQL0vQJvjBddr5lduK1xswFDyp4oUJA3Rmhd4n_G7xYGAXdgaBybeBWp98rpjR_v6sKkaKEcDzaUYO5xCyp1D6NFqrtMxPYhYTs0Aqeq8ZLaNH6VGMcnVD58gKjyQmi5g&preferred_environment=");

	}
	public void login(String a, String b) throws InterruptedException {
		driver.findElement(By.id("usernameInput-input")).sendKeys(a);
		driver.findElement(By.id("password-input")).sendKeys(b);
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(1000);
	}
	
	public String readEmailErr() {
				String ActualErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
				return ActualErr;
		
	}
	
	public String readPassErr() {
		String ActualErr = driver.findElement(By.id("PasswordTextField__errors-password")).getText();
		return ActualErr;
		
	}
}

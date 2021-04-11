package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;
	By username=By.id("user-name");
	By password=By.id("password");
	By loginBtn=By.id("login-button");
	
	public WebElement getUserName()
	{
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getLoginBtn()
	{
		return driver.findElement(loginBtn);
	}
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}


}

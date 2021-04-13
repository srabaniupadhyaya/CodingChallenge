package codingChallenge.mapsynq;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import pageObjects.productsPage;
import resources.base;

public class ValidateProductsPageTitle extends base {
	public WebDriver driver;
	  @BeforeTest
	  public void initializeTest()  throws IOException{
		  driver=initializeDriver();
	  }
	  
	  @AfterTest
	  public void tearDownTest() {
		  driver.quit();
	  }
	  
	  @Test
	  public void ValidateProductsTitle() throws IOException{
		
		  driver.get(prop.getProperty("url"));
			loginPage l=new loginPage(driver);
			l.getUserName().sendKeys("standard_user");
			l.getPassword().sendKeys("secret_sauce");
			System.out.println("valid User");
			l.getLoginBtn().click();
			productsPage p=new productsPage(driver);
			String title=p.getProductTitle().getText();
			Assert.assertEquals(title, "Product","Product Title does not match");  
	  }

}

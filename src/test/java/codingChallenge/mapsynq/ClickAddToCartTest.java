package codingChallenge.mapsynq;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.loginPage;
import pageObjects.productsPage;
import resources.base;

public class ClickAddToCartTest extends base {
	public WebDriver driver;

  @Test
  public void AddCartTest() throws IOException{
	  driver.get(prop.getProperty("url"));
		loginPage l=new loginPage(driver);
		l.getUserName().sendKeys("standard_user");
		l.getPassword().sendKeys("secret_sauce");
		System.out.println("valid User");
		l.getLoginBtn().click();
		String pageTitle=driver.getTitle();
		Assert.assertEquals(pageTitle, "Swag Labs","Title does not match");
		productsPage p=new productsPage(driver);
		if(p.getBackPackTitle().isDisplayed())
		{
			p.getAddToCartBackPack().click();
		}
		Assert.assertTrue(p.getRemoveBackPackBtn().isDisplayed(),"The remove button for backpack product is disabled");
  }
  @BeforeTest
  public void initializeTest()  throws IOException{
	  driver=initializeDriver();
  }

  @AfterTest
  public void tearDownTest() {
	  driver.quit();
  }
}

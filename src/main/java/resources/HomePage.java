package resources;

import java.io.IOException;
import pageObjects.loginPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class HomePage extends resources.base {
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String userName,String Passowrd,String userCategory) throws IOException
	{
		driver.get(prop.getProperty("url"));
		loginPage l=new loginPage(driver);
		l.getUserName().sendKeys(userName);
		l.getPassword().sendKeys(Passowrd);
		System.out.println(userCategory);
		l.getLoginBtn().click();
		
	}
	
	@DataProvider
	public Object [][] getData()
	{
		Object[][] data= new Object[2][3];
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		data[0][2]="valid User";
		data[1][0]="locked_out_user";
		data[1][1]="secret_sauce";
		data[1][2]="2nd valid User";
		return data;
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}

package resources;
import java.io.File;
//import org.openqa.selenium.TakesScreenshot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException 
	{
		 prop= new Properties();
		
		FileInputStream fis= new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		
		//FileInputStream fis= new FileInputStream("data.properties"); 
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\resources\\chromedriver.exe");
		    driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			//For Firefox driver
		}
		else if(browserName.equals("IE"))
		{
			//For IE driver
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenshotMethod(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png"	;
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
	
}

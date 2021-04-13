package codingChallenge.mapsynq;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener{
	ExtentTest test;
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<>();
	@Override
	public void onTestStart(ITestResult result) {
		 test= extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		extentTest.get().log(Status.PASS, "Test has paased");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Extent report status when test fails
		extentTest.get().fail(result.getThrowable());
		// Screenshot to taken on failures
		WebDriver driver=null;
		String testMethodName=result.getMethod().getMethodName();
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		try {
			getScreenshotMethod(testMethodName,driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotMethod(testMethodName,driver), result.getMethod().getMethodName());
		}
			
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}

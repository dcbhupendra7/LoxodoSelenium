package LoxodoWebsite.AbstractComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseClass.BaseClass;
import Resources.ExtentReportObject;

public class Listeners extends BaseClass implements ITestListener{
	ExtentTest test;
	ExtentReports extent= ExtentReportObject.getReportObject();
	//Thread safe
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
		//unique thread id ->test
		extentTest.set(test);
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		//to print error message
		extentTest.get().fail(result.getThrowable());
		
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String filePath = null;

		try {
			filePath = getScreenShot(result.getMethod().getMethodName(), driver);

		}
			catch(IOException e){
				e.printStackTrace();
			}
		
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}

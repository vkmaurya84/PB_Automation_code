package testCase;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.Common;

public class Listeners implements ITestListener 
{
	
	ExtentTest test;
	ExtentReports extent = Common.extentReport();
	
//	WebDriver driver;
//    String filePath;
	
	public void onTestStart(ITestResult result) 
	{					
        // TODO Auto-generated method stub				
       test = extent.createTest(result.getMethod().getMethodName());
    }		

	 public void onTestSuccess(ITestResult result)
	 {					
	        // TODO Auto-generated method stub				
	        	test.log(Status.PASS, "Test Passed");
	        	
	        	Common.logout();
	    		Common.driver.close();
	 }	
	      
	 public void onTestFailure(ITestResult result) 
	 {					
	        // TODO Auto-generated method stub				
	       test.fail(result.getThrowable());
	       
	      

//			try {
//				driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//				
////				 WebDriver element = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
////				 WebDriver element = (WebDriver) result.getTestClass().getRealClass()
////				WebDriver element = (WebDriver) result.getTestContext();
//				System.out.println("Print : "+ driver);
//				
//			} catch (Exception e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} 

	       
	      try 
	      {
			Common.getFailedTestCaseScreenshot(result.getMethod().getMethodName());
	      } 
	      catch (Exception e) 
	      {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      }
	      test.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\reports\\" + result.getMethod().getMethodName() + ".png", result.getMethod().getMethodName());
	      
	      
	      Common.logout();
			Common.driver.close();
	      
	      finish();
	 }		

	    
	 public void onTestSkipped(ITestResult result) 
	 {					
	        // TODO Auto-generated method stub	
		 test.skip(result.getThrowable());
		 
		 Common.logout();
			Common.driver.close();
	 }		
	 		
	 public void onFinish(ITestContext result) 
	 {					
	        // TODO Auto-generated method stub				
	        	extent.flush();
	 }	
	 
	 public void finish()
	 {
		 extent.flush();
	 }
	    
}

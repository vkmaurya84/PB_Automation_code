package testCase;


import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.Common;
import objectRepo.LoginPage;


public class Login {
	
	LoginPage log;
	
//	@BeforeMethod
//	public void Browser() throws IOException
//	{
//		Common.browserSetup();
//		log = new LoginPage(Common.driver);
//	}
//	
//	@AfterMethod
//	public void afterExecution()
//	{
//		Common.logout();
//		Common.driver.close();
//	}
	
	
	@Test(enabled = false)
	public void login() throws IOException
	{
		Common.login();
	}
	

}

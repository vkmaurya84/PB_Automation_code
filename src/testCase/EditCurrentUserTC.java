package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Common;
import objectRepo.EditCurrentUser;


public class EditCurrentUserTC {
	
	EditCurrentUser currentUser;
	
	@BeforeMethod
	public void Browser() throws IOException
	{
		Common.browserSetup();
		Common.login();
		currentUser = new EditCurrentUser(Common.driver);
	}
	
//	@AfterMethod
//	public void afterExecution()
//	{
//		Common.logout();
//		Common.driver.close();
//	}
	
	@Test(enabled = true)
	public void TC_476()
	{
//		TC_479 is covered in this test case
		currentUser.currentUser();
		currentUser.clickEditUserButton();
		currentUser.enterOldPassword(Common.userData.getProperty("password"));
		currentUser.enterNewPassword(Common.userData.getProperty("password"));
		currentUser.enterConfirmPassword(Common.userData.getProperty("password"));
		currentUser.clickOnConfirmButton();
		Assert.assertEquals(currentUser.validateEditSuccess(), Common.message.getProperty("userEditSuccessMessage"));
		currentUser.clickCloseButton();
	}
	
	@Test(enabled = true)
	public void TC_477()
	{
		currentUser.currentUser();
		currentUser.clickEditUserButton();
		currentUser.enterOldPassword(Common.userData.getProperty("password"));
		currentUser.enterNewPassword(Common.userData.getProperty("password"));
		currentUser.enterConfirmPassword("abcdef");
		currentUser.clickOnConfirmButton();
		Assert.assertEquals(currentUser.confirmPasswordErrorMessage(), Common.message.getProperty("newAndConfirmPasswordError"));
		
	}
	
	@Test(enabled = true)
	public void TC_478()
	{
		currentUser.currentUser();
		currentUser.clickEditUserButton();
		currentUser.enterOldPassword(Common.userData.getProperty("password"));
		currentUser.enterNewPassword(Common.userData.getProperty("password"));
		currentUser.enterConfirmPassword("");
		currentUser.clickOnConfirmButton();
		Assert.assertEquals(currentUser.confirmPasswordErrorMessage(), Common.message.getProperty("confirmPasswordError"));
	}

}

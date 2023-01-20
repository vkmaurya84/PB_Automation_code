package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvException;

import common.Common;
import objectRepo.EditUserPage;
import objectRepo.NewUserPage;
import objectRepo.UserManagement;

public class UserManagementTC {
	
	UserManagement user_management;
	NewUserPage newUser;
	EditUserPage editUser;
	
	@BeforeMethod
	public void browser() throws IOException
	{
		Common.browserSetup();
		Common.login();
		user_management = new UserManagement(Common.driver);
		newUser = new NewUserPage(Common.driver);
		editUser = new EditUserPage(Common.driver);
	}
	
//	@AfterMethod
//	public void afterExecution()
//	{
//		Common.logout();
//		Common.driver.close();
//	}
	
	
	@Test(enabled = true)
	public void TC_364()
	{
		user_management.userManagementMenu();
//		user_management.userManagementSubmenuValidate();
		Assert.assertEquals(user_management.userManagementSubmenu1Label().getText(), Common.message.getProperty("userManagementSubmenu1"));
		Assert.assertEquals(user_management.userManagementSubmenu2Label().getText(), Common.message.getProperty("userManagementSubmenu2"));
	}
	
	@Test(enabled = true)
	public void TC_365()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userMgtTitleValidate();
		Assert.assertEquals(user_management.userMgtTitleValidate().getText(), Common.message.getProperty("userMgtTitle"));
	}
	
	@Test(enabled = true)
	public void TC_366() throws InterruptedException, IOException
	{
//		TC_370 is covered in this Test Case
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		Common.validateScreen("TC_366.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_367()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.selectValue();
//		user_management.selectedValueValidate();
		Assert.assertEquals(10 , Common.message.getProperty("selectedValue"));
	}
	
	@Test(enabled = true)
	public void TC_368()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.selectValue();		
		Assert.assertEquals(Common.message.getProperty("selectedValue"), user_management.rowLength());
	}
	
	@Test(enabled = true)
	public void TC_369()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
//		Search by User name
		user_management.userManagementSearch("Nagarjun");
		Assert.assertEquals(user_management.recordHead().getText(), Common.message.getProperty("recordHead"));
//		Search by User Role
		user_management.userManagementSearch("Super Admin");
		Assert.assertEquals(user_management.recordHead().getText(), Common.message.getProperty("recordHead"));
//		Search by Meter No
		user_management.userManagementSearch("3815272");
		Assert.assertEquals(user_management.recordHead().getText(), Common.message.getProperty("recordHead"));
		
	}
	
	@Test(enabled = true)
	public void TC_371()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.getDeletedMeterNo();
		user_management.RemoveMeter();
		Assert.assertNotEquals(user_management.meterLable().getText(), user_management.deletedMeterLabel);
	}

	@Test(enabled = true)
	public void TC_372() throws IOException
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("Nagarjun");
		user_management.getDeletedMeterNo();
		user_management.RemoveMeter();
		Common.logout();
		Common.login();
		user_management.landOnDepositFundPage();
		user_management.clickOnMeterNoDropdown();
		Assert.assertEquals(user_management.meterNotFound().getText(), Common.message.getProperty("noSearchedMeter")+" \""+user_management.deletedMeterLabel+"\"");
	}
	
	@Test(enabled = true)
	public void TC_373()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("Nagarjun");
		user_management.clickActionButton();
		Assert.assertNotEquals(user_management.getEditUserLabel().getText(), Common.message.getProperty("editUserLabel"));
	}
	
	@Test(enabled = true)
	public void TC_374() throws InterruptedException, IOException
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("Nagarjun01");
		user_management.clickMeterButton();
		Common.validateScreen("TC_374.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
		user_management.crossButton();
	}

	@Test(enabled = true)
	public void TC_375() throws InterruptedException
	{
//		TC_376 is covered in current Test case
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("Nagarjun01");
		
		user_management.getDeletedMeterNo();
		user_management.RemoveMeter();
		user_management.userManagementSearch("Nagarjun01");
		
		user_management.clickMeterButton();
		user_management.clickMeterDropdown();
		user_management.enterMeterNumber(user_management.deletedMeterLabel);
		Thread.sleep(2000);
		user_management.selectSearchedMeter();
		user_management.clickMeterDropdown();
		user_management.clickSubmitButton();
		Assert.assertEquals(user_management.validateAssignedMeter().getText(), Common.message.getProperty("assignedMeterMsg"));
	}
	
	@Test(enabled = true)
	public void TC_377()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("Nagarjun01");
		user_management.clickMeterButton();
		user_management.crossButton();
		Assert.assertEquals(user_management.userMgtTitleValidate().getText(), Common.message.getProperty("userMgtTitle"));
	}
	
	@Test(enabled = true)
	public void TC_378()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("Nagarjun01");
		user_management.clickMeterButton();
		user_management.closeButton();
		Assert.assertEquals(user_management.userMgtTitleValidate().getText(), Common.message.getProperty("userMgtTitle"));
	}
	
	@Test(enabled = true)
	public void TC_379()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("Unlock");
		user_management.clickUnlockButton();
//		System.out.println(user_management.unlockedUserLabel);
		user_management.userManagementSearch("Unlock");
		Assert.assertNotEquals(user_management.unlockedUserLabel, user_management.nextToUnlockUser());
	}
	@Test(enabled = true)
	public void TC_380()
	{
		Common.logout();
		user_management.login("vineet1", "adm123");
		Assert.assertEquals(user_management.unlockedUserLoginValidate(), Common.message.getProperty("unlockedUserLoginValidateMessage"));
		
	}
	
	@Test(enabled = true)
	public void TC_381()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("vineet06");
		user_management.clickOnDeactivateButton();
		user_management.userManagementSearch("vineet06");
		Assert.assertEquals(user_management.validateDeactiveUser(), Common.message.getProperty("activateLabel"));
//		user_management.clickOnActivateButton();
	}
	
	@Test(enabled = true, dependsOnMethods = { "TC_381" })
	public void TC_382() throws InterruptedException, IOException
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("vineet06");
		Common.validateScreen("TC_382.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
		user_management.crossButton();
		
	}
	
	@Test(enabled = true, dependsOnMethods = { "TC_382" })
	public void TC_383()
	{
//		user_management.userManagementMenu();
//		user_management.userManagementSubmenu1();
//		user_management.userManagementSearch("vineet06");
//		user_management.deactivatedUsername();
//		user_management.clickOnDeactivateButton();
		Common.logout();
//		Login with deactivated account
		user_management.login("vineet06", "adm123");
		Assert.assertEquals(user_management.errorMessageOfDeactiveUser(), Common.message.getProperty("errorMessageOfDeactiveUser"));
	}
	
	@Test(enabled = true, dependsOnMethods = { "TC_383" })
	public void TC_384()
	{
		Common.logout();
//		Login with deactivated account
		user_management.login("ksvineet9909@gmail.com", "adm123");
		Assert.assertEquals(user_management.errorMessageOfDeactiveUser(), Common.message.getProperty("errorMessageOfDeactiveUser2"));
	}
	
	@Test(enabled = true, dependsOnMethods = { "TC_384" })
	public void TC_385()
	{
		Common.logout();
//		Login with deactivated account
		user_management.mobileLoginButton();
		user_management.enterMobileNumber("7836856473");
		user_management.clickOnSendOtp();
		Assert.assertEquals(user_management.validateMobile(), Common.message.getProperty("errorMessageOfDeactiveUser3"));
	}
	
	@Test(enabled = true, dependsOnMethods = { "TC_385" })
	public void TC_386()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch("vineet06");
		user_management.clickOnActivateButton();
		user_management.userManagementSearch("vineet06");
		Assert.assertEquals(user_management.validateActivateButton(), Common.message.getProperty("deactiveLabel"));
	}
	
	@Test(enabled = true)
	public void TC_387()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch(Common.userData.getProperty("userName"));
		user_management.clickOnDeactivateButton();
		user_management.deactivateConfirmDialogButton();
		Assert.assertEquals(user_management.validateLoginPage(), Common.message.getProperty("userName"));
		activateUser();
	}
	
	public void activateUser()
	{
		user_management.login("vineet5", "adm123");
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.userManagementSearch(Common.userData.getProperty("userName"));
		user_management.clickOnActivateButton();
	}
	
	@Test(enabled = true)
	public void TC_388()
	{
		user_management.userManagementMenu();
		user_management.userManagementSubmenu1();
		user_management.newUserClick();
		Assert.assertEquals(user_management.validateNewUserTitle(), Common.message.getProperty("newUser"));
	}
	
//	New User Page
	
	@Test(enabled = true)
	public void TC_389() throws InterruptedException, IOException
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		Common.validateScreen("TC_389.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_390()
	{
//		TC_391 is covered in current test case
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet97");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet97@gmail.com");
		newUser.enterMobile("8896997136");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
//		newUser.clickMeterDropdown();
//		newUser.clickToSelectMeter();
//		newUser.clickMeterDropdown();
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.userAddedConfirmationMessage(), Common.message.getProperty("userAddedMmessage"));
		newUser.clickCloseButton();
	}
	
	@Test(enabled = true)
	public void TC_392()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet98");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet98@gmail.com");
		newUser.enterMobile("8896997138");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnCancelButton();
		Assert.assertEquals(newUser.afterClickOnCancelValidate(), Common.message.getProperty("userManagementMmessage"));
	}
	
	@Test(enabled = true, dependsOnMethods = { "TC_392" })
	public void TC_393()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.enterInSearchField("vineet96");
		Assert.assertEquals(newUser.validateSearchResult(), Common.message.getProperty("noSearchResult"));
	}
	
	@Test(enabled = true)
	public void TC_395()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("2");
		Assert.assertEquals(newUser.validateStatusLabel(), Common.message.getProperty("statusLabelMessage"));
	}
	
	@Test(enabled = true)
	public void TC_396()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("8896997133");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateUserNameError(), Common.message.getProperty("userNameError"));
	}
	
	@Test(enabled = true)
	public void TC_397()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vin");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("8896997133");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateUserNameError(), Common.message.getProperty("userNameError2"));
		newUser.enterUserName("abcdefghijklmnopqrstuv");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateUserNameError(), Common.message.getProperty("userNameError2"));
	}
	
	@Test(enabled = true)
	public void TC_398()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet@#12");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("8896997133");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateUserNameError(), Common.message.getProperty("userNameInvalid"));
	}
	
	@Test(enabled = true)
	public void TC_399()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName(Common.userData.getProperty("userName"));
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("8896997133");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.existingUser(), Common.message.getProperty("existingUser"));
		newUser.clickCloseButton();
	}
	
	@Test(enabled = true)
	public void TC_400()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("");
		newUser.enterMobile("8896997133");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateEmailError(), Common.message.getProperty("emailEmptyError"));
	}
	
	@Test(enabled = true)
	public void TC_401()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96.gmail.com");
		newUser.enterMobile("8896997133");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateEmailError(), Common.message.getProperty("emailInvalid"));
	}
	
	@Test(enabled = true)
	public void TC_402()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("ksvineet9909@gmail.com");
		newUser.enterMobile("8896997133");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateEmailExist(), Common.message.getProperty("emailExist"));
	}
	
	@Test(enabled = true)
	public void TC_403()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateMobileError(), Common.message.getProperty("mobileEmptyError"));
	}
	
	@Test(enabled = true)
	public void TC_404()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("889699#174");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateMobileError(), Common.message.getProperty("mobileInvalid"));
	}
	
	@Test(enabled = true)
	public void TC_405()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("88969931");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateMobileError(), Common.message.getProperty("mobileIncorrect"));
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.enterMobile("889699317534543");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateMobileError(), Common.message.getProperty("mobileIncorrect"));
	}
	
	@Test(enabled = true)
	public void TC_406()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("7290939419");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateMobileExist(), Common.message.getProperty("mobileExist"));
	}
	
	@Test(enabled = true)
	public void TC_407()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("adm123");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("7290939419");
		newUser.enterShahredKey("");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validateSharedKeyError(), Common.message.getProperty("sharedKeyError"));
	}
	
	@Test(enabled = true)
	public void TC_408()
	{
		newUser.userManagementMenu();
		newUser.userManagementSubmenu1();
		newUser.newUserClick();
		newUser.enterUserName("vineet96");
		newUser.selectUserRole("3");
		newUser.enterPassword("");
		newUser.enterConfirmPassword("adm123");
		newUser.selectLanguage("Hindi");
		newUser.enterEmail("vineet96@gmail.com");
		newUser.enterMobile("7290939419");
		newUser.enterShahredKey("889699");
		newUser.selectOfficeCode("IGR537_ACS , MUMBAI");
		newUser.enterDSROCode("889699");
		newUser.clickOnSubmitButton();
		Assert.assertEquals(newUser.validatePasswordError(), Common.message.getProperty("passwordError"));
	}
	
	@Test(enabled = true)
	public void TC_409() throws InterruptedException, IOException
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		Common.validateScreen("TC_409.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_410()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
//		editUser.enterOldPassword("adm123");
		editUser.enterPassword("adm123");
		editUser.enterConfirmPassword("adm123");
		editUser.clickOnSubmitButton();
		Assert.assertEquals(editUser.validateUserEditMessage(), Common.message.getProperty("userEditSuccessMessage"));
		editUser.clickCloseButton();
	}
	
	@Test(enabled = true)
	public void TC_411()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		editUser.enterPassword("adm123");
		editUser.enterConfirmPassword("adm123");
		editUser.enterEmail("vineet97@gmail.com");
		editUser.clickOnSubmitButton();
		Assert.assertEquals(editUser.validateUserEditMessage(), Common.message.getProperty("userEditSuccessMessage"));
		editUser.clickCloseButton();
	}
	
	@Test(enabled = true)
	public void TC_413()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		editUser.enterPassword("adm123");
		editUser.enterConfirmPassword("adm123");
		editUser.enterMobile("8896997131");
		editUser.clickOnSubmitButton();
		Assert.assertEquals(editUser.validateUserEditMessage(), Common.message.getProperty("userEditSuccessMessage"));
		editUser.clickCloseButton();
	}
	
	@Test(enabled = true)
	public void TC_414()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		editUser.enterPassword("adm123");
		editUser.enterConfirmPassword("adm123");
		editUser.enterEmail("vineet97@gmail.com");
		editUser.enterMobile("8896997131");
		editUser.clickOnSubmitButton();
		Assert.assertEquals(editUser.validateUserEditMessage(), Common.message.getProperty("userEditSuccessMessage"));
		editUser.clickCloseButton();
	}
	
	@Test(enabled = true)
	public void TC_415()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		editUser.enterPassword("adm123");
		editUser.enterConfirmPassword("adm123");
		editUser.clickOnCancelButton();
		Assert.assertEquals(editUser.afterClickOnCancelValidate(), Common.message.getProperty("userManagementMmessage"));
	}
	
	@Test(enabled = true)
	public void TC_418()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		editUser.enterPassword("");
		editUser.enterConfirmPassword("adm123");
		editUser.clickOnSubmitButton();
		Assert.assertEquals(editUser.validatePasswordError(), Common.message.getProperty("passwordError"));
	}
	
	@Test(enabled = true)
	public void TC_419()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		editUser.enterPassword("adm123");
		editUser.enterConfirmPassword("adm123");
		editUser.enterEmail("");
		editUser.clickOnSubmitButton();
		Assert.assertEquals(editUser.validateEmailError(), Common.message.getProperty("emailEmptyError"));
	}
	
	@Test(enabled = true)
	public void TC_421()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		editUser.enterPassword("adm123");
		editUser.enterConfirmPassword("adm123");
		editUser.enterEmail("vineet97.gmail.com");
		editUser.clickOnSubmitButton();
		Assert.assertEquals(editUser.validateEmailError(), Common.message.getProperty("emailInvalid"));
	}
	
	@Test(enabled = true)
	public void TC_422()
	{
		editUser.userManagementMenu();
		editUser.userManagementSubmenu1();
		editUser.enterInSearchField("vineet97");
		editUser.clickActionButton();
		editUser.enterPassword("adm123");
		editUser.enterConfirmPassword("adm123");
		editUser.enterEmail("vineet97@gmail.com");
		editUser.enterMobile("");
		editUser.clickOnSubmitButton();
		Assert.assertEquals(editUser.validateMobileError(), Common.message.getProperty("mobileEmptyError"));
	}
	
	@Test(enabled = true)
	public void newTest() throws IOException, CsvException
	{
		Common.readDataFromFile();
		System.out.println(Common.name+", "+Common.email+", "+Common.mobile);
	}
	
}

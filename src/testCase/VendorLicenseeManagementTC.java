package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Common;
import objectRepo.EditMeterPage;
import objectRepo.NewMeterPage;
import objectRepo.VenedorLicenseeManagementPage;

public class VendorLicenseeManagementTC {
	
	VenedorLicenseeManagementPage vendorLicensee;
	NewMeterPage newMeter;
	EditMeterPage editMeter;

	@BeforeMethod
	public void Browser() throws IOException
	{
		Common.browserSetup();
		Common.login();
		vendorLicensee = new VenedorLicenseeManagementPage(Common.driver);
		newMeter = new NewMeterPage(Common.driver);
		editMeter = new EditMeterPage(Common.driver);
	}
	
//	@AfterMethod
//	public void afterExecution()
//	{
//		Common.logout();
//		Common.driver.close();
//	}
	
	@Test(enabled = true)
	public void TC_424()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		Assert.assertEquals(vendorLicensee.validateVendorLicenseLabel(), Common.message.getProperty("vendorLicenseLabel"));
	}
	
	@Test(enabled = true)
	public void TC_425() throws InterruptedException, IOException
	{
//		TC_432 is covered in this Test Case
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		Common.validateScreen("TC_425.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_426()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.selectValue();
		Assert.assertEquals(25 , vendorLicensee.rowLength());
	}
	
	@Test(enabled = true)
	public void TC_427()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.searchBox("25362");  // Searching by Serial No.
		Assert.assertEquals(vendorLicensee.validateRecord() , "tr");
		vendorLicensee.searchBox("25632587");  // Searching by Account No.
		Assert.assertEquals(vendorLicensee.validateRecord() , "tr");
		vendorLicensee.searchBox("vineet_test");  // Searching by License No.
		Assert.assertEquals(vendorLicensee.validateRecord() , "tr");
		vendorLicensee.searchBox("vineet vineet");  // Searching by Alias Name
		Assert.assertEquals(vendorLicensee.validateRecord() , "tr");
		vendorLicensee.searchBox("31-Dec-2022");  // Searching by Date
		Assert.assertEquals(vendorLicensee.validateRecord() , "tr");
	}
	
	@Test(enabled = true)
	public void TC_428() throws InterruptedException, IOException
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.downloadPDF();
		Assert.assertEquals(vendorLicensee.pdfButtonLabel, "PDF");
	}
	
	@Test(enabled = true)
	public void TC_430()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.downloadEXCEL();
		Assert.assertEquals(vendorLicensee.excelButtonLabel, "Excel");
	}
	
	@Test(enabled = true)
	public void TC_433()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.searchBox("Nagarjun");
		vendorLicensee.clickActionButton();
		Assert.assertEquals(vendorLicensee.ValidateEditMeterLabel(), Common.message.getProperty("editMeterLabel"));
	}
	
	@Test(enabled = true)
	public void TC_434()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.clickOnAddMeter();
		Assert.assertEquals(vendorLicensee.validateNewMeter(), Common.message.getProperty("newMeterLabel"));
	}
	
	@Test(enabled = true)
	public void TC_435() throws InterruptedException, IOException
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.clickOnAddMeter();
		Common.validateScreen("TC_435.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_436()
	{
//		TC_439 is covered in this Test Case
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("911386");	// need to change
		newMeter.enterLicenseNumber("911386");		// need to change
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0106");	// need to change
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("District_Registrar");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateAddedMeterLabel(), Common.message.getProperty("meterAddedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_437()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("911385");	
		newMeter.enterLicenseNumber("911385");		
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0105");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("District_Registrar");
		newMeter.clickCancelbutton();
		Assert.assertEquals(newMeter.validateVendorLicenseLabel(), Common.message.getProperty("vendorLicenseLabel"));
	}
	
	@Test(enabled = true)
	public void TC_438()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("911387");	// need to change
		newMeter.enterLicenseNumber("911387");		// need to change
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0108");	// need to change
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Stamp_Vendor");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateAddedMeterLabel(), Common.message.getProperty("meterAddedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_440()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("911388");	// need to change
		newMeter.enterLicenseNumber("911388");		// need to change
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0109");	// need to change
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateAddedMeterLabel(), Common.message.getProperty("meterAddedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_441()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("911389");	// need to change
		newMeter.enterLicenseNumber("911389");		// need to change
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0110");	// need to change
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateAddedMeterLabel(), Common.message.getProperty("meterAddedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_442()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("");	
		newMeter.enterLicenseNumber("911382");		
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0108");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateCamSerialNumberError(), Common.message.getProperty("camSerialErrorMessage"));
	}
	
	@Test(enabled = true)
	public void TC_443()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("9113");	
		newMeter.enterLicenseNumber("911382");		
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0108");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateCamSerialNumberError(), Common.message.getProperty("camSerialErrorMessage2"));
		newMeter.enterCamSerialNumber("911387785864");	
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateCamSerialNumberError(), Common.message.getProperty("camSerialErrorMessage2"));
	}
	
	@Test(enabled = true)
	public void TC_444()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("911@#abc");	
		newMeter.enterLicenseNumber("911382");		
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0108");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateCamSerialNumberError(), Common.message.getProperty("camSerialInvalidErrorMessage"));
	}
	
	@Test(enabled = true)
	public void TC_445()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("");		
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0108");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateLicenseError(), Common.message.getProperty("emptyLicenseErrorMessage"));
	}
	
	@Test(enabled = true)
	public void TC_446()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("123");		
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0108");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateLicenseError(), Common.message.getProperty("licenseErrorMessage"));
		newMeter.enterLicenseNumber("123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateLicenseError(), Common.message.getProperty("licenseErrorMessage"));
	}
	
	@Test(enabled = true)
	public void TC_447()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("123@#ab");		
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("06-Jan-2023");
		newMeter.enterAliasName("Nagarjun0108");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateLicenseError(), Common.message.getProperty("licenseInvalidMessage"));
	}
	
	@Test(enabled = true)
	public void TC_448()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("91138778");		
		newMeter.enterValidFromDate("03-Jan-2023");
		newMeter.enterValidToDate("02-Jan-2023");
		newMeter.enterAliasName("Nagarjun0108");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateToDateError(), Common.message.getProperty("validToDateError"));
	}
	
	@Test(enabled = true)
	public void TC_449()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("91138778");		
		newMeter.enterValidFromDate(Common.futureDate());
		newMeter.enterValidToDate(Common.currentDate());
		newMeter.enterAliasName("Nagarjun0108");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateFromDateError(), Common.message.getProperty("futuristicFromDate"));
	}
	
	@Test(enabled = true)
	public void TC_450()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("91138778");		
		newMeter.enterValidFromDate(Common.currentDate());
		newMeter.enterValidToDate(Common.futureDate());
		newMeter.enterAliasName("");	
		newMeter.enterAccountNumber("91138778");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateLicenseeNameError(), Common.message.getProperty("licenseeNameError"));
	}
	
	@Test(enabled = true)
	public void TC_451()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("91138778");		
		newMeter.enterValidFromDate(Common.currentDate());
		newMeter.enterValidToDate(Common.futureDate());
		newMeter.enterAliasName("Nagarjun0110");	
		newMeter.enterAccountNumber("");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateAccountError(), Common.message.getProperty("accountNumberError"));
	}
	
	@Test(enabled = true)
	public void TC_452()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("91138778");		
		newMeter.enterValidFromDate(Common.currentDate());
		newMeter.enterValidToDate(Common.futureDate());
		newMeter.enterAliasName("Nagarjun0110");	
		newMeter.enterAccountNumber("911");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateAccountError(), Common.message.getProperty("accountNumberError2"));
		newMeter.enterAccountNumber("911387785864");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateAccountError(), Common.message.getProperty("accountNumberError2"));
	}
	
	@Test(enabled = true)
	public void TC_453()
	{
		newMeter.userManagementMenu();
		newMeter.userManagementSubmenu2();
		newMeter.clickOnAddMeter();
		newMeter.enterCamSerialNumber("91138778");	
		newMeter.enterLicenseNumber("91138778");		
		newMeter.enterValidFromDate(Common.currentDate());
		newMeter.enterValidToDate(Common.futureDate());
		newMeter.enterAliasName("Nagarjun0110");	
		newMeter.enterAccountNumber("911@#abc");
		newMeter.selectCamUser("Captive_User");
		newMeter.clickSubmitButton();
		Assert.assertEquals(newMeter.validateAccountError(), Common.message.getProperty("invalidAccountError"));
	}
	
	@Test(enabled = true)
	public void TC_454() throws InterruptedException, IOException
	{
		editMeter.userManagementMenu();
		editMeter.userManagementSubmenu2();
		editMeter.searchBox("Nagarjun0");
		editMeter.clickActionButton();
		Common.validateScreen("TC_454.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_455()
	{
		editMeter.userManagementMenu();
		editMeter.userManagementSubmenu2();
		editMeter.searchBox("Nagarjun0");
		editMeter.clickActionButton();
		editMeter.enterLicenseNumber("911387");
		editMeter.clickSubmitButton();
		Assert.assertEquals(editMeter.validateEditMeterLabel(), Common.message.getProperty("meterUpdatedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_456()
	{
//		TC_457 is covered in this Test case
		editMeter.userManagementMenu();
		editMeter.userManagementSubmenu2();
		editMeter.searchBox("Nagarjun0");
		editMeter.clickActionButton();
		editMeter.enterValidFromDate(Common.currentDate());
		newMeter.enterValidToDate(Common.futureDate());
		editMeter.clickSubmitButton();
		Assert.assertEquals(editMeter.validateEditMeterLabel(), Common.message.getProperty("meterUpdatedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_458()
	{
		editMeter.userManagementMenu();
		editMeter.userManagementSubmenu2();
		editMeter.searchBox("Nagarjun0");
		editMeter.clickActionButton();
		editMeter.enterAliasName("Nagarjun00");
		editMeter.clickSubmitButton();
		Assert.assertEquals(editMeter.validateEditMeterLabel(), Common.message.getProperty("meterUpdatedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_459()
	{
		editMeter.userManagementMenu();
		editMeter.userManagementSubmenu2();
		editMeter.searchBox("Nagarjun0");
		editMeter.clickActionButton();
		editMeter.enterAccountNumber("9113878");
		editMeter.clickSubmitButton();
		Assert.assertEquals(editMeter.validateEditMeterLabel(), Common.message.getProperty("meterUpdatedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_460()
	{
//		TC_461 is covered in this Test Case
		editMeter.userManagementMenu();
		editMeter.userManagementSubmenu2();
		editMeter.searchBox("Nagarjun0");
		editMeter.clickActionButton();
		editMeter.selectCamUser("District_Registrar");
		editMeter.clickSubmitButton();
		Assert.assertEquals(editMeter.validateEditMeterLabel(), Common.message.getProperty("meterUpdatedMessage"));
	}
	
	@Test(enabled = true)
	public void TC_462()
	{
		editMeter.userManagementMenu();
		editMeter.userManagementSubmenu2();
		editMeter.searchBox("Nagarjun0");
		editMeter.clickActionButton();
		editMeter.clickCancelbutton();
		Assert.assertEquals(editMeter.validateVendorLicenseLabel(), Common.message.getProperty("vendorLicenseLabel"));
	}
	
	@Test(enabled = true)
	public void TC_463()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.searchBox("Nagarjun0");
		vendorLicensee.getDeactivatedMeter();
		vendorLicensee.ClickDeactivateButton();
		vendorLicensee.searchBox(vendorLicensee.deactiveMeter);
		Assert.assertEquals(vendorLicensee.validateButtonAfterDeactivation(), Common.message.getProperty("activateMeterLabel"));
	}

	@Test(enabled = true, dependsOnMethods = { "TC_463" })
	public void TC_464()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.searchBox(vendorLicensee.deactiveMeter);
//		vendorLicensee.validateActionButton();
		Assert.assertEquals(vendorLicensee.validateActionButton(), "");
	}
	
	@Test(enabled = true, dependsOnMethods = { "TC_464" })
	public void TC_465() throws InterruptedException
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu1();
		vendorLicensee.searchBox("Nagarjun");
		vendorLicensee.clickOnAssignMeter();
		vendorLicensee.clickMeterDropdown();
		vendorLicensee.searchDeactiveMeter();
		vendorLicensee.selectSearchedMeter();
		vendorLicensee.clickMeterDropdown();
		Assert.assertEquals(vendorLicensee.selectMeterDropdownLabel, Common.message.getProperty("noMeterSelected"));
		vendorLicensee.clickOnCrossButton();
	}
	
	@Test(enabled = true, dependsOnMethods = { "TC_465" })
	public void TC_466()
	{
		vendorLicensee.userManagementMenu();
		vendorLicensee.userManagementSubmenu2();
		vendorLicensee.searchBox(vendorLicensee.deactiveMeter);
		vendorLicensee.clickActivateButton();
		vendorLicensee.searchBox(vendorLicensee.deactiveMeter);
		Assert.assertEquals(vendorLicensee.validateButtonAfterActivation(), Common.message.getProperty("deactiveMeterLabel"));
	}
	
	@Test(enabled = true)
	public void TC_474()
	{
		Common.logout();
		vendorLicensee.login("roli@liberintechnologies.com", "adm123");
		Assert.assertEquals(vendorLicensee.errorMessageWhileLogin(), Common.message.getProperty("errorDuringLogin"));
		vendorLicensee.mobileLoginButton();
		vendorLicensee.enterMobileNumber("8800857741");
		vendorLicensee.clickSendOtpButton();
		Assert.assertEquals(vendorLicensee.errorMobileMmessageWhenLogin(), Common.message.getProperty("errorDuringLogin"));
	}
	
}

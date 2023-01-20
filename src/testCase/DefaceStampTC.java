package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Common;
import objectRepo.DefaceStamp;


public class DefaceStampTC {
	
	DefaceStamp deface;
	
	@BeforeMethod
	public void Browser() throws IOException
	{
		Common.browserSetup();
		Common.login();
		deface = new DefaceStamp(Common.driver);
	}
	
	
//	@AfterMethod
//	public void afterExecution()
//	{
//		Common.logout();
//		Common.driver.close();
//	}
//	
	
	@Test(enabled = true)
	public void TC_318()
	{
		deface.defaceStampMenu();
//		deface.defaceStampMenuValidation();
		Assert.assertEquals(deface.submenu1Label().getText(), Common.message.getProperty("submenu1"));
		Assert.assertEquals(deface.submenu2Label().getText(), Common.message.getProperty("submenu2"));
		Assert.assertEquals(deface.submenu3Label().getText(), Common.message.getProperty("submenu3"));
	}
	
	@Test(enabled = true)
	public void TC_319()
	{
		deface.defaceStampMenu();
		deface.submenu1();
//		deface.defaceStampMsg();
		Assert.assertEquals(deface.defaceStampMsg().getText(), Common.message.getProperty("defaceStampMsg"));
	}
	
	@Test(enabled = true)
	public void TC_320() throws InterruptedException, IOException
	{
		deface.defaceStampMenu();
		deface.submenu1();
		Common.validateScreen("TC_320.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_321()
	{
		deface.defaceStampMenu();
		deface.submenu1();		
//		deface.currentDateValidate();
		Assert.assertEquals(deface.fromDateReturn().getAttribute("value"), Common.currentDate());
		Assert.assertEquals(deface.toDateReturn().getAttribute("value"), Common.currentDate());
	}
	
	@Test(enabled = false)
	public void TC_322()
	{
//		TC_323 and TC_324 has been covered in this test Case
		
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("01-May-2022");
		deface.toDate("06-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.submitButton();
//		deface.reportValidate();
		Assert.assertEquals(deface.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_325()
	{
//		TC_325 and TC_326 are the same
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("05-Dec-2022");
		deface.toDate("04-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.submitButton();
//		deface.toDateBeforeFromDate();
		Assert.assertEquals(deface.toDateBeforeFromDate().getText(), Common.message.getProperty("toDateBeforeFromDate"));
	}
	
	@Test(enabled = true)
	public void TC_327()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("01-May-2022");
		deface.toDate("04-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.allMeterSelectedValidate();
		deface.submitButton();
//		deface.reportValidate();
		Assert.assertEquals(deface.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_328()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("01-Jan-2022");
		deface.toDate("04-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.singleMeterSelect();
		deface.licenseeDropdownOpenClose();
		deface.validateAfterSearch();
		deface.submitButton();
//		deface.reportValidate();
		Assert.assertEquals(deface.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_329() throws InterruptedException, IOException
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("01-Jan-2022");
		deface.toDate("04-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.selectMultipleMeter();
		deface.licenseeDropdownOpenClose();
		Common.validateScreen("TC_329.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_330()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("01-Jan-2022");
		deface.toDate("04-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.searchMeter("3815272");
//		report.allMeter().click();
		deface.singleMeterSelect();
		deface.licenseeDropdownOpenClose();
//		deface.validateAfterSearch();
		Assert.assertEquals(deface.validateAfterSearch().getText(), Common.message.getProperty("singleMeterSelected"));
	}
	
	@Test(enabled = true)
	public void TC_331()
	{
		deface.defaceStampMenu();
		deface.submenu1();
//		deface.noMeterSelected();
		Assert.assertEquals(deface.noMeterSelected().getText(), Common.message.getProperty("noMeterSelected"));
	}
	
	@Test(enabled = true)
	public void TC_332()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("01-Nov-2022");
		deface.toDate("06-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.submitButton();
//		deface.noRecordMsg();
		Assert.assertEquals(deface.noRecordMsg().getText(), Common.message.getProperty("noRecordMsg"));
	}

	@Test(enabled = true)
	public void TC_333()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("31-May-2022");
		deface.toDate("31-May-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.submitButton();
//		deface.reportValidate();
		Assert.assertEquals(deface.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_334()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("31-May-2022");
		deface.toDate("06-Jun-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.submitButton();
//		deface.reportValidate();
		Assert.assertEquals(deface.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_335()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("31-May-2022");
		deface.toDate("30-Jun-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.submitButton();
//		deface.reportValidate();
		Assert.assertEquals(deface.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_336()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("15-Dec-2021");
		deface.toDate("13-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.submitButton();
//		deface.reportValidate();
		Assert.assertEquals(deface.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_337()
	{
		deface.defaceStampMenu();
		deface.submenu1();
		deface.fromDate("15-Dec-2012");
		deface.toDate("13-Dec-2022");
		deface.licenseeDropdownOpenClose();
		deface.allMeter();
		deface.licenseeDropdownOpenClose();
		deface.submitButton();
//		deface.reportValidate();
		Assert.assertEquals(deface.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
}

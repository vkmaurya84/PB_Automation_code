package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Common;
import objectRepo.DefaceReport;


public class DefaceReportTC {
	
	DefaceReport deface_report;
	
	@BeforeMethod
	public void Browser() throws IOException
	{
		Common.browserSetup();
		Common.login();
		deface_report = new DefaceReport(Common.driver);

	}
	
//	@AfterMethod
//	public void afterExecution()
//	{
//		Common.logout();
//		Common.driver.close();
//	}
	
	
	@Test(enabled = true)
	public void TC_338()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.defaceReportMsg();
		Assert.assertEquals(deface_report.defaceReportMsg().getText(), Common.message.getProperty("defaceReportMsg"));
	}
	
	@Test(enabled = true)
	public void TC_339() throws InterruptedException, IOException
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		Common.validateScreen("TC_339.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_340()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
//		deface_report.currentDateValidate();
		Assert.assertEquals(deface_report.fromDateReturn().getAttribute("value"), Common.currentDate());
		Assert.assertEquals(deface_report.toDateReturn().getAttribute("value"), Common.currentDate());
	}
	
	@Test(enabled = true)
	public void TC_341()
	{
//		TC_342 and TC_343 has been covered in this test Case
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("01-May-2022");
		deface_report.toDate("06-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.submitButton();
//		deface_report.reportValidate();
		Assert.assertEquals(deface_report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_344()
	{
//		TC_344 and TC_345 are the same
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("05-Dec-2022");
		deface_report.toDate("04-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.submitButton();
//		deface_report.toDateBeforeFromDate();
		Assert.assertEquals(deface_report.toDateBeforeFromDate().getText(), Common.message.getProperty("toDateBeforeFromDate"));
	}
	
	@Test(enabled = true)
	public void TC_346()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("01-May-2022");
		deface_report.toDate("04-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeterSelectedValidate();
		deface_report.submitButton();
//		deface_report.reportValidate();
		Assert.assertEquals(deface_report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_347()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("01-May-2022");
		deface_report.toDate("04-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.singleMeterSelect();
		deface_report.licenseeDropdownOpenClose();
		deface_report.validateAfterSearch();
		deface_report.submitButton();
//		deface_report.reportValidate();
		Assert.assertEquals(deface_report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_348() throws InterruptedException, IOException
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("01-May-2022");
		deface_report.toDate("04-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.selectMultipleAlias();
		deface_report.licenseeDropdownOpenClose();
		Common.validateScreen("TC_348.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_349()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("01-May-2022");
		deface_report.toDate("04-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.searchMeter("3815272");
//		report.allMeter().click();
		deface_report.singleMeterSelect();
		deface_report.licenseeDropdownOpenClose();
//		deface_report.validateAfterSearch();
		Assert.assertEquals(deface_report.validateAfterSearch().getText(), Common.message.getProperty("singleMeterSelected"));
	}
	
	@Test(enabled = true)
	public void TC_350()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
//		deface_report.noMeterSelected();
		Assert.assertEquals(deface_report.noMeterSelected().getText(), Common.message.getProperty("noMeterSelected"));
	}
	
	@Test(enabled = true)
	public void TC_351()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("01-Nov-2022");
		deface_report.toDate("06-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.submitButton();
//		deface_report.noRecordMsg();
		Assert.assertEquals(deface_report.noRecordMsg().getText(), Common.message.getProperty("noRecordMsg"));
	}
	
	@Test(enabled = true)
	public void TC_352()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("31-Jan-2022");
		deface_report.toDate("31-Jan-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.submitButton();
//		deface_report.reportValidate();
		Assert.assertEquals(deface_report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_353()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("31-Jan-2022");
		deface_report.toDate("07-Feb-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.submitButton();
//		deface_report.reportValidate();
		Assert.assertEquals(deface_report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_354()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("31-Jan-2022");
		deface_report.toDate("02-Mar-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.submitButton();
//		deface_report.reportValidate();
		Assert.assertEquals(deface_report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_355()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("15-Dec-2021");
		deface_report.toDate("13-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.submitButton();
//		deface_report.reportValidate();
		Assert.assertEquals(deface_report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_356()
	{
		deface_report.defaceStampMenu();
		deface_report.submenu2();
		deface_report.fromDate("01-Dec-2012");
		deface_report.toDate("13-Dec-2022");
		deface_report.licenseeDropdownOpenClose();
		deface_report.allMeter();
		deface_report.licenseeDropdownOpenClose();
		deface_report.submitButton();
//		deface_report.reportValidate();
		Assert.assertEquals(deface_report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
}

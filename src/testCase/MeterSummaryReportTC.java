package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Common;
import objectRepo.MeterSummaryReport;


public class MeterSummaryReportTC {
	
	MeterSummaryReport report;
	
	@BeforeMethod
	public void Browser() throws IOException
	{
		Common.browserSetup();
		Common.login();
		report = new MeterSummaryReport(Common.driver);
		
	}
	
//	@AfterMethod
//	public void afterExecution()
//	{
//		Common.logout();
//		Common.driver.close();
//	}
	
	
	@Test(enabled = true)
	public void TC_306()
	{
		report.Menu();
		report.misSubMenu();
		report.fromDate("01-Jan-2022");
		report.toDate("06-Dec-2022");
		report.aliasSelect();
		report.allMeter();
		report.licenseeDropdownClose();
		report.submitButton();
//		report.reportValidate();
		Assert.assertEquals(report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_307()
	{
//		TC_307 and TC_308 are same
		report.Menu();
		report.misSubMenu();
		report.fromDate("05-Dec-2022");
		report.toDate("04-Dec-2022");
		report.aliasSelect();
		report.allMeter();
		report.licenseeDropdownClose();
		report.submitButton();
//		report.toDateBeforeFromDate();
		Assert.assertEquals(report.toDateBeforeFromDate().getText(), Common.message.getProperty("toDateBeforeFromDate"));
	}
	
	@Test(enabled = true)
	public void TC_309()
	{
		report.Menu();
		report.misSubMenu();
		report.fromDate("01-Jan-2022");
		report.toDate("04-Dec-2022");
		report.aliasSelect();
		report.singleMeterSelect();
		report.licenseeDropdownClose();
		report.validateAfterSearch();
		report.submitButton();
//		report.reportValidate();
		Assert.assertEquals(report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_310()
	{
		report.Menu();
		report.misSubMenu();
		report.fromDate("01-Jan-2022");
		report.toDate("04-Dec-2022");
		report.aliasSelect();
		report.searchMeter("3815272");
		report.allMeter();
		report.licenseeDropdownClose();
//		report.validateAfterSearch();
		Assert.assertEquals(report.validateAfterSearch().getText(), Common.message.getProperty("singleMeterSelected"));
	}
	
	@Test(enabled = true)
	public void TC_311()
	{
		report.Menu();
		report.misSubMenu();
		report.submitButton();
//		report.noMeterSelected();
		Assert.assertEquals(report.noMeterSelected().getText(), Common.message.getProperty("noMeterSelected"));
	}
	
	@Test(enabled = true)
	public void TC_312()
	{
		report.Menu();
		report.misSubMenu();
		report.fromDate("01-Nov-2022");
		report.toDate("06-Dec-2022");
		report.aliasSelect();
		report.allMeter();
		report.licenseeDropdownClose();
		report.submitButton();
//		report.noRecordMsg();
		Assert.assertTrue(report.noRecordMsg().getText().contains("No Records Found\nकोई रिकॉर्ड नहीं मिला"));
	}
	
	@Test(enabled = true)
	public void TC_313()
	{
		report.Menu();
		report.misSubMenu();
		report.fromDate("13-May-2022");
		report.toDate("13-May-2022");
		report.aliasSelect();
		report.allMeter();
		report.licenseeDropdownClose();
		report.submitButton();
//		report.reportValidate();
		Assert.assertEquals(report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_314()
	{
		report.Menu();
		report.misSubMenu();
		report.fromDate("13-May-2022");
		report.toDate("19-May-2022");
		report.aliasSelect();
		report.allMeter();
		report.licenseeDropdownClose();
		report.submitButton();
//		report.reportValidate();
		Assert.assertEquals(report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_315()
	{
		report.Menu();
		report.misSubMenu();

		report.fromDate("13-May-2022");
		report.toDate("13-Jun-2022");
		report.aliasSelect();
		report.allMeter();
		report.licenseeDropdownClose();
		report.submitButton();
//		report.reportValidate();
		Assert.assertEquals(report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_316()
	{
		report.Menu();
		report.misSubMenu();
		report.fromDate("07-Dec-2021");
		report.toDate("07-Dec-2022");
		report.aliasSelect();
		report.allMeter();
		report.licenseeDropdownClose();
		report.submitButton();
//		report.reportValidate();
		Assert.assertEquals(report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}
	
	@Test(enabled = true)
	public void TC_317()
	{
		report.Menu();
		report.misSubMenu();
		report.fromDate("07-Dec-2012");
		report.toDate("07-Dec-2022");
		report.aliasSelect();
		report.allMeter();
		report.licenseeDropdownClose();
		report.submitButton();
//		report.reportValidate();
		Assert.assertEquals(report.reportValidate().getText(), Common.message.getProperty("meterNo"));
	}

}

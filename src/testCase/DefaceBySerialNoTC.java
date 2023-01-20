package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Common;
import objectRepo.DefaceBySerialNo;


public class DefaceBySerialNoTC {
	
	@BeforeMethod
	public void Browser() throws IOException
	{
		Common.browserSetup();
		Common.login();
		deface_by_id = new DefaceBySerialNo(Common.driver);
		
	}
	
//	@AfterMethod
//	public void afterExecution()
//	{
//		Common.logout();
//		Common.driver.close();
//	}
	
	DefaceBySerialNo deface_by_id;
	
	@Test(enabled = true)
	public void TC_358()
	{
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu3();
//		deface_by_id.defaceBySerialIdMsg();
		Assert.assertEquals(deface_by_id.defaceBySerialIdMsg().getText(), Common.message.getProperty("defaceStampBySerialId"));
	}
	
	@Test(enabled = true)
	public void TC_359() throws InterruptedException, IOException
	{
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu3();
		Common.validateScreen("TC_359.png");
		Assert.assertFalse(Common.diff.hasDiff(),"Images are not Same");
	}
	
	@Test(enabled = true)
	public void TC_360()
	{
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu1();
		deface_by_id.fromDate("01-May-2022");
		deface_by_id.toDate("06-Dec-2022");
		deface_by_id.aliasSelect();
		deface_by_id.allMeter();
		deface_by_id.licenseeDropdownClose();
		deface_by_id.submitButton();
		deface_by_id.stampSerialNo();
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu3();
		deface_by_id.serialNo(deface_by_id.Stampserial);
		deface_by_id.submitButton();
//		deface_by_id.reportValidate();
		Assert.assertEquals(deface_by_id.reportValidate().getText(), Common.message.getProperty("meterNo"));
//		deface_by_id.defaceBtnValidate();
		Assert.assertEquals(deface_by_id.defaceBtnValidate().getText(), Common.message.getProperty("BtnValidate"));
	}
	
	@Test(enabled = true)
	public void TC_361()
	{
//		TC_357 is covered in this Test Case
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu1();
		deface_by_id.fromDate("01-May-2022");
		deface_by_id.toDate("06-Dec-2022");
		deface_by_id.aliasSelect();
		deface_by_id.allMeter();
		deface_by_id.licenseeDropdownClose();
		deface_by_id.submitButton();
		deface_by_id.stampSerialNo();
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu3();
		deface_by_id.serialNo(deface_by_id.Stampserial);
		deface_by_id.submitButton();
		deface_by_id.defaceBtn();
		deface_by_id.defaceConfirmButton();
//		deface_by_id.defaceConfirmMsg();
		Assert.assertTrue(deface_by_id.defaceConfirmMsg().getText().contains("Serial Number "+deface_by_id.Stampserial+" is Defaced Successfully"));
	}
	
	@Test(enabled = true)
	public void TC_362()
	{
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu3();
		deface_by_id.invalidSerialNo();
		deface_by_id.submitButton();
//		deface_by_id.noRecordMsg();
		Assert.assertEquals(deface_by_id.noRecordMsg().getText(), Common.message.getProperty("noRecordMsg"));
	}
	
	@Test(enabled = true)
	public void TC_363()
	{
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu2();
		deface_by_id.fromDate("01-May-2022");
		deface_by_id.toDate("06-Dec-2022");
		deface_by_id.aliasSelect();
		deface_by_id.allMeter();
		deface_by_id.licenseeDropdownClose();
		deface_by_id.submitButton();
		deface_by_id.reportSerialNo();
		deface_by_id.defaceStampMenu();
		deface_by_id.submenu3();
		deface_by_id.serialNo(deface_by_id.reportSerial);
		deface_by_id.submitButton();
//		deface_by_id.defacedBtnValidate();
		Assert.assertEquals(deface_by_id.defacedBtnValidate().getText(), Common.message.getProperty("defacedBtn"));
	}

}

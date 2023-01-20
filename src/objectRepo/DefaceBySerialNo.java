package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import common.Common;

public class DefaceBySerialNo {
	
	WebDriver driver;
	
	public DefaceBySerialNo(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='navbarSupportedContent']/ul/li[5]")
	WebElement defaceStampMenu;
	
	@FindBy(xpath = "//a[@id='defaceTranaction']")
	WebElement defaceStampSubmenu1;
	
	@FindBy(xpath = "//a[@id='defaceTranactionReport']")
	WebElement defaceStampSubmenu2;
	
	@FindBy(xpath = "//a[@id='defaceTransactionSerial']")
	WebElement defaceStampSubmenu3;
	
	@FindBy(xpath = "//h1[contains(text(),'Deface Stamp By Serial Id')]")
	WebElement defaceBySerialIdMsg;

//	By deface_by_serial_id_msg = By.xpath("//h1[contains(text(),'Deface Stamp By Serial Id')]");
	
	
	@FindBy(xpath = "//input[@id='fromDate']")
	WebElement fromDate;
	
	@FindBy(xpath = "//input[@id='toDate']")
	WebElement toDate;
	
	@FindBy(xpath = "//span[contains(text(),'None selected')]")
	WebElement alias;
	
	@FindBy(xpath = "//label[contains(text(),'Select all')]")
	WebElement allMeter;
	
	@FindBy(xpath = "//span[@class='multiselect-native-select']/div/button")
	WebElement licenseeDropdown;
	
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement submit;
	
	@FindBy(xpath = "//table[@id='row']/tbody/tr[1]/td[5]")
	WebElement defaceStampserialNo;
	
	@FindBy(xpath = "//input[@id='serialNo']")
	WebElement serialNo;
	
	@FindBy(xpath = "//th[contains(text(),'Meter No')]")
	WebElement meterMsg;
	
	@FindBy(xpath = "//div[contains(text(),'No Records Found')]")
	WebElement noRecordMsg;
	
	@FindBy(xpath = "//button[@id='defaceBtn']")
	WebElement defaceBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Yes, Deface it!')]")
	WebElement defaceConfirmBtn;
	
	@FindBy(xpath = "//p[@id='modal-body-id']")
	WebElement defaceConfirmMsg;
	
	@FindBy(xpath = "//body/div[@id='modal-id']//button[1]")
	WebElement defaceConfirmClose;
	
	@FindBy(xpath = "//table[@id='data']/tbody[1]/tr[1]/td[5]")
	WebElement defaceReportSerialNo;
	
	@FindBy(xpath = "//button[contains(text(),'Defaced Already')]")
	WebElement defaced;
	
	
	public void defaceStampMenu()
	{
		Common.explicitWait(defaceStampMenu);
		defaceStampMenu.click();
	}
	
	public void submenu1()
	{
		Common.explicitWait(defaceStampSubmenu1);
		defaceStampSubmenu1.click();
	}
	
	public void submenu2()
	{
		Common.explicitWait(defaceStampSubmenu2);
		defaceStampSubmenu2.click();
	}
	
	public void submenu3()
	{
		Common.explicitWait(defaceStampSubmenu3);
		defaceStampSubmenu3.click();
	}
	
	public void fromDate(String fromdate)
	{
		Common.explicitWait(fromDate);
		fromDate.clear();
		fromDate.sendKeys(fromdate);
	}
	
	public void toDate(String todate)
	{
		Common.explicitWait(toDate);
		toDate.clear();
		toDate.sendKeys(todate);
	}
	
	public void aliasSelect()
	{
		Common.explicitWait(alias);
		alias.click();
	}
	
	public void allMeter()
	{
		Common.explicitWait(allMeter);
		allMeter.click();
	}
	
	public void licenseeDropdownClose()
	{
		Common.explicitWait(licenseeDropdown);
		licenseeDropdown.click();
	}

	public void submitButton()
	{
		Common.explicitWait(submit);
		submit.click();
	}
	
	public String Stampserial;
	public void stampSerialNo()
	{
		Common.explicitWait(defaceStampserialNo);
		Stampserial = defaceStampserialNo.getText();
	}
	
	public void serialNo(String serialNum)
	{
		Common.explicitWait(serialNo);
		serialNo.clear();
		serialNo.sendKeys(serialNum);
	}
	
	public void invalidSerialNo()
	{
		Common.explicitWait(serialNo);
		serialNo.clear();
		serialNo.sendKeys("0000000000");
	}
	
	public WebElement defaceConfirmMsg()
	{
		Common.explicitWait(defaceConfirmMsg);
//		String Msg = defaceConfirmMsg.getText();
//		System.out.println("Serial Number "+serial+" is Defaced Successfully");
		return defaceConfirmMsg;
//		Assert.assertTrue(defaceConfirmMsg.getText().contains("Serial Number "+Stampserial+" is Defaced Successfully"));
	}
	public void defaceConfirmDialogClose()
	{
//		Close the dialog after deface message
		Common.explicitWait(defaceConfirmClose);
		defaceConfirmClose.click();
	}
	
	
	public void defaceBtn()
	{
		Common.explicitWait(defaceBtn);
		defaceBtn.click();
	}
	
	public WebElement defaceBtnValidate()
	{
		Common.explicitWait(defaceBtn);
		return defaceBtn;
//		Assert.assertEquals(defaceBtn.getText(), Common.message.getProperty("BtnValidate"));
	}
	
	public WebElement defacedBtnValidate()
	{
		Common.explicitWait(defaced);
		return defaced;
//		Assert.assertEquals(defaced.getText(), Common.message.getProperty("defacedBtn"));
	}
	
	public void defaceConfirmButton()
	{
		Common.explicitWait(defaceConfirmBtn);
		defaceConfirmBtn.click();
	}
	
	public String reportSerial;
	public void reportSerialNo()
	{
		Common.explicitWait(defaceReportSerialNo);
		reportSerial = defaceReportSerialNo.getText();
	}
	
	public WebElement reportValidate()
	{
		Common.explicitWait(meterMsg);
//		return driver.findElement(meter_msg);
		return meterMsg;
//		Assert.assertEquals(meter_msg.getText(), Common.message.getProperty("meterNo"));
	}
	
	public WebElement noRecordMsg()
	{
		Common.explicitWait(noRecordMsg);
//		return driver.findElement(no_record_msg);
		return noRecordMsg;
//		Assert.assertEquals(no_record_msg.getText(), Common.message.getProperty("noRecordMsg"));
	}
	
	public WebElement defaceBySerialIdMsg()
	{
		Common.explicitWait(defaceBySerialIdMsg);
//		return driver.findElement(deface_by_serial_id_msg);
		return defaceBySerialIdMsg;
//		Assert.assertEquals(deface_by_serial_id_msg.getText(), Common.message.getProperty("defaceStampBySerialId"));
	}
	
}

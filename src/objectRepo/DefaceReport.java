package objectRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.Common;

public class DefaceReport {
	
	WebDriver driver;
	
	public DefaceReport(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='navbarSupportedContent']/ul/li[5]")
	WebElement defaceStampMenu;
	
	@FindBy(xpath = "//a[@id='defaceTranactionReport']")
	WebElement defaceStampSubmenu2;
	
	@FindBy(xpath = "//h1[contains(text(),'Deface Report')]")
	WebElement defaceReportMsg;
	
	
//	By deface_report_msg = By.xpath("//h1[contains(text(),'Deface Report')]");
	
	@FindBy(xpath = "//input[@id='fromDate']")
	WebElement fromDate;
	
	@FindBy(xpath = "//input[@id='toDate']")
	WebElement toDate;
	
//	@FindBy(xpath = "//span[contains(text(),'None selected')]")
//	WebElement alias;
	
	@FindBy(xpath = "//label[contains(text(),'Select all')]")
	WebElement allMeter;
	
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	WebElement licenseeDropdown;
	
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement submit;
	
	
	@FindBy(xpath = "//label[contains(text(),'3815272')]")
	WebElement singleMeter;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchMeter;
	
	
	@FindBy(xpath = "//th[contains(text(),'Meter No')]")
	WebElement meterMessage;
	
	@FindBy(xpath = "//p[@id='modal-body-id']")
	WebElement beforeFromDateMsg;
	
	@FindBy(xpath = "//div[contains(text(),'No Records Found')]")
	WebElement noRecordMsg;
	
	@FindBy(xpath = "//span[@class='multiselect-native-select']//ul[1]/li[3]")
	WebElement selectAlias1;
	
	@FindBy(xpath = "//span[@class='multiselect-native-select']//ul[1]/li[4]")
	WebElement selectAlias2;

	
	
	public void defaceStampMenu()
	{
		Common.explicitWait(defaceStampMenu);
		defaceStampMenu.click();
	}
	
	public void submenu2()
	{
		Common.explicitWait(defaceStampSubmenu2);
		defaceStampSubmenu2.click();
	}
	
	public WebElement fromDateReturn()
	{
		Common.explicitWait(fromDate);
		return fromDate;
//		Assert.assertEquals(from_date.getAttribute("value"), Common.currentDate());
//		Assert.assertEquals(to_date.getAttribute("value"), Common.currentDate());
	}
	
	public WebElement toDateReturn()
	{
		Common.explicitWait(toDate);
		return toDate;
	}
	
	public WebElement defaceReportMsg()
	{
		Common.explicitWait(defaceReportMsg);
//		return driver.findElement(deface_report_msg);
		return defaceReportMsg;
//		Assert.assertEquals(deface_report_msg.getText(), Common.message.getProperty("defaceReportMsg"));
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
	
//	public void aliasSelect()
//	{
//		Common.explicitWait(alias);
//		alias.click();
//	}
	
	public void selectMultipleAlias()
	{
		Common.explicitWait(selectAlias1);
		selectAlias1.click();
		selectAlias2.click();
	}
	
	public void allMeter()
	{
		Common.explicitWait(allMeter);
		allMeter.click();
	}
	
	public void licenseeDropdownOpenClose()
	{
		Common.explicitWait(licenseeDropdown);
		licenseeDropdown.click();
	}
	
	public void allMeterSelectedValidate()
	{
		String[] dropdownText = licenseeDropdown.getText().split(" ");
		Assert.assertEquals(dropdownText[0]+" "+dropdownText[1], Common.message.getProperty("allMeterSelected"));
	}
	
	public void submitButton()
	{
		Common.explicitWait(submit);
		submit.click();
	}
	
	public WebElement reportValidate()
	{
		Common.explicitWait(meterMessage);
//		return driver.findElement(meter_msg);
		return meterMessage;
//		Assert.assertEquals(meter_msg.getText(), Common.message.getProperty("meterNo"));
	}
	
	public WebElement toDateBeforeFromDate()
	{
		Common.explicitWait(beforeFromDateMsg);
//		return driver.findElement(before_fromDate_msg);
		return beforeFromDateMsg;
//		Assert.assertEquals(before_fromDate_msg.getText(), Common.message.getProperty("toDateBeforeFromDate"));
	}
	
	public void singleMeterSelect()
	{
		Common.explicitWait(singleMeter);
//		return driver.findElement(single_meter);
		singleMeter.click();
//		Assert.assertEquals(single_meter.getText(), Common.message.getProperty("singleMeterSelected"));
	}
	
	public void searchMeter(String meterno)
	{
		Common.explicitWait(searchMeter);
		searchMeter.sendKeys(meterno);
		
	}
	
	public WebElement validateAfterSearch()
	{
		return licenseeDropdown;
//		Assert.assertEquals(licensee_dropdown.getText(), Common.message.getProperty("singleMeterSelected"));
	}
	
	public WebElement noMeterSelected()
	{
		return licenseeDropdown;
//		Assert.assertEquals(alias.getText(), Common.message.getProperty("noMeterSelected"));
	}
	
	public WebElement noRecordMsg()
	{
		Common.explicitWait(noRecordMsg);
//		return driver.findElement(no_record_msg);
		return noRecordMsg;
//		Assert.assertEquals(no_record_msg.getText(), Common.message.getProperty("noRecordMsg"));
	}


}

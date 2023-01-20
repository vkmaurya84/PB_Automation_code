package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import common.Common;

public class MeterSummaryReport {
	
	WebDriver driver;
	
	public MeterSummaryReport(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Meter MIS')]")
	WebElement misMenu;
	
	@FindBy(xpath = "//a[@id='dailyreport']")
	WebElement submenu;
	
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
	
	
	@FindBy(xpath = "//label[contains(text(),'3815272')]")
	WebElement singleMeter;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchMeter;
	
	
	@FindBy(xpath = "//th[contains(text(),'Meter No')]")
	WebElement meterMsg;
	
	@FindBy(xpath = "//p[@id='modal-body-id']")
	WebElement beforeFromDateMsg;
	
	@FindBy(xpath = "//div[contains(text(),'No Records Found')]")
	WebElement noRecordMsg;

	
	
//	By mis_menu = By.xpath("//a[contains(text(),'Meter MIS')]");
//	By submenu = By.xpath("//a[@id='dailyreport']");
//	By from_date = By.xpath("//input[@id='fromDate']");
//	By to_date = By.xpath("//input[@id='toDate']");
//	By alias = By.xpath("//span[contains(text(),'None selected')]");
//	By all_meter = By.xpath("//label[contains(text(),'Select all')]");
//	By licensee_dropdown = By.xpath("//span[@class='multiselect-native-select']/div/button");
//	By submit = By.xpath("//div[contains(text(),'SUBMIT')]");
	
//	By single_meter = By.xpath("//label[contains(text(),'3815272')]");
//	By search_meter = By.xpath("//input[@placeholder='Search']");
	
//	By meter_msg = By.xpath("//th[contains(text(),'Meter No')]");
//	By before_fromDate_msg = By.xpath("//p[@id='modal-body-id']");
//	By no_record_msg = By.xpath("//div[contains(text(),'No Records Found')]");
	
	
	
	
	
	public void Menu()
	{
		Common.explicitWait(misMenu);
//		driver.findElement(mis_menu);
		misMenu.click();
	}
	
	public void misSubMenu()
	{
		Common.explicitWait(submenu);
		submenu.click();;
	}
	
	public void fromDate(String fromdate)
	{
		Common.explicitWait(fromDate);
		fromDate.clear();
		fromDate.sendKeys(fromdate);
	}
	
	public void toDate(String todate)
	{
		Common.explicitWait(fromDate);
		fromDate.clear();
		fromDate.sendKeys(todate);
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
	
	public WebElement reportValidate()
	{
		Common.explicitWait(meterMsg);
//		return driver.findElement(meter_msg);
		return meterMsg;
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
		return alias;
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

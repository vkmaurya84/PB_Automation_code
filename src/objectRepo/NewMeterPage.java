package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Common;

public class NewMeterPage {
	
	WebDriver driver;

	public NewMeterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//li/a[contains(text(),'User Management')]")
	WebElement userMgtMenu;
	
	@FindBy(xpath = "//a[@id='camlist']")
	WebElement userMgtSubmenu2;
	
	@FindBy(xpath = "//a[contains(text(),'Add Meter')]")
	WebElement addMeter;
	
	@FindBy(xpath = "//input[@id='camSerialNo']")
	WebElement camSerialNo;
	
	@FindBy(xpath = "//input[@id='licenseNo']")
	WebElement licenseNo;
	
	@FindBy(xpath = "//input[@id='validFromDate']")
	WebElement validFromDate;
	
	@FindBy(xpath = "//input[@id='validToDate']")
	WebElement validToDate;
	
	@FindBy(xpath = "//input[@id='alias']")
	WebElement alias;
	
	@FindBy(xpath = "//input[@id='account']")
	WebElement account;
	
	@FindBy(xpath = "//select[@id='camusers']")
	WebElement camUser;
	
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement submit;
	
	@FindBy(xpath = "//div[contains(text(),'CANCEL')]")
	WebElement cancel;
	
	@FindBy(xpath = "//div[@class='long-content-wrapper-2']/div[2]")
	WebElement addedMeterMessage;
	
	@FindBy(xpath = "//h1[contains(text(),'Vendor License-Meter Management')]")
	WebElement vendorLicenseLabel;
	
	@FindBy(xpath = "//span[@id='camSerialNo.errors']")
	WebElement camSerialNumberError;
	
	@FindBy(xpath = "//span[@id='licenseNo.errors']")
	WebElement licenseNumberError;
	
	@FindBy(xpath = "//span[@id='constraint1Satisfied.errors']")
	WebElement validToDateError;
	
	@FindBy(xpath = "//span[@id='constraint2Futiristic.errors']")
	WebElement validFromDateError;
	
	@FindBy(xpath = "//span[@id='alias.errors']")
	WebElement licenseeNameError;
	
	@FindBy(xpath = "//span[@id='account.errors']")
	WebElement accountError;
	
	
	public void userManagementMenu()
	{
		Common.explicitWait(userMgtMenu);
		userMgtMenu.click();
	}
	
	public void userManagementSubmenu2()
	{
		Common.explicitWait(userMgtSubmenu2);
		userMgtSubmenu2.click();
	}
	
	public void clickOnAddMeter()
	{
		Common.explicitWait(addMeter);
		addMeter.click();
	}
	
	public void enterCamSerialNumber(String camNumber)
	{
		Common.explicitWait(camSerialNo);
		camSerialNo.clear();
		camSerialNo.sendKeys(camNumber);
	}
	
	public void enterLicenseNumber(String licenseNumber)
	{
		Common.explicitWait(licenseNo);
		licenseNo.clear();
		licenseNo.sendKeys(licenseNumber);
	}
	
	public void enterValidFromDate(String fromDate)
	{
		Common.explicitWait(validFromDate);
		validFromDate.clear();
		validFromDate.sendKeys(fromDate);
	}
	
	public void enterValidToDate(String toDate)
	{
		Common.explicitWait(validToDate);
		validToDate.clear();
		validToDate.sendKeys(toDate);
	}
	
	public void enterAliasName(String aliasName)
	{
		Common.explicitWait(alias);
		alias.clear();
		alias.sendKeys(aliasName);
	}
	
	public void enterAccountNumber(String accountNumber)
	{
		Common.explicitWait(account);
		account.clear();
		account.sendKeys(accountNumber);
	}
	
	public void selectCamUser(String camUserValue)
	{
		Common.explicitWait(camUser);
		Select value = new Select(camUser);
		value.selectByValue(camUserValue);
	}
	
	public void clickSubmitButton()
	{
		Common.explicitWait(submit);
		submit.click();
	}
	
	public void clickCancelbutton()
	{
		Common.explicitWait(cancel);
		cancel.click();
	}
	
	public String validateAddedMeterLabel()
	{
		Common.explicitWait(addedMeterMessage);
		return addedMeterMessage.getText();
	}
	
	public String validateVendorLicenseLabel()
	{
		Common.explicitWait(vendorLicenseLabel);
		return vendorLicenseLabel.getText();
	}
	
	public String validateCamSerialNumberError()
	{
		Common.explicitWait(camSerialNumberError);
		return camSerialNumberError.getText();
	}
	
	public String validateLicenseError()
	{
		Common.explicitWait(licenseNumberError);
		return licenseNumberError.getText();
	}
	
	public String validateToDateError()
	{
		Common.explicitWait(validToDateError);
		return validToDateError.getText();
	}
	
	public String validateFromDateError()
	{
		Common.explicitWait(validFromDateError);
		return validFromDateError.getText();
	}
	
	public String validateLicenseeNameError()
	{
		Common.explicitWait(licenseeNameError);
		return licenseeNameError.getText();
	}
	
	public String validateAccountError()
	{
		Common.explicitWait(accountError);
		return accountError.getText();
	}

}

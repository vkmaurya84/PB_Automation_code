package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Common;

public class EditMeterPage {
	
	WebDriver driver;

	public EditMeterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li/a[contains(text(),'User Management')]")
	WebElement userMgtMenu;
	
	@FindBy(xpath = "//a[@id='camlist']")
	WebElement userMgtSubmenu2;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//tbody/tr[1]/td[8]/a")
	WebElement ActionButton;
	
	@FindBy(xpath = "//input[@id='licenseNo']")
	WebElement licenseNo;
	
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement submit;
	
	@FindBy(xpath = "//div[contains(text(),'CANCEL')]")
	WebElement cancel;
	
	@FindBy(xpath = "//div[@class='long-content-wrapper-2']/div[2]")
	WebElement editMeterMessage;
	
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
	
	@FindBy(xpath = "//h1[contains(text(),'Vendor License-Meter Management')]")
	WebElement vendorLicenseLabel;
	
	
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
	
	public void searchBox(String parameter)
	{
		Common.explicitWait(searchField);
		searchField.clear();
		searchField.sendKeys(parameter);
	}
	
	public void clickActionButton()
	{
		Common.explicitWait(ActionButton);
		ActionButton.click();
	}
	
	public void enterLicenseNumber(String licenseNumber)
	{
		Common.explicitWait(licenseNo);
		licenseNo.clear();
		licenseNo.sendKeys(licenseNumber);
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
	
	public String validateEditMeterLabel()
	{
		Common.explicitWait(editMeterMessage);
		return editMeterMessage.getText();
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
	
	public String validateVendorLicenseLabel()
	{
		Common.explicitWait(vendorLicenseLabel);
		return vendorLicenseLabel.getText();
	}

}

package objectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Common;

public class VenedorLicenseeManagementPage {
	
	WebDriver driver;
	public String pdfButtonLabel;
	public String excelButtonLabel;
	public String deactiveMeter;
	public String selectMeterDropdownLabel;

	public VenedorLicenseeManagementPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li/a[contains(text(),'User Management')]")
	WebElement userMgtMenu;
	
	@FindBy(xpath = "//a[@id='manageuser']")
	WebElement userMgtSubmenu1;
	
	@FindBy(xpath = "//a[@id='camlist']")
	WebElement userMgtSubmenu2;
	
	@FindBy(xpath = "//h1[contains(text(),'Vendor License-Meter Management')]")
	WebElement vendorLicenseLabel;
	
	@FindBy(xpath = "//select[@name='data_length']")
	WebElement select;
	
	@FindBy(xpath = "//table[@id='data']/tbody")
	WebElement rows;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//tbody/tr[1]")
	WebElement record;
	
	@FindBy(xpath = "//span[contains(text(),'PDF')]")
	WebElement clickPdf;
	
	@FindBy(xpath = "//span[contains(text(),'Excel')]")
	WebElement clickExcel;
	
	@FindBy(xpath = "//tbody/tr[1]/td[8]/a")
	WebElement ActionButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Edit Meter')]")
	WebElement editMeterLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Add Meter')]")
	WebElement addMeter;
	
	@FindBy(xpath = "//h1[contains(text(),'New Meter')]")
	WebElement newMeter;
	
	@FindBy(xpath = "//tbody/tr[1]//button[contains(text(),'De-Activate')]")
	WebElement deactivateButton;
	
	@FindBy(xpath = "//tbody/tr[1]//button[contains(text(),'Activate')]")
	WebElement activateButton;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement deactivatedMeter;
	
	@FindBy(xpath = "//tbody/tr[1]/td[8]")
	WebElement validateAction;
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]/a")
	WebElement userManagementAssignMeter;
	
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	WebElement selectMeterDropdown;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchMeter;
	
	@FindBy(xpath = "//div[@id='multiselectButton']/span/div/ul[1]/li[2]")
	WebElement SelectMeter;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement crossButton;
	
	
//	
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='contains_pass']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='login']")
	WebElement proceed;
	
	@FindBy(xpath = "//div[@id='invalid_credentials']")
	WebElement errorCredentialMessage;
	
	@FindBy(xpath = "//button[contains(text(),'Mobile Login')]")
	WebElement mobileLogin;
	
	@FindBy(xpath = "//input[@id='mobileNo']")
	WebElement mobileField;
	
	@FindBy(xpath = "//button[@id='sendOtp']")
	WebElement sendOtp;
	
	@FindBy(xpath = "//p[@id='invalid_mobile']")
	WebElement errorMobileMessage;
	
	
	
	public void login(String user, String pass)
	{
		Common.explicitWait(userName);
//		userName.sendKeys(unlockedUserLabel);
		userName.sendKeys(user);
		password.sendKeys(pass);
		proceed.click();
	}
	
	public void userManagementMenu()
	{
		Common.explicitWait(userMgtMenu);
		userMgtMenu.click();
	}
	
	public void userManagementSubmenu1()
	{
		Common.explicitWait(userMgtSubmenu1);
		userMgtSubmenu1.click();
	}
	
	public void userManagementSubmenu2()
	{
		Common.explicitWait(userMgtSubmenu2);
		userMgtSubmenu2.click();
	}
	
	public String validateVendorLicenseLabel()
	{
		Common.explicitWait(vendorLicenseLabel);
		return vendorLicenseLabel.getText();
	}
	
	public void selectValue()
	{
		Common.explicitWait(select);
		Select value = new Select(select);
		value.selectByValue("25");
	}
	
	public int rowLength()
	{
		List<WebElement>TotalRowsList = rows.findElements(By.tagName("tr"));
//		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		int rowSize = TotalRowsList.size();
		return rowSize;
	}
	
	public void searchBox(String parameter)
	{
		Common.explicitWait(searchField);
		searchField.clear();
		searchField.sendKeys(parameter);
	}
	
	public String validateRecord()
	{
		Common.explicitWait(record);
		return record.getTagName();
	}
	
	public void downloadPDF()
	{
		Common.explicitWait(clickPdf);
		clickPdf.click();
		pdfButtonLabel = clickPdf.getText();
	}
	
	public void downloadEXCEL()
	{
		Common.explicitWait(clickExcel);
		clickExcel.click();
		excelButtonLabel = clickExcel.getText();
	}
	
	public void clickActionButton()
	{
		Common.explicitWait(ActionButton);
		ActionButton.click();
	}
	
	public String ValidateEditMeterLabel()
	{
		Common.explicitWait(editMeterLabel);
		return editMeterLabel.getText();
	}
	
	public void clickOnAddMeter()
	{
		Common.explicitWait(addMeter);
		addMeter.click();
	}
	
	public String validateNewMeter()
	{
		Common.explicitWait(newMeter);
		return newMeter.getText();
	}
	
	public void ClickDeactivateButton()
	{
		Common.explicitWait(deactivateButton);
		deactivateButton.click();
	}
	
	public void clickActivateButton()
	{
		Common.explicitWait(activateButton);
		activateButton.click();
	}
	
	public void getDeactivatedMeter()
	{
		Common.explicitWait(deactivatedMeter);
		deactiveMeter = deactivatedMeter.getText();
	}
	
	public String validateButtonAfterDeactivation()
	{
		Common.explicitWait(activateButton);
		return activateButton.getText();
	}
	
	public String validateButtonAfterActivation()
	{
		Common.explicitWait(deactivateButton);
		return deactivateButton.getText();
	}
	
	public String validateActionButton()
	{
		Common.explicitWait(validateAction);
		return validateAction.getText();
	}
	
	public void clickOnAssignMeter()
	{
		Common.explicitWait(userManagementAssignMeter);
		userManagementAssignMeter.click();
	}
	
	public void clickMeterDropdown()
	{
		Common.explicitWait(selectMeterDropdown);
		selectMeterDropdownLabel = selectMeterDropdown.getText();
		selectMeterDropdown.click();
	}
	
	public void searchDeactiveMeter()
	{
		Common.explicitWait(searchMeter);
		searchMeter.clear();
		searchMeter.sendKeys(deactiveMeter);
//		searchMeter.sendKeys("911384");
	}
	
	public void selectSearchedMeter() throws InterruptedException
	{
		Common.explicitWait(SelectMeter);
		Thread.sleep(1000);
		SelectMeter.click();
	}
	
	public void clickOnCrossButton()
	{
		Common.explicitWait(crossButton);
		crossButton.click();
	}
	
	public String errorMessageWhileLogin()
	{
		Common.explicitWait(errorCredentialMessage);
		return errorCredentialMessage.getText();
	}
	
	public void mobileLoginButton()
	{
		Common.explicitWait(mobileLogin);
		mobileLogin.click();
	}
	
	public void enterMobileNumber(String mobileNo)
	{
		Common.explicitWait(mobileField);
		mobileField.sendKeys(mobileNo);
	}
	
	public void clickSendOtpButton()
	{
		Common.explicitWait(sendOtp);
		sendOtp.click();
	}
	
	public String errorMobileMmessageWhenLogin()
	{
		Common.explicitWait(errorMobileMessage);
		return errorMobileMessage.getText();
	}
	

}

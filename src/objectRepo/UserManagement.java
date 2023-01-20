package objectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import common.Common;

public class UserManagement {
	
WebDriver driver;

	
//	public String lockUsername = "vineet1";
//	public String lockUserPassword = "adm1234";
//	
	public UserManagement(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li/a[contains(text(),'User Management')]")
	WebElement userMgtMenu;
	
	@FindBy(xpath = "//a[@id='manageuser']")
	WebElement userMgtSubmenu1;
	
	@FindBy(xpath = "//a[@id='camlist']")
	WebElement userMgtSubmenu2;
	
	@FindBy(xpath = "//h1[contains(text(),'USER MANAGEMENT')]")
	WebElement userMgtTitle;
	
	@FindBy(xpath = "//select[@name='data_length']")
	WebElement select;
	
	@FindBy(xpath = "//table[@id='data']/tbody")
	WebElement rows;
	
	@FindBy(xpath = "//div[@id='data_filter']//input")
	WebElement userMgtSearch;
	
	@FindBy(xpath = "//table[@id='data']/thead/tr[1]/th[1]")
	WebElement recordHeader;
	
	@FindBy(xpath = "//tbody/tr[1]/td[3]/a[1]")
	WebElement removeMeterButton;
	
	@FindBy(xpath = "//tbody/tr[1]/td[3]/label[1]")
	WebElement removedMeterLabel;
	
	@FindBy(xpath = "//li[2]/a[contains(text(),'Fund Management')][1]")
	WebElement fundManagement;
	
	@FindBy(xpath = "//a[contains(text(),'Deposit Funds')]")
	WebElement depositFund;
	
	@FindBy(xpath="//span[@class='filter-option pull-left']")
	WebElement meterNo;

	@FindBy(xpath = "//form[@id='test']/div[1]/div[1]/div[1]/div[1]//input[1]")
	WebElement searchField;
	
	@FindBy(xpath = "//li[contains(text(),'No results matched')]")
	WebElement meterNotFound;
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]/a[1]/img[1]")
	WebElement actionButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Edit User')]")
	WebElement editUserLabel;
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]/a[1]/img[1]")
	WebElement meterButton;
	
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	WebElement selectMeterDropdown;
	
	@FindBy(xpath = "//div[@id='multiselectButton']//li[1]//input[1]")
	WebElement meterSearchBox;
	
	@FindBy(xpath = "//div[@id='multiselectButton']//li[2]")
	WebElement selectMeter;
	
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement submit;
	
	@FindBy(xpath = "//div[contains(text(),'Successfully Meter assign to user.')]")
	WebElement meterAssignedMessage;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement crossButton;
	
	@FindBy(xpath = "//div[contains(text(),'CANCEL')]")
	WebElement closeButton;
	
	@FindBy(xpath = "//tbody/tr[1]/td[6]/a[1]")
	WebElement unlockButton;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement unlockedUser;
	
	@FindBy(xpath = "//a[contains(text(),'New User')]")
	WebElement newUser;
	
	@FindBy(xpath = "//h1[contains(text(),'New User')]")
	WebElement newUserTitle;
	
	
//	Locator for login 
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='contains_pass']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='login']")
	WebElement proceed;
	
	@FindBy(xpath = "//h1[contains(text(),'Fund Report')]")
	WebElement unlockedUserLogin;
	
	@FindBy(xpath = "//button[contains(text(),'De-Activate')]")
	WebElement deactivateButton;
	
	@FindBy(xpath = "//button[contains(text(),'Activate')]")
	WebElement activateButton;
	
	@FindBy(xpath = "//div[@id='invalid_credentials']")
	WebElement errorMessageOfdeactiveUser;
	
	@FindBy(xpath = "//button[contains(text(),'Mobile Login')]")
	WebElement mobileLogin;
	
	@FindBy(xpath = "//input[@id='mobileNo']")
	WebElement mobileField;
	
	@FindBy(xpath = "//button[@id='sendOtp']")
	WebElement sendOtpButton;
	
	@FindBy(xpath = "//p[@id='invalid_mobile']")
	WebElement invalidMobile;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm Proceed!')]")
	WebElement deactivateConfirmation;
	
	@FindBy(xpath = "//label[contains(text(),'User Name :')]")
	WebElement loginPageValidate;
	
	
	
	
	
	public String validateNewUserTitle()
	{
		Common.explicitWait(newUserTitle);
		return newUserTitle.getText();
	}
	
	public void newUserClick()
	{
		Common.explicitWait(newUser);
		newUser.click();
	}
	
	public String validateLoginPage()
	{
		Common.explicitWait(loginPageValidate);
		return loginPageValidate.getText();
	}
	
	public void deactivateConfirmDialogButton()
	{
		Common.explicitWait(deactivateConfirmation);
		deactivateConfirmation.click();
	}
	
	public String validateMobile()
	{
		Common.explicitWait(invalidMobile);
		return invalidMobile.getText();
	}
	
	public void clickOnSendOtp()
	{
		Common.explicitWait(sendOtpButton);
		sendOtpButton.click();
	}
	
	public void enterMobileNumber(String mobile)
	{
		Common.explicitWait(mobileField);
		mobileField.clear();
		mobileField.sendKeys(mobile);
	}
	
	public void mobileLoginButton()
	{
		Common.explicitWait(mobileLogin);
		mobileLogin.click();
	}
	
	public String deactiveUser;
	public void deactivatedUsername()
	{
		Common.explicitWait(unlockedUser);
		deactiveUser = unlockedUser.getText();
	}
	
	public String errorMessageOfDeactiveUser()
	{
		Common.explicitWait(errorMessageOfdeactiveUser);
		return errorMessageOfdeactiveUser.getText();
	}
	
	public String validateDeactiveUser()
	{
		Common.explicitWait(activateButton);
		return activateButton.getText();
	}
	
	public void clickOnActivateButton()
	{
		Common.explicitWait(activateButton);
		activateButton.click();
	}
	
	public void clickOnDeactivateButton()
	{
		Common.explicitWait(deactivateButton);
		deactivateButton.click();
	}
	
	public String validateActivateButton()
	{
		Common.explicitWait(deactivateButton);
		return deactivateButton.getText();
	}
	
	public void login(String user, String pass)
	{
		Common.explicitWait(userName);
//		userName.sendKeys(unlockedUserLabel);
		userName.sendKeys(user);
		password.sendKeys(pass);
		proceed.click();
	}
	
	public String unlockedUserLoginValidate()
	{
		Common.explicitWait(unlockedUserLogin);
		return unlockedUserLogin.getText();
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
	
	public void RemoveMeter()
	{
		Common.explicitWait(removeMeterButton);
		removeMeterButton.click();
	}
	
	public String deletedMeterLabel;
	public void getDeletedMeterNo()
	{
		Common.explicitWait(removedMeterLabel);
		deletedMeterLabel = removedMeterLabel.getText();
	}
	
	public WebElement meterLable()
	{
		Common.explicitWait(removedMeterLabel);
		return removedMeterLabel;
	}
	
	public void clickActionButton()
	{
		Common.explicitWait(actionButton);
		actionButton.click();
	}
	
	public void clickMeterDropdown()
	{
		Common.explicitWait(selectMeterDropdown);
		selectMeterDropdown.click();
	}
	
	public void enterMeterNumber(String meterNo)
	{
		Common.explicitWait(meterSearchBox);
		meterSearchBox.sendKeys(meterNo);
	}
	
	public void selectSearchedMeter()
	{
		Common.explicitWait(selectMeter);
		selectMeter.click();
	}
	
	public void clickSubmitButton()
	{
		Common.explicitWait(submit);
		submit.click();
	}
	
	public void crossButton()
	{
		Common.explicitWait(crossButton);
		crossButton.click();
	}
	
	public void closeButton()
	{
		Common.explicitWait(closeButton);
		closeButton.click();
	}
	
	public String unlockedUserLabel;
	public void clickUnlockButton()
	{
		Common.explicitWait(unlockButton);
		unlockedUserLabel = unlockedUser.getText();
		unlockButton.click();
	}
	
	public String nextToUnlockUser()
	{
		Common.explicitWait(unlockedUser);
//		System.out.println(unlockedUser.getText());
		return unlockedUser.getText();
	}
	
	public WebElement validateAssignedMeter()
	{
		Common.explicitWait(meterAssignedMessage);
		return meterAssignedMessage;
	}
	
	public void clickMeterButton()
	{
		Common.explicitWait(meterButton);
		meterButton.click();
	}
	
	public WebElement getEditUserLabel()
	{
		Common.explicitWait(editUserLabel);
		return editUserLabel;
	}
	
	public void landOnDepositFundPage()
	{
		Common.explicitWait(fundManagement);
		fundManagement.click();
		depositFund.click();
	}
	
	public void clickOnMeterNoDropdown()
	{
		Common.explicitWait(meterNo);
		meterNo.click();
		searchForDeletedMeter();
	}
	
	public void searchForDeletedMeter()
	{
		Common.explicitWait(searchField);
		searchField.sendKeys(deletedMeterLabel);
	}
	
	public WebElement meterNotFound()
	{
		Common.explicitWait(searchField);
		return meterNotFound;
	}
	
	public void selectValue()
	{
		Common.explicitWait(select);
		Select value = new Select(select);
		value.selectByValue("10");
	}
	
	public void userManagementSearch(String parameter)
	{
		Common.explicitWait(userMgtSearch);
		userMgtSearch.clear();
		userMgtSearch.sendKeys(parameter);
	}
	
//	public void selectedValueValidate()
//	{
//		Assert.assertEquals(select.getText(), Common.message.getProperty("selectedValue"));
//	}
	
	public WebElement SelectedValue()
	{
		return select;
	}
	
	
	public int rowLength()
	{
		List<WebElement>TotalRowsList = rows.findElements(By.tagName("tr"));
//		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		int rowSize = TotalRowsList.size();
		return rowSize;
	}
	
	public WebElement recordHead()
	{
		Common.explicitWait(recordHeader);
		return recordHeader;
	}
	
	
	public WebElement userMgtTitleValidate()
	{
		Common.explicitWait(userMgtTitle);
		return userMgtTitle;
//		Assert.assertEquals(userMgtTitle.getText(), Common.message.getProperty("userMgtTitle"));
	}
	
	public WebElement userManagementSubmenu1Label()
	{
		return userMgtSubmenu1;
//		Assert.assertEquals(userMgtSubmenu1.getText(), Common.message.getProperty("userManagementSubmenu1"));
//		Assert.assertEquals(userMgtSubmenu2.getText(), Common.message.getProperty("userManagementSubmenu2"));
	}
	
	public WebElement userManagementSubmenu2Label()
	{
		return userMgtSubmenu2;
	}
	
}

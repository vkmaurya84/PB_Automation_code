package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Common;

public class NewUserPage {
	
	WebDriver driver;

	public NewUserPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li/a[contains(text(),'User Management')]")
	WebElement userMgtMenu;
	
	@FindBy(xpath = "//a[@id='manageuser']")
	WebElement userMgtSubmenu1;
	
	@FindBy(xpath = "//a[contains(text(),'New User')]")
	WebElement newUser;
	
	@FindBy(xpath = "//input[@id='userName']")
	WebElement userName;
	
	@FindBy(xpath = "//select[@id='roleSelectionId']")
	WebElement selectRole;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='cpassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//select[@id='language']")
	WebElement language;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='mobile']")
	WebElement mobile;
	
	@FindBy(xpath = "//input[@id='sharedKey']")
	WebElement sharedkey;
	
	@FindBy(xpath = "//select[@id='officeCode']")
	WebElement officeCode;
	
	@FindBy(xpath = "//input[@id='dsro']")
	WebElement dsroCode;
	
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	WebElement meterDropdown;
	
	@FindBy(xpath = "//label[@title='3815330']")
	WebElement selectMeter;
	
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement submit;
	
	@FindBy(xpath = "//div[contains(text(),'CANCEL')]")
	WebElement cancel;
	
	@FindBy(xpath = "//div[contains(text(),'User Added Successfully!')]")
	WebElement userAddedMessage;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement close;
	
	@FindBy(xpath = "//h1[contains(text(),'USER MANAGEMENT')]")
	WebElement userManagementMessage;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//td[contains(text(),'No matching records found')]")
	WebElement searchResult;
	
	@FindBy(xpath = "//div[@id='statusCheck']/label")
	WebElement statusLabel;
	
	@FindBy(xpath = "//span[@id='userName.errors']")
	WebElement userNameError;
	
	@FindBy(xpath = "//div[contains(text(),'User already exists!')]")
	WebElement existingUser;
	
	@FindBy(xpath = "//span[@id='email.errors']")
	WebElement  emailError;
	
	@FindBy(xpath = "//span[contains(text(),'Email already exist')]")
	WebElement emailExist;
	
	@FindBy(xpath = "//span[@id='mobile.errors']")
	WebElement mobileError;
	
	@FindBy(xpath = "//span[contains(text(),'Phone number already exist')]")
	WebElement mobileExist;
	
	@FindBy(xpath = "//span[@id='sharedKey.errors']")
	WebElement sharedKeyError;
	
	@FindBy(xpath = "//span[@id='password.errors']")
	WebElement passwordError;
	
	
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
	
	public void newUserClick()
	{
		Common.explicitWait(newUser);
		newUser.click();
	}
	
	public void enterUserName(String user)
	{
		Common.explicitWait(userName);
		userName.clear();
		userName.sendKeys(user);
	}
	
	public void selectUserRole(String userRole)
	{
		Common.explicitWait(selectRole);
		Select value = new Select(selectRole);
		value.selectByValue(userRole);
	}
	
	public void enterPassword(String userPassword)
	{
		Common.explicitWait(password);
		password.clear();
		password.sendKeys(userPassword);
	}
	
	public void enterConfirmPassword(String userConfirmPassword)
	{
		Common.explicitWait(confirmPassword);
		confirmPassword.clear();
		confirmPassword.sendKeys(userConfirmPassword);
	}
	
	public void selectLanguage(String userLanguage)
	{
		Common.explicitWait(language);
		Select value = new Select(language);
		value.selectByValue(userLanguage);
	}
	
	public void enterEmail(String userEmamil)
	{
		Common.explicitWait(email);
		email.clear();
		email.sendKeys(userEmamil);
	}
	
	public void enterMobile(String userMobile)
	{
		Common.explicitWait(mobile);
		mobile.clear();
		mobile.sendKeys(userMobile);
	}
	
	public void enterShahredKey(String shareKey)
	{
		Common.explicitWait(sharedkey);
		sharedkey.clear();
		sharedkey.sendKeys(shareKey);
	}
	
	public void selectOfficeCode(String userOfficeCode)
	{
		Common.explicitWait(officeCode);
		Select value = new Select(officeCode);
		value.selectByValue(userOfficeCode);
	}
	
	public void enterDSROCode(String userDSROCode)
	{
		Common.explicitWait(dsroCode);
		dsroCode.clear();
		dsroCode.sendKeys(userDSROCode);
	}
	
	public void clickMeterDropdown()
	{
		Common.explicitWait(meterDropdown);
		meterDropdown.click();
	}
	
	public void clickToSelectMeter()
	{
		Common.explicitWait(selectMeter);
		selectMeter.click();
	}
	
	public void clickOnSubmitButton()
	{
		Common.explicitWait(submit);
		submit.click();
	}
	
	public void clickOnCancelButton()
	{
		Common.explicitWait(cancel);
		cancel.click();
	}
	
	public String userAddedConfirmationMessage()
	{
		Common.explicitWait(userAddedMessage);
		return userAddedMessage.getText();
	}
	
	public void clickCloseButton()
	{
		Common.explicitWait(close);
		close.click();
	}
	
	public String afterClickOnCancelValidate()
	{
		Common.explicitWait(userManagementMessage);
		return userManagementMessage.getText();
	}
	
	public void enterInSearchField(String searchValue)
	{
		Common.explicitWait(searchField);
		searchField.clear();
		searchField.sendKeys(searchValue);
	}
	
	public String validateSearchResult()
	{
		Common.explicitWait(searchResult);
		return searchResult.getText();
	}
	
	public String validateStatusLabel()
	{
		Common.explicitWait(statusLabel);
		return statusLabel.getText();
	}
	
	public String validateUserNameError()
	{
		Common.explicitWait(userNameError);
		return userNameError.getText();
	}
	
	public String existingUser()
	{
		Common.explicitWait(existingUser);
		return existingUser.getText();
	}
	
	public String validateEmailError()
	{
		Common.explicitWait(emailError);
		return emailError.getText();
	}
	
	public String validateEmailExist()
	{
		Common.explicitWait(emailExist);
		return emailExist.getText();
	}
	
	public String validateMobileError()
	{
		Common.explicitWait(mobileError);
		return mobileError.getText();
	}
	
	public String validateMobileExist()
	{
		Common.explicitWait(mobileExist);
		return mobileExist.getText();
	}
	
	public String validateSharedKeyError()
	{
		Common.explicitWait(sharedKeyError);
		return sharedKeyError.getText();
	}
	
	public String validatePasswordError()
	{
		Common.explicitWait(passwordError);
		return passwordError.getText();
	}

}

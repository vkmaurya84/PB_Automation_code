package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Common;

public class EditUserPage {
	
	WebDriver driver;

	public EditUserPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//li/a[contains(text(),'User Management')]")
	WebElement userMgtMenu;
	
	@FindBy(xpath = "//a[@id='manageuser']")
	WebElement userMgtSubmenu1;
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//tbody/tr[1]/td[4]/a")
	WebElement actionButton;
	
	@FindBy(xpath = "//input[@id='old_password']")
	WebElement oldPassword;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='cpassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement submit;
	
	@FindBy(xpath = "//div[contains(text(),'CANCEL')]")
	WebElement cancel;
	
	@FindBy(xpath = "//div[contains(text(),'User edit successfully!')]")
	WebElement editConfirmMessage;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement close;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='mobile']")
	WebElement mobile;
	
	@FindBy(xpath = "//h1[contains(text(),'USER MANAGEMENT')]")
	WebElement userManagementMessage;
	
	@FindBy(xpath = "//span[@id='password.errors']")
	WebElement passwordError;
	
	@FindBy(xpath = "//span[@id='email.errors']")
	WebElement  emailError;
	
	@FindBy(xpath = "//span[@id='mobile.errors']")
	WebElement mobileError;
	
	
	
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
	
	public void enterInSearchField(String searchValue)
	{
		Common.explicitWait(searchField);
		searchField.clear();
		searchField.sendKeys(searchValue);
	}
	
	public void clickActionButton()
	{
		Common.explicitWait(actionButton);
		actionButton.click();
	}
	
	public String enterOldPassword(String userOldPassword)
	{
		Common.explicitWait(oldPassword);
		return oldPassword.getText();
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
	
	public void clickCloseButton()
	{
		Common.explicitWait(close);
		close.click();
	}
	
	public String validateUserEditMessage()
	{
		Common.explicitWait(editConfirmMessage);
		return editConfirmMessage.getText();
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
	
	public String afterClickOnCancelValidate()
	{
		Common.explicitWait(userManagementMessage);
		return userManagementMessage.getText();
	}
	
	public String validatePasswordError()
	{
		Common.explicitWait(passwordError);
		return passwordError.getText();
	}
	
	public String validateEmailError()
	{
		Common.explicitWait(emailError);
		return emailError.getText();
	}
	
	public String validateMobileError()
	{
		Common.explicitWait(mobileError);
		return mobileError.getText();
	}

}

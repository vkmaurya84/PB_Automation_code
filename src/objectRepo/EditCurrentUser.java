package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Common;

public class EditCurrentUser {
	
	WebDriver driver;

	public EditCurrentUser(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[@id='username-offscreen']")
	WebElement user;
	
	@FindBy(xpath = "//a[contains(text(),'Edit User')]")
	WebElement editButton;
	
	@FindBy(xpath = "//input[@id='old_password']")
	WebElement oldPassword;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='cpassword']")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//div[contains(text(),'SUBMIT')]")
	WebElement submitButton;
	
	@FindBy(xpath = "//div[contains(text(),'User edit successfully!')]")
	WebElement successMessage;
	
	@FindBy(xpath = "//button[contains(text(),'Close')]")
	WebElement closeButton;
	
	@FindBy(xpath = "//span[@class='text-danger']")
	WebElement confirmPasswordError;
	
	
	public void currentUser()
	{
		Common.explicitWait(user);
		user.click();
	}
	
	public void clickEditUserButton()
	{
		Common.explicitWait(editButton);
		editButton.click();
	}
	
	public void enterOldPassword(String oldpassword)
	{
		Common.explicitWait(oldPassword);
		oldPassword.clear();
		oldPassword.sendKeys(oldpassword);
	}
	
	public void enterNewPassword(String newPassword)
	{
		Common.explicitWait(password);
		password.clear();
		password.sendKeys(newPassword);
	}
	
	public void enterConfirmPassword(String cnfPassword)
	{
		Common.explicitWait(confirmPassword);
		confirmPassword.clear();
		confirmPassword.sendKeys(cnfPassword);
	}
	
	public void clickOnConfirmButton()
	{
		Common.explicitWait(submitButton);
		submitButton.click();
	}
	
	public String validateEditSuccess()
	{
		Common.explicitWait(successMessage);
		return successMessage.getText();
	}
	
	public void clickCloseButton()
	{
		Common.explicitWait(closeButton);
		closeButton.click();
	}
	
	public String confirmPasswordErrorMessage()
	{
		Common.explicitWait(confirmPasswordError);
		return confirmPasswordError.getText();
	}

}

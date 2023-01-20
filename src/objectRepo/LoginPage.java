package objectRepo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Common;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Login
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id='contains_pass']")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='login']")
	WebElement proceed;
	
//	By userName = By.xpath("//input[@id='username']");
//	By password = By.xpath("//input[@id='contains_pass']");
//	By proceed = By.xpath("//button[@id='login']");
	
//	Logout
	
	@FindBy(xpath = "//span[@id='username-offscreen']")
	WebElement user;
	
	@FindBy(xpath = "//a[@id='logout']")
	WebElement logout;
	
//	By user = By.xpath("//span[@id='username-offscreen']");
//	By logout = By.xpath("//a[@id='logout']");
	

	public void email(String username)
	{
		Common.explicitWait(userName);
		userName.sendKeys(username);;
	}
	
	public void password(String pwd) 
	{
		Common.explicitWait(password);
		password.sendKeys(pwd);;
	}
	
	public void submit()
	{
		Common.explicitWait(proceed);
		proceed.click();;
	}
	
	public void currentuser()
	{
		Common.explicitWait(user);
		user.click();
	}
	
	public void userlogout()
	{
		Common.explicitWait(logout);
		logout.click();;
	}
}

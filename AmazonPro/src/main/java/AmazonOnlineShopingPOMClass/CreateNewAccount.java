package AmazonOnlineShopingPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewAccount
{	
	private WebDriver driver;
	
	private Actions act;
	
	private WebDriverWait wait;
	
	@FindBy (xpath="//span[text()='Account & Lists']")
	private WebElement accountAndLists;
	
	@FindBy (xpath="(//a[text()='Start here.'])[1]")
	private WebElement startHere;
	
	@FindBy (xpath="//input[@name='customerName']")
	private WebElement enterName;
	
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement enterEmail;
	
	@FindBy (xpath="//input[@id='ap_password']")
	private WebElement enterPassword;
	
	@FindBy (xpath="//input[@id='ap_password_check']")
	private WebElement enterReEnterPassword;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement createAccount;
	
	public CreateNewAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;	
		wait=new WebDriverWait(driver,10);
		act=new Actions(driver);
	}
	
	public void clickAccountAndListsOption()
	{	wait.until(ExpectedConditions.visibilityOf(accountAndLists));
		act.moveToElement(accountAndLists).perform();
	}
	public void clickSignHereOption()
	{	wait.until(ExpectedConditions.visibilityOf(startHere));
		startHere.click();
	}
	public void sendName(String fname)
	{
		enterName.sendKeys(fname);
	}
	public void sendEmail(String email)
	{
		enterEmail.sendKeys(email);
	}
	public void sendPassword(String pass)
	{
		enterPassword.sendKeys(pass);
	}
	public void sendReEnterPassword(String pass1)
	{
		enterReEnterPassword.sendKeys(pass1);
	}
	public void clickCreateAccountButton()
	{
		createAccount.click();
	}
}


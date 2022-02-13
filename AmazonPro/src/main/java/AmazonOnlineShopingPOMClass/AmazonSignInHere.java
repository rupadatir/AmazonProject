package AmazonOnlineShopingPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSignInHere 
{
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private Actions act;
	
	
	@FindBy (xpath="//span[text()='Account & Lists']")
	private WebElement accountAndLists;
	
	@FindBy (xpath="(//span[text()='Sign in'])[1]")
	private WebElement signIn;
	
	
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement sendMobileNo;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement clickContinueBtn;
	
	@FindBy (xpath="//input[@id='ap_password']")
	private WebElement sendPassword;
	
	@FindBy (xpath="//input[@type='checkbox']")
	private WebElement keepMeSignInCheckbox;
	
	@FindBy (xpath="//span[@id='auth-signin-button']")
	private WebElement signInToAmazon;
	
	public AmazonSignInHere(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;	
		wait=new WebDriverWait(driver,10);
		act=new Actions(driver);
	}
	
	public void moveAccountAndListsOption()
	{	
		wait.until(ExpectedConditions.visibilityOf(accountAndLists));
		act.moveToElement(accountAndLists).perform();
	}
	
	public void clickSignInButton()
	{	
		act.moveToElement(signIn).click().build().perform();
	}
	
	public void sendMobileNumber(String mobileNo)
	{	

		sendMobileNo.sendKeys(mobileNo);
	}
	
	public void clickOnContinue()
	{	
		clickContinueBtn.click();
	}
	
	public void sendPassword(String pass)
	{	
		sendPassword.sendKeys(pass);
	}
	
	public boolean checkboxFunctionality()
	{
	boolean result =keepMeSignInCheckbox.isSelected();
	return result;
	}
	
	public void keepMeLoginCheckbox()
	{	
		keepMeSignInCheckbox.click();
	}
	
	public void finalSignInButton()
	{	
		signInToAmazon.click();
	}
}

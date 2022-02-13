package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AmazonOnlineShopingPOMClass.AmazonSignInHere;
import AmazonOnlineShopingPOMClass.ChangeCountry;
import AmazonOnlineShopingPOMClass.ChangeCurrency;
import AmazonOnlineShopingPOMClass.CreateNewAccount;
import AmazonOnlineShopingPOMClass.SignoutFromAmazon;

public class CreateNewAccTestNG 
{

WebDriver driver;
	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void signinToAmazon()
	{
		driver.get("https://www.amazon.com/");
	}
	
	
	@Test
	public void createNewAmazonAcc()
	{
		CreateNewAccount createNewAccount = new CreateNewAccount(driver);
		
		createNewAccount.clickAccountAndListsOption();
		createNewAccount.clickSignHereOption();
		createNewAccount.sendName("Rupali");
		createNewAccount.sendEmail("rupadatir@gmail.com");
		createNewAccount.sendPassword("New@2022");
		createNewAccount.sendReEnterPassword("New@2022");
		createNewAccount.clickCreateAccountButton();
	}
	
	
		@AfterMethod()
	public void afterMethod()
	{
		AmazonSignInHere amazonSignInHere =new AmazonSignInHere(driver);
		amazonSignInHere.moveAccountAndListsOption();
		
		SignoutFromAmazon signoutFromAmazon=new SignoutFromAmazon(driver);
		signoutFromAmazon.signoutFromApplication();
	}
	
	@AfterClass()
	public void afterClass()
	{
		 driver.quit();
	}
	
}

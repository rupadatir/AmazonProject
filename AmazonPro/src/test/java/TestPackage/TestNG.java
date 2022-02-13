

//Change Currency and Country run successful with  keywords applies on test.

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

public class TestNG 
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
		
		AmazonSignInHere amazonSignInHere =new AmazonSignInHere(driver);
				
		amazonSignInHere.moveAccountAndListsOption();
		amazonSignInHere.clickSignInButton();
		amazonSignInHere.sendMobileNumber("9405265472");
		amazonSignInHere.clickOnContinue();
		amazonSignInHere.sendPassword("New@2022");
		
		boolean checkbox=amazonSignInHere.checkboxFunctionality();
		if(checkbox=true)
		{
			System.out.println("Checkbox is Selected");
		}
		else
		{
			System.out.println("Checkbox is not Selected");
		}
		
		amazonSignInHere.keepMeLoginCheckbox();
		amazonSignInHere.finalSignInButton();
	}
	
	@Test(priority=1)
	public void changeCurrencyAsPerCOuntry()
	{
			
				ChangeCurrency changeCurrency=new ChangeCurrency(driver);
				
				changeCurrency.mouseOverChangeLanguage();
				
				changeCurrency.changeCurrencySetting();
				
				JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,400)");
				
						
				changeCurrency.selectCurrencyFromList();
				
				changeCurrency.clickSelectedCurrency();
				
				changeCurrency.saveChangesButton();
			
	}
	
	@Test(priority=0,dependsOnMethods= {"changeCurrencyAsPerCOuntry"})
	public void changeCountryAsperNation()
	{
		ChangeCountry changeCountry = new ChangeCountry(driver);

		changeCountry.changeLanguage();
		changeCountry.changeCountryRegion();
		changeCountry.selectCountryFromList();
		changeCountry.clickSelectedCountry();
		changeCountry.gotoWebsiteButton();
	}
	
	@Test(enabled=false)
	public void createNewAmazonAcc()
	{
		
		CreateNewAccount createNewAccount = new CreateNewAccount(driver);
		
		createNewAccount.clickAccountAndListsOption();
		createNewAccount.clickSignHereOption();
		createNewAccount.sendName("Rupali");
		createNewAccount.sendEmail("rupadatir");
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
//		driver.navigate().refresh();	
	}
	
	@AfterClass()
	public void afterClass()
	{
		driver.quit();
	}
	
}

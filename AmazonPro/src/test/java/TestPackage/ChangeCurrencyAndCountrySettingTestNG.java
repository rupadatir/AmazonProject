
//Amazon ChangeCurrency And CountrySetting testNG class- successful run ------with Assertion

package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AmazonOnlineShopingPOMClass.AmazonSignInHere;
import AmazonOnlineShopingPOMClass.ChangeCountry;
import AmazonOnlineShopingPOMClass.ChangeCurrency;
import AmazonOnlineShopingPOMClass.SignoutFromAmazon;

public class ChangeCurrencyAndCountrySettingTestNG
{

	WebDriver driver;
	
	@BeforeClass
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
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
	public void ChangeCountryAsperNation()
	{
		ChangeCountry changeCountry = new ChangeCountry(driver);
		changeCountry.changeLanguage();
		changeCountry.changeCountryRegion();
		
		String url= driver.getCurrentUrl();
		String expectedURL="https://www.amazon.com/gp/navigation-country/select-country/ref=icp_lop_mop_chg_ais?preferencesReturnUrl=/";
		
		String tital=driver.getTitle();
		String expectedtitle="Go to website";
		
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(url, expectedURL,"URL does not match");
		softAssert.assertEquals(tital, expectedtitle,"Title does not match");
		softAssert.assertAll();
				
		
		changeCountry.selectCountryFromList();
		changeCountry.clickSelectedCountry();
		changeCountry.gotoWebsiteButton();
	}
	
	
	@Test
	public void changeCurrencyAsPerCOuntry()
	{	
		SoftAssert soft=new SoftAssert();
		
		ChangeCurrency changeCurrency=new ChangeCurrency(driver);
		
		String url= driver.getCurrentUrl();
		System.out.println(url);
		String expectedURL="https://www.amazon.com/?ref_=nav_signin&";
		
		String tital=driver.getTitle();
		System.out.println(tital);
		String expectedtitle="Amazon.com. Spend less. Smile more.";
		
		Assert.assertEquals(tital, expectedtitle,"title doesn't match");
		Assert.assertEquals(url, expectedURL,"URL doesn't match");
		
//		boolean result=tital.equals(expectedtitle);
//		boolean urlrResult=url.equals(expectedURL);
//		
//		soft.assertFalse(result);
//		soft.assertFalse(urlrResult);
//		soft.assertAll();
				
		changeCurrency.mouseOverChangeLanguage();
				
		changeCurrency.changeCurrencySetting();
				
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
				
						
		changeCurrency.selectCurrencyFromList();
				
		changeCurrency.clickSelectedCurrency();
				
		changeCurrency.saveChangesButton();
			
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

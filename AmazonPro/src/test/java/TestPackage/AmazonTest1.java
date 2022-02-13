package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AmazonOnlineShopingPOMClass.AmazonSignInHere;
import AmazonOnlineShopingPOMClass.ChangeCountry;
import AmazonOnlineShopingPOMClass.ChangeCurrency;
import AmazonOnlineShopingPOMClass.CreateNewAccount;
import AmazonOnlineShopingPOMClass.SignoutFromAmazon;

public class AmazonTest1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.com/");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	
		//AmazonSignInHere POM class Object
		
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
		
			
//		// CreateNewAccount POM class object
//		
//		CreateNewAccount createNewAccount = new CreateNewAccount(driver);
//		
//		createNewAccount.clickAccountAndListsOption();
//		createNewAccount.clickSignHereOption();
//		createNewAccount.sendName("Rupali");
//		createNewAccount.sendEmail("rupadatir");
//		createNewAccount.sendPassword("New@2022");
//		createNewAccount.sendReEnterPassword("New@2022");
//		createNewAccount.clickCreateAccountButton();

	
		
//		//Object of ChangeCurrency POM class
//		
//		
//		ChangeCurrency changeCurrency=new ChangeCurrency(driver);
//		
//		changeCurrency.clickAccountAndListsOption();
//		changeCurrency.changeLanguage();
//		
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,500)");
//		
//		changeCurrency.changeCurrencySetting();
//		
//		changeCurrency.selectCurrencyFromList();
//		
//		changeCurrency.clickSelectedCurrency();
//		
//		changeCurrency.saveChangesButton();		
		
		
		
		
//		//Object of ChangeCountry POM class
//		
//	ChangeCountry changeCountry = new ChangeCountry(driver);
//
//	changeCountry.changeLanguage();
//	changeCountry.changeCountryRegion();
//	changeCountry.selectCountryFromList();
//	changeCountry.clickSelectedCountry();
//	changeCountry.gotoWebsiteButton();

		
		
	//Signout from SignoutFromAmazon POM class object
		
		SignoutFromAmazon signoutFromAmazon=new SignoutFromAmazon(driver);
		signoutFromAmazon.mouseoverAccountAndListsOption();
		signoutFromAmazon.signoutFromApplication();
	
	}

}

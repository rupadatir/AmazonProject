package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AmazonOnlineShopingPOMClass.AmazonSignInHere;
import AmazonOnlineShopingPOMClass.SignoutFromAmazon;

public class Signout {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.com/");

		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

		
		AmazonSignInHere amazonSignInHere =new AmazonSignInHere(driver);
		
		amazonSignInHere.moveAccountAndListsOption();
		amazonSignInHere.clickSignInButton();
		amazonSignInHere.sendMobileNumber("9405265472");
		amazonSignInHere.clickOnContinue();
		amazonSignInHere.sendPassword("New@2022");
		amazonSignInHere.keepMeLoginCheckbox();
		amazonSignInHere.finalSignInButton();
		
		
		//Signout from SignoutFromAmazon POM class object
		
				SignoutFromAmazon signoutFromAmazon=new SignoutFromAmazon(driver);
				signoutFromAmazon.mouseoverAccountAndListsOption();
				signoutFromAmazon.signoutFromApplication();
			
	}
	
	

}

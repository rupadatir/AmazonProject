package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import AmazonOnlineShopingPOMClass.ChangeCountry;

public class Test3 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");

				
		//Object of ChangeCountry POM class
		
	ChangeCountry changeCountry = new ChangeCountry(driver);

	changeCountry.changeLanguage();
	changeCountry.changeCountryRegion();
	changeCountry.selectCountryFromList();
	changeCountry.clickSelectedCountry();
	changeCountry.gotoWebsiteButton();

	}

}

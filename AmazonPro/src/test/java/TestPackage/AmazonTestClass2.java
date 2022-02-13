package TestPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import AmazonOnlineShopingPOMClass.ChangeCurrency;

public class AmazonTestClass2 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Rupali\\Softwares\\chromedriver_win32 97.0\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.com/");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		String url= driver.getCurrentUrl();
		System.out.println(url);
		String expectedURL="https://www.amazon.in/?ref_=nav_ya_signin&";
	
			//https://www.amazon.com/
		String tital=driver.getTitle();
		System.out.println(tital);
		String expectedtitle="Amazon.com. Spend less. Smile more.";
		
		//Assertions Applied- Hard Assert
		
			
		Assert.assertEquals(tital, expectedtitle,"title doesn't match");
		Assert.assertEquals(url, expectedURL,"URL doesn't match");
		
		
//		boolean urlrResult=url.equals(expectedURL);
//		Assert.assertTrue(urlrResult);
//		Assert.assertFalse(urlrResult);
//		Assert.assertNotEquals(url, expectedURL);
		
				
	
					
//		boolean result=tital.equals(expectedtitle);
//		
//		Assert.assertTrue(result);
//		
//		boolean urlrResult=url.equals(expectedURL);
//		Assert.assertTrue(urlrResult);
			
		
			//Soft Assert
//		SoftAssert soft= new SoftAssert();
//		soft.assertEquals(tital, expectedtitle);
//		soft.assertTrue(urlrResult);
//		soft.assertFalse(urlrResult);
		
		
		
		// Before Applying Assertion this was needed
//		if(url.equals(expectedURL))
//		{
//			System.out.println("url matches");
//		}
//		else
//		{
//			System.out.println("url does not matches");
//		}
//		
//		if(tital.equals(expectedtitle))
//		{
//			System.out.println("Title matches");
//		}
//		else
//		{
//			System.out.println("Title does not matches");
//		}
//		
		
		//Object of ChangeCurrency POM class
		
		ChangeCurrency changeCurrency=new ChangeCurrency(driver);
		
		
		
		
		changeCurrency.mouseOverChangeLanguage();
		
		changeCurrency.changeCurrencySetting();
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
				
		changeCurrency.selectCurrencyFromList();
		
		changeCurrency.clickSelectedCurrency();
		
		changeCurrency.saveChangesButton();
	}

}

package AmazonOnlineShopingPOMClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeCountry
{
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private Actions act;
	
	
	@FindBy (xpath="//a[@id='icp-nav-flyout']")
	private WebElement changeLanguage;
	
	@FindBy (xpath="(//div[text()='Change country/region.'])[1]")
	private WebElement changeCountryRegion;
	
	@FindBy (xpath="//select[@id='icp-selected-country']//option")
	private List<WebElement> ChangeCountryRegion;
	
	@FindBy (xpath="//span[text()='India']")
	private WebElement selectedCountry;
	
	@FindBy (xpath="//input[@class='a-button-input']")
	private WebElement goToWebsite;
	
	public ChangeCountry(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		act=new Actions(driver);
		this.driver=driver;
		wait=new WebDriverWait(driver,10);
	}
	 

	
	public void changeLanguage()
	{
		act.moveToElement(changeLanguage).perform();
	}
	
	public void changeCountryRegion()
	{
		changeCountryRegion.click();
	}
	
	
	public void selectCountryFromList()
	{  
		int count=ChangeCountryRegion.size();
		System.out.println("Total Countries listed are :" +count);
		
		for(int i=0;i<count;i++)
			{
			String str = ChangeCountryRegion.get(i).getText();
			System.out.println(str);
			
			if(str.equalsIgnoreCase("India"))
				{
				ChangeCountryRegion.get(i).click();
				break;
				}
			}
	}
	
	public void clickSelectedCountry()
	{
		selectedCountry.click();
	}
	
	public void gotoWebsiteButton()
	{
		goToWebsite.click();
	}
}

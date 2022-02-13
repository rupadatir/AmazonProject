package AmazonOnlineShopingPOMClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeCurrency 
{
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	private Actions act;
	
		
	@FindBy (xpath="//a[@id='icp-nav-flyout']")
	private WebElement changeLanguage;
	
	@FindBy (xpath="(//a[text()='Change'])[1]")
	private WebElement change;
	
	@FindBy (xpath="//select[@id='icp-sc-dropdown']//option")
	private List<WebElement> ChooseCurrencyToShop;
	
	@FindBy (xpath="//a[@id='icp-sc-dropdown_2']") 
	private WebElement selectedCurrency;
	
	@FindBy (xpath="//span[@id='icp-btn-save']")
	private WebElement saveChanges;
	
		
	public ChangeCurrency(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		act=new Actions(driver);
		this.driver=driver;
		wait=new WebDriverWait(driver,5);
	}
	
	
		public void mouseOverChangeLanguage()
	{
		act.moveToElement(changeLanguage).perform();
	}
	
	public void changeCurrencySetting()
	{	
		act.moveToElement(change).click().build().perform();
	}
	
	
	
	public void selectCurrencyFromList()
	{	
		
		int cnt=ChooseCurrencyToShop.size();
		System.out.println("Currencies of different countries are:" + cnt);
		
		for(int i=1;i<cnt;i++)
		{
			String Data=ChooseCurrencyToShop.get(i).getText();
			
			System.out.println(Data);
			
			if(Data.equals("₹ - INR - Indian Rupee"));
				{
					ChooseCurrencyToShop.get(i).click();
					break;
				}
		}
	
	}	
	
	
	public void clickSelectedCurrency()
	{
		selectedCurrency.click();
	}
	
	public void saveChangesButton()
	{
		wait.until(ExpectedConditions.visibilityOf(saveChanges));
		saveChanges.click();
	}
	
}

package AmazonOnlineShopingPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignoutFromAmazon {

	
		WebDriver driver;
		
		Actions act;
		
		WebDriverWait wait;
		
		@FindBy (xpath="//span[text()='Account & Lists']")
		private WebElement accountAndLists;
		
		@FindBy (xpath="//a[@id='nav-item-signout']//span")
		private WebElement signout;
		
		public SignoutFromAmazon(WebDriver driver)
		{   
			PageFactory.initElements(driver, this);
			this.driver=driver;	
			wait=new WebDriverWait(driver,14);
			act=new Actions(driver);
		}
				
		public void mouseoverAccountAndListsOption()
		{	wait.until(ExpectedConditions.visibilityOf(accountAndLists));
			act.moveToElement(accountAndLists).click().build().perform();
		}
		
		public void signoutFromApplication()
		{	WebDriverWait wait=new WebDriverWait(driver,12);
			wait.until(ExpectedConditions.visibilityOf(accountAndLists));
			signout.click();
		}
}

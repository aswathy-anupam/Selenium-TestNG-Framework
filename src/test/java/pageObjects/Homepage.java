package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage
{

	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	  @FindBy(xpath="//div[text()='Swag Labs']")
	  WebElement msgHeading;
	  
	  @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
		WebElement BtnAddCart;
	  
	  @FindBy(xpath="//button[@id='react-burger-menu-btn']")
		WebElement Btnreact;
	  
	  @FindBy(xpath="//a[@id='logout_sidebar_link']")
	    WebElement Mnulogout;
	  

	  @FindBy(xpath="//a[@id='logout_sidebar_link']")
	    WebElement Mnulogout12;
	  
	  public String isHeadingExists()
	 {
				try
				{
				return(msgHeading.getText());
					
				}
				catch(Exception e)
				{
					return "data not found";
				}
	 }	
		
		public void clickAddCart() throws InterruptedException
		{
			Thread.sleep(3000);	
			//Actions actions = new Actions(driver);
			//actions.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER).perform();
			//Thread.sleep(3000);	
			driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
			BtnAddCart.click();
			
		}
		
		public void clickReact() 
		{
			
			Btnreact.click();
			Mnulogout.click();
		}
		
		public void clickLogout() throws InterruptedException
		{
	    Thread.sleep(3000);
	   
			Mnulogout.click();
		}
		
		}


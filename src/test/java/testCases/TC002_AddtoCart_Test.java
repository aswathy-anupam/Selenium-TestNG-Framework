package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.Baseclass;

public class TC002_AddtoCart_Test extends Baseclass
{
	
	@Test
	public void verify_AddtpCart() throws InterruptedException 
	{
		
		Homepage hp1=new Homepage(driver);
		hp1.clickAddCart(); 
		
	}
		
		@Test
		public void verify_reactclick() 
		{
			Homepage hp2=new Homepage(driver);
			hp2.clickReact();
			System.out.println("Logout successful");
		
		}
		
		
		  //@Test public void verify_logout() throws InterruptedException 
		  //{ 
			  
		  //Homepage hp3=new Homepage(driver);
		 // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //
		//  WebElement test=driver.findElement(By.id("logout_sidebar_link")); //test.click();
		 // hp3.clickLogout();
		  
		  }
		 


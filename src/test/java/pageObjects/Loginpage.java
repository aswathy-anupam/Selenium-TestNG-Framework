package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage
{
		public Loginpage(WebDriver driver)
		{
			super(driver);
		}
	    
		@FindBy(xpath="//input[@id='user-name']")
        WebElement txtUsername;
		
		@FindBy(xpath="//input[@id='password']")
		WebElement txtPassword;
		
		@FindBy(xpath="//input[@id='login-button']")
		WebElement btnLogin;
		
		@FindBy(xpath="//input[@id='login-button']")
		WebElement btnLogin6;
				
		public void setUsername(String uname)
		{   System.out.println("Inside page object class> first method");
			txtUsername.sendKeys(uname);
			System.out.println("Checking whether username field is detected");
		}
		
		public void setPassword(String psw)
		{
			 System.out.println("Inside page object class> second method");
			txtPassword.sendKeys(psw);
		}
		
		public void clickLogin()
		{  System.out.println("Inside page object class> Before clicking login");
			btnLogin.click();
			System.out.println("Inside page object class> After clicking login");
			
		}
		
}

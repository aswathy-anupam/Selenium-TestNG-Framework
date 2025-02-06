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
				
		public void setUsername(String uname)
		{
			txtUsername.sendKeys(uname);
		}
		
		public void setPassword(String psw)
		{
			txtPassword.sendKeys(psw);
		}
		
		public void clickLogin()
		{
			btnLogin.click();
		}
		
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC001_Login_Test extends Baseclass
{
	

    @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)// getting data provider from different class
	public void verify_login_Test(String uname, String pwd, String expec)
	{
         try
         {
		 Loginpage lp=new Loginpage(driver);
		 System.out.println("Checking valid Login");
		 lp.setUsername(uname);
		 lp.setPassword(pwd);
		 lp.clickLogin();
		 Homepage hp=new Homepage(driver);
		 String targetheading= hp.isHeadingExists();
		 try 
		 {
			 Assert.assertEquals(targetheading,"Swag Labs");
		 
				 System.out.println("✅ Test Passed: Login Successful, Home page is loaded");
				 }
				 catch (AssertionError e) 
                 {
				 System.out.println("❌ Test Failed: Login Unsuccessful, Expected '" +"Swag Labs "+ "', but got '" + targetheading + "'");
				  
				 }
				  
				  }
    catch(Exception e)
    
    { 
    	Assert.fail();
    }
		 
		 
		 
		 
		 
		
	
	
	
	
	
	/*@Test
	public void verify_login()
	{

		 Loginpage lp=new Loginpage(driver);
		 lp.setUsername(p.getProperty("username"));
		 lp.setPassword(p.getProperty("password"));
		 lp.clickLogin();
		 //lp.clickAddCart(); 
*/	}
	
	
	
}

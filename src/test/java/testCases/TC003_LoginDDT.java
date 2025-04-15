package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import testBase.Baseclass;
import utilities.DataProviders;

public class TC003_LoginDDT extends Baseclass
{
    @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)// getting data provider from different class
	public void verify_loginDDT(String uname, String pwd, String expec)
	{
         try
         {
		 Loginpage lp=new Loginpage(driver);
		 lp.setUsername(uname);
		 lp.setPassword(pwd);
		 lp.clickLogin();
		 Homepage hp=new Homepage(driver);
		 String targetheading= hp.isHeadingExists();
		 
		 if(expec.equalsIgnoreCase("Valid"))
		 {
		 if(targetheading.contains("Swag Labs"))
		 {
			 System.out.println(targetheading);
			 //hp.clickLogout();
			 //comment for Github
			 Assert.assertTrue(true);
			
		 }
		 
		 else
		 {
			 Assert.assertTrue(false);
		 }
		 
		 }
		 
			
			/*
			 * if(expec.equalsIgnoreCase("Invalid")) { if(targetheading=="Swag Labs") {
			 * //hp.clickLogout(); Assert.assertTrue(false); } else {
			 * Assert.assertTrue(false); } }
			 */
			/*
			 * try 
			 * {
			 *  Homepage hp=new Homepage(driver);
			 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 *  String
			 * targetheading= hp.isHeadingExists();
			 *  try
			 *   { 
			 *   Assert.assertEquals(targetheading,"Swag Labs");
			 * System.out.println("✅ Test Passed: Login Successful, Home page is loaded"); }
			 * catch (AssertionError e)
			 *  {
			 * System.out.println("❌ Test Failed: Login Unsuccessful, Expected '" +
			 * "Swag Labs "+ "', but got '" + targetheading + "'");
			 * 
			 * }
			 * 
			 * } catch(Exception e) { Assert.fail(); }
			 */
	    
	}
         catch(Exception e)
         {
        	 Assert.fail();
         }
	}
}

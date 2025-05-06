package testBase;
import java.net.URI;
import java.net.URL;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class Baseclass 
{
public static WebDriver driver;
public Properties p;
	

@BeforeSuite
   @Parameters({"os", "browser"})

	public void setup(String os, String br) throws IOException

		{
	System.out.println("Inside @BeforeSuite");
    	//Loading config.properties file
    	FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
    	p.load(file);
    	
    	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capabilities.setPlatform(Platform.LINUX);
				
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching os");
				return;
			}
			System.out.println("Before switch case");
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: System.out.println("No matching browser"); return;
			}
		
			System.out.println("Before checking grid connection");
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
			System.out.println("After checking grid connection");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			//driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		
				
    	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{    	
			System.out.println("To check local connection is executing");
        //driver=new ChromeDriver();
    	switch(br.toLowerCase())
    	{          
    	case "chrome" : 
    	ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    	break;
    	case "edge" : driver=new EdgeDriver(); break;
    	case "firefox" : driver=new FirefoxDriver(); break;
    	default : System.out.println("Invalid browser name.."); 
    	return;
    	}
    	}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.saucedemo.com/");
		//System.out.println("Opening URL: " + p.getProperty("appURL1"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(p.getProperty("appURL1")); //reading URL from properties file
		driver.manage().window().maximize();
		System.out.println("URL is opened");
		}
	
  @AfterSuite
	public void tearDown()
	{
	driver.quit();
	}
  
  public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}

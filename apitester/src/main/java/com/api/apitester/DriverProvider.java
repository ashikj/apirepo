package com.api.apitester;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.ChromeDriverManager;


public class DriverProvider {

	public static WebDriver driver;
	DesiredCapabilities capability;
	WebElement element;
	WebDriverWait wait;
	
//	public static HtmlReporter Reporter = new HtmlReporter();
	

	
	public WebDriver browserLaunch(String browserName) throws Exception {
		boolean browser = false;
		if (browserName.equalsIgnoreCase("Chrome")) {
			File f = new File("Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",f.getAbsolutePath());
			ChromeDriverManager.getInstance().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("-incognito");
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars"); 
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();             
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			//driver = new ChromeDriver();
		
			browser = true;
		} else if (browserName.equalsIgnoreCase("IE")) {
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("browserstack.ie.enablePopups", "true");
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.URLtoInitiateIE.com");
			caps.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);    
			caps.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,"Accept");
			caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "Accept");
			caps.setCapability(InternetExplorerDriver.SILENT,true);
			caps.setCapability("disable-popup-blocking", true);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			
			caps.setCapability("ie.forceCreateProcessApi", true);
			caps.setJavascriptEnabled(true);  
			
			File f = new File("Drivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver",f.getAbsolutePath());
			driver = new InternetExplorerDriver(caps);
			browser = true;
			 driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				//driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			browser = true;
		}
	   
		driver.get(Constants.URL);
		if (browser){
			//Reporter.Insert_TC_Step("Browser should be launched", browserName + " should be launched", browserName + " is launched", "Pass", null);
		}else{
			//Reporter.Insert_TC_Step("Browser should be launched", browserName + " should be launched", "Only IE, FireFox, Chrome Browsers are allowed", "Fail", null);
			throw new NoSuchElementException("No browser found");
		}
		return driver;

	}
}

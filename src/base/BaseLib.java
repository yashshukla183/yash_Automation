package base;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseLib {
	  public static final String USERNAME = "yash119";
	  public static final String AUTOMATE_KEY = "b81csGsqWxsGpsHoVJnW";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void preCondition(String browser) throws MalformedURLException{
		if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			System.out.println("firefox launched");
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("chrome launched");
		} else if (browser.equalsIgnoreCase("browserstack")) {
 			DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "chrome");
		    caps.setCapability("browser_version", "60");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "10");
		    caps.setCapability("browserstack.debug", "true");
		    caps.setCapability("browserstack.console", "verbose");
		    caps.setCapability("browserstack.networkLogs", "true");
		    driver = new RemoteWebDriver(new URL(URL), caps);
		}
		driver.manage().window().maximize();
//		driver.get("http://wt.eckovation.com");
		driver.get("http://139.162.32.247:3004");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
   @AfterMethod
   public void postCondition()throws Exception{
	driver.quit();
		System.out.println("browser closed");
	}
}

	
	
	
	
	

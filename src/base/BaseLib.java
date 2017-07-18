package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	public WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void preCondition(String browser){
		if (browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			System.out.println("firefox launched");
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("chrome launched");
		}
		driver.manage().window().maximize();
		driver.get("http://wt.eckovation.com/");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
   public void postCondition(){
		driver.close();
		System.out.println("browser closed");
	}
}

	
	
	
	
	

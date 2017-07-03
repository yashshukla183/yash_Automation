package eckovationweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


 

//import com.eckovation.pageobjects.SignInPage;
//import com.eckovation.pageobjects.SignUpPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInTest {
	
// for valid and invalid data 
	
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://wt.eckovation.com//");
		
		
		for(int i=0; i<3; i++)
		{
			
			if(i==0)
			{
				driver.findElement(By.name("tels")).sendKeys("9655645457");
				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			    Thread.sleep(10000);
			    WebElement txt = driver.findElement(By.xpath("//div[contains(text(), 'Please sign up before you can log in.')]"));
			    String errormsg2 = txt.getText();
			    System.out.println(errormsg2);
			    driver.findElement(By.xpath("(//button[@ng-click='close()'])[1]")).click();
				
				
			}
			else if(i==1)
			{
				driver.findElement(By.name("tels")).sendKeys("2222222222");
				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			    Thread.sleep(10000);
			    WebElement txt = driver.findElement(By.xpath("//div[contains(text(), 'Failed to complete the request! Please try again later!')]"));
			    String errormsg1 = txt.getText();
			    System.out.println(errormsg1);
			    driver.findElement(By.xpath("(//button[@ng-click='close()'])[1]")).click();
			}
			else if(i==2)
			{
				driver.findElement(By.name("tels")).sendKeys("9999999999");
				driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			    Thread.sleep(10000);
				driver.findElement(By.id("otpNumber")).sendKeys("133496");
				driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
				driver.findElement(By.id("eck-profile-dropdown")).click();
				driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
			    	
			}
		}
		
		
	

	}
}


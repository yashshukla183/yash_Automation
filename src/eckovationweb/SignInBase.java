package eckovationweb;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.openqa.selenium.WebDriver;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInBase {	
	WebDriver driver;
	
	public SignInBase(WebDriver webDriver){
		driver = webDriver;
	}
	
	public String PHONE_NUMER = "9591997098";
	public String CORRECT_OTP = "133496";

	public void removePhoneNumberDataFromBackend() {
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = null;

		try {
			response = httpclient
					.execute(new HttpGet("https://apiht.pathshala.eckovation.com/ci/rph?p_no=" + PHONE_NUMER));
		} catch (IOException e) {
			e.printStackTrace();
		}
		StatusLine statusLine = response.getStatusLine();
		if (statusLine.getStatusCode() != 200) {
			Assert.fail("Server Returned Error Code : " + Integer.toString(statusLine.getStatusCode()));
		}
	}

	public void clearDataAndReachTillOtp(String otp) {
		removePhoneNumberDataFromBackend();

		Signup sup = new Signup(driver);
		sup.signUp("Student", "Test", PHONE_NUMER, "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.navigate().refresh();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		driver.findElement(By.name("tels")).sendKeys(PHONE_NUMER);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		Boolean ifFailed = false;
		try {
			driver.findElement(By.id("otpNumber")).sendKeys(otp);
		} catch (NoSuchElementException e) {
			ifFailed = true;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {

			}
		}

		if (ifFailed == true) {
			driver.findElement(By.id("otpNumber")).sendKeys(otp);
		}

		driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	}
}

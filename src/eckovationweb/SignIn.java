package eckovationweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	@FindBy(xpath="(//input[@id='otpNumber'])[1]")
	private WebElement otpSignInTxtBx;
	@FindBy(xpath="(//button[text()='Submit'])[1]")
	private WebElement submitSignInBtn;
	
	public SignIn(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void submitOTP(String otp){
		otpSignInTxtBx.sendKeys(otp);
		submitSignInBtn.click();
	}
}

package eckovationweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Signup {
	@FindBy(id="stp")
	private WebElement roleDrpDwn;
	@FindBy(id="form-first-name")
	private WebElement fullNameTxtBx;
	@FindBy(name="tel")
	private WebElement phNumForSignUp;
	@FindBy(id="form-email")
	private WebElement emailTxtBx;
	@FindBy(xpath="//button[text()='Create Profile']")
	private WebElement createProfileBtn;
	@FindBy(xpath="(//input[@id='otpNumber'])[1]")
	private WebElement otpSignUpTxtBx;
	@FindBy(xpath="(//button[text()='Submit'])[1]")
	private WebElement submitSignUpBtn;
	@FindBy(name="tels")
	private WebElement phNumForSignIn;
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signInBtn;
	@FindBy(xpath="//button[text()='join group']")
	private WebElement joingroupBtn;
	
	public Signup(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void signUp(String role, String name, String phNum, String emailID){
		Select sel=new Select(roleDrpDwn);
		sel.selectByVisibleText(role);
		fullNameTxtBx.sendKeys(name);
		//phNumTxtBx.click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		phNumForSignUp.sendKeys(phNum);
		emailTxtBx.sendKeys(emailID);
		createProfileBtn.click();
	}
	public void submitOTP(String otp){
		otpSignUpTxtBx.sendKeys(otp);
		submitSignUpBtn.click();
	}
	
	public void clickOnSignIn(String phNum){
		phNumForSignIn.sendKeys(phNum);
		signInBtn.click();
	}
	public void ClickOnjoingroup(String gpCode){
		joingroupBtn.click();
	}
	
	}

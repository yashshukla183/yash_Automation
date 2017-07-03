package eckovationweb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseLib;

public class SignupTest extends BaseLib{	
	
	@Test(priority=11)
	public void signUpTest11(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test", "9899999895", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP("133496");
		System.out.println("Signup as Student with valid details");

	}

	@Test(priority=2)
	public void signUpTest2(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "", " ", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP("133496");
	

	}
	@Test(priority=3)
	public void signUpTest3(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test                     hjasj       ", "000000000000000", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP("133496");
	}


	@Test(priority=4)
	public void signUpTest4(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test", "abcdhcbcejc", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP("133496");

	}
	@Test(priority=5)
	public void signUpTest5(){
		Signup sup=new Signup(driver);
		sup.signUp(" ", "Test", "9899999999", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP("133496");

	}

	@Test(priority=6)
	public void signUpTest6(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test", "989947489", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP("133496");

	}

	@Test(priority=7)
	public void signUpTest7(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "ABCDEF", "9899989599", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP("1@3496");

	}

	@Test(priority=8)
	public void signUpTest8(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test", "8899999899", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP("133496");

	}
	@Test(priority=9)
	public void signUpTest9(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test","9865986732", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		sup.submitOTP(" hjcbihbhi");

	}

	@Test(priority=10)
	public void signUpTest10(){
		Signup sup=new Signup(driver);
		//sup.signUp(" ", "Student ", "9876543210", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");

	}

	@SuppressWarnings("unused")
	@Test(priority=1)
	public void signInTest1(){
		Signup sup =new Signup(driver);
		
			driver.findElement(By.name("tels")).sendKeys("9383103014");
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		    try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			
			}
		    WebElement txt = driver.findElement(By.xpath("//div[contains(text(), 'Please sign up before you can log in.')]"));
		    String errormsg2 = txt.getText();
		    System.out.println(errormsg2);
		    driver.findElement(By.xpath("(//button[@ng-click='close()'])[1]")).click();
	
	}
	
	
	
	
}
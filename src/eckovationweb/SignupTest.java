package eckovationweb;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import base.BaseLib;

public class SignupTest extends BaseLib{
	@Test(priority=1)
	public void signUpTest(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test", "9899999999", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");
		System.out.println("Signup as Student with valid details");

	}
	
	@Test(priority=2)
	public void signUpTest2(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "", " ", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");
		System.out.println("Signup as teacher with valid details");
		
}
	@Test(priority=3)
	public void signUpTest3(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test                     hjasj       ", "000000000000000", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");
	
	
	
	
	
	}
	
	
	@Test(priority=4)
	public void signUpTest4(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test", "abcdhcbcejc", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");
		
	}
	@Test(priority=5)
	public void signUpTest5(){
		Signup sup=new Signup(driver);
		sup.signUp(" ", "Test", "9899999999", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");
		
	}
	
	@Test(priority=6)
	public void signUpTest6(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test", "989947449", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");
		
	}
	
	@Test(priority=7)
	public void signUpTest7(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "ABCDEF", "9899999599", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("1@3496");
		
	}
	
	@Test(priority=8)
	public void signUpTest8(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test", "8899999999", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");
		
	}
	@Test(priority=9)
	public void signUpTest9(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Test","98\7@34@@@@", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP(" ");
		
	}
	
	@Test(priority=10)
	public void signUpTest10(){
		Signup sup=new Signup(driver);
		sup.signUp("Student", "Student ", "9876543210", "abc@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sup.submitOTP("133496");
		
	}

//	@Test(priority=11)
//	public void signUpTest11(){
//		SignUpPage sup=new SignUpPage(driver);
//		sup.signUp("Student", "Student", "9876543210", "abc@gmail.com");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		sup.submitOTP("133496");
//		}
//	@Test(priority=12)
//	public void signUpTest12(){
//		SignUpPage sup=new SignUpPage(driver);
//		sup.signUp("Student", "Student", "9876543210", "abc@gmail.com");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		sup.submitOTP("133496");
//		}
//	
//	@Test(priority=13)
//	public void signUpTest13(){
//		SignUpPage sup=new SignUpPage(driver);
//		sup.signUp("Student", "Student", "9876543210", "abc@gmail.com");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		sup.submitOTP("133496");
//		}
//	
//	
//	@Test(priority=14)
//	public void signUpTest14(){
//		SignUpPage sup=new SignUpPage(driver);
//		sup.signUp("Student", "Student", "9876543210", "abc@gmail.com");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		sup.submitOTP("133496");
//		}
//	
//	
//	@Test(priority=15)
//	public void signUpTest15(){
//		SignUpPage sup=new SignUpPage(driver);
//		sup.signUp("Student", "Student", "9876543210", "abc@gmail.com");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		sup.submitOTP("133496");
//		}
}
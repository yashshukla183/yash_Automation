package eckovationweb;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseLib;

@SuppressWarnings("deprecation")
public class SignInTest extends BaseLib{	
	
	
	
	@Test(priority=1)
	public void http(){
	@SuppressWarnings("resource")
	HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = null;
	
	    try {
	        response = httpclient.execute(new HttpGet("https://apiht.pathshala.eckovation.com/ci/rph?p_no=98990617442"));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    StatusLine statusLine = response.getStatusLine();
	    if (statusLine.getStatusCode() != 200) {
	        Assert.fail(Integer.toString(statusLine.getStatusCode()));
	    }
			
		}

	public void SignInTest1(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("9899061744");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 1 executed");
	}
	
	@Test(priority=2)
	public void SignInTest2(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("9899061744");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("131177");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test2executed");
	}
	 
	@Test(priority=3)
	public void SignInTest3(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("8765432188");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 3 executed");
    	
    	
}
	
	@Test(priority=4)
	public void SignInTest4(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys(" ");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 4 executed");
    	
}
	
	
	@Test(priority=5)
	public void SignInTest5(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("9899061744");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 5 executed");
    	
}
	
	@Test(priority=6)
	public void SignInTest6(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("abgecbehsb");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 6 executed");
    	
}
	@Test(priority=7)
	public void SignInTest7(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("8474848494857584948574849494949");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 7 executed");
    	
}
	@Test(priority=8)
	public void SignInTest8(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("98 99 06 17  44");
	
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test8 executed");
    	
}
	@Test(priority=9)
	public void SignInTest9(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("9899061744");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133 496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test9 executed");
    	
}
	@Test(priority=10)
	public void SignInTest10(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("    9899061744");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 10executed");
    	
}
	@Test(priority=11)
	public void SignInTest11(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys("989906174     ");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 11 executed ");
	
	}
	@Test(priority=12)
	public void SignInTest12(){
		@SuppressWarnings("unused")
		Signup sup=new Signup(driver);
	
	driver.findElement(By.name("tels")).sendKeys(" dcbjqbccbqqbd 9899061744");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
	}
	driver.findElement(By.id("otpNumber")).sendKeys("133496");
driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]")).click();
	driver.findElement(By.id("eck-profile-dropdown")).click();
	driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
    	System.out.println("test 12 executed ");
	
}
}


	
	
	
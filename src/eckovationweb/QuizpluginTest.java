package eckovationweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseLib;
import eckovationweb.SignInTest;

public class QuizpluginTest extends BaseLib {
	
	@Test
	public void openQuiz() throws InterruptedException {
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);

		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		Assert.assertEquals(driver.getTitle(), "Quiz D");
		Assert.assertEquals((driver.findElements(By.className("title")).get(0).getText()),"Topics");
		Assert.assertEquals((driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2")).getText()),"Java Test");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[1]/a")).getText(), "Quiz Plugin" );
	}
}
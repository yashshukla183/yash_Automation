package eckovationweb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseLib;
import eckovationweb.SignInTest;

public class QuizpluginTest extends BaseLib {

	private int answer;

	@Test(priority=1)
	public void openQuizPluginMain() throws InterruptedException {
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Assert.assertEquals(driver.getTitle(), "Quiz D");
		Assert.assertEquals((driver.findElements(By.className("title")).get(0).getText()), "Topics");
		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2")));
		Assert.assertEquals((driver
				.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
				.getText()), "Java Test");
		
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='sidebar-wrapper']/ul/li[1]/a")).getText(),
				"Quiz Plugin");
		System.out.println("first priority test is executed successfully");
		driver.quit();
	}
	@Test(priority=2)
	public void SelectTopicAndLoadTests() throws InterruptedException {
		System.out.println("Select topic and load test");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();
		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		Assert.assertEquals(driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/div[3]/div/div/div[1]/div/h2")).getText(),"Java Test");
		System.out.println("tests are loaded");
		System.out.println("Second priority test is executed successfully");
	}

	@Test(priority = 3)
	public void startFirstTest() throws InterruptedException {
		System.out.println("perform test 1");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();
		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[3]/div/div[2]/button"))
		.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println(driver.getPageSource());
		String firstQuestionText = driver.findElements(By.className("question-text")).get(0).getText();
		System.out.println(firstQuestionText);
		Assert.assertNotSame(quizbase.correctAnswerForQuestion(firstQuestionText), null);
		System.out.println("test 1 is loaded with question 1 ");
		System.out.println("Third priority test is executed successfully");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority=4)
	public void AttemptAndSubmitFirstTest() throws InterruptedException {
		System.out.println("perform test 1");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles())
			driver.switchTo().window(winHandle);
		System.out.println("window is handled ");
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();
		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[3]/div/div[2]/button"))
		.click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		System.out.println(driver.getPageSource());
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),"Test 1 - NM-F,SS-F, SSU-F,SQ-F,ET-F");
		String firstQuestionText = driver.findElements(By.className("question-text")).get(0).getText();
		System.out.println(firstQuestionText);
		Assert.assertNotSame(quizbase.correctAnswerForQuestion(firstQuestionText), null);
		System.out.println("test 1 is loaded with question 1 ");
		driver.findElements(By.className("option-buttons")).get(2).click();
		System.out.println("answer 3 of test 1 is clicked ");
		Assert.assertEquals(driver.findElements(By.className("btn-primary")).get(2).getText(), "Finish");
		System.out.println("Next button is found");
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");
		Assert.assertEquals(driver.findElements(By.className("results-circle ")).get(0).getText(), "4/40");
		System.out.println("Fourth priority test is executed successfully");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority=5)
	public void attemptOneQuestionsFirstTest() throws InterruptedException {
		System.out.println("perform test 1");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();
		System.out.println("topic is clicked");
		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[3]/div/div[2]/button"))
		.click();
		System.out.println("start test is clicked");

		System.out.println(driver.getPageSource());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),"Test 1 - NM-F,SS-F, SSU-F,SQ-F,ET-F");
		System.out.println("test 1 is loaded with question 1 ");
		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();
		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);
		System.out.println(allQuestionAnswers);
		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");
		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);
		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=6)
	public void attemptTwoQuestionsFirstTest() throws InterruptedException {
		System.out.println("perform test 1");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();
		System.out.println("topic is clicked");
		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[3]/div/div[2]/button"))
		.click();
		System.out.println("start test is clicked");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),"Test 1 - NM-F,SS-F, SSU-F,SQ-F,ET-F");
		System.out.println("test 1 is loaded with question 1 ");
		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();
		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);
		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);
		System.out.println(allQuestionAnswers);
		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");
		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);
		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=7)
	public void attemptEightQuestionsFirstTest() throws InterruptedException {
		System.out.println("perform test 1");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[3]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 1 - NM-F,SS-F, SSU-F,SQ-F,ET-F");

		System.out.println("test 1 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(5, 7, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(7, 9, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(9, 3, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(3, 1, 0);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 0);

		quizbase.goToQuestionNumberAndSelectAnswer(1, 4, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(4, 6, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		System.out.println(allQuestionAnswers);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=8)
	public void testSubmissionWithoutAnswer() {
		QuizpluginBase reachtest = new QuizpluginBase(driver);
		reachtest.reachTest();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Assert.assertEquals(driver.findElements(By.className("alert-warning")).get(0).getText(), "Error Error at submitting test! please try again");
	}


	@Test(priority=9)
	public void attemptOneQuestionsSecondTest() throws InterruptedException {
		System.out.println("perform test 2");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[4]/div/div[2]/button"))
		.click();
		System.out.println("start test is clicked");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 2 - NM-T,SS-F, SSU-F,SQ-F,ET-F");
		System.out.println("test 2 is loaded with question 1 ");
		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();
		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);
		System.out.println(allQuestionAnswers);
		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(-1, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=10)
	public void attemptTwoQuestionsSecondTest() throws InterruptedException {
		System.out.println("perform test 1");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);


		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[4]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 2 - NM-T,SS-F, SSU-F,SQ-F,ET-F");

		System.out.println("test 2 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		System.out.println(allQuestionAnswers);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(-1, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=11)
	public void attemptThreeQuestionsSecondTest() throws InterruptedException {
		System.out.println("perform test 2");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[4]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");

		Thread.sleep(10000);

		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 2 - NM-T,SS-F, SSU-F,SQ-F,ET-F");

		System.out.println("test 2 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(5, 3, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2 );

		System.out.println(allQuestionAnswers);

		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(-1, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=12)
	public void attemptEightQuestionsSecondTest() throws InterruptedException {
		System.out.println("perform test 2");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[4]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");

		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 2 - NM-T,SS-F, SSU-F,SQ-F,ET-F");

		System.out.println("test 2 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(5, 7, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(7, 9, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(9, 3, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(3, 1, 0);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 0);

		quizbase.goToQuestionNumberAndSelectAnswer(1, 4, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(4, 6, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);
		System.out.println(allQuestionAnswers);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(-1, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=13)
	public void attemptOneQuestionsThirdTest() throws InterruptedException {
		System.out.println("perform test 3");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[5]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 3 - NM-F,SS-T, SSU-F,SQ-F,ET-F");

		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);


		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=14)
	public void attemptTwouestionsThirdTest() throws InterruptedException {
		System.out.println("perform test 3");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[5]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 3 - NM-F,SS-T, SSU-F,SQ-F,ET-F");
		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=15)
	public void attemptEightQuestionsThirdTest() throws InterruptedException {
		System.out.println("perform test 3");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[5]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 3 - NM-F,SS-T, SSU-F,SQ-F,ET-F");
		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(5, 7, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(7, 9, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(9, 3, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(3, 1, 0);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 0);

		quizbase.goToQuestionNumberAndSelectAnswer(1, 4, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(4, 6, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);
		System.out.println(allQuestionAnswers);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=16)
	public void attemptOneQuestionsFourthTest() throws InterruptedException {
		System.out.println("perform test 4");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[6]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 4 - NM-F,SS-F, SSU-T,SQ-F,ET-F");

		System.out.println("test 4 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);


		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=17)
	public void attemptTwouestionsFourthTest() throws InterruptedException {
		System.out.println("perform test 4");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[6]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 4 - NM-F,SS-F, SSU-T,SQ-F,ET-F");
		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 4 is  " + marks);
	}

	@Test(priority=18)
	public void attemptEightQuestionsFourthTest() throws InterruptedException {
		System.out.println("perform test 4");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[6]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 4 - NM-F,SS-F, SSU-T,SQ-F,ET-F");
		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(5, 7, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(7, 9, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(9, 3, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(3, 1, 0);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 0);

		quizbase.goToQuestionNumberAndSelectAnswer(1, 4, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(4, 6, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);
		System.out.println(allQuestionAnswers);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 4 is  " + marks);
	}

	@Test(priority=19)
	public void attemptOneQuestionsFifthTest() throws InterruptedException {
		System.out.println("perform test 5");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[7]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 5 - NM-F,SS-F, SSU-F,SQ-T,ET-F");

		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);


		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 5 is  " + marks);
	}

	@Test(priority=20)
	public void attemptTwouestionsFifthTest() throws InterruptedException {
		System.out.println("perform test 5");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[7]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 5 - NM-F,SS-F, SSU-F,SQ-T,ET-F");
		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 5 is  " + marks);
	}

	@Test(priority=21)
	public void attemptEightQuestionsFifthTest() throws InterruptedException {
		System.out.println("perform test 5");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[7]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 5 - NM-F,SS-F, SSU-F,SQ-T,ET-F");
		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(5, 7, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(7, 9, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(9, 3, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(3, 1, 0);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 0);

		quizbase.goToQuestionNumberAndSelectAnswer(1, 4, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(4, 6, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);
		System.out.println(allQuestionAnswers);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 1 is  " + marks);
	}

	@Test(priority=22)
	public void attemptOneQuestionsSixthTest() throws InterruptedException {
		System.out.println("perform test 6");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[8]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		
		System.out.println("test 3 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);


		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 6 is  " + marks);
	}

	@Test(priority=23)
	public void attemptTwouestionsSixthTest() throws InterruptedException {
		System.out.println("perform test 6");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[8]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		System.out.println("test 6 is loaded with question 1 ");

		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();

		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 1);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");
		System.out.println("Total marks in test 6 is  " + marks);
	}

	@Test(priority=24)
	public void attemptEightQuestionsSixthTest() throws InterruptedException {
		System.out.println("perform test 6");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);
		QuizpluginBase quizbase = new QuizpluginBase(driver);
		quizbase.enterGroupCodeAndOpenQuiz();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		System.out.println("window is handled");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();

		System.out.println("topic is clicked");

		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[8]/div/div[2]/button"))
		.click();

		System.out.println("start test is clicked");
		Thread.sleep(10000);
		System.out.println("test 6 is loaded with question 1 ");
		HashMap<String, Integer> allQuestionAnswers = new HashMap<>();
		quizbase.goToQuestionNumberAndSelectAnswer(0, 2, 1);
		String questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 1);

		quizbase.goToQuestionNumberAndSelectAnswer(2, 5, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(5, 7, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(7, 9, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(9, 3, 3);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 3);

		quizbase.goToQuestionNumberAndSelectAnswer(3, 1, 0);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 0);

		quizbase.goToQuestionNumberAndSelectAnswer(1, 4, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);

		quizbase.goToQuestionNumberAndSelectAnswer(4, 6, 2);
		questionText = driver.findElements(By.className("question-text")).get(0).getText();
		allQuestionAnswers.put(questionText, 2);
		System.out.println(allQuestionAnswers);

		Thread.sleep(1000);
		driver.findElements(By.className("footer-btn")).get(0).click();
		WebElement submitModal = driver.findElements(By.className("modal-content")).get(0);
		System.out.println("submit modal found");
		Thread.sleep(1000);
		submitModal.findElements(By.className("btn-primary")).get(0).click();
		Thread.sleep(1000);
		System.out.println("submit answer yes clicked");

		Integer marks = quizbase.calculateTotalScore(0, 4, allQuestionAnswers);

		Assert.assertEquals(driver.findElements(By.className("results-circle")).get(0).getText(), marks + "/40");

		System.out.println("Total marks in test 6 is  " + marks);

	}

}
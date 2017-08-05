package eckovationweb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.thoughtworks.selenium.Wait;


public class QuizpluginBase {

	String CONSTANT_GROUP_CODE = "432157";
	WebDriver driver;
	

	public QuizpluginBase(WebDriver webDriver) {
		driver = webDriver;
	}

	public void enterGroupCodeAndOpenQuiz() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,5);
		WebElement joinGroup = wait.until(ExpectedConditions.elementToBeClickable(By.id("dashboard-join-group")));
		joinGroup.click();
		System.out.println("join group is clicked");
//		WebElement element = (WebElement) driver.switchTo().activeElement();
//		System.out.println(element.getText());
		WebElement modal = driver.findElements(By.className("modal-content")).get(0);
		Boolean ifFailed = false;
		try {
			modal.findElement(By.id("gcode")).sendKeys(CONSTANT_GROUP_CODE);
			Thread.sleep(2000);
			modal.findElement(By.id("join-group")).click();
			
		} catch (Exception e) {
			ifFailed = true;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {

			}
		}
		if (ifFailed == true) {
			modal.findElement(By.id("gcode")).sendKeys(CONSTANT_GROUP_CODE);
		}
		modal.findElement(By.id("join-group")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e2) {
       System.out.println("exception :" + getmessage());
		}
	
        Thread.sleep(10000);
		System.out.println("join group button is clicked");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		
		Boolean ifFailed1 = false;
		try {
			driver.findElements(By.className("eck-btn-cg")).get(0).click();
		} catch (NoSuchElementException e) {
			ifFailed = true;
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {

			}
		}
		if (ifFailed == true) {
			driver.findElements(By.className("eck-btn-cg")).get(0).click();
		}
		WebElement pluginModal = driver.findElements(By.className("modal-dialog")).get(0);
		pluginModal.findElements(By.className("plugin-list")).get(0).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e2) {

		}
	}
	

	private String getmessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void reachTest(){
		System.out.println("perform test 1");
		SignInBase signinbase = new SignInBase(driver);
		signinbase.clearDataAndReachTillOtp(signinbase.CORRECT_OTP);

		QuizpluginBase quizbase = new QuizpluginBase(driver);
		try {
			quizbase.enterGroupCodeAndOpenQuiz();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		for (String winHandle : driver.getWindowHandles())
			driver.switchTo().window(winHandle);

		System.out.println("window is handled ");

		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[2]/div/button/div[2]/h2"))
		.click();
		Assert.assertEquals(driver.findElements(By.className("sub-topic-panel")).size(), 6);
		driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div[3]/div/div/div[3]/div/div[2]/button"))
		.click();
		Assert.assertEquals(driver.findElements(By.className("panel-title")).get(0).getText(),
				"Test 1 - NM-F,SS-F, SSU-F,SQ-F,ET-F");
		System.out.println("test 1 is loaded with question 1 ");
		
	}
	
	public void goToQuestionNumberAndSelectAnswer(int currentScreen, int qNo, int answer) throws InterruptedException {
		Thread.sleep(10000);

		// answer : 0,1,2,3
		// qNo : 0,1,2,3,4,5,6,7,8,9
		
		if (qNo >= currentScreen) {
			for (int i = 0; i < qNo - currentScreen; i++) {
				WebElement e = driver.findElements(By.className("header-bar")).get(0);
				WebElement nextButton = e.findElements(By.className("btn-primary")).get(1);
				nextButton.click();
				Thread.sleep(5000);
			}

		} else {
			for (int i = 0; i < currentScreen - qNo; i++) {
				WebElement e = driver.findElements(By.className("header-bar")).get(0);
				WebElement prevButton = e.findElements(By.className("btn-primary")).get(0);
				prevButton.click();
				Thread.sleep(5000);
			}
		}

		driver.findElements(By.className("option-buttons")).get(answer).click();
	}
	
	public Integer correctAnswerForQuestion(String questionText) {
		String[] questions = new String[]{
				"1What is the range of data type short in Java?",
				"2What is the range of data type byte in Java?",
				"3An expression involving byte, int, and literal numbers is promoted to which of these?",
				"4Which of these literals can be contained in a data type float variable?",
				"5Which four options describe the correct default values for array elements of the types indicated?",
				"6Which one of these lists contains only Java programming language keywords?",
				"7Which one of these lists contains only Java programming language keywords?",
				"8Which will legally declare, construct, and initialize an array?\"",
				"9Which will legally declare, construct, and initialize an array? ",
				"10Which is a reserved word in the Java programming language?"
		};
		
		Integer[] answers = new Integer[]{2,1,1,2,2,1,0,0,2,2};

		int questionIndex = Arrays.asList(questions).lastIndexOf(questionText);
		
		if(questionIndex == -1) {
			return null;
		}
		
		return answers[questionIndex];
	 }
	
	public Integer calculateTotalScore(Integer negativeMarking,Integer correctMarking,HashMap<String,Integer> markedAnswers) {
		Integer totalMarks = 0;
		
		String[] questions = new String[]{
				"1What is the range of data type short in Java?",
				"2What is the range of data type byte in Java?",
				"3An expression involving byte, int, and literal numbers is promoted to which of these?",
				"4Which of these literals can be contained in a data type float variable?",
				"5Which four options describe the correct default values for array elements of the types indicated?",
				"6Which one of these lists contains only Java programming language keywords?",
				"7Which one of these lists contains only Java programming language keywords?",
				"8Which will legally declare, construct, and initialize an array?",
				"8Which will legally declare, construct, and initialize an array?\"",
				"10Which is a reserved word in the Java programming language?"
		};
		
		Integer[] answers = new Integer[]{2,1,1,2,2,1,0,0,2,2};
		
		String[] markedAnswersQuestionTexts = new String[markedAnswers.keySet().size()];

		markedAnswers.keySet().toArray(markedAnswersQuestionTexts);
		
		for(int i = 0; i < markedAnswers.keySet().size(); i++) {
			String questionText = markedAnswersQuestionTexts[i];
			
			System.out.println("Question : " + questionText);
			System.out.println("Actual Correct Answer : " + correctAnswerForQuestion(questionText));
			System.out.println("Provided Answer : " + markedAnswers.get(questionText));
			
			if(markedAnswers.get(questionText) == correctAnswerForQuestion(questionText)) {
				totalMarks += correctMarking;
			} else {
				totalMarks += negativeMarking;
			}
		}
		
		return totalMarks;
		
	 }
	
	}


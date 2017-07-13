package eckovationweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuizpluginBase {
	
	String CONSTANT_GROUP_CODE = "432157";
	WebDriver driver;
	
	public QuizpluginBase(WebDriver webDriver){
		driver = webDriver;
	}

	public void enterGroupCodeAndOpenQuiz() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		System.out.println("page is refreshed ");

		driver.findElement(By.id("dashboard-join-group")).click();
		Thread.sleep(10000);
		System.out.println("join group is clicked");

		WebElement element = (WebElement)driver.switchTo().activeElement();
		System.out.println(element.getText());
		
		WebElement modal = driver.findElements(By.className("modal-content")).get(0);
		
		modal.findElement(By.id("gcode")).sendKeys(CONSTANT_GROUP_CODE);
		Thread.sleep(10000);
		modal.findElement(By.id("join-group")).click();
		Thread.sleep(10000);

		System.out.println("join group button is clicked ");
		
		driver.findElements(By.className("eck-btn-cg")).get(0).click();
		WebElement pluginModal = driver.findElements(By.className("modal-dialog")).get(0);
		
		System.out.println("going to click first plugin!");
		pluginModal.findElements(By.className("plugin-list")).get(0).click();
		System.out.println("first plugin clicked!");
		Thread.sleep(10000);
	}
}

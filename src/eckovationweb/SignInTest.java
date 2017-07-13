package eckovationweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseLib;

public class SignInTest extends BaseLib {

	@Test
	public void SigninTest1() {
		SignInBase signin = new SignInBase(driver);

		System.out.println("SignInTest 1 is being executed");

		signin.clearDataAndReachTillOtp(signin.CORRECT_OTP);
		Assert.assertEquals(driver.findElement(By.id("eck-profile-dropdown")).isDisplayed(), true);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals(((WebElement) driver.findElements(By.className("eck-bc-head")).get(0)).getText(),
				"Dashboard");
		System.out.println("Dashboard title found!");

		Assert.assertTrue(driver.getTitle().contentEquals("Eckovation"));
		System.out.println("window title matched");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals(driver.findElement(By.id("eck-profile-role")).isDisplayed(), true);
		System.out.println("profile role tracked");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}

		Assert.assertEquals(((WebElement) driver.findElements(By.className("eck-profile-name")).get(0)).getText(),
				"Test");

		System.out.println("SignInTest1 executed");
	}

	@Test
	public void SignInTest2() {

		System.out.println("SignInTest 2 is being executed");

		SignInBase signin = new SignInBase(driver);
		signin.clearDataAndReachTillOtp("123456");

		Assert.assertEquals((driver.findElements(By.className("modal-body")).get(0)).getText()
				.contentEquals("The entered OTP is not correct!"), true);
		System.out.println("Error text found!");

		Assert.assertEquals(driver.findElements(By.className("eck-bc-head")).size(), 0);
		System.out.println("Dashboard title not found!");

		System.out.println("SignInTest2 is completed!");
	}

	@Test
	public void SignInTest3() {

		System.out.println("SignInTest 3 is being executed");

		SignInBase signin = new SignInBase(driver);
		signin.clearDataAndReachTillOtp("  ");

		// Assert.assertEquals((driver.findElements(By.className("modal-body")).get(0)).getText().contentEquals("Please
		// sign up before you can log in."),true);
		System.out.println("Error text found!");

		Assert.assertEquals(driver.findElements(By.className("eck-bc-head")).size(), 0);
		System.out.println("Dashboard title not found!");

		System.out.println("Dashboard title not found!");

		System.out.println("SignInTest 3 is completed!");
	}

	@Test
	public void SignInTest4() {
		System.out.println("SignInTest 4 is being executed");

		driver.findElement(By.name("tels")).sendKeys("9899061q4245");

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Assert.assertEquals(((WebElement) driver.findElements(By.tagName("h2")).get(0)).getText()
				.contentEquals("New to Eckovation?"), true);

		System.out.println("User has not been able to login!!");

		System.out.println("SignInTest4 done!");
	}

	@Test
	public void SignInTest5() {

		System.out.println("SignInTest 5 is being executed");

		driver.findElement(By.name("tels")).sendKeys("abcdefghijdsx");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		System.out.println("Dashboard title not found!");

		System.out.println("SignIn field found");
		Assert.assertEquals(((WebElement) driver.findElements(By.tagName("h2")).get(0)).getText()
				.contentEquals("New to Eckovation?"), true);

		System.out.println("User has not been able to login!!");

		Assert.assertEquals(((WebElement) driver.findElements(By.className("navbar-brand")).get(0)).getText(),
				"Eckovation");
		System.out.println("SignInTest 5 is executed");
	}

	@Test
	public void SignInTest6() {
		System.out.println("test 6 is being executed for Unregistered no");
		driver.findElement(By.name("tels")).sendKeys("9988774455");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		Assert.assertEquals(driver.findElements(By.className("eck-bc-head")).size(), 0);
		System.out.println("Dashboard title not found!");

		Assert.assertEquals((driver.findElements(By.className("modal-body")).get(0)).getText()
				.contentEquals("Please sign up before you can log in."), true);
		System.out.println("Error text found!");
		System.out.println("test case 6 is executed ");
	}
}

// *
// * @SuppressWarnings("unused") Signup sup = new Signup(driver);
// *
// * driver.findElement(By.name("tels")).sendKeys("abgecbehsb");
// * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(
// * ); try { Thread.sleep(10000); } catch (InterruptedException e) {
// *
// * } driver.findElement(By.id("otpNumber")).sendKeys("133496");
// * driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]"))
// * .click(); driver.findElement(By.id("eck-profile-dropdown")).click();
// * driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
// * System.out.println("test 6 executed");
// *
// * }
// *
// * @Test(priority = 7) public void SignInTest7() {
// *
// * @SuppressWarnings("unused") Signup sup = new Signup(driver);
// *
// * driver.findElement(By.name("tels")).sendKeys(
// * "8474848494857584948574849494949");
// * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(
// * ); try { Thread.sleep(10000); } catch (InterruptedException e) {
// *
// * } driver.findElement(By.id("otpNumber")).sendKeys("133496");
// * driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]"))
// * .click(); driver.findElement(By.id("eck-profile-dropdown")).click();
// * driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
// * System.out.println("test 7 executed");
// *
// * }
// *
// * @Test(priority = 8) public void SignInTest8() {
// *
// * @SuppressWarnings("unused") Signup sup = new Signup(driver);
// *
// * driver.findElement(By.name("tels")).sendKeys("98 99 06 17 44");
// *
// * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(
// * ); try { Thread.sleep(10000); } catch (InterruptedException e) {
// *
// * } driver.findElement(By.id("otpNumber")).sendKeys("133496");
// * driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]"))
// * .click(); driver.findElement(By.id("eck-profile-dropdown")).click();
// * driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
// * System.out.println("test8 executed");
// *
// * }
// *
// * @Test(priority = 9) public void http2() {
// *
// * @SuppressWarnings("resource") HttpClient httpclient = new
// * DefaultHttpClient(); HttpResponse response = null;
// *
// * try { response = httpclient.execute(new
// * HttpGet("https://apiht.pathshala.eckovation.com/ci/rph?p_no=9899061744"))
// * ; } catch (IOException e) { e.printStackTrace(); } StatusLine statusLine
// * = response.getStatusLine(); if (statusLine.getStatusCode() != 200) {
// * Assert.fail(Integer.toString(statusLine.getStatusCode())); }
// *
// * }
// *
// * public void SignInTest9() {
// *
// * @SuppressWarnings("unused") Signup sup = new Signup(driver);
// *
// * driver.findElement(By.name("tels")).sendKeys("9899061744");
// * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(
// * ); try { Thread.sleep(10000); } catch (InterruptedException e) {
// *
// * } driver.findElement(By.id("otpNumber")).sendKeys("133 496");
// * driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]"))
// * .click(); driver.findElement(By.id("eck-profile-dropdown")).click();
// * driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
// * System.out.println("test9 executed");
// *
// * }
// *
// * @Test(priority = 10) public void SignInTest10() {
// *
// * @SuppressWarnings("unused") Signup sup = new Signup(driver);
// *
// * driver.findElement(By.name("tels")).sendKeys(" 9899061744");
// * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(
// * ); try { Thread.sleep(10000); } catch (InterruptedException e) {
// *
// * } driver.findElement(By.id("otpNumber")).sendKeys("133496");
// * driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]"))
// * .click(); driver.findElement(By.id("eck-profile-dropdown")).click();
// * driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
// * System.out.println("test 10executed");
// *
// * }
// *
// * @Test(priority = 11) public void SignInTest11() {
// *
// * @SuppressWarnings("unused") Signup sup = new Signup(driver);
// *
// * driver.findElement(By.name("tels")).sendKeys("989906174 ");
// * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(
// * ); try { Thread.sleep(10000); } catch (InterruptedException e) {
// *
// * } driver.findElement(By.id("otpNumber")).sendKeys("133496");
// * driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]"))
// * .click(); driver.findElement(By.id("eck-profile-dropdown")).click();
// * driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
// * System.out.println("test 11 executed ");
// *
// * }
// *
// * @Test(priority = 12) public void SignInTest12() {
// *
// * @SuppressWarnings("unused") Signup sup = new Signup(driver);
// *
// * driver.findElement(By.name("tels")).sendKeys(" dcbjqbccbqqbd 9899061744"
// * );
// * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(
// * ); try { Thread.sleep(10000); } catch (InterruptedException e) {
// *
// * } driver.findElement(By.id("otpNumber")).sendKeys("133496");
// * driver.findElement(By.xpath("(//button[contains(text(), 'Submit')])[1]"))
// * .click(); driver.findElement(By.id("eck-profile-dropdown")).click();
// * driver.findElement(By.xpath("//a[@ng-click='logout()']")).click();
// * System.out.println("test 12 executed ");
// *
// * }
// */
// }

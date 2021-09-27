package org.wtt.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wtt.docker.listener.PropertiesUtility;

public class SampleConnectGrid {

	WebDriver driver;

	@Test(priority = 1)
	public void f() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities capabilities=DesiredCapabilities.chrome();
	  capabilities.setPlatform(Platform.LINUX);
	  driver=new RemoteWebDriver(new URL(PropertiesUtility.properties.getProperty("environment.url")), capabilities);
		System.out.println("driver connected.............");
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		Assert.assertEquals("Google", title);
	}

	@Test(priority = 2)
	public void getTitle() {
		String title = driver.getTitle();
		Assert.assertEquals("Google", title);
	}

	@Test(priority = 3)

	public void SearchGoogle() throws InterruptedException, AWTException {
		driver.findElement(By.name("q")).sendKeys("Mahendra Singh Dhoni");
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		driver.findElement(By.id("logo")).click();
	}

	@Test(priority = 4)
	public void GmailLoginInValidCreds() throws MalformedURLException, InterruptedException {
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-label = 'Search']")).sendKeys("Toys");
		Thread.sleep(1000);
		driver.findElement(By.id("nav-search-submit-button"));
		Thread.sleep(1000);

	}



	@Test(priority = 5)
	public void SearchDoodle() throws Exception {
		driver.navigate().to("https://www.google.com");
		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("Independence Day");
		Thread.sleep(3000);
		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@Test(priority = 6)
	public void AboutDoodle() throws Exception {
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.findElement(By.id("latest-link")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 7)
	public void OnClickGmailLink() throws InterruptedException {
driver.navigate().to("https://www.google.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 8)
	public void GmailLoginValidCred() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("farheenradish1@gmail.,com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("farru123");
		Thread.sleep(1000);
		driver.findElement(By.xpath(" //span[text()='Next']")).click();
		Thread.sleep(2000);
	}
	@Test(priority = 9)
	public void GoogleClickFeelingLucky() throws Exception {
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		 
	}
	
	
	@Test(priority = 10)
	public void NavigateCRMApplication() {
		driver.navigate().to("https://classic.crmpro.com/index.html");
		String s =driver.getTitle();
		System.out.println("Tittle is :"+ s );
	}
	
	@Test(priority = 11)
	public void LoginCrm() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	@Test(priority = 12)
	public void close() {
		driver.close();
	}

}

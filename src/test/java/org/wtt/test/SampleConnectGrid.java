package org.wtt.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wtt.docker.listener.PropertiesUtility;

public class SampleConnectGrid {
  
	
  WebDriver driver;
  @Test
  public void f() throws MalformedURLException {
	  DesiredCapabilities capabilities=DesiredCapabilities.chrome();
	  capabilities.setPlatform(Platform.LINUX);
	 driver=new RemoteWebDriver(new URL(PropertiesUtility.properties.getProperty("environment.url")), capabilities);
	  System.out.println("driver connected.............");
	  driver.navigate().to(PropertiesUtility.properties.getProperty("google.url"));
	  String title = driver.getTitle();
	  Assert.assertEquals("Google", title);
  }
@Test(priority=2)
  public void getTitle() {
	  String title = driver.getTitle();
	  Assert.assertEquals("Google", title);
  }
  
  @Test(priority=3)
  
  public void SearchGoogle() throws InterruptedException, AWTException {
	  driver.findElement(By.name("q")).sendKeys("Mahendra Singh Dhoni");
	  Robot robot = new Robot();
		 Thread.sleep(3000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(10000);
	  	  driver.findElement(By.id("logo")).click();
  }
  
  @Test(priority=4)
  public void OnClickGmailLink() throws InterruptedException {
	 
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[text()='Gmail']")).click();
	  Thread.sleep(2000);
  }
  
  @Test(priority=5)
  public void GmailLoginValidCred() throws InterruptedException
  {
	  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("farheenradish1@gmail.,com");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("farru123");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(" //span[text()='Next']")).click();
	  Thread.sleep(2000);
	  driver.quit();
  }
  
  @Test(priority=6)
  public void GmailLoginInValidCreds() throws MalformedURLException, InterruptedException
  {
	  driver.navigate().to("https://www.amazon.in/");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//input[@aria-label = 'Search']")).sendKeys("Toys");
	  Thread.sleep(1000);
	  driver.findElement(By.id("nav-search-submit-button"));
	  Thread.sleep(1000);
	  driver.quit();
  }
  
  @Test(priority=7)
  public void GoogleClickFeelingLucky() throws Exception
  {
	  driver.navigate().to(PropertiesUtility.properties.getProperty("google.url"));
	  Thread.sleep(2000);
	  driver.findElement(By.name("btnI")).click();
	  Thread.sleep(1000);
	 boolean a = driver.findElement(By.xpath("//a[@id='archive-link-link']")).isDisplayed();
	 System.out.println("Doddles values is : "+a);
  }
  
  @Test(priority=8)
  public void SearchDoodle() throws Exception
  {
	driver.findElement(By.name("q")).sendKeys("Independence Day");
	Thread.sleep(3000);
	driver.findElement(By.id("searchbtn")).click();
	}
  
  @Test(priority=9)
  public void AboutDoodle() throws Exception
  {
	  driver.findElement(By.id("about-link")).click();
	  Thread.sleep(2000);
	driver.quit();  
  }

}

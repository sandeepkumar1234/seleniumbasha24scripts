package org.wtt.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.ITestContext;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wtt.docker.listener.PropertiesUtility;

public class SeleniumDocker{  

	
	private static WebDriver driver;
	

	@BeforeSuite
	public void setupBeforeSuite(ITestContext context) {
  		PropertiesUtility.loadApplicationProperties();
		
	}	


	@BeforeTest
	public void setUp() throws MalformedURLException {
 		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL(PropertiesUtility.properties.getProperty("environment.url")), capabilities);
  		System.out.println("driver loaded................. ");
		System.out.println(driver);
	}
	
	
	@AfterTest
	public void afterTest() throws MalformedURLException {
	}

	@Test(priority=1,description = "Launching javatpoint application")
	public void simpleTest() throws MalformedURLException {
		// Launch website  
		driver.navigate().to(PropertiesUtility.properties.getProperty("application.url")); 
		String tittle=driver.getTitle();
		System.out.println("tittle"+tittle);
		Assert.assertEquals("Tutorials List - Javatpoint", driver.getTitle());
	}


	@Test(priority=2,description = "verify checkbox click functionality")
	public void testCheckBox() throws MalformedURLException {

		WebElement element=driver.findElement(By.xpath("//*[@id=\"link\"]/div/ul/li[3]/a"));
		element.click();
		WebElement element2=driver.findElement(By.xpath("//*[@id=\"city\"]/table/tbody/tr/td/h1"));
		String expectedText = element2.getText();
		System.out.println("checkBox():"+expectedText);
		Assert.assertEquals("Java Tutorial", expectedText);
	}
    
@Test(priority=3,description = "verify enter the text in input feild")
	
public void SearchText() throws AWTException, InterruptedException {
		driver.findElement(By.id("gsc-i-id1")).sendKeys("java");
		Robot robot = new Robot();
		 Thread.sleep(3000);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	}

@Test(priority=4,description = "verify entered text is clearing")

public void clearText() {
	driver.findElement(By.id("gsc-i-id1")).clear();
}

@Test(priority=5,description = "Closing the application")

public void CloseApplication()
{
	driver.navigate().to("http://demo.guru99.com/v4/");
}


@Test(priority=6,description = "verify Launching the inet Banking Application")

public void LaunchApplication()
{
	driver.navigate().refresh();
	System.out.println("Launched application successfully");
}

@Test(priority=7,description = "verify Title")
public void VerifyTitle() {
	String title=driver.getTitle();
	System.out.println("Title is"+title);
}

@Test(priority=8,description = "verify Login")
public void Login() {
	driver.findElement(By.name("uid")).sendKeys("mngr355318");
	driver.findElement(By.name("password")).sendKeys("UdaqeqY");
	driver.findElement(By.name("btnLogin")).click();
}

@Test(priority=9,description = "verify Logout")

public void Logout1() {
	driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
	System.out.println("Logout Successfully");
	
}

@Test(priority=10,description = "verify AlertPopup")

public void AlertPopup() {
	driver.switchTo().alert().accept();
}

@Test(priority=11,description = "verify Launching the inet Banking Application")

public void LaunchApplication1()
{
	driver.navigate().to("http://demo.guru99.com/v4/");
	System.out.println("Launched application successfully");
}

@Test(priority=12,description = "verify Title")
public void VerifyTitle1() {
	String title=driver.getTitle();
	System.out.println("Title is"+title);
}

@Test(priority=13,description = "verify Login")
public void Login1() {
	driver.findElement(By.name("uid")).sendKeys("mngr355318");
	driver.findElement(By.name("password")).sendKeys("UdaqeqY");
	driver.findElement(By.name("btnLogin")).click();
}
@Test(priority=14,description = "verify Adding Customer")
public void AddCustomer() {
	driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
	String name = randomestring();
	driver.findElement(By.name("name")).sendKeys(name);
	driver.findElement(By.name("rad1")).sendKeys("male");
	driver.findElement(By.name("dob")).sendKeys("10/23/1990");
	driver.findElement(By.name("addr")).sendKeys("INDIA");
	driver.findElement(By.name("city")).sendKeys("HYD");
	driver.findElement(By.name("state")).sendKeys("Telangana");
	driver.findElement(By.name("pinno")).sendKeys("518009");
	driver.findElement(By.name("telephoneno")).sendKeys("9876543210");
	driver.findElement(By.name("emailid")).sendKeys(name+"@gmail.com");
	driver.findElement(By.name("password")).sendKeys("testing");
	driver.findElement(By.name("sub")).click();
}

public String randomestring()
{
  String generatestring = RandomStringUtils.randomAlphabetic(6);
  return(generatestring);
}

@Test(priority=15,description = "verify Logout")

public void Logout() {
	driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).click();
	System.out.println("Logout Successfully");
	
}

@Test(priority=16,description = "verify AlertPopup")

public void AlertPopup1() throws InterruptedException {
	Thread.sleep(5000);
	driver.close();
	
}
}

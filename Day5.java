package Testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day5 {
	private WebDriver driver;
	private String burl;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		burl = "http://live.demoguru99.com/";
		driver.get(burl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@Test(priority=100)
	
	public void testcase1() throws InterruptedException {
		driver.findElement(By.linkText("MY ACCOUNT")).click();
		Thread.sleep(2000);
		
		 
		for(String handle: driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		
		driver.findElement(By.linkText("CREATE AN ACCOUNT")).click();
	   driver.findElement(By.id("firstname")).sendKeys("abcd");
		driver.findElement(By.id("middlename")).sendKeys("d");
		driver.findElement(By.id("lastname")).sendKeys("eee");
		driver.findElement(By.id("email_address")).sendKeys("sairohithpan22@gmail.com");
		driver.findElement(By.id("password")).sendKeys("rohiiii");
		String tt = driver.findElement(By.id("password")).getText();
		driver.findElement(By.id("confirmation")).sendKeys("rohiiii");
		String tg = driver.findElement(By.id("confirmation")).getText();
		if(tt==tg)
		{
			System.out.println("conformation password");
		}
		else
		{
			System.out.println("not conformation password");
		}
		String firstname = driver.findElement(By.id("firstname")).getText();
		String lastname  = driver.findElement(By.id("lastname")).getText();
		driver.findElement(By.xpath("(//button[@class='button'])[1]")).click();
		String vWelcome = ("WELCOME, " + firstname + " " + lastname + "!");
	    String tWelcome = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p")).getText();
	    System.out.println("tWelcome = "+tWelcome);
	    
	    for(String handle: driver.getWindowHandles())
	    {
	    	driver.switchTo().window(handle);
	    }
	    driver.findElement(By.linkText("TV")).click();    
	    driver.findElement(By.xpath("//li/a[@class='link-wishlist']")).click();
	    
	    Thread.sleep(2000);
	    
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
	    
	    Thread.sleep(2000);
	    for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
	    
	    driver.findElement(By.id("email_address")).clear();
	    driver.findElement(By.id("email_address")).sendKeys("support@guru99.com");
	    driver.findElement(By.id("message")).clear();
	    driver.findElement(By.id("message")).sendKeys("Hey Mary!! this LCD TV looks ok, check it out !!.. cheers .. Berry");
	    
	    driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();	    
	    
	    Thread.sleep(2000);
	    
	
	    String vWishList = "Your Wishlist has been shared.";
	    String wishList = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
	    System.out.println("wishList = "+wishList);
	    try {	    	
	    	assertEquals(vWishList, wishList);
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    	    
	    Thread.sleep(2000);
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	  }
	
		
	}



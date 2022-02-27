package Testcases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {
	private WebDriver driver;
	private String burl;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		burl = "http://live.demoguru99.com/";
		driver.get(burl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(priority = 100)
	public void testcase1()
	{
		driver.findElement(By.linkText("MOBILE")).click();
		String price =  driver.findElement(By.xpath("(//span[@id='product-price-1']/span)")).getText();
		driver.findElement(By.id("product-collection-image-1")).click();
		String price1 = driver.findElement(By.xpath("(//*[@class='price'])")).getText();
		String price2 = price.replaceAll("[$,]", "");
		String price3 = price1.replaceAll("[$,]", "");
		float num = Float.parseFloat(price2);
		float num1 = Float.parseFloat(price3);
		if(num == num1)
		{
			System.out.println("the prices are same");
		}
		else
		{
			System.out.println("the prices are different");
		}
		
	}
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	   
	  }
	

}

package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class otp {
	private static final String account_id="ACdc6775ff963fecf34a75d08a4ef2d50f";
	private static final String auth_token="b4015902821c0f7640de0419ff8d7d16";
	private static WebDriver driver;
	private String burl;
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
	}
	@Test
	public void test1()
	{
		driver.get("https://www.flipkart.com/");
driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("testuser@abc.com");
driver.findElement(By.linkText("New to Flipkart? Create an account")).click();
driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("+18302823538");
// check the otp screen shot
		
	}
}

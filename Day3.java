package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day3 {
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
	@Test(priority = 1)
	public void testcase1()
	{
		driver.findElement(By.linkText("MOBILE")).click();
		driver.findElement(By.xpath("(//button[@class='button btn-cart'])[1]")).click();
		driver.findElement(By.xpath("//input[@class='input-text qty']")).sendKeys("1000");
		driver.findElement(By.xpath("//button[@class='button btn-update']")).click();
		String error = driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
		String expected = "* The maximum quantity allowed for purchase is 500.";
		if(expected.equals(error))
		{
			System.out.println("correct");
		}
		else
		{
			System.out.println(error);
		}
		driver.findElement(By.id("empty_cart_button")).click();
		String mess = driver.findElement(By.className("page-title")).getText();
		String exp = "SHOPPING CART IS EMPTY";
		if(exp.equals(mess))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println(mess);
		}
	}
	@AfterTest
	public void quit()
	{
		driver.quit();
	}

}

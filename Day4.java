package Testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day4 {
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
	public void testcase1() throws InterruptedException
	{
		driver.findElement(By.linkText("MOBILE")).click();
		String mobilepage = driver.getWindowHandle();
		driver.findElement(By.xpath("(//a[@class='link-compare'])[1]")).click();
		driver.findElement(By.xpath("(//a[@class='link-compare'])[2]")).click();
		driver.findElement(By.xpath("(//button[@class='button'])[1]")).click();
		//list is not possible if the same id's is there it will confuse which one have to take for set it takes unique id's
		Set<String> drv = driver.getWindowHandles();
		System.out.println(drv.size());
		//If you don't use an iterator but simply have a for loop and inside it use the remove method you will get exceptions because the contents of the array changes while you iterate through.
		Iterator iterator = drv.iterator();
		String currentWindowId;
		while(iterator.hasNext())
		{
			currentWindowId = (String) iterator.next();
			if(!currentWindowId.equals(mobilepage))
			{
				driver.switchTo().window(currentWindowId);
				driver.manage().window().maximize();
				String tt=driver.findElement(By.xpath("//*[@class='page-title title-buttons']/h1")).getText();
				if(tt=="COMPARE PRODUCTS")
				{
					System.out.println("true");
				}
				else
				{
					System.out.println(tt);
				}
				Thread.sleep(4000);
				driver.findElement(By.xpath("(//button[@class='button'])[1]")).click();
				
			}
		}
		
	}
	@AfterTest
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}

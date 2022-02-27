
package Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day1 {
	private  WebDriver driver;
	private String burl;
	private int scc=0;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		burl = "http://live.demoguru99.com/";
		driver.get(burl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test(priority = 100)
	public void testcase1() {
		 String demoSite  = driver.findElement(By.cssSelector("h2")).getText();
		    System.out.println(demoSite);
	}
	@Test(priority = 200)
	public void testcase2() throws IOException
	{
		driver.findElement(By.linkText("MOBILE")).click();
		 new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
		 scc = scc+1;
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String png = ("C:\\selenium\\rk.txt" + scc + ".png");
			FileUtils.copyFile(scrFile, new File(png));		
	}
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	   
	  }
	
	
}

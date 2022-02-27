package Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Irctc {
	private static WebDriver driver;
	private String burl;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		burl = "https://www.irctc.co.in/nget/train-search";
		driver.get(burl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
		@Test(priority=100)
		public void test1() throws IOException, InterruptedException, TesseractException
		{
			try
			{
		for(String handle:driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		for(String handle:driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		driver.findElement(By.xpath("//a[contains(@class,'search_btn loginText')]")).click();
		for(String handle:driver.getWindowHandles())
		{
			driver.switchTo().window(handle);
		}
		WebElement imagelement = driver.findElement(By.id("nlpCaptchaImg"));
		File src= ((TakesScreenshot)imagelement).getScreenshotAs(OutputType.FILE);
		
		String path = ("C:\\selenium\\pic8.txt"+".png");
		FileUtils.copyFile(src,new File(path));
		
		Thread.sleep(2000);
		Tesseract image = new Tesseract();
		image.setDatapath("C:\\Users\\Hp\\eclipse-workspace\\WebDriverMavenProject\\testdata");
		String str=	image.doOCR(new File(path));
		System.out.println("image optical character recognition done");
		System.out.println(str);
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}
		



}

package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class labexam1 {
	private static WebDriver driver;
	private String burl;
	@BeforeClass
	public void invokebrowser()
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
	}
	
	@Test(priority = 0)
	public void verifyTitleOfThePage()
	{
		String expectedTitle="amazon.com";
		String actualTitle;
		actualTitle = driver.getTitle();
	    if(actualTitle == expectedTitle)
	    {
	    	System.out.println("verified successful");
	    }
	    else
	    {
	    	System.out.println(actualTitle);
	    }
	}

}

package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestElementPresent {
	public static void main(String args[])
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//*[@id='identifierId']")).isDisplayed());
	}

}

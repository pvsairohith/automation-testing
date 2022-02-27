package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mmt {
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
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.linkText("Flights")).click();
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		WebElement search=driver.findElement(By.xpath("//input[contains(@class,'react-autosuggest__input react-autosuggest__input--open')]"));
		search.sendKeys("delhi");
		//search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//li[contains(@class,'react-autosuggest__suggestion react-autosuggest__suggestion--first')]")).click();
		
	}

}

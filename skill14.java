package Testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class skill14 {
	ChromeDriver driver;
	@BeforeClass
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://amazon.com");
	}
	@Test(priority = 100)
	public void searchproduct()
	{
		String productItem="";
		String category="Electronics";
		
		WebElement setdropDown =  driver.findElement(By.id("searchDropdownBox"));
		Select selcategory = new Select(setdropDown);
		selcategory.selectByVisibleText(category);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productItem);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	}
	
	@AfterClass
	public void  closeBrowser()
	{
		driver.quit();
	}

}

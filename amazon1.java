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



public class amazon1 {
	ChromeDriver driver;
	@BeforeClass
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hp\\Downloads\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
	@Test(priority = 100)
	public void searchproduct()
	{
		String productItem="Apple watch";
		String category="Electronics";
		
		WebElement setdropDown =  driver.findElement(By.id("searchDropdownBox"));
		Select selcategory = new Select(setdropDown);
		selcategory.selectByVisibleText(category);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productItem);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	}
	@Test(priority = 101)
	public void getNthproduct()
	{
	
		int productItemNumber= 4;
		String xpathexpression = String.format("//div[@data-component-type='s-search-result'][%d]", productItemNumber);
		WebElement nthproduct = driver.findElement(By.xpath(xpathexpression));
		String nthproductResult = nthproduct.getText();
		System.out.println(nthproductResult);
	}
	@Test(priority = 300, enabled = false)
	public void getAllproduct()
	{
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		String productresult;
		for(WebElement allproduct: allProducts)
		{
			productresult = allproduct.getText();
			System.out.println(productresult);
			System.out.println("------------------------");
		}
	}
	@Test(priority = 400)
	public void scrolldown()
	{
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		String productresult;
		Actions action = new Actions(driver);
		for(WebElement allproduct: allProducts)
		{
			action.moveToElement(allproduct).build().perform();
			productresult = allproduct.getText();
			System.out.println(productresult);
			System.out.println("------------------------");
		}
		
	}
	@AfterClass
	public void  closeBrowser()
	{
		driver.quit();
	}

}

package Testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Testlogin {
	public static void main(String args[])
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.echoecho.com/htmlforms11.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("(//span[@class='text']//table)[2]/tbody[1]/tr[2]/td[3]/select[1]")).sendKeys("cheese");
//WebElement dropdown = driver.findElement(By.name("dropdownmenu"));
//Select select = new Select(dropdown);
//select.selectByValue("cheese");
	
		List<WebElement> values = driver.findElements(By.xpath("(//span[@class='text']//table)[2]/tbody[1]/tr[2]/td[3]"));
		System.out.println(values.size());
	}

}

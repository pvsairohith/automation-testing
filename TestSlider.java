package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSlider {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
		WebDriver 	driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
		
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id='slider']"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, mainSlider.getSize().width/2, 0).perform();
		
	

	}

}

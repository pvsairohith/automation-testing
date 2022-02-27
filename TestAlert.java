package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAlert {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://mail.google.com/mail");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.findElement(By.className("signinbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();

	}

}

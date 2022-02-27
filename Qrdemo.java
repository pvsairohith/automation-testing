package Testcases;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Qrdemo {
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
	public void test1() throws IOException, NotFoundException
	{
		driver.get("http://qrcode.meetheed.com/qrcode_examples.php");
		String locationurl = driver.findElement(By.xpath("//img[@alt='QR Contact Example']")).getAttribute("src");
		//to read the url 
		URL  url = new URL(locationurl);
		//we are dealing with images reading the url getting image
		BufferedImage imageio = ImageIO.read(url);
		//3rd party source luminancesource getting the entire infomation
		LuminanceSource source = new BufferedImageLuminanceSource(imageio);
		//all the information will be there in form of bitdata(SQL Server BIT data type is an integer data type that can take a value of 0, 1, or NULL)
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		
		Result result = new MultiFormatReader().decode(bitmap);
		System.out.println("qr or bar code reader info is:"+ result.getText());
		driver.quit();
		
		
	}
	
}



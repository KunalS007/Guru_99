package Action_Class;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frame 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
	//	System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.cssSelector("#content")).getText());
		
		
		
	}

}

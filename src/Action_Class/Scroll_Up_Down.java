package Action_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scroll_Up_Down 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	}

}

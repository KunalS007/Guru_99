package Action_Class;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Demo 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.path2usa.com/travel-companions");
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.id("travel_date")).click();
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("December"))
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
	
		List<WebElement> dates = driver.findElements(By.cssSelector(".day"));
		
		int count = driver.findElements(By.cssSelector(".day")).size();
		for(int i =0; i<count;i++)
		{
			String text = driver.findElements(By.cssSelector(".day")).get(i).getText();
			if(text.equalsIgnoreCase("31"))
			{
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}
		
	}
	
}



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSugg_Drop 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.geckodriver.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("tes");
		
		try 
		{
			Thread.sleep(3000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='wM6W7d']"));
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("testbook"))
			{
				option.click();
				break;
			}
		}
		
	}

}

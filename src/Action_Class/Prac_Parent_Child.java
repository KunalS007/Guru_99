package Action_Class;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prac_Parent_Child 
{
    public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		String parentID = it.next();
		driver.switchTo().window(it.next());
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
		
		driver.switchTo().window(parentID);
		
		//driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".example")).getText());
	}

}

package Action_Class;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Parent_Child_Window 
{
    public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows=   driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String Email_ID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];	
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(Email_ID);
	}
    

}

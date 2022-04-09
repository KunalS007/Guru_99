import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Chebx 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
		
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='red']")).isSelected());  //Assert verify first checkbox is ticked or not
		driver.findElement(By.xpath("//input[@value='red']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='red']")).isSelected());
		
	}

}

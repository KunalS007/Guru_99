import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Radio_btn 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		
		if(driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("1"))  //Check validation with Contains classl
		{
			System.out.println("It is enabled");
			Assert.assertTrue(true);
		}	
		else
		{
			Assert.assertTrue(false);
		}
		
		
		
		
		
		
		
	}

}

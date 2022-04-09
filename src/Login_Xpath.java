import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_Xpath {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		//driver.get("www.rediff.com");
		
		//Rediff : Work
		/*driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Kunal");
		driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("123");
		
		
		driver.findElement(By.cssSelector("span[class='forgotlink']")).click();
		
		// new with contains keyword
		driver.findElement(By.xpath("//input[contains(@class,'rText')]")).sendKeys("Asdf");
		*/
		
		// Google : Below is Xpath for parent-chile traverse
		driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("Testing");
	}
	
 
}

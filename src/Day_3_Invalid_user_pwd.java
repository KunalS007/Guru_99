import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Day_3_Invalid_user_pwd {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("123");
		driver.findElement(By.name("password")).sendKeys("YtydypE");		
		driver.findElement(By.name("btnLogin")).click();
		
		// Pop-up message handling
		Alert alert = driver.switchTo().alert();
		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		Thread.sleep(5000);
	    alert.accept();
	}

}

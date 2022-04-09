import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Drop_down {

	public static void main(String[] args) 
	{
			
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.spicejet.com/");
			
			driver.findElement(By.id("divpaxinfo")).click();
			
			WebElement el1 = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
			Select drop = new Select(el1);
			drop.selectByValue("5");
			
			
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[@value='GOI']")).click();
			try 
			{
				Thread.sleep(2000);
			} catch (InterruptedException e) 
			{
				
				e.printStackTrace();
			}
			//driver.findElement(By.xpath("(//a[@value='JAI'])[2]")).click();  //By indexing find dynamic path
			
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='HYD']")).click();// By parent-child find dynamic path
			
	}

}

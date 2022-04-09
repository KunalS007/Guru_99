package Action_Class;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prints_Links_Count 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "E:\\\\geckodriver-v0.29.1-win64\\\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//1. All pages link count
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2.Footer driver a tag count[hyperlink]
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
	
		//3.Footer-Selected frame- link count
		
		WebElement columndriver =footerdriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
	
		//4.Footer-all link opened in different tabs
		
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinktab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
		}
			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it =abc.iterator();

			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}

	}
		


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ADD_Cart 
{
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		//This code for single Item we doing in and ADD to CART
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
	
		for(int i=0;i<products.size();i++) 
		{
			String name = products.get(i).getText();
			
			if(name.contains("Cucumber - 1 Kg"))
			{
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
	}

}

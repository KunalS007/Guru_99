import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ADD_Cart_Array 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] product_Name = {"Cucumber","Beetroot - 1 Kg"};
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		List<WebElement> prod_Name = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<prod_Name.size();i++)
		{
			String fetched_Name= prod_Name.get(i).getText();
			
			List<String> itemlist_Name =Arrays.asList(product_Name);
			
			if(itemlist_Name.contains(fetched_Name))
			{
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				
			}
		}
		
	}

}

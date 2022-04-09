import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prac 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		int j=0;
		String[] S_Name = {"Cucumber" , "Beetroot"};
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		List<WebElement> get_Name = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<get_Name.size();i++)
		{
			String[] exact_Name = get_Name.get(i).getText().split("-");
			String Actual_Name = exact_Name[0].trim();
			
			List<String> require_Name = Arrays.asList(S_Name);
			if(require_Name.contains(Actual_Name))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==2)
				{
					break;
				}
			}
			
		}
	}

}

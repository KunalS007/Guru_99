import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ADD_Cart_Trim_Name_Regex 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		int j=0;
		String[] name12= {"Cucumber","Betroot","Brocolli"};

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		List<WebElement> itemList = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<itemList.size();i++)
		{
			 String[] itemName = itemList.get(i).getText().split("-");
			 String formatedName = itemName[0].trim();
			//Array list 
			List<String> list_Array =  Arrays.asList(name12);
			
			
			 if(list_Array.contains(formatedName))
			 {
				 j++;
				 driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				 
				 if(j==3)
				 {
					 break;
				 }
			 }
		}
	}
}

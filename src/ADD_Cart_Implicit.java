import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ADD_Cart_Implicit 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		String[] List_Name = {"Cucumber","Beetroot"};
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		AddItem(driver,List_Name);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("PrinceodVda");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}

	public static void AddItem(WebDriver driver, String[] List_Name)
	{
		int j=0;
		List<WebElement> get_Name = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0; i<get_Name.size();i++)
		{
			String[] Fetch_Name= get_Name.get(i).getText().split("-");
			String Formated_Name = Fetch_Name[0].trim();
			List<String> Found_Name=Arrays.asList(List_Name);
		
			if(Found_Name.contains(Formated_Name))
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



package JAVAStream;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Demo 
{
	public static void main(String[] args) 
	{

		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> Lt_Items = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> Org_List = Lt_Items.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> F_List = Org_List.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(Org_List.equals(F_List));
		
		//2nd program
		//select particular item
		List<String> select_List;
		do
		{
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		select_List = rows.stream().filter(s->s.getText().contains("Rice")).
		map(s->getPrice(s)).collect(Collectors.toList());
		select_List.forEach(a->System.out.println(a));
		
		if(select_List.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(select_List.size()<1);
	}
	
	private static String getPrice(WebElement s) 
	{
		String Price_Values = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return Price_Values;
	}
}

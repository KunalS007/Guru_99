package JAVAStream;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class JaveStream_first 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//tr/td[1]"));
		
		List<String> orglist = list.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> srtlist = orglist.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(orglist.equals(srtlist));
		
		//2nd program
		// Scan the name column with getText -> Beans > Print the price
		
		List<String> Price = list.stream().filter(s->s.getText().contains("Beans")).
		map(s->getPriceVeggie(s)).collect(Collectors.toList());
		Price.forEach(a->System.out.println(a));
	}

	private static String getPriceVeggie(WebElement s) 
	{
		String PriceValues = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return PriceValues;
	}

}

package Misc;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Broken_some_links 
{

	public static void main(String[] args) throws MalformedURLException, IOException 
	{

		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
	//	String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link:links)
		{
			String url= link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respcode = conn.getResponseCode();
			System.out.println(respcode);
		
		if(respcode>400)
		{
			System.out.println("The link with text" +link.getText()+"is broken with code" +respcode);
			Assert.assertTrue(false);
		}
		}
	}

}

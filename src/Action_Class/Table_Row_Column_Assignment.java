package Action_Class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Table_Row_Column_Assignment 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		int tbl_colums = driver.findElements(By.cssSelector(".table-display tbody tr th")).size();
		System.out.println(tbl_colums);
		
		int tbl_rows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
		System.out.println(tbl_rows);
		
		System.out.println(driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr[3]")).getText());
	}

}

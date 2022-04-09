package Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test_Session_Dynamic_Drop 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]/input")).click();
		String chkName = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]")).getText();
		
		
		WebElement drpName = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(drpName);
		s.selectByVisibleText(chkName);
		
		driver.findElement(By.name("enter-name")).sendKeys(chkName);
		driver.findElement(By.id("alertbtn")).click();
		
		String text = driver.switchTo().alert().getText();
		if(text.contains(chkName))
		{
			System.out.println("Alert message success");
		}
		else
		{
			System.out.println("Something went wrong");
		}
		
		//driver.findElement(By.xpath("//div[@class='cen-right-align']/fieldset/select/option[4]")).click();
	}

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E_all  {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver gecko driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		
		
		// 1. Static dropdown, user can select the values from the list
		WebElement el2 = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select drop12 = new Select(el2);
		drop12.selectByVisibleText("USD");
	
		//You can write the static dropdown below syntax
		
		//Select drop17 = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		//drop17.selectByValue("USD");
	
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		
		// 2. Dynamic drop-down select values from the list
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='DEL']")).click();
	
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value='MAA']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3. Date Picker, select the current date only
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		
		
		// 4. Radio button and ----verify the return date disable/enable
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("It is enabled");
			Assert.assertTrue(true);
		}
		
		
	}

}

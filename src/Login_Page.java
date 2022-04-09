import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_Page {

	private static final CharSequence ExceptTitle = null;

	public static void main(String[] args) 
	{
		
		System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe" );
		WebDriver driver = new FirefoxDriver();
		
		//Test case:1
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys("mngr334996");
		driver.findElement(By.name("password")).sendKeys("YtydypE");
		driver.findElement(By.name("btnLogin")).click();
		
		//Test case:2
		String ActualTitle = driver.getTitle();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The actual Title is:" +ActualTitle);
		
		
		
		}
		
	}



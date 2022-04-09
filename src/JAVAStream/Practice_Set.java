package JAVAStream;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

public class Practice_Set 
{	
		//public static void main(String[] args) 
		/*
	     	1) Auto Suggestion list
			2) Static_Drop-down value select
			3) Dynamic Drop-down
			4) Radio Button and check the Date-picker is enable or not [validation part- Optcity, 0.5,1]
			5) Verify the Checkbox it ticked or not before selection
			6) Add to Cart single item
			7) ADD TO CART in Array
			8) ADD_TO+CART=Trim and Button 
			9) Action class, 1) Move mouse over the field, 2) enter Capital letter, 3) Select the text
			10) Parent-Child window, grab the text
			11) Frame handling 
			12) All links count, All footer links count, All links open in different tabs
			13) Practice set of dynamic not hard coded values
			14) Select Future Date-picker i)Below code is for only same month future date.
      		15) Date-Picker, Below code is for future month and date
      		16) Scroll up-down
      		17) Screen shot
      		18) Find all Broken links
      		19) Handling the windows pop-up
      		
      		Note 1: By button name: driver.findElement(By.xpath("//*[text()='AMD']")).click();
      	    Note 2: All refer lecutre 42
      	    Note 3: Ctrl+shift+F =code format
            Note 4: WebElement display with findElement not findElements
            Note 5: When links are open in new tab : Keys.chord(Keys.Control,Keys.Enter)    	     
      		 */
      

	//@Test
		public void Auto_Suggestion()
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.google.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//	
		//1.Auto Suggestion list
		//
			driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("tes");
			List<WebElement> options= driver.findElements(By.xpath("//div[@class='wM6W7d']"));
			for(WebElement option : options)
			{
				if(option.getText().equalsIgnoreCase("testbook"))
				{
					option.click();
					break;
				}
			}
		}
		//
		//2.Static_Drop-down value select
		//
	//	@Parameters({"URL"})
		//@Test
		public void Static_Drop_Down(String url_Name)
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.spicejet.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.findElement(By.cssSelector("#divpaxinfo")).click();
			
			WebElement drp_List1= driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
			Select dp = new Select(drp_List1);
			dp.selectByValue("5");
			
		}
		
		//
	    //3.Dynamic Drop-down
		//
		//@Test
		public void Dynamic_Drop_Down()
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.spicejet.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.xpath("//a[@value='PNQ']")).click();
			
			driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI']")).click();
			
	   }	
		//
		//4.Radio Button and check the Date-picker is enable or not [validation part- Optcity, 0.5,1]
		//
		
			//@Test
			public void Radio_button()
			{
				System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://www.spicejet.com/");
				
				System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("Style"));
				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
				
				System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("Style"));
				
				if(driver.findElement(By.cssSelector("#Div1")).getAttribute("Style").contains("1"))
				{
					System.out.println("Enable");
					Assert.assertTrue(true);
					
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			//
			//5.Verify the checkbox it ticked or not before selection
			//
			
			//@Test
			public void Checkbox_Button()
			{
				System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://www.ironspider.ca/forms/checkradio.htm");
				
				Assert.assertFalse(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
				driver.findElement(By.xpath("//input[@value='yellow']")).click();
				
				Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
			} 
			
			//
			//6.Add to Cart single item
			//
			
			//@Test
			public void Add_To_Cart()
			{
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://rahulshettyacademy.com/seleniumPractise/");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				List <WebElement> g1 =driver.findElements(By.cssSelector("h4.product-name"));
				
				for(int i=0;i<g1.size();i++)
				{
					String name = g1.get(i).getText();
					
					if(name.contains("Cucumber - 1 Kg"))
					{
						driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
						break;
					}
				}
			}
			
			//
			//7.ADD TO CART in Array
			//
			
			//@Test
			public void ADD_TO_Cart_Array()
			{
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://rahulshettyacademy.com/seleniumPractise/");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				String[] product_Name = {"Cucumber","Beetroot - 1 Kg"};
				
				List<WebElement> Prod_name = driver.findElements(By.cssSelector("h4.product-name"));
				for(int i =0; i<Prod_name.size();i++)
				{
					String fetched_name = Prod_name.get(i).getText();
					
					List<String> itemlist_Name = Arrays.asList(product_Name);
					
					if(itemlist_Name.contains(fetched_name))
					{
						driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
					}
				}
			}
			
			//
			// 8. ADD_TO+CART=Trim and Button 
			//
			
			//@Test
			public void ADD_TO_CART_TRIM()
			{
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://rahulshettyacademy.com/seleniumPractise/");
				 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
				String[] name12= {"Cucumber" ,"Beetroot" ,"Brocolli"};
			    int j=0;
			//	driver.get("https://rahulshettyacademy.com/seleniumPractise/");
				
				List<WebElement> Product_Name = driver.findElements(By.cssSelector("h4.product-name"));
				for(int i=0; i<Product_Name.size();i++)
				{
					String[] Fetch_Product = Product_Name.get(i).getText().split("-");
					String Format_Name = Fetch_Product[0].trim();
					List<String> list_Array = Arrays.asList(name12);
					
					if(list_Array.contains(Format_Name))
					{
						j++;
						driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
						if(j==3)
						{
							break;
						}
					}
				}
			}
			
			//
			//9. Action class, 1) Move mouse over the field, 2) enter Capital letter, 3) Select the text
			//
			//@Test
			public void Action_Class()
			{
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://www.amazon.com/");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
				Actions a = new Actions(driver);
				a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();
				
				a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Nourtek").doubleClick().build().perform();
			}
			
			//
			//10. Parent-Child window, grab the text
			//
			// @Test
			public void Parent_Child_Window()
			{
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				
				driver.findElement(By.cssSelector("a.blinkingText")).click();
				
				Set<String> windows= driver.getWindowHandles();
				Iterator<String> it = windows.iterator();
				String ParentID = it.next();
				String ChildID = it.next();
			
				driver.switchTo().window(ChildID);
				
				System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
				String Email_ID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];			
			
				driver.switchTo().window(ParentID);
				
				driver.findElement(By.id("username")).sendKeys(Email_ID);
			}
			
			//
			//11. Frame handling 
			//
			
			//@Test
			public void Frame_handling()
			{
				System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://jqueryui.com/droppable/");
				
				driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
				//driver.findElement(By.id("draggable")).click();
				Actions a2 = new Actions(driver);
				WebElement source = driver.findElement(By.id("draggable"));
				WebElement target= driver.findElement(By.id("droppable"));
				
				a2.dragAndDrop(source, target).build().perform();
				
				driver.switchTo().defaultContent();
			}
			
		//
		//12. All links count, All footer links count, All links open in different tabs
		//	
			
		//@Test
		public void Print_All_Links()
		{
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//1. all links count in particular page
			System.out.println(driver.findElements(By.tagName("a")).size());
			
			//2. all hyperlink count in footer page
			
			WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
			System.out.println(footerdriver.findElements(By.tagName("a")).size());
			
			//3. All Footer links count in particular column
			
			WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
			System.out.println(columndriver.findElements(By.tagName("a")).size());
			
			//4. All footer links open in the different tabs
			
			for(int i=0;i<columndriver.findElements(By.tagName("a")).size();i++)
			{
			  String clickontab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			  columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickontab);
			}
			
			// 5. Get the title from all opening tab
			
			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}	
		//
		//13. Practice set of dynamic not hard coded values
		//
		
		//@Test
		public void Practice_not_hard_code()
		{
			System.setProperty("webdriver.gecko.driver","E:\\\\geckodriver-v0.29.1-win64\\\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//Assert.assertFalse(driver.findElement(By.xpath("//div[@class='right-align']/fieldset/label[2]")).isSelected());
			driver.findElement(By.xpath("//div[@class='right-align']/fieldset/label[2]/input")).click();
			
			String op2 = driver.findElement(By.xpath("//div[@class='right-align']/fieldset/label[2]")).getText();
		
			WebElement dropdown= driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		    Select s = new Select(dropdown);
		    s.selectByVisibleText(op2);
		    
		    driver.findElement(By.name("enter-name")).sendKeys(op2);
		    
		    driver.findElement(By.id("alertbtn")).click();
		    
		    String text = driver.switchTo().alert().getText();
		    if(text.contains(op2))
		    {
		    	System.out.println("Alert message sucess");
		    }
		}
		
		//
		//14.Select Future Date-picker i)Below code is for only same month future date.
		//
		
		//@Test
		public void Future_Date_Picker()
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.path2usa.com/travel-companions");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			driver.findElement(By.id("travel_date")).click();
			
			
			List<WebElement> dates2 = driver.findElements(By.cssSelector(".day"));
			int count = driver.findElements(By.cssSelector(".day")).size();
			for(int i=0;i<count;i++)
			{
				String Fetch_date = driver.findElements(By.cssSelector(".day")).get(i).getText();
				if(Fetch_date.equalsIgnoreCase("31"))
				{
					driver.findElements(By.cssSelector(".day")).get(i).click();
					break;
				}
			}
		}
		
		//
		//15. Date-Picker, Below code is for future month and date
		//
		
		//@Test
		public void Date_Picker()
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.path2usa.com/travel-companions");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
			driver.findElement(By.id("travel_date")).click();
		
			while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("December"))
			{
				driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
			}
		List<WebElement> dates= driver.findElements(By.cssSelector(".day"));
		int count = driver.findElements(By.cssSelector(".day")).size();
		for(int i=0; i<count;i++)
		{
			String text = driver.findElements(By.cssSelector(".day")).get(i).getText();
			if(text.equalsIgnoreCase("31"))
			{
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}
	}

		
		//
		// 16. Scroll up-down
		//
		
		//@Test
		public void Scroll_Up_down()
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("windows.scrollBy(0,500)");
			js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		}
		
		//
		//17.Screen shot
		//
		
		//@Test
		public void Screen_Shot() throws IOException
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
			driver.get("http://www.google.com");
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("D:\\SONGS\\screenshot.png"));
		}
		
		//
		//18.Find all broken links
		//
		
	//	@Test
		public void Broken_Links() throws MalformedURLException, IOException
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
			
			//String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
			
			List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
			SoftAssert a = new SoftAssert();
			
			for(WebElement link:links)
			{
			
				String url = link.getAttribute("href");
				HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
				conn.setRequestMethod("HEAD");
				conn.connect();
				int respcode = conn.getResponseCode();
				System.out.println(respcode);
				a.assertTrue(respcode<400,"The link with text " +link.getText()+ " is broken with code" +respcode);
			}
			a.assertAll();
		}
		
		//
		//19. Handling the windows pop-up
		//
		@Test
		public void Windows_Popup()
		{
			System.setProperty("Webdriver.gecko.driver","E:\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("http://admin:admin@the-internet.herokuapp.com/");
			driver.findElement(By.linkText("Basic Auth")).click();
		}
}

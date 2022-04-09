package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Kunal_Practice 
{

	public static void main(String[] args) throws IOException 
	{
	
		Properties prop =new Properties();
		FileInputStream fis = new FileInputStream("E:\\JAVA_Automation\\Framework_Workplace\\Guru_99\\src\\data.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
		prop.setProperty("browser", "chorme");
		System.out.println(prop.getProperty("browser"));
	
		FileOutputStream fos = new FileOutputStream("E:\\JAVA_Automation\\Framework_Workplace\\Guru_99\\src\\data.properties");
		prop.store(fos, null);
	}
}



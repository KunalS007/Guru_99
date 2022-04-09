package TestNG;

import org.testng.annotations.Test;

public class login 
{
  @Test(groups={"rr"})
  public void method1() 
  {
	  System.out.println("Testing");
  }
  
  @Test
  public void method2() 
  {
	 System.out.println("Manual Testing.");
  }
}

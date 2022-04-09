package Misc;

public class test 
{
	static int count;
	int numOfcar;
	
	test()
	{
		count++;
		numOfcar = count;
	}
	
	public void printNumofCar()
	{
		System.out.println(numOfcar);
	}
	public static void main(String[] args) 
	{
		test t1 = new test();
		test t2 = new test();
		test t3 = new test();
		test t4 = new test();
		
		t1.printNumofCar();
		t2.printNumofCar();
		t3.printNumofCar();
		t4.printNumofCar();
	}

}

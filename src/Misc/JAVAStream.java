package Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

//import com.sun.tools.javac.code.Attribute.Array;

public class JAVAStream 
{
//	@Test
	public void Regular()
	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Kunal");
		names.add("Akash");
		names.add("Bhavesh");
		names.add("Ajay");
		
		int count=0;
		for(int i=0; i<names.size();i++)
		{
			String actual = names.get(i);
			if(actual.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);
	}
	
	//@Test
	public void streamFilter()
	{
		ArrayList<String> names= new ArrayList<String>();
		names.add("Kunal");
		names.add("Akash");
		names.add("Bhavesh");
		names.add("Ajay");
		
		long c =names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		long d =Stream.of("Kunal", "Akash" ,"Bhavesh" , "Ajay").filter(s->
		{	
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		
		//Print all the names of arraylist
		
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void Streamap()
	{
		Stream.of("Kunal", "Akash" ,"Bhavesh" , "Ajay").filter(s->s.endsWith("l")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
		//Stream.of("Kunal", "Shah").filter(s->s.endsWith("l")).map(s->s.toLowerCase()).forEach(s->System.out.println(s));
		
		List<String>names = Arrays.asList("Kunal" , "Akash" , "Bhavesh" ,"Ajay");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	}
}

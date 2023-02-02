package uhc.tdd.practice;

import org.testng.annotations.Test;

public class Defaultvalue {

	String string;
	int a;
	boolean b;
	char c;

	@Test(enabled = false)
	public void defaultValueTesting() {
		System.out.println(string);
		System.out.println(a);
		System.out.println(b);
		System.out.println((int) c);
		
	}
	
	
	@Test
	public void parselongValidation() {
		String a = " 123* ";
		String b = a.trim().replaceAll("[^0-9]", "");
		System.out.println(Long.parseLong(b));
	}
	

}

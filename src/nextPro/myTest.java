package nextPro;

import java.util.*;
import project.Customer;

public class myTest extends Customer{
	
	  myTest (String name, int noOfTickets, int age, ArrayList<String> tickets){
		super(name, noOfTickets, age, tickets);
	}
	
	void b() {
		System.out.println(this.age);
	}
	
	static ArrayList<String> array = new ArrayList<>();
	
	public static void main(String args[] ) {
		myTest c8 = new myTest("Praveen", 12, 210, array);
		c8.b();
		
	}
}

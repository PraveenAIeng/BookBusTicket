package project;

import java.util.ArrayList;

public class Customer{
	public String name;
	public int noOfTickets;
	protected int age;
	public ArrayList<String> tickets;
	
	public Customer(String name, int noOfTickets, int age, ArrayList<String> tickets) {
	
		this.name = name;
		this.noOfTickets = noOfTickets;
		this.age = age;
		this.tickets = tickets;
	}
}
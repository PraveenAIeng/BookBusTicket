package project;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static ArrayList<Customer> dataBase = new  ArrayList<Customer>();
	
	static int[][] busMatrix = new int[9][9];
	static int balanceTicket = 81;
	
	
	
	static void bookMyTicket() {
		
		int i, j;
		
		System.out.print("How many Ticket needed.....-> ");
		int count = sc.nextInt();
		
		if (count <= balanceTicket) {
			System.out.println("Please Choose you choise of column based on avilablity...");
			
			System.out.println("A B C D E F G H I");
			for (i=0; i<9; i++) {
				for (j=0; j<9; j++)
					System.out.print( busMatrix[i][j] + " ");
				System.out.println();
			}
			System.out.println();
			
			int column;
			while (true) {
				System.out.print("Please Enter your column .....  ");
				column = sc.next().charAt(0);
				//System.out.println(column);
				
				if (column > 73 || column < 65) {
					System.out.println("Please Enter the valid column.... (A B C D E F G H I)....... ");
					column = sc.next().charAt(0);
				}
				int tempCount = 0;
				for (i=0; i<9; i++) {
					if ( busMatrix[i][column-65] == 0 ) {
						tempCount++;
					}
				}
				
				if (tempCount < count) {
					System.out.println("There is no amount of ticket in this column..... Choose another column");    
				}else {
					break;
				}
			}
			
			
			ArrayList<String> customerTickerArray = new ArrayList<String>();
			int tCount = count;
			
			for (i=0; i<9; i++) {
				if (count < 1)
					break;
				if (busMatrix[i][column-65] == 0) {
					busMatrix[i][column-65] = 1;
					char seetCol = (char)column;
					customerTickerArray.add(seetCol + String.valueOf(i));
					count--;
				}
			}
			
			System.out.println("Enter your name.... ");
			String test = sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Enter your age.... ");
			int age = sc.nextInt();
			Customer c1 = new Customer(name, tCount, age, customerTickerArray);
			dataBase.add( c1 );
			
			System.out.println("*** Congralulation, Your Ticket Booking Conformed*******");
			System.out.println("Your Ticket Id is " + dataBase.size() );
			System.out.println();
			
			
		}else {
			System.out.println("There is no this amount seets....");
		}
		
	}
	
	static void viewTicketAvail() {
		int i,j;
		
		System.out.println("A B C D E F G H I");
		
		for (i=0; i<9; i++) {
			for (j=0; j<9; j++)
				System.out.print( busMatrix[i][j] + " ");
			System.out.println();
		}
			
		
			
	}
	
	
	static void cancelMyTicket() {
		System.out.print(".....Enter Your Ticket Id ....");
		int id = sc.nextInt();
		System.out.println(".....Enter your Ticket holder Name....");
		String t = sc.nextLine();
		String name = sc.nextLine();
		
		Customer c = dataBase.get(id-1);
		if (c.name.equals(name)) {
			int col = c.tickets.get(0).charAt(0);
			col = col-65;
			for (int i = 0; i<c.noOfTickets; i++) {
				int r = Integer.parseInt( c.tickets.get(i).substring(1) );
				busMatrix[r][col] = 0;
				
				
			}
			dataBase.set( (id-1), null);
			System.out.println("Your Ticket is cancled");
			System.out.println(dataBase);
		}else {
			System.out.println("Your Data is invalid...");
		}
	}
	
	static void displayAllCustomer() {
		int i;
		for (i = 0; i<dataBase.size(); i++) {
			Customer temp = dataBase.get(i);
			System.out.print(i+1 + ": " );
			System.out.println("Name: " + temp.name);
			System.out.println("   Age: " + temp.age);
			System.out.println("   Number of Tickets: " + temp.noOfTickets);
			System.out.println("   Tickets Detaials: " + temp.tickets);
			System.out.println();
		}
	}
	

	
	public static void main(String[] args) {
		System.out.println(".....Welcome to ZOHO Bus....");
		
		while (true) {
			System.out.println("choose your menu...");
			System.out.println();
			
			System.out.println("1. Book My Ticket");
			System.out.println("2. View Seat Availability");
			System.out.println("3. Cancel My Ticket");
			System.out.println("4. View All Customers");
			System.out.println("5. Exit");
			System.out.println();
			
			
			int choise = sc.nextInt();
			
			switch (choise) {
			case 1:
//				bookMyTicket();
				One.one = "10";
				System.out.println(One.one);
				
				One o = new One();
				o.one = "11";
				
				One o1 = new One();
				System.out.println(o1.one);
				
				break;
			case 2:
				viewTicketAvail();
				break;
			case 3:
				cancelMyTicket();
				break;
			case 4:
				displayAllCustomer();
				break;
			case 5:
				System.exit(choise);
				break;
			default:
				System.out.println("Enter Valid input...**** #####");
			}
			
		}
		
	}
	
	

}

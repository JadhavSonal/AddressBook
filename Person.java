import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

		public class Person implements Comparable<Person> {
		private String Name;
		private String Number;
		private String City;
		private String Address;
		private String Zip;
	
	
		public void Test(String name, String number, String city, String address, String zip )
		{
			this.Name=name;
			this.Number=number;
			this.City=city;
			this.Address=address;
			this.Zip=zip;
		}
		
		public String toString() {
			return "Person [Name= " + getName() + ", Number= " + getNumber() + ", City= " + getCity()+ ",Address= "+getAddress()+",Zip= "+getZip()+"]";
		}
 
		public void setName(String name)
		{
			this.Name = name;
		}
		public String getName()
		{
			return Name;
		}

		public void setNumber(String number)
		{
			this.Number = number;
		}
		public String getNumber()
		{
			return 	Number;
		}

		public void setCity(String city)
		{
			this.City = city;
		}
		public String getCity()
		{
			return City;
		}

		public void setAddress(String Address)
		{
			this.Address = Address;
		}
		public String getAddress()
		{
			return Address;
		}

		public void setZip(String Zip)
		{
			this.Zip = Zip;
		}
		public String getZip()
		{
			return Zip;
		}
	static ArrayList<Person> nums=new ArrayList<Person>();
	public static void main(String[]args) {
		menu();
	}
	public static void menu() 
	{
		
		    Scanner sc=new Scanner(System.in);
			System.out.println("-----------------MENU---------------------");
			System.out.println("1.CREATE");
			System.out.println("2.UPDATE");
			System.out.println("3.DELETE");
			System.out.println("4.SORT BY NAME");
			System.out.println("5.DISPLAY");
			System.out.println("6.SORT BY ZIP");
			System.out.println("Enter your choice");
			int choice =sc.nextInt();
			switch(choice)
			{
			case 1:
				add();
			case 2:
				update();
			case 3:
				delete();
			case 4:
				sortbyname();
			case 5:
				display();
			case 6:
				sortbyzip();
			}
			
		}
		
	public static void add() 
	{
	    Scanner sc = new Scanner(System.in);
	    char ans;
	    int total;

	    do {

	        System.out.println("NUMBER OF PERSON ADDRESS YOU WANT TO INPUT: ");
	        total = sc.nextInt();
	        Person[] per = new Person[total];

	        	for (int index = 0; index < per.length; index++) {

	            System.out.print("**********ADDRESS INFORMATION**********\n");
	            per[index] = new Person();
	            System.out.print("\nPerson:"+(index+1));
	            sc.nextLine();
	            System.out.print("\nEnter Name of Person: \n");
	            per[index].setName(sc.nextLine());

	            System.out.print("\nEnter Contact Number of Person:\n ");
	            per[index].setNumber(sc.nextLine());

	            System.out.print("\nEnter City: \n");
	            per[index].setCity(sc.nextLine());

	            System.out.print("\nEnter Address of Person: \n");
	            per[index].setAddress(sc.nextLine());

	            System.out.print("\nEnter Zipcode:\n ");
	            per[index].setZip(sc.nextLine());

	            nums.add(per[index]);

	        }

	        System.out.print("Would you like to Continue (y/n)? ");
	        String answer = sc.next();
	        ans = answer.charAt(0);

	    } while (ans == 'y');
	    menu();
	}
	
	public static void update() {
		Scanner sc = new Scanner(System.in);
		String idnum = new String();    
	    System.out.print("Enter Person Name ..Then go for Modification : ");
	    idnum = sc.nextLine();
	    	for(Person per:nums)
	    	{
	    		if(per.getName().equals(idnum) )
	    		{
	    			
	    			System.out.print("Is there any changes required for a previous name..Update Now!!:\n ");
	    			per.setName(sc.nextLine());
	    			
	    			System.out.print("Enter Contact Number of Person:\n ");
	    			per.setNumber(sc.nextLine());

	    			System.out.print("\nEnter City: \n");
	    			per.setCity(sc.nextLine());

	    			System.out.print("\nEnter Address of Person: \n");
	    			per.setAddress(sc.nextLine());

	    			System.out.print("\nEnter Zipcode:\n ");
	    			per.setZip(sc.nextLine());
	    		}  		
	    	}
	    
	    menu();
	    
	}	    
    
	
	public static void delete() {
		Scanner sc = new Scanner(System.in);
		String num = new String();    
	    System.out.print("Enter Person Name .. ");
	    num = sc.nextLine();
	    for(int index = 0; index < nums.size(); index++)
	    {
	       if(nums.get(index).getName().equals(num))
	       {
	          nums.remove(index);
	          break;
	       }	    	   
	    }
	    display();
		menu();
	}
	
	
	public static void sortbyname() {
		Collections.sort(nums, Comparator.comparing(Person::getName));
		nums.forEach(System.out::println);
		menu();
	}
	
	
		public static void display() {
		Scanner sc = new Scanner(System.in);
		
		if(nums.size() == 0)
	    {
	        System.out.print("EMPTY........PLEASE INPUT FIRST\n");
	        sc.nextLine();
	    }
	    else
	    {
	    	 for (Person s : nums) 
	         {
	             System.out.print("\nName :"+s.getName()+"\nNumber :"+s.getNumber()+"\nCity :"+s.getCity()+"\nAddress :"+s.getAddress()+"\nZipCode :"+s.getZip());
	             System.out.print("\n---------------------------------------------------------\n");
	         }
	         
	    }
	menu();
		
	}
	public static void sortbyzip()
	{
		Collections.sort(nums, Comparator.comparing(Person::getZip));
		nums.forEach(System.out::println);
		menu();
	}

	@Override
	public int compareTo(Person o) {
		return 0;
	}
}

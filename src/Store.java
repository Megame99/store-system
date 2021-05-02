/*
 * Assessment: Lab 07
 * Student Name: Megan Machkouri
 * Due Date: March 21st 2021
 * Description:  A Java class that is used to initialize and instantiate an array of Employees. Constructor is parameterized
 * and is employed to set the size of the Employee array and the name. This class contains 1 public void methods, and 3 private void methods
 * which are invoked within the public method(implementation hiding).
 * Professor Name: James Mwangi
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is to represent a Store Object. This class contains two private fields; an array of Employee Objects and
 * name. This class serves to initialize an array of Employee Object and intializes fields according to user input. This class is capable 
 * of reading, testing and printing user input. 
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */

public class Store {
	/** Store's List of Employees**/
	private ArrayList<Employee> employees2 = new ArrayList<Employee>();//ArrayList of Employee Objects
	//private Employee[] employees; //Array of Employee Objects
	/** The Name of The Store**/
	private static String name;
	/** Loop Counter Variable **/
	private int i = 0;//loop counter variable (tracks array size)
	/** Scanner object **/
	public static Scanner input = new Scanner(System.in);
	
	/**
	 * @param name
	 * @param size
	 */
	//Parameterized Constructor, initializes array size and name
	public Store(String name, int size) {
		Store.name = name;
		this.employees2.ensureCapacity(size);
	
	}
	/**
	 *This is a method that prints a menu options list to the user. It takes user input and utilizes a selection structure, to invoke
	 *the selected option. It makes calls to various methods within the class, and it also initializes Regular and Contractor Objects and
	 *adds them to the Employee ArrayList.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	public void readDetails() {
		boolean shouldContinue = true; //loop control variable
		


		while(shouldContinue) {
			try {// Control Loop
				//creating an instance for Scanner class
				Scanner input = new Scanner(System.in);
				// Print MEnu Options
				System.out.println("1. Read Employee Details from the User" );
				System.out.println("2. Read Details From the File");
				System.out.println("3. Print Employee Details");
				System.out.println("4. Quit");
				if(!input.hasNextInt()) {
					throw new InputMismatchException("Must be integer.");
				} else {
					var choice = input.nextInt();
					if (choice == 1) {
						if(i <= employees2.size()) {
							System.out.println("Enter Details of Employee: " );
							System.out.println("1. Regular");
							System.out.println("2. Contractor");
							var choice2 = input.nextInt();
							if (choice2 == 1) {//selection structure in order to select type of employee
								Regular reg = new Regular(null, null, null, 0, 0, 0); //Polymorphism
								reg.readInfo(input);//Method call To read Employee Info
								employees2.add(reg);// adding Regular Object to Employee Array
								i++;
							} else if (choice2 == 2) {
								Contractor contract = new Contractor(null, null, null, 0, 0, 0, 0); //Polymorphism
								contract.readInfo(input); //Method call To read Employee Info
								employees2.add(contract);// adding Contract Object to Employee Array
								i++;
							} else
								continue;
						}else {
							System.err.println("Array is Full...cannot add more elements!");
						}

					} 
					else if (choice == 2) { //Print Report
						String regular = "r";
						try { //Try Block
							input = new Scanner(Paths.get("C:\\employees.txt")); 
						}
						catch(FileNotFoundException fe) { //Catch Block
							System.err.println("Error Opening File");
						}
						catch(IOException ioe) { //Catch Block
							System.err.println("IOE");
						}
						while (input.hasNext() && i <= employees2.size()){
							if(input.next().equalsIgnoreCase(regular)) { //selection structure in order to select type of employee
								Regular reg2 = new Regular(null, null, null, 0, 0, 0); //Initialize Regular Employee
								//Re-Initialize Employee Fields with Corresponding File Data
								reg2.employeeNumber = input.nextInt();
								reg2.firstName = input.next();
								reg2.lastName = input.next();
								reg2.emailID = input.next();
								reg2.phoneNumber = input.nextLong();
								reg2.salary = input.nextDouble();
								employees2.add(reg2);
								i++; //increment Control Variable	
							}
							else {
								Contractor con = new Contractor(null, null, null, 0, 0, 0, 0); //Initialize Regular Employee
								//Re-Initialize Employee Fields with Corresponding File Data
								con.employeeNumber = input.nextInt();
								con.firstName = input.next();
								con.lastName = input.next();
								con.emailID = input.next();
								con.phoneNumber = input.nextLong();
								con.hourlyRate = input.nextDouble();
								con.numHours = input.nextDouble();
								employees2.add(con);
								i++; //increment Control Variable	
							}

						}
					}
					else if (choice == 3) {
						if(i > 0) {
							printLine();
							printTitle();
							printLine();
							printDetails();
							//reset control variable
							continue; //Continue Loop
						}else {
							System.err.println("No elements in the array!");
							continue;
						}//Read Data From File
						
					}

					else if (choice == 4) {
						shouldContinue = false;
						System.out.println("Goodbye...");
						input.close();
					}
					else { // Resets loop and displays error message if value is out of acceptable range
						System.out.println("Wrong Employee Type. Try again");

						continue;//Continue Loop
					}
				}
			}

			catch(InputMismatchException im) { // Catch Block
				System.err.println("Input Mismatch Exception. " + im.getMessage()); //Error Message

			}
		}
	}
		
	
	
	/**
	 *This is a method that prints a formatted string of a table header. It then iterates over an Employee Array and prints a formatted string 
	 *of the instance variables of an Employee Object.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	public void printDetails() {
		String str2 = String.format("%10s|", "Emp#");
		String str3 = String.format("%20s|", "Name");
		String str4 = String.format("%20s|", "Email");
		String str5 = String.format("%15s|", "Phone");
		String str7 = String.format("%15s|", "Salary");
		
		System.out.printf(str2 + str3 + str4 + str5 + str7);//Formatted Ouput
		System.out.println();
		printLine();
		for(int j = 0; j < employees2.size(); j++) {//Iterating Employee array
			employees2.get(j).printInfo();// Invoking print method on Employee object(s)
			System.out.println();
		}
	}
	
	
	/**
	 *This is a private static method that prints the title of our Management System. Invoked within the class.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	private static void printTitle() {
		System.out.println("					" + name + " " + "Store Management System");
		
	}
	
	/**
	 *This is a private static method that prints a line. Invoked within the class.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	private static void printLine() {
		System.out.println("==========================================================================================================");
	}
	
	
	
}

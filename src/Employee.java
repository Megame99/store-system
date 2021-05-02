/*
 * Assessment: Lab 07
 * Student Name: Megan Machkouri
 * Due Date: March 21st 2021
 * Description: A parent class of our program, it is inherited by two classes in our program. It contains 1 field; double employeeNumber. These fields are inherited by all 
 * Person Objects. The constructor is parameterized and initializes all fields and invokes the super construtor. It contains two public void methods one for reading user 
 * input and the second for displaying user input(abstract). Both methods invoke the superclass(PErson) method and provide additional functionality.
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The superclass of our program This class extends 
 * Employee class, and inherits all methods and fields. It invokes superclass methods, but
 * also provides additional unique functionality. It contains one unqiue field; salary. 
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */
public class Employee extends Person{
	/** The unique number assigned to an employee**/
	protected int employeeNumber;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param emailID
	 * @param phoneNumber
	 * @param employeeNumber
	 */
	public Employee(String firstName, String lastName, String emailID, long phoneNumber, int employeeNumber) {
		super(firstName, lastName, emailID, phoneNumber);//Invokes super class constructor
		
		this.employeeNumber = employeeNumber;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 *This is an overriden method inherited from the Person Class. It prints a formatted output 
	 *of all class fields.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		String str2 = String.format("%10d|", employeeNumber);
		String str3 = String.format("%20s|", firstName + " " + lastName);
		String str4 = String.format("%20s|", emailID);
		String str5 = String.format("%15s|", phoneNumber);
		//System.out.println("\n");
		System.out.printf(str2 + str3 + str4 + str5);//Print Formatted Output
	}


	/**
	 *This method reads user inputs and initializes Employee Fields according to input.
	 *@param scanner
	 *			The scanner object used to read user input.
	 *@return Nothing. 
	 */

	@Override
	public void readInfo(Scanner scanner) {
	
		boolean btrue = true;//Control Variable
		
		do {// Initialize Loop
			try {//Try Block
				System.out.print("Enter employee number: ");//User Prompt Message
				scanner.nextLine();//Clear Print Stream 
				//Selection Structure
				if(!scanner.hasNextDouble()) {// Error Check
					throw new InputMismatchException("Must be integer.");//Output Descriptive Error Message
				}else {
					employeeNumber = scanner.nextInt();// Sets employeeNumber only if input is a double
					scanner.reset();// Reset Scanner
					btrue = false;// Break Loop
				}
					
			}
			catch(InputMismatchException im) {// Catch Block
				System.err.println("Input Mismatch Exception. " + im.getMessage());//Error Message
				scanner.reset();// Reset Scanner
			} 
			
		} while(btrue);// Control Variable
		super.readInfo(scanner);//Invokes super class method
	}

	
}

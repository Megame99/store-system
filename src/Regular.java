/*
 * Assessment: Lab 07
 * Student Name: Megan Machkouri
 * Due Date: March 21st 2021
 * Description:   A sublass class of our program, inherits all Employee methods and fields, as well as Person methods/fields. It contains 1 additional fields;
 * double salary. It inherits two void methods, and invokes the super class method for both methods. It also provides added functionality unique to Regular Objects for both inherited methods.
 * It contains a parametrized constructor.
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is to represent a Regular object. This class extends 
 * Employee class, and inherits all methods and fields. It invokes superclass methods, but
 * also provides additional unique functionality. It contains one unqiue field; salary. 
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */
public class Regular extends Employee{
	/** The annual salary in dollars **/
	protected double salary = 0.0;

	/**
	 * @param firstName
	 * @param lastName
	 * @param emailID
	 * @param phoneNumber
	 * @param employeeNumber
	 * @param salary
	 */
	//Parametrized Constructor
	public Regular(String firstName, String lastName, String emailID, long phoneNumber, int employeeNumber,
			double salary) {
		super(firstName, lastName, emailID, phoneNumber, employeeNumber);//Invokes super class constructor
		this.salary = salary;
	}

	/**
	 *This is an overriden method inherited from the Employee Class. It invokes the superclass method and also prints a formatted output 
	 *of all class fields.
	 *@param Nothing.
	 *@return Nothing. 
	 */
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();//Invokes super class method
		String str8 = String.format("%15.2f|", salary);//String Formatted
		System.out.printf(str8);
	}
	
	/**
	 *This is an overriden method that invokes superclass(Employee) method. It alo prompts and reads additional user input 
	 *in order to initialize Regular field.
	 *@param scanner
	 *			The scanner object used to read user input.
	 *@return Nothing. 
	 */
	@Override
	public void readInfo(Scanner scanner) {
		boolean btrue = true;//Control Variable
		super.readInfo(scanner);//Invokes super class method
		scanner.reset();//Reset Scanner(Prevent Errors)
		do {// Initialize Loop
			try { //Try Block
				System.out.print("Enter annual salary: ");//User Prompt Message
				scanner.nextLine();
				//Selection Structure
				if(!scanner.hasNextDouble()) {// Error Check
					throw new InputMismatchException("Must be integer."); //Output Descriptive Error Message
				}else {
					salary = scanner.nextDouble(); // Sets Salary if input is a double
					scanner.reset();// Reset Scanner
					btrue = false;// Break Loop
				}
					
			}
			catch(InputMismatchException im) { // Catch Block
				System.err.println("Input Mismatch Exception. " + im.getMessage()); //Error Message
				scanner.reset();// Reset Scanner
			} 
			
		} while(btrue); // Control Variable
		
	}
	
	
	
}

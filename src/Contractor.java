/*
 * Assessment: Lab 07
 * Student Name: Megan Machkouri
 * Due Date: March 21st 2021
 * Description:   A sublass class of our program, inherits all Employee methods and fields, as well as Person methods/fields. It contains 2 additional fields;
 * double hourlyRate and numHours. It inherits two void methods, and invokes the super class method for both methods. It also provides added functionality unique to Contractor Objects for both inherited methods.
 * It contains a parametrized constructor.
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * The purpose of this class is to represent a Contractor object. This class extends 
 * Employee class, and inherits all methods and fields. It invokes superclass methods, but
 * also provides additional functionality. It contains two unique fields; hourlyRate and numHours. 
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */
public class Contractor extends Employee{
	/** The hourly rate in dollars **/
	protected double hourlyRate = 0;
	/** The number of hours worked **/
	protected double numHours = 0;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param emailID
	 * @param phoneNumber
	 * @param employeeNumber
	 * @param hourlyRate
	 * @param numHours
	 */
	//Parametrized Constructor
	public Contractor(String firstName, String lastName, String emailID, long phoneNumber, int employeeNumber,
			double hourlyRate, double numHours) {
		super(firstName, lastName, emailID, phoneNumber, employeeNumber); //Invokes super class constructor
		this.hourlyRate = hourlyRate;
		this.numHours = numHours;
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
		super.printInfo(); //Invokes super class method
		String str8 = String.format("%15.2f|", hourlyRate*numHours);//String Formatted
		System.out.printf(str8);
	}
	
	/**
	 *This is a  overriden method that invokes superclass(Employee) method. It alo prompts and reads additional user input 
	 *in order to initialize Contractor fields.
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
			try {//Try Block
				System.out.print("Enter hourly rate: ");//User Prompt Message
				scanner.nextLine();
				//Selection Structure
				if(!scanner.hasNextDouble())// Error Check
					throw new InputMismatchException("Must be integer.");//Output Descriptive Error Message
				else {
					hourlyRate = scanner.nextDouble();
					System.out.print("Enter number of hours worked: ");//User Prompt Message
					if(!scanner.hasNextDouble())// Error Check
						throw new InputMismatchException("Must be integer.");//Output Descriptive Error Message
					else {
						numHours = scanner.nextDouble();// Sets numHours if input is a double
						scanner.reset();// Reset Scanner
						btrue = false;// Break Loop
					}
				}
			}catch(InputMismatchException im) {// Catch Block
				System.err.println("Input Mismatch Exception. " + im.getMessage());//Error Message
				scanner.reset();// Reset Scanner
			} 
		}while(btrue);// Control Variable
	}
	
	
}

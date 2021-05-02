/*
 * Assessment: Lab 07
 * Student Name: Megan Machkouri
 * Due Date: March 21st 2021
 * Description: A parent class of our program, it is the foundation of our program. It contains 5 fields; String firstName,
 * String lastName, String emailID, long phoneNumber. These fields are inherited by all Person Objects. The constructor is parameterized and initializes all fields. IT contains
 * two public void methods one for reading user input and the second for displaying user input(abstract).
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The superclass of our program, this abstract class contains the foundation of our program. The purpose f this class is to represent a Person object.
 * This class will be inherited by other classes within our program.  It contains two methods; an abstract and regular method
 * which will be inherited and overriddenby all classes that extend this program. It contains four protected fields and a parametrized constructor.
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */
public abstract class Person {
	/** A person's first name. **/
	protected String firstName = " ";
	/** A person's last name. **/
	protected String lastName = " ";
	/** A person's email address. **/
	protected String emailID = " ";
	/** A person's phone number. **/
	protected long phoneNumber = 0;
	/**
	 * @param firstName
	 * @param lastName
	 * @param emailID
	 * @param phoneNumber
	 */
	//Parametrized Constructor
	public Person(String firstName, String lastName, String emailID, long phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 *This method reads user inputs and initializes Person Fields according to input. 
	 *@param scanner
	 *			The scanner object used to read user input.
	 *@return Nothing. 
	 */
	public void readInfo(Scanner scanner) {
		boolean bTrue =true;//Control Variable
		do {// Initialize Loop
			try {//Try Block

				System.out.print("Enter first name: ");//User Prompt Message
				scanner.nextLine();
				//Selection Structure
				if(scanner.hasNextDouble()||scanner.hasNextInt()) {// Error Check
					throw new InputMismatchException("Must be string");//Output Descriptive Error Message
				} else {
					firstName = scanner.nextLine();// Sets firstName if input is a string
					System.out.print("Enter last name: ");//User Prompt Message
					//Selection Structure
					if(scanner.hasNextDouble()||scanner.hasNextInt()) {// Error Check
						throw new InputMismatchException("Must be string");//Output Descriptive Error Message
					}else {
						lastName = scanner.nextLine();// Sets lastName if input is a string
						System.out.print("Enter email: ");//User Prompt Message
						//Selection Structure
						if(scanner.hasNextDouble()||scanner.hasNextInt()) {// Error Check
							throw new InputMismatchException("Must be string");//Output Descriptive Error Message
						}else {
							emailID = scanner.nextLine();// Sets email if input is a string
							System.out.print("Enter phone: ");//User Prompt Message
							//Selection Structure
							if(!scanner.hasNextLong()) {// Error Check
								throw new InputMismatchException("Must be long");//Output Descriptive Error Message
							}else {
								phoneNumber = scanner.nextLong();// Sets phone if input is a long
								bTrue = false;// Break Loop
							}
						}
					}
				}
			}
			catch(InputMismatchException im) {// Catch Block
				System.err.println("Input Mismatch Exception. " + im.getMessage());//Error Message
				scanner.reset();// Reset Scanner
			} 
		} while (bTrue); // Control Variable

	}
	
	/**
	 *This is an abstract method that will be inherited and extended by all subclasses. 
	 *@param Nothing.
	 *@return Nothing. 
	 */
	public abstract void printInfo(); //Abstract Method( No method body)
	
}

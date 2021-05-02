/*
 * Assessment: Lab 07
 * Student Name: Megan Machkouri
 * Due Date: March 21st 2021
 * Description:  A driver class for our Java Program used to test for testing and implementing program.
 * Professor Name: James Mwangi
 */
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The purpose of this class is to allow for testing and implementation of our project's classes and methods.
 * @author megan
 * @version 1.0
 * @since 1.8
 * 
 */

public class Test {
	 
	public static void main(String[] args) {
	
		
		String name = null;
		int size = 0;
		boolean yes = true; // Control Variable
		
	do {
		try {//Try Block
		Scanner input = new Scanner (System.in);
		System.out.print("Enter name of store: " );
		if(input.hasNextDouble()||input.hasNextInt()) {// Input Mismatch Check
			throw new InputMismatchException("Must be string");// Descriptive Error Message
		} else {
		name = input.nextLine();
		System.out.print("Enter number of employees: " );
			if(input.hasNextInt()) {
				size = input.nextInt();
				if(size <= 0)
					throw new NegativeArraySizeException("Must be greater than 0");// Descriptive Error Message
				else
					yes = false;
			
			
		} else
			throw new InputMismatchException("Must be integer.");
			
			}
			
		}
		catch(InputMismatchException im) {// Catch Block
			System.err.println("Input Mismatch Exception. " + im.getMessage());
			
		} 
		catch(NegativeArraySizeException ae) {// Catch Block
			System.err.println("Negative Array Size Exception. " + ae.getMessage());
			
		} 
	
		} while (yes);// Control Variable
	
	Store store = new Store(name, size); // Intialize Store Object
	store.readDetails(); // Invoke Method
	//store.printDetails();
	

	

}
}

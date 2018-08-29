/**
 * Driver
 * A Program that solve any good simple expression using the algorithm discussed in class.
 * Artin Malekian
 * Dr. Hoang
 * CSC 201 - Assignment#3
 * 29 November 2016
 */

package HW3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.print("Enter file name: ");
		Scanner input = new Scanner(System.in);
		String fileName = input.next();
		Scanner inputStr = null;
		System.out.println("The file " + fileName + "\ncontains the following lines:\n");

		try {
			inputStr = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}

		while (inputStr.hasNextLine()) {
			String line = inputStr.nextLine();
			System.out.println(line);
			double result = ExpressionSolver.solve(line);
			System.out.println("the result is " + result + "\n");
		}
		inputStr.close();
	}

}

/**
 * 
 */
package lab02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Robert Ritchie
 *
 */
public class Lab2InputOutput {

	// Opens the filename provided in the command line arguments and copies the
	// contents to a new file with line numbers
	public static void main(String[] args) throws FileNotFoundException {
		String inputFileName = args[0];
		Scanner file = new Scanner(new File(inputFileName));

		Scanner in = new Scanner(System.in);

		System.out.print("Name of output file:");
		String outputFileName = in.next();
		PrintWriter PW = new PrintWriter(new File(outputFileName));

		int lineNumber = 1;
		while (file.hasNextLine()) {
			PW.printf("/* %d */ " + file.nextLine() + "%n", lineNumber);
			lineNumber++;
		}

		file.close();
		PW.close();

	}

}

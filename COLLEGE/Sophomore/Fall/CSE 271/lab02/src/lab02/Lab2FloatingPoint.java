/**
 * 
 */
package lab02;

import java.util.Scanner;

/**
 * @author Robbie Ritchie
 *
 */
public class Lab2FloatingPoint {

	// Asks the user to enter float values until two non-float entries are made
	// and sums the floats that were entered.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int chancesLeft = 2;
		float sum = 0;

		while (chancesLeft > 0) {
			try {
				System.out.print("Enter a float value.");
				float num = Float.parseFloat(in.next());
				sum += num;
				chancesLeft = 2;
			} 
			catch (NumberFormatException exception) {
				System.out.println("Illegal entry. Floats only.");
				chancesLeft -= 1;
			}
		}

		System.out.printf("Sum: %f", sum);

	}

}

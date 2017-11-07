/**
 * 
 */
package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Robbie Ritchie
 *
 */
public class Lab_01_Tester {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		PrintWriter PW = new PrintWriter(new File("Lab_01_nums.txt"));

		int[] nums = Lab_01_ArrayUtilities.buildIntArray(20, 10, 29);

		System.out.println(Arrays.toString(nums));
		PW.println(Arrays.toString(nums));

		// Swaps even indexed values with odd indexed values
		for (int i = 0; i <= 18; i += 2) {
			Lab_01_ArrayUtilities.swap(nums, i, i + 1);
		}

		System.out.println(Arrays.toString(nums));
		PW.println(Arrays.toString(nums));

		Arrays.sort(nums);

		System.out.println(Arrays.toString(nums));
		PW.print(Arrays.toString(nums));

		PW.close();

		// Counts the odd numbers in the array and displays it to the user
		int oddCount = 0;
		for (int n : nums) {
			if (n % 2 == 1)
				oddCount++;
		}
		System.out.printf("There are %d odd numbers in the array. %n", oddCount);

		Scanner in = new Scanner(new File("words.txt"));
		int vowelCount = 0;
		int consonantCount = 0;
		int otherCount = 0;

		// Counts the vowels, consonants, and other characters in the file
		while (in.hasNext()) {
			String word = in.next();
			
			 // converts the string to lowercase because isVowel and isConsonant require it
			word = word.toLowerCase();
			
			// itterates through each letter in the word and determines whether
			// it's a vowel, consonant or other
			for (int i = 0; i < word.length(); i++) {
				if (isVowel(word.charAt(i)))
					vowelCount++;
				else if (isConsonant(word.charAt(i)))
					consonantCount++;
				else
					otherCount++;
			}
		}
		
		in.close();
		
		
		System.out.printf("There are %d vowels, %d consanants, and %d other characters.", vowelCount,consonantCount, otherCount);
	}

	// Given a char, returns true if it is a lowercase vowel, and false otherwise
	public static boolean isVowel(char letter) {
		if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
			return true;
		else
			return false;
	}

	// Given a char, returns true if it is a lowercase consonant, and false otherwise
	public static boolean isConsonant(char letter) {
		if (letter == 'b' || letter == 'c' || letter == 'd' || letter == 'f' || letter == 'g' || letter == 'h'
				|| letter == 'j' || letter == 'k' || letter == 'l' || letter == 'm' || letter == 'n' || letter == 'p'
				|| letter == 'q' || letter == 'r' || letter == 's' || letter == 't' || letter == 'v' || letter == 'w'
				|| letter == 'x' || letter == 'y' || letter == 'z')
			return true;
		else
			return false;
	}

}

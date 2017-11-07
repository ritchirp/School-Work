/**
 * 
 */
package lab04;

/**
 * @author Robbie Ritchie
 *
 */
public class MessageTester {
	public static void main(String[] args) {
		Message test1 = new Message("John Doe", "Jane Doe");
		
		// test the append method
		test1.append("Hello World");
		System.out.println("Hello World");
		System.out.println(test1.getBody());
		
		// test the toString method
		Message test2 = new Message("John", "jane");
		test2.append("Some text");
		String expected = "From; John \nTo: jane\nSome text";
		System.out.println("Result: \n"+ test2.toString());
		System.out.println("Expected: \n"+expected);
		
		
	}

}

/**
 * 
 */
package lab04;

/**
 * @author Robbie Ritchie
 *
 */
public class MailboxTester {
	public static void main(String[] args) {
		
		Message testMessage = new Message("John Doe", "Jane Doe");
		testMessage.append("Hello World");
		
		Mailbox test1 = new Mailbox("awesome");
		
		//tests the addMessage and getMessage methods
		test1.addMessage(testMessage);
		System.out.println("result: " + test1.getMessage(0).toString());
		System.out.println("expected: " + testMessage.toString());

		//tests the removeMessage method
		Message testMessage2 = new Message("Bob", "Joe");
		test1.addMessage(testMessage2);
		test1.removeMessage(0);
		System.out.println("result: " + test1.getMessage(0));
		System.out.println("expected: " + testMessage2.toString());
	}

}

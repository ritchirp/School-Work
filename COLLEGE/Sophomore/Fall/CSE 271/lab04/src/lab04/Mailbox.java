/**
 * 
 */
package lab04;

import java.util.ArrayList;

/**
 * @author Robbie Ritchie
 *
 */
public class Mailbox {
	private ArrayList<Message> inbox;
	private final String SIGNATURE;
	
	public Mailbox(String signature){
		this.inbox = new ArrayList<Message>();
		this.SIGNATURE = signature;
	}
	
	// Adds a message to the mailbox
	public void addMessage(Message m){
		m.append("\n" + SIGNATURE);
		this.inbox.add(m);
	}
	
	// Returns the message at a given index in the mailbox
	public Message getMessage(int i) throws IndexOutOfBoundsException{
		return this.inbox.get(i);
	}
	// Removes the message at a given index in the mailbox
	public void removeMessage(int i) throws IndexOutOfBoundsException{
		this.inbox.remove(i);
	}
}

/**
 * 
 */
package lab04;

/**
 * @author Robbie Ritchie
 *
 */
public class Message {
	private String recipient;
	private String sender;
	private String body;
	public static final String TO_LINE = "\nTo: ";
	public static final String FROM_LINE = "From: ";
	
	// creates a message object given a recipient and sender
	public Message(String sender, String recipient) {
		this.recipient = recipient;
		this.sender = sender;
		this.body = "";
	}
	
	// appends the parameter string to the body of the message
	// note does not add any line feeds or spaces
	public void append(String str){
		this.body = body + str;
	}

	@Override
	public String toString() {
		String output = FROM_LINE + sender;
		output += TO_LINE + recipient + "\n";
		output += body;
		return output;
	}
	// returns the recipient
	public String getRecipient() {
		return recipient;
	}
	// sets the recipient
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	// returns the sender
	public String getSender() {
		return sender;
	}
	// sets the sender
	public void setSender(String sender) {
		this.sender = sender;
	}
	// returns the body
	public String getBody() {
		return body;
	}
	// sets the body
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}

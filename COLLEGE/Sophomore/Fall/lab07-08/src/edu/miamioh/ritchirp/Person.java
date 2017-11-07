/**
 * 
 */
package edu.miamioh.ritchirp;

/**
 * @author Robbie Ritchie
 *
 */
public class Person {
	private int id;
	private String email;
	
	
	/**
	 * @param id The person's ID number
	 * @param email The person's email address
	 */
	public Person(int id, String email) {
		this.id = id;
		this.email = email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	
}

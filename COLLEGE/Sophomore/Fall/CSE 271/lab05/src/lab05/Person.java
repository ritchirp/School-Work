/**
 * 
 */
package lab05;

/**
 * @author Robbie Ritchie
 *
 */
public class Person {
	private String name;
	private int birthYear;
	
	// constructs a person object given its name and birthyear
	public Person(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}


	@Override
	public String toString() {
		return this.name + " was born in the year " + this.birthYear + ".";
	}

	// returns the name
	public String getName() {
		return name;
	}
	
	// sets the name
	public void setName(String name) {
		this.name = name;
	}

	// returns the birth year
	public int getBirthYear() {
		return birthYear;
	}

	// sets the birth year
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	
}

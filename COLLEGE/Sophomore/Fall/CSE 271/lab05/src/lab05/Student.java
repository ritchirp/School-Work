/**
 * 
 */
package lab05;

/**
 * @author Robbie Ritchie
 *
 */
public class Student extends Person {
	
	private String major;
	
	// constructs a student object given its name birthyear and major
	public Student(String name, int birthYear, String major) {
		super(name, birthYear);
		this.major = major;
	}
	

	@Override
	public String toString() {
		return super.toString() + " Their major is " + this.major + ".";
	}


	// returns the major
	public String getMajor() {
		return major;
	}
	
	// sets the major
	public void setMajor(String major) {
		this.major = major;
	}
	
	

}

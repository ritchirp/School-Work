/**
 * 
 */
package lab05;

/**
 * @author Robbie Ritchie
 *
 */
public class Instructor extends Person {
	
	private int salary;
	
	// constructs an instructor object given its name birthyear and salary
	public Instructor(String name, int birthYear, int salary) {
		super(name, birthYear);
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " Their salary is " + this.salary + ".";
	}


	// sets the salary
	public void setSalary(int salary){
		this.salary = salary;
	}
	
	// returns the salary
	public int getSalary(){
		return this.salary;
	}

}

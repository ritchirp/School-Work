/**
 * 
 */
package lab05;

/**
 * @author Robbie Ritchie
 *
 */
public class Employee {
	private String name;
	private int salary;
	
	// constructs an employee object with its salary and name
	public Employee(String name, int salary){
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return name + " earns " + salary + " a year.";
	}

	// returns the name string
	public String getName() {
		return name;
	}

	// sets the name string
	public void setName(String name) {
		this.name = name;
	}

	// returns the salary
	public int getSalary() {
		return salary;
	}
	
	// sets the salary
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}

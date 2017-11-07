/**
 * 
 */
package lab05;

/**
 * @author Robbie
 *
 */
public class Manager extends Employee {
	private String department;
	
	// constructs a manaager object given its name salary and department
	public Manager(String name, int salary, String department){
		super(name, salary);
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + " They work in " + department + ".";
	}

	// returns the department string
	public String getDepartment() {
		return department;
	}

	// sets the department string
	public void setDepartment(String department) {
		this.department = department;
	}
	
}

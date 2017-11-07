/**
 * 
 */
package lab05;

/**
 * @author Robbie Ritchie
 *
 */
public class Executive extends Manager {
	private String officeLocation;

	/**
	 * @param name
	 *            string containing the name
	 * @param salary
	 *            int for the worker's salary
	 * @param department
	 *            string for where they work
	 * @param officeLocation
	 *            string for where the office is located
	 */
	
	// constructs an executive object given its name, salary, department and office location
	public Executive(String name, int salary, String department,
			String officeLocation) {
		super(name, salary, department);
		this.officeLocation = officeLocation;
	}

	@Override
	public String toString() {
		return super.toString() + " Their office is located in "
				+ officeLocation + ".";
	}

	// returns the office location
	public String getOfficeLocation() {
		return officeLocation;
	}

	// sets the office location
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

}

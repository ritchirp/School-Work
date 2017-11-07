/**
 * 
 */
package lab05;

/**
 * @author Robbie Ritchie
 *
 */
public class EmployeeTester {

	public static void main(String[] args) {
		// tests the employee constructor
		Employee test1 = new Employee("John", 30000);
		System.out.println(test1.getName().equals("John"));
		System.out.println(test1.getSalary()==30000);
		// tests the toString method
		String expected1 = test1.getName() + " earns " + test1.getSalary() + " a year.";
		System.out.println(expected1.equals(test1.toString()));
		
		// tests the manager constructor
		// only department parameter is necessary since the manager constructor 
		// has already been tested
		Manager test2 = new Manager("Annie", 123456, "Shipping");
		System.out.println(test2.getDepartment().equals("Shipping"));
		/// tests the toString method
		String expected2 = test2.getName() + " earns " + test2.getSalary() + " a year."
				+ " They work in " + test2.getDepartment() + ".";
		System.out.println(expected2.equals(test2.toString()));
		
		// tests the executive constructor
		// only the office location needs to be tested
		Executive test3 = new Executive("Jenny", 1234567, "Marketing", "the east wing");
		System.out.println(test3.getOfficeLocation().equals("the east wing"));
		// tests the toString method
		String expected3 = test3.getName() + " earns " + test3.getSalary() + " a year."
				+ " They work in " + test3.getDepartment() + "."
				+ " Their office is located in " + test3.getOfficeLocation() + ".";
		System.out.println(test3.toString().equals(expected3));
		
	}

}

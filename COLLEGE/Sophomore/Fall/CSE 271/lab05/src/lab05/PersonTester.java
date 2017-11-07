/**
 * 
 */
package lab05;

/**
 * @author Robbie Ritchie
 *
 */
public class PersonTester {
	// Dr. Stephan approved of using .equals over printing out every result

	public static void main(String[] args) {
		// tests the Person constructor and toString
		Person test1 = new Person("George", 1999);
		System.out.println(test1.getBirthYear()==1999);
		System.out.println(test1.getName().equals("George"));
		String expected1 = "George was born in the year 1999.";
		System.out.println(expected1.equals(test1.toString()));
		
		// tests the Student constructor and toString
		// note only the Major is different in Students, so it is unnecessary
		// to test name and birthyear again
		Student test2 = new Student("Jane", 2, "Mathematics");
		System.out.println(test2.getMajor().equals("Mathematics"));
		String expected2 = "Jane was born in the year 2. Their major is Mathematics.";
		System.out.println(expected2.equals(test2.toString()));
		
		// tests the Instructor constructor and toString
		// note only the salary is different in Instructors, so it is unnecessary
		// to test name and birthyear again
		Instructor test3 = new Instructor("Alex", 800000, 100000);
		System.out.println(test3.getSalary()==100000);
		String expected3 = "Alex was born in the year 800000. Their salary is 100000.";
		System.out.println(expected3.equals(test3.toString()));

	}

}

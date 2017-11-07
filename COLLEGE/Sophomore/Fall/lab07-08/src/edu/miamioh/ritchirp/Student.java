/**
 * 
 */
package edu.miamioh.ritchirp;

import java.util.ArrayList;

/**
 * @author Robbie Ritchie
 *
 */
public class Student extends Person {
	private ArrayList<Course> courses;

	/**
	 * @param id The student's ID number
	 * @param email The student's email address
	 * @param courses The courses the student is taking
	 */
	public Student(int id, String email, ArrayList<Course> courses) {
		super(id, email);
		this.courses = courses;
	}

	/**
	 * @return the courses
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	
}

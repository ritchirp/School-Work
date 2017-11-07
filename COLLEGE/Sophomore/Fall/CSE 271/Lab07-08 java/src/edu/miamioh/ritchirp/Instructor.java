/**
 * 
 */
package edu.miamioh.ritchirp;

import java.util.ArrayList;

/**
 * @author ritchirp
 *
 */
public class Instructor extends Person {
	private int salary;
	private ArrayList<Course> courses;

	/**
	 * @param id The instructor's id number
	 * @param email The instructor's email
	 * @param salary The instructor's salary
	 */
	public Instructor(int id, String email, int salary) {
		super(id, email);
		this.salary = salary;
		this.courses = new ArrayList<>();
	}
	/**
	 * Add a course to the instructors list
	 * @param course the course to be added
	 */
	public void addCourse(Course course){
		this.courses.add(course);
	}
	/**
	 * Change the student's GPA
	 * @param student the student whose GPA is changed
	 * @param gpa the GPA to set
	 */
	public void assignGpa(Student student, double gpa){
		student.setGpa(gpa);
	}
	
	/**
	 * @return The instructor's salary
	 */
	public int getSalary(){
		return this.salary;
	}
	/**
	 * @param salary the salary to be set
	 */
	public void setSalary(int salary){
		this.salary = salary;
	}
	/**
	 * @return The list of courses the instructor is assigned to
	 */
	public ArrayList<Course> getCourses(){
		return this.courses;
	}
}

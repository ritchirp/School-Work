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
	private String major;
	private ArrayList<Course> courses;
	private double gpa;

	/**
	 * @param id The student's ID number
	 * @param email The student's email address
	 * @param major the name of the student's major
	 */
	public Student(int id, String email, String major) {
		super(id, email);
		this.major = major;
		this.courses = new ArrayList<Course>();
	}
	
	/**
	 * @param gpa the GPA to set
	 */
	public void setGpa(double gpa){
		this.gpa = gpa;
	}
	
	
	/**
	 * @return the student's GPA
	 */
	public double getGpa(){
		return this.gpa;
	}
	

	/**
	 * @return the courses the student is enrolled in
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	
	/**
	 * Adds a course to the student's list
	 * @param course the course to add
	 */
	public void addCourse(Course course){
		this.courses.add(course);
	}
	

	/**
	 * @return the student's major
	 */
	public String getMajor() {
		return major;
	}
	

	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	
}

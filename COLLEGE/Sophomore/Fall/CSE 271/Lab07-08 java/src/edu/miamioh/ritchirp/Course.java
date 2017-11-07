package edu.miamioh.ritchirp;

import java.util.ArrayList;

public class Course {
	private LectureHall hall;
	private Instructor instructor;
	private ArrayList<Student> students;
	
	
	/**
	 * @param hall The hall that the course is in
	 * @param teacher The instructor for the course
	 * @param students The list of students taking the course
	 */
	public Course(LectureHall hall, Instructor instructor,
			ArrayList<Student> students) {
		this.hall = hall;
		this.instructor = instructor;
		this.students = students;
	}
	
	
	/**
	 * add a student to the course
	 * @param student the student to be added
	 */
	public void addStudent(Student student){
		this.students.add(student);
	}

	
	/**
	 * @return the lecture hall
	 */
	public LectureHall getHall() {
		return hall;
	}

	
	/**
	 * @param hall the hall to set
	 */
	public void setLectureHall(LectureHall hall) {
		this.hall = hall;
	}
	

	/**
	 * @return the instructor
	 */
	public Instructor getInstructor() {
		return instructor;
	}
	

	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	

	/**
	 * @return the students
	 */
	public ArrayList<Student> getStudents() {
		return students;
	}
	
}

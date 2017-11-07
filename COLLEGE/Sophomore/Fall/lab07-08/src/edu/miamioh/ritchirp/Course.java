package edu.miamioh.ritchirp;

import java.util.ArrayList;

public class Course {
	private LectureHall hall;
	private Instructor teacher;
	private ArrayList<Student> students;
	private String name;
	/**
	 * @param hall The hall that the course is in
	 * @param teacher The instructor for the course
	 * @param students The list of students taking the course
	 * @param name The name of the course
	 */
	public Course(LectureHall hall, Instructor teacher,
			ArrayList<Student> students, String name) {
		this.hall = hall;
		this.teacher = teacher;
		this.students = students;
		this.name = name;
	}
	
}

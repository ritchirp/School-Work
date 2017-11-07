package edu.miamioh.ritchirp;

import java.util.ArrayList;

public class tester {
	
	public static void main(String[] args) {
		
		LectureHall hall1 = new LectureHall("Benton", 100);
		LectureHall hall2 = new LectureHall("notBenton", 50);
		
		Student student1 = new Student(1111, "studentEmail 1", "major1");
		Student student2 = new Student(2222, "studentEmail 2", "major2");
		
		Instructor instructor1 = new Instructor(1111, "instructorEmail 1", 100000);
		Instructor instructor2 = new Instructor(2222, "instructorEmail 2", 200000);
		
		AdminStaff staff = new AdminStaff(0000, "Admin email", 300000);
		
		Course course1 = new Course(hall1, instructor1, new ArrayList<Student>());
		
		course1.addStudent(student1);
		System.out.print("addStudent: ");
		System.out.println(course1.getStudents().get(0).equals(student1));
		
		student1.addCourse(course1);
		System.out.print("addCourse: ");
		System.out.println(student1.getCourses().get(0).equals(course1));
		
		instructor1.assignGpa(student1, 3.6);
		System.out.print("assignGpa: ");
		System.out.println(student1.getGpa()==3.6);
		
		staff.assignHall(course1, hall2);
		System.out.print("assignHall: ");
		System.out.println(course1.getHall().equals(hall2));
		
		staff.assignInstructor(course1, instructor2);
		System.out.print("assignInstructor: ");
		System.out.println(course1.getInstructor().equals(instructor2) && instructor2.getCourses().contains(course1));
		
		staff.enroll(student2, course1);
		System.out.print("enroll: ");
		System.out.println(course1.getStudents().contains(student2) && student2.getCourses().contains(course1));
	}

}

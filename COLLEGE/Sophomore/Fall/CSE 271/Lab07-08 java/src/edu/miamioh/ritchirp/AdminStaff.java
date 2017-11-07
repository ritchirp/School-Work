/**
 * 
 */
package edu.miamioh.ritchirp;

/**
 * @author Robbie
 *
 */
public class AdminStaff extends Person {
	
	private int salary;

	/**
	 * @param id
	 * @param email
	 */
	public AdminStaff(int id, String email, int salary) {
		super(id, email);
		this.salary = salary;
	}
	/**
	 * Enroll a student in a course
	 * @param student the student to be enrolled
	 * @param course the course to enroll the student in
	 */
	public void enroll(Student student, Course course){
		if(!student.getCourses().contains(course))
			student.addCourse(course);
		if(!course.getStudents().contains(student))
			course.addStudent(student);
	}
	/**
	 * Assign a hall to a course
	 * @param course The course to assign the hall to
	 * @param hall the hall to be assigned to the course
	 */
	public void assignHall(Course course, LectureHall hall){
		course.setLectureHall(hall);
	}
	/**
	 * Assign an instructor to a course
	 * @param course the course the instructor is assigned to
	 * @param instructor the instructor being assigned to the course
	 */
	public void assignInstructor(Course course, Instructor instructor){
		course.setInstructor(instructor);
		if(!(instructor.getCourses().contains(course)))
			instructor.addCourse(course);
	}
	/**
	 * @return The adminStaff's salary
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
}

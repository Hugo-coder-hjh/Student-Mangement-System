package roles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import courses.Course;

/**
 * Represents an admin
 * @author Xinyang Shen
 */
public class Admin extends User{
	
	
	//instance variable
	/**
	 * use an ArrayList to contain all the admins in the system
	 */
	public static ArrayList<Admin> ADMINS = new ArrayList<Admin>();
	
	
	
	// constructor
	
	/**
	 * create an admin with its given features
	 * @param id
	 * @param name
	 * @param userName
	 * @param password
	 */
	
	public Admin(String id, String name, String userName, String password) {
		
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		
	}
	
	
	// methods
	
	
	/**
	 * add the new professor into the system
	 * @param professor to add
	 */
	public static void addProfessor(Professor professor) {
		// this only considers the legal situation, the other illegal ones will be excluded in the Controller
		System.out.println("Successfully add the professor: " + professor.getId() + " " + professor.getName());
		
		Professor.PROFESSORS.add(professor);
		
	}
	
	
	/**
	 * delete the given professor with given id
	 * @param proID to delete
	 */
	public static void delProfessor(String proID) {
		
		// iterate over the professor list 
		for(int i = 0; i < Professor.PROFESSORS.size(); i++) {
			
			// find the professor by id
			if(Professor.PROFESSORS.get(i).getId().equals(proID)){
				
				System.out.println("Successfully remove the professor: " + Professor.PROFESSORS.get(i).getId() + " " + Professor.PROFESSORS.get(i).getName());
				
				// remove this professor
				Professor.PROFESSORS.remove(i);
			}
		}
		
	}
	
	/**
	 * take the given student and add to the list
	 * @param student to add
	 */
	public static void addStudent(Student student) {
		// this only considers the legal situation, the other illegal ones will be excluded in the Controller
		System.out.println("Successfully add the student: " + student.getId() + " " + student.getName());
		Student.STUDENTS.add(student);
		
	}
	
	
	/**
	 * delete the student in the system
	 * check if the student is in the list
	 * @param studentID to delete
	 * @return
	 */
	public static void delStudent(String studentID) {
		// iterate over the student list 
		for(int i = 0; i < Student.STUDENTS.size(); i++) {
				
			// find the student by id
				if(Student.STUDENTS.get(i).getId().equals(studentID)) {
					
					System.out.println("Successfully remove the student: " + Student.STUDENTS.get(i).getId() + " " + Student.STUDENTS.get(i).getName());
					
					// remove this student
					Student.STUDENTS.remove(i);
				}
			}
		
	}
	
	
	
	/**
	 * add the new course to the list
	 * @param course to add
	 */
	public static void addCourse(Course course) {
		// this only considers the legal situation, the other illegal ones will be excluded in the Controller
		System.out.println("Successfully added the course: " + course);
		Course.COURSELIST.add(course);
		
	}
	
	
	/**
	 * delete the course in the system
	 * check if the course is in the list
	 * @param courseID to delete
	 * @return
	 */
	public static void delCourse(String courseID) {
		// iterate over the course list 
		for(int i = 0; i < Course.COURSELIST.size(); i++) {
				
			// find the course by id
				if(Course.COURSELIST.get(i).getId().equals(courseID)) {
					
					System.out.println("Successfully remove the course: " + Course.COURSELIST.get(i).getId() + " " + Course.COURSELIST.get(i).getName());
					
					// remove this course
					Course.COURSELIST.remove(i);
				}
			}
		
	}
	
	/**
	 * check whether the endTime is later than the startTime
	 * @param start course start time
	 * @param end course end time
	 * @return true if the endTime is later than the startTime
	 */
	
	public boolean checkEndTime(String start, String end) {
		//create a dateFormatTranslator
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm");			
		Date startTime = null;
		Date endTime = null;
		try {
			//change the end_time string to the date
			startTime = sdf.parse(start);
			//change the end_time string to the date
			endTime = sdf.parse(end);
		if (endTime.getTime() > startTime.getTime()) {
			return true;
		}return false;
		
	} catch (ParseException e) {
		e.printStackTrace();
	}
		return false;
	
}	

	

}

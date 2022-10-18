package roles;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import courses.Course;


/**
 * Represents a student
 * @author Xinyang Shen
 */
public class Student extends User {
	
	// instance variables
	
	/**
	 * use an ArrayList to contain all the students in the system
	 */
	public static ArrayList<Student> STUDENTS = new ArrayList<Student>();
	
		
	/**
	 * the course and its grade
	 */
	private Map<String, String> courseMap;
	
	
	/**
	 * enrolled courses of a student as a list
	 */
	private ArrayList<Course> enrolledCourses = new ArrayList<Course>();

	
	// constructor
	
	/**
	 * create a student with his/her given features
	 * @param id
	 * @param name
	 * @param userName
	 * @param password
	 * @param courseMap
	 */
	public Student(String id, String name, String userName, String password, Map<String, String> courseMap) {
		
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.courseMap = courseMap;
		
	}


	// getter methods
	
	

	/**
	 * get the student's courseMap
	 * @return courseMap of student
	 */
	public Map<String, String> getCourseMap() {
		return courseMap;
	}
	

	
	/**
	 * get student's enrolled courses list
	 * @return
	 */
	public ArrayList<Course> getEnrolledCourses() {
		return enrolledCourses;
	}
	
	
	
	// other method

	
	/**
	 * add the enrolled courses from the hashmap into arraylist 
	 * convert string to course
	 */
	public void addEnrolledCourse() {
		
		
		//iterate over all the keys in the courseMap
		for (Map.Entry<String, String> set: this.courseMap.entrySet()) {
			
			// key value as the course ID
			String cID = set.getKey();
			
			// iterate over the course arraylist, finding the courseID which matches
			for(int i = 0; i < Course.COURSELIST.size(); i++) {
				if (Course.COURSELIST.get(i).getId().equals(cID)) {
					
					// create the course instance
					Course course = Course.COURSELIST.get(i);
					
					// add the course into the enrolledCourse list
					if (!this.enrolledCourses.contains(course)) {
					this.enrolledCourses.add(course);}
					
					// add this student to the student list of this course
					if (!course.addStudent.contains(this)) {
					course.addStudent.add(this);}
					
					// add one enrolled number to this course
					if (!course.addStudent.contains(this)) {
					course.addEnrolledNum();}
					}
				}
			}
		}

	
	
	/**
	 * add a course in the student's course list(enrolled courses list)
	 * @param courseID, the id of a course to add
	 */
	public void addCourse(String courseID) {
		
	
		// set a boolean value to track if a course exist or not
		boolean isCourseExist = false;
		
		// iterate over all course list to check if the course is in the course list
		for(int i = 0; i < Course.COURSELIST.size(); i++) {
			
			if(Course.COURSELIST.get(i).getId().equals(courseID)) {
				
				Course addCourse = Course.COURSELIST.get(i);
				
				// change the isCourseExist value to true
				isCourseExist = true;
				
				// use a boolean value to track if the course had already been takes
				boolean isCourseTaken = false;
				
				//use a boolean value to track if the course is overloaded
				boolean isCourseFull = false;
				
				// check the course Capacity 
				isCourseFull = addCourse.CourseIsFull();
				
				// iterate over the enrolled course arraylist to check if the course has been enrolled before
				for (int j = 0; j < this.enrolledCourses.size(); j++) {
					
					// if the course already exist in the enrolledCourse ArrayList
					if(this.enrolledCourses.get(j).getId().equals(courseID)) {
						
						System.out.println("The course you selected is already in your list.");
						
						// change the boolean value isCourseTaken to true
						// break out the loop
						isCourseTaken = true;
						break;
					}
				}
				
				
				// if this course has not been chosen before
				if(isCourseTaken == false) {
					
					// check if there's a time conflict with other course					
					if (addCourse.noTimeConflict(this, addCourse) == false) {
						System.out.println("The course you selected has time conflict with other courses: ");
						
						// iterate over time conflict courses and print the course id and name
						for(int a = 0; a < addCourse.getConflictCourses().size(); a++) {
							System.out.println(addCourse.getConflictCourses().get(a).getId() + " " + addCourse.getConflictCourses().get(a).getName());
						}			
					}
					
						
						else {
							// check the courseCapacity
							if (isCourseFull) {
								System.out.println("This course is overloaded, so you can not register for it");
								
							}else {
							
							// if there's no time conflict
							System.out.println("Course added successfully.");
							
							this.enrolledCourses.add(addCourse);
							
							// update the courseMap
							this.courseMap.put(courseID, null);
							
							//update the enrolled students number
							
							addCourse.addEnrolledNum();
							//update the AddStudent arrayList
							
							// if the student is not in the arrayList
							if (!addCourse.addStudent.contains(this)) {
								addCourse.addStudent.add(this);
								// update the arrayList
								addCourse.setAddStudent(addCourse.addStudent);
							}
						
							break;
							}
						}
				
						
					}
													
					}		
				}
				
					
		
			
		// if the course does not exist, print out message
		if(isCourseExist == false) {
			System.out.println("Course not found.");
		}
		
	}
	
	/**
	 * view the enrolled course information of a student
	 */
	public void viewEnrolledCourses() {
		System.out.println("The courses in your list: ");
		// iterate over the enrolled courses list and print out each course
		for(int i = 0; i < this.enrolledCourses.size(); i++) {
			
			// print out the information for each course
			System.out.println(this.enrolledCourses.get(i));
		}
		
	}
	
	/**
	 * delete a course from the student course list (enrolled courses list)
	 * @param courseID, the id of a course to drop
	 */
	public void dropCourse(String courseID) {
		
		// set a boolean value to track if a course exist or not
		boolean isCourseExist = false;
		
		// iterate over all course list to check if the course is in the course list
		for(int i = 0; i < Course.COURSELIST.size(); i++) {
			
			if(Course.COURSELIST.get(i).getId().equals(courseID)) {
								
				// change the isCourseExist value to true
				isCourseExist = true;
				
				// use a boolean value to track if a course have been selected 
				boolean isCourseTaken = false;
				
				// iterate over the enrolled course arraylist to check if the course has been enrolled before
				for (int j = 0; j < this.enrolledCourses.size(); j++) {
					
					// if the course already exist in the enrolledCourse ArrayList
					if(this.enrolledCourses.get(j).getId().equals(courseID)) {
						
						System.out.println("Course dropped successfully.");
						
						// delete this student in the course's student list
						
						
						//change the isCourseTaken value to true
						isCourseTaken = true;
						
						// delete this course from the enrolled course list
						this.enrolledCourses.remove(j);
						
						// remove the keys and value from the map
						
						// creates an iterator
						Iterator<Entry<String, String>> iterator = this.courseMap.entrySet().iterator();
						
						// iterate through the courseMap
						while(iterator.hasNext()) {
							Map.Entry<String, String> mapElement = (Map.Entry<String, String>) iterator.next();
							
							if(mapElement.getKey().equals(courseID)) {
								iterator.remove();
							}
						}
						}
						
					}
				// if this course has not been chosen before
				if(isCourseTaken == false) {
					
					// can't drop the course
					System.out.println("The course isn't in your schedule.");
				}
				
				}					
				
			} 			
			
		// if the course does not exist, print out message
		if(isCourseExist == false) {
			System.out.println("Course not found.");
		}
		
	}
	
	
	/**
	 * print out the grades for the student
	 */
	public void viewGrade() {
		
		// creates an iterator
		Iterator<Entry<String, String>> iterator = this.courseMap.entrySet().iterator();
		
		// iterate through the courseMap
		while(iterator.hasNext()) {
			Map.Entry<String, String> mapElement = (Map.Entry<String, String>) iterator.next();
			System.out.println("Grade of " + mapElement.getKey() + ": " + mapElement.getValue());
		}
		
	}
	
	/**
	 * to check if a student id is already in the list
	 * @param stuID to check
	 * @return true if the id is occupied, otherwise false
	 */
	public static boolean isIDOccupied(String stuID) {
		
		// sets the initial value to be false
		boolean isIDOccupied = false;
		
		// iterate over the professor list
		for (int i = 0; i < Student.STUDENTS.size(); i++) {
			
			if(Student.STUDENTS.get(i).getId().equals(stuID)) {
				
				// if the id is occupied
				isIDOccupied = true;
				break;
			}
		}

		return isIDOccupied;
		
	}
	
	/**
	 * to check if a student user name is already in the list
	 * @param stuUN to check
	 * @return true if the username is occupied, otherwise false
	 */
	public static boolean isUserNameOccupied(String stuUN) {
		
		// sets the initial value to be false
		boolean isUserNameOccupied = false;
		
		// iterate over the professor list
				for (int i = 0; i < Student.STUDENTS.size(); i++) {
					
					if(Student.STUDENTS.get(i).getUserName().equals(stuUN)) {
						
						// if the id is occupied
						isUserNameOccupied = true;
						break;
					}
				}

				return isUserNameOccupied;	
	}
	
	

}




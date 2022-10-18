package roles;

import courses.Course;

/**
 * abstract class for user who can access this system
 * three subclass: student, professor and admin
 * @author Xinyang Shen
 */
public abstract class User {
	
	// instance variables
	
	/**
	 * ID number for a user
	 */
	String id;
	
	
	/**
	 * real name for a user
	 */
	String name;
	
	
	/**
	 * user name 
	 */
	String userName;
	
	
	/**
	 * User password
	 */
	String password;
	

	// getters

	
	/**
	 * @return id of the user
	 */
	public String getId() {
		return id;
	}
	

	/**
	 * @return name of the user
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	
	
	// other method
	

	/**
	 * prints out the information for all courses
	 */
	public void viewAllCourses() {
		
		// print all the information line by line
		Course.COURSELIST.forEach(System.out::println);
		
	}
	


}

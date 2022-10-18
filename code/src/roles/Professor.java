package roles;

import java.util.ArrayList;
import courses.Course;

/**
 * Represents a professor
 * @author Xinyang Shen
 */
public class Professor extends User {
	
	//instance variables
	
	/**
	 * use an ArrayList to contain all the professors in the system
	 */
	public static ArrayList<Professor> PROFESSORS = new ArrayList<Professor>();
	

	
	// constructor
	
	/**
	 * create a professor with his/her given features
	 * @param name
	 * @param id
	 * @param userName
	 * @param password
	 */
	
	public Professor(String name, String id, String userName, String password) {
		this.name = name;
		this.id = id;
		this.userName = userName;
		this.password = password;
	}
	
   	
	// methods
	
	
	/**
	 * get the professor's list of given courses
	 * @return ArrayList<Course> courseList
	 */
	public ArrayList<Course> getCourseList() {
	
	//create an arrayList of given courses
	ArrayList<Course> courseList = new ArrayList<Course>();
	
	for (int j = 0; j < Course.COURSELIST.size(); j++) {
		  // get each professor
		  String prof = Course.COURSELIST.get(j).getLecturer();
		  // if professor name is in the courseList, get the course
		  if (this.getName().equals(prof)) {
			  Course givenCourse = Course.COURSELIST.get(j);
			  courseList.add(givenCourse);
			  }
		  }
	return courseList;	  
	}	
	
	
	/**
	 * to check if a professor id is already in the list
	 * @param proID to check
	 * @return true if the id is occupied, otherwise false
	 */
	public static boolean isIDOccupied(String proID) {
		
		// sets the initial value to be false
		boolean isIDOccupied = false;
		
		// iterate over the professor list
		for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
			
			if(Professor.PROFESSORS.get(i).getId().equals(proID)) {
				
				// if the id is occupied
				isIDOccupied = true;
				break;
			}
		}

		return isIDOccupied;
		
	}
	
	/**
	 * to check if a professor user name is already in the list
	 * @param proUN to check
	 * @return true if the username is occupied, otherwise false
	 */
	public static boolean isUserNameOccupied(String proUN) {
		
		// sets the initial value to be false
		boolean isUserNameOccupied = false;
		
		// iterate over the professor list
				for (int i = 0; i < Professor.PROFESSORS.size(); i++) {
					
					if(Professor.PROFESSORS.get(i).getUserName().equals(proUN)) {
						
						// if the id is occupied
						isUserNameOccupied = true;
						break;
					}
				}

				return isUserNameOccupied;	
	}


	

	
	
	
}

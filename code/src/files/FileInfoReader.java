package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import courses.Course;
import roles.Admin;
import roles.Professor;
import roles.Student;

/**
 * to load the files
 * @author Xinyang Shen
 */
public class FileInfoReader {
	
	
	/**
	 * to see if the username is already in the user's list
	 * get the username and password as map for a user class
	 * @param username to check
	 * @return a hashmap has Ss as username and values as password
	 */
	public static Map<String, String> LoginInfo() {
		
		// create a hashmap to store the username and passwords of a user class
		Map<String, String> LoginInfo = new HashMap<String, String>();
		
		// iterate over the student list and update the student username and password into the map
		for(int i = 0; i < Student.STUDENTS.size(); i++) {
			
			// get the username and password for each student and store in the map
			LoginInfo.put(Student.STUDENTS.get(i).getUserName(), Student.STUDENTS.get(i).getPassword());
			
		}
		
		// iterate over the professor list and update the professor username and password into the mao
		
		for(int j = 0; j < Professor.PROFESSORS.size(); j++) {
			
			// get the username and passowrd for each professor and store in the map
			LoginInfo.put(Professor.PROFESSORS.get(j).getUserName(), Professor.PROFESSORS.get(j).getPassword());
			
		}
		
		// iterate over the admin list and update the admin username and passowrd for the map
		for(int a = 0; a < Admin.ADMINS.size(); a++) {
			
			LoginInfo.put(Admin.ADMINS.get(a).getUserName(), Admin.ADMINS.get(a).getPassword());
		}
			
		
	return LoginInfo;
	}
	
	

	
	/**
	 * load the file content to the ArrayList of course
	 */
     public static void setCourseInfo(){
		
		// create file
		File file = new File("courseInfo.txt");
		
		// initialize FR and BR
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
			
		
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			
			// variable to store each lines
			String line;
					
			// while there is a line to read
			while((line = bufferedReader.readLine()) != null) {
				
				// string array for each line to store the information
				String[] courseInfo = line.split("; ");
				
				// create the course with given information from file
				Course c = new Course(courseInfo[0], courseInfo[1], courseInfo[2], courseInfo[3], courseInfo[4], courseInfo[5], courseInfo[6]);
			
				// add each course to the ArrayList
				Course.COURSELIST.add(c); 
				}
			
		} catch (FileNotFoundException e) {
		  System.out.println("No File Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		
}
     
     
     /**
 	  * load the file content to the ArrayList of students
 	  */
      public static void setStudentInfo(){
 		
 		// create file
 		File file = new File("studentInfo.txt");
 		
 		// initialize FR and BR
 		FileReader fileReader = null;
 		BufferedReader bufferedReader = null;
 	
 		try {
 			fileReader = new FileReader(file);
 			bufferedReader = new BufferedReader(fileReader);
 			
 			// variable to store each lines
 			String line;
 			
 					
 			// while there is a line to read
 			while((line = bufferedReader.readLine()) != null) {
 				
 				// variable to be as map
 	 			Map<String, String> map = new HashMap<String, String>();
 			 	
 			    // string array for each line to store the information
				String[] studentInfo = line.split("; ");
				
				// change the string to map
				//get the course information from the student
				String courseInfo = studentInfo[4];
				String[] courses = courseInfo.split(", ");
				// iterate over each course
				for(int i = 0; i < courses.length; i++) {
					String[] eachCourse = courses[i].split(": ");
					// put the information into the map
					// keys as the course id, value as the grade
					map.put(eachCourse[0], eachCourse[1]);
				}
				
 				// create the student with given information from file
 				Student s = new Student(studentInfo[0], studentInfo[1], studentInfo[2], studentInfo[3], map);
 			
 				// add each student to the ArrayList
 				Student.STUDENTS.add(s); 
 				}
 			
  		} catch (FileNotFoundException e) {
 		  System.out.println("No File Found");
 			e.printStackTrace();
 		} catch (IOException e) {
 			System.out.println("IOException");
 			e.printStackTrace();
 			}
 		}
      
     
      
      /**
       * load the file content to the ArrayList of professors
       */
       public static void setProfessorInfo(){
  		
  		// create file
  		File file = new File("profInfo.txt");
  		
  		// initialize FR and BR
  		FileReader fileReader = null;
  		BufferedReader bufferedReader = null;
  		
  		
  		try {
  			fileReader = new FileReader(file);
  			bufferedReader = new BufferedReader(fileReader);
  			
  			// variable to store each lines
  			String line;
  					
  			// while there is a line to read
  			while((line = bufferedReader.readLine()) != null) {
  				
  				// string array for each line to store the information
  				String[] proInfo = line.split("; ");
  				
  				// create the professor with given information from file
  				Professor p = new Professor(proInfo[0], proInfo[1], proInfo[2], proInfo[3]);
  			
  				// add each professor to the ArrayList
  				Professor.PROFESSORS.add(p);
  				}
  			
  		} catch (FileNotFoundException e) {
  		  System.out.println("No File Found");
  			e.printStackTrace();
  		} catch (IOException e) {
  			System.out.println("IOException");
  			e.printStackTrace();
  		}
  		
  }
       
       
       /**
        * load the file content to the ArrayList of admins
        */
       public static void setAdminInfo(){
     		
     		// create file
     		File file = new File("adminInfo.txt");
     		
     		// initialize FR and BR
     		FileReader fileReader = null;
     		BufferedReader bufferedReader = null;
     		
     		
     		try {
     			fileReader = new FileReader(file);
     			bufferedReader = new BufferedReader(fileReader);
     			
     			// variable to store each lines
     			String line;
     					
     			// while there is a line to read
     			while((line = bufferedReader.readLine()) != null) {
     				
     				// string array for each line to store the information
     				String[] adminInfo = line.split("; ");
     				
     				// create the admin with given information from file
     				Admin a = new Admin(adminInfo[0], adminInfo[1], adminInfo[2], adminInfo[3]);
     				// add each admin to the ArrayList
     				Admin.ADMINS.add(a);
     				}
     			
     		} catch (FileNotFoundException e) {
     		  System.out.println("No File Found");
     			e.printStackTrace();
     		} catch (IOException e) {
     			System.out.println("IOException");
     			e.printStackTrace();
     		}     		
     } 
      
}
	

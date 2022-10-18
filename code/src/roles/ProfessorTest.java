package roles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courses.Course;
import files.FileInfoReader;

class ProfessorTest {
	

	@BeforeEach
	void setUp() throws Exception {
		
		FileInfoReader.setStudentInfo();
		FileInfoReader.setProfessorInfo();
		FileInfoReader.setCourseInfo();
		FileInfoReader.setAdminInfo();
	}

	@Test
	void testGetCourseList() {
		// pro should be Greenberg
		Professor pro = Professor.PROFESSORS.get(0);
		ArrayList<Course> givenCourses = pro.getCourseList();
		// the lecturer of course in list is equal to Clayton Greenberg
		assertEquals("Clayton Greenberg", givenCourses.get(0).getLecturer());
		// the first course should be CIT592
		assertEquals("CIT592", givenCourses.get(0).getId());
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}
	
	@Test
	void testIsIDOccupied() {
		
		// 001 is occupied
		assertTrue(Professor.isIDOccupied("001"));
	
		// 12345 is not occupied
		assertFalse(Professor.isIDOccupied("12345"));
		

		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}
	
	
	@Test
	void testIsUserNameOccupied() {
		
		// testStudent01 is occupied
		assertTrue(Professor.isUserNameOccupied("Greenberg"));
		
		// curry is not occupied
		assertFalse(Professor.isUserNameOccupied("curry"));
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
	}
	
	


}

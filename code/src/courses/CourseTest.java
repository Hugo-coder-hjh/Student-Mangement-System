package courses;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import files.FileInfoReader;
import roles.Admin;
import roles.Professor;
import roles.Student;

class CourseTest {
	
	Course CIT590;
	Course CIT591;
	Course CIS620;
	Course CIS320;
	Course CIT592;

	@BeforeEach
	void setUp() throws Exception {
	
		 FileInfoReader.setAdminInfo();
		 FileInfoReader.setCourseInfo();
		 FileInfoReader.setStudentInfo();
		 FileInfoReader.setProfessorInfo();
		 
		 CIT590 = Course.COURSELIST.get(0);
		 
		 CIT591 = Course.COURSELIST.get(1);
		 
		 CIS620 = Course.COURSELIST.get(47);
		 
		 CIS320 = Course.COURSELIST.get(20);
		 
		 CIT592 = Course.COURSELIST.get(2);
		 
		
	}

	@Test
	void testNoTimeConflictStudentCourseArrayListOfCourse() {
		
		Map<String, String> enrolledCourse = new HashMap<String, String>();
		
		enrolledCourse.put("CIT590", "A+");
		
		
		Student student = new Student("id", "name", "username", "password", enrolledCourse);
		
		student.addEnrolledCourse();
		
		// the student now have course "CIT590"
		assertEquals(1, student.getEnrolledCourses().size());
		
		// Has time conflict with CIS620
		assertFalse(CIS620.noTimeConflict(student, CIS620));
		assertEquals(1, CIS620.getConflictCourses().size());
		
		// Dose not have time conflict with CIT591
		assertTrue(CIT591.noTimeConflict(student, CIT591));
		
		
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}

	
	
	@Test
	void testToString() {
		
		assertEquals("CIS620|Advanced Topics in Machine Learning, 15:00-18:00 on M, with course capacity: 40, students: 0, lecturer: Professior Dan Roth",
				CIS620.toString());
		
		assertEquals("CIT590|Programming Languages and Techniques, 16:30-18:00 on MW, with course capacity: 110, students: 0, lecturer: Professior Brandon L Krakowsky",
				CIT590.toString());
		
		assertEquals("CIS320|Introduction to Algorithms, 15:00-16:30 on MW, with course capacity: 200, students: 0, lecturer: Professior Sanjeev Khanna",
				CIS320.toString());
		
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
		
	}

	
	
	
	@Test
	void testNoTimeConflictProfessorCourseArrayListOfCourse() {
		
		Professor professor = Professor.PROFESSORS.get(0);
		
		// the professor already has the course CIT592
		
		assertEquals("CIT592", professor.getCourseList().get(0).getId());
		
		// there's time conflict with CIT592
		assertFalse(CIT592.noTimeConflict(professor, CIT592));
		
		// no time conflict with CIT590
		assertTrue(CIT590.noTimeConflict(professor, CIT590));
			
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}

	
	
	@Test
	void testIsIDOccupied() {
		
		// CIT590 is occupied
		assertTrue(Course.isIDOccupied("CIT590"));
		
		// CBE554 is not occupied
		assertFalse(Course.isIDOccupied("CBE554"));
		
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();

	}

	
	
	
	@Test
	void testCourseIsFull() {
		
		// course CIT590 is not full now
		assertFalse(CIT590.CourseIsFull());
		
		//create a new course that is full
		Course fullCourse = new Course("id", "name", "lecturer", "days", "3:00", "4:00", "1");
		
		fullCourse.setEnrolledNum(1);
		
		// the course is full now
		assertTrue(fullCourse.CourseIsFull());
	
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
	}
	
	

}

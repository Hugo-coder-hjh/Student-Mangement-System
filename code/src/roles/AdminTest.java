package roles;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courses.Course;
import files.FileInfoReader;

class AdminTest {
	
	@BeforeEach
	void setUp() throws Exception {
		FileInfoReader.setStudentInfo();
		FileInfoReader.setProfessorInfo();
		FileInfoReader.setCourseInfo();
		FileInfoReader.setAdminInfo();
	}

	@Test
	void testAddProfessor() {
		// the old size of professor list
		assertEquals(32, Professor.PROFESSORS.size());
		// add a new professor
		Professor p = new Professor("Newton", "100", "Oldton", "password590");
		Admin.addProfessor(p);
		// the new size of professor list
		assertEquals(33, Professor.PROFESSORS.size());
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
	}
	
	
	@Test
	void testDelProfessor() {
		// the old size of professor list
		assertEquals(32, Professor.PROFESSORS.size());
		Admin.delProfessor("001");
		// the new size of professor list
		assertEquals(31, Professor.PROFESSORS.size());
				
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		}
	
	
	@Test
	void testAddStudent() {
		// the old size of student list
		assertEquals(2, Student.STUDENTS.size());
		// create a new student
		Map<String, String> courseList = new HashMap<String, String>();
		courseList.put("CIS545", "A+");
		Student newStudent = new Student("003", "student03", "teststudent03", "012345", courseList);
	
		Admin.addStudent(newStudent);
		// the new size of student list
		assertEquals(3, Student.STUDENTS.size());
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
	}
	
	
	@Test
	void testDelStudent() {
		// the old size of student list
		assertEquals(2, Student.STUDENTS.size());
		Admin.delStudent("001");
		// the new size of student list
		assertEquals(1, Student.STUDENTS.size());
				
			Student.STUDENTS.clear();
			Professor.PROFESSORS.clear();
			Admin.ADMINS.clear();
			Course.COURSELIST.clear();
		}
	
	
	
	@Test
	void testAddCourse() {
		// this only considers the legal situation, the other illegal ones will be excluded in the Controller
		// Or we will test the methods independently, such as noTimeConflict() and checkEndTime();
		// the old size of course list
		assertEquals(50, Course.COURSELIST.size());
		Course c = new Course("CIT900", "Web", "Ives", "MW", "14:30", "15:30", "120");
		Admin.addCourse(c);
		// the new size of course list
		assertEquals(51, Course.COURSELIST.size());
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
		
	}
	
	@Test
	void testDelCourse() {
		// the old size of course list
		assertEquals(50, Course.COURSELIST.size());
		Admin.delCourse("CIS557");
		// the new size of student list
		assertEquals(49, Course.COURSELIST.size());
				
			Student.STUDENTS.clear();
			Professor.PROFESSORS.clear();
			Admin.ADMINS.clear();
			Course.COURSELIST.clear();
		}
	
	@Test
	void testcheckEndTime() {
		
		 Admin a = Admin.ADMINS.get(0);
		// endTime is later than startTime, return True;
		assertTrue(a.checkEndTime("16:30", "17:30"));
		// endTime is earlier than startTime, return False;
		assertFalse(a.checkEndTime("16:30", "13:30"));
		
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		Course.COURSELIST.clear();
	}
	
	
	
	
	
}

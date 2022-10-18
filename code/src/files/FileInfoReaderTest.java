package files;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import courses.Course;
import roles.Admin;
import roles.Professor;
import roles.Student;

class FileInfoReaderTest {

	@BeforeEach
	void setUp() throws Exception {
		
		FileInfoReader.setCourseInfo();
		FileInfoReader.setAdminInfo();
		FileInfoReader.setProfessorInfo();
		FileInfoReader.setStudentInfo();	
		
	}
	
	
	@Test
	void testLoginInfo() {
		
		Map<String, String> loginInfo = new HashMap<String, String>();
		
		loginInfo = FileInfoReader.LoginInfo();
		
		assertEquals(37, loginInfo.size());
		
		assertTrue(loginInfo.containsKey("Jayaraman"));
		
		assertTrue(loginInfo.containsKey("testStudent01"));
		
		assertTrue(loginInfo.containsKey("admin03"));
		
		assertTrue(loginInfo.containsValue("password590"));
		
		assertFalse(loginInfo.containsKey("XinyangShen"));
		
		assertFalse(loginInfo.containsKey("JiaheHao"));
		
		Course.COURSELIST.clear();
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();	
	}
	
	

	@Test
	void testSetCourseInfo() {
		
		
		assertEquals(50, Course.COURSELIST.size());
		
		assertEquals("CIT590", Course.COURSELIST.get(0).getId());
		
	    assertEquals("Introduction to Software Development", Course.COURSELIST.get(1).getName());
		
		assertEquals("Clayton Greenberg", Course.COURSELIST.get(2).getLecturer());
		
		assertEquals("MWF", Course.COURSELIST.get(3).getDays());
		
		assertEquals("11:00", Course.COURSELIST.get(3).getStartTime());
		
		assertEquals("12:00", Course.COURSELIST.get(3).getEndTime());
		
		assertEquals("72", Course.COURSELIST.get(3).getCapacity());
		
		
		Course.COURSELIST.clear();
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		
		
		
	}

	@Test
	void testSetStudentInfo() {
				
		assertEquals(2, Student.STUDENTS.size());
		
		assertEquals("001", Student.STUDENTS.get(0).getId());
		
		assertEquals("StudentName1", Student.STUDENTS.get(0).getName());
		
		assertEquals("testStudent01", Student.STUDENTS.get(0).getUserName());
		
		assertEquals("password590", Student.STUDENTS.get(1).getPassword());
		
		assertTrue(Student.STUDENTS.get(1).getCourseMap().containsKey("CIT592"));
		
		assertFalse(Student.STUDENTS.get(1).getCourseMap().containsValue("B"));
		
		
		Course.COURSELIST.clear();
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		
	}

	@Test
	void testSetProfessorInfo() {
		
		
		assertEquals(32, Professor.PROFESSORS.size());
		
		assertEquals("001", Professor.PROFESSORS.get(0).getId());
		
		assertEquals("Clayton Greenberg", Professor.PROFESSORS.get(0).getName());
		
		assertEquals("Greenberg", Professor.PROFESSORS.get(0).getUserName());
		
		assertEquals("password590", Professor.PROFESSORS.get(4).getPassword());	
		
		Course.COURSELIST.clear();
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
		
	}

	
	
	
	@Test
	void testSetAdminInfo() {
		
		
		assertEquals(3, Admin.ADMINS.size());
		
		assertEquals("001", Admin.ADMINS.get(0).getId());
		
		assertEquals("admin", Admin.ADMINS.get(0).getName());
		
		assertEquals("admin03", Admin.ADMINS.get(2).getUserName());
		
		assertEquals("password590", Admin.ADMINS.get(1).getPassword());
		
		Course.COURSELIST.clear();
		Student.STUDENTS.clear();
		Professor.PROFESSORS.clear();
		Admin.ADMINS.clear();
			
		
	}

}

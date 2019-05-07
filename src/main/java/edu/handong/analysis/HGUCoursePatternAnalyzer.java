package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
								"1999-2, JC Nam, Programming Language Theory",
								"1999-1, JC Nam, Data Structures",
								"2001-1, JC Nam, Database Systems",
								"2018-1, SB Lim, Java Programming",
								"2018-2, SB Lim, Programming Language Theory",
								"2019-1, SB Lim, Data Structures",
								"2019-1, SB Lim, Algorithm Analysis",
								"2018-1, SJ Kim, Java Programming",
								"2018-2, SJ Kim, Programming Language Theory",
								"2019-1, SJ Kim, Logic Design",
								"2019-1, SJ Kim, Algorithm Analysis",
							}; 

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	    
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {

		// TODO: implement this method
		students = new Student[numOfStudents];
		String[] name = new String[lines.length];
		Student realName;
		Student[] studentNameNumTwo = new Student[lines.length];
		Student[] studentList  = new Student[numOfStudents];

		for(int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String[] names = line.split(", ");
			String studentName = names[1];
			name[i]=studentName;
			studentNameNumTwo[i] = new Student(studentName);
		}
		
		int i = 0;
		for(String anotherName : name) {
			realName = new Student(anotherName);
			while(!studentExist(studentList,realName)) {
				studentList[i] = realName;
				i++;
			}
		}
		
		return studentList;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {

		// TODO: implement this method
		boolean result = false;
		
		int i=0;
		while(students[i]!=null) {
			if(students[i].getName().equals(student.getName())) {
				result = true;
				break;
			}
			
			i++;
		
		}
		
		return result;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		
		courses = new Course[numOfCourses];
		String[] nameCourse = new String[lines.length];
		Course realNameCourse;
		Course[] courseTwo = new Course[lines.length];
		Course[] courseList  = new Course[numOfCourses];

		for(int i = 0; i < lines.length; i++) {
			String line = lines[i];
			String[] names = line.split(", ");
			String courseName = names[2];
			nameCourse[i]=courseName;
			courseTwo[i] = new Course(courseName);
		}
		
		int i = 0;
		for(String anotherNameCourse : nameCourse) {
			realNameCourse = new Course(anotherNameCourse);
			while(!courseExist(courseList,realNameCourse)) {
				courseList[i] = realNameCourse;
				i++;
			}
		}
		
		return courseList;
		
	}
	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		
		boolean result = false;
		
		int i=0;
		while(courses[i]!=null) {
			if(courses[i].getCourseName().equals(course.getCourseName())) {
				result = true;
				break;
			}
			
			i++;
		
		}
		
		return result;
	}

}

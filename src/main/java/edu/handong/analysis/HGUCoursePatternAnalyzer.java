package edu.handong.analysis;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

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

		List<Student> list = new ArrayList<Student>();


		for(int i = 0; i < lines.length; i++) {
			String line = lines[i];
			StringTokenizer st = new StringTokenizer(line, ",");
			String hakki = st.nextToken();
			String name = st.nextToken().trim();

			boolean isExist = false;
			for (int j=0; j<list.size(); j++) {
				if (name.equals(list.get(j).getName())) {
					isExist = true;
				}
			}

			if (!isExist) {
				list.add(new Student(name));
			}
			
		}
		
		
		return list.toArray(new Student[1]);
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {

		// TODO: implement this method
		boolean result = false;
		
		for (int i=0; i<students.length; i++) {
			if (students[i].getName().equals(student.getName()))
				result = true;
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
		List<Course> secondList = new ArrayList<Course>();

		
		for(int i = 0; i < lines.length; i++) {
			String line = lines[i];
			StringTokenizer st = new StringTokenizer(line, ",");
			String hakki = st.nextToken();
			String name = st.nextToken();
			String courseName = st.nextToken().trim();

			boolean isExist = false;
			for (int j=0; j<secondList.size(); j++) {
				if (courseName.equals(secondList.get(j).getCourseName())) {
					isExist = true;
				}
			}

			if (!isExist) {
				secondList.add(new Course(courseName));
			}
			
		}
		
		
		return secondList.toArray(new Course[1]);
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
		
		for (int i=0; i<courses.length; i++) {
			if (courses[i].getCourseName().equals(course.getCourseName()))
				result = true;
		}
		
		return result;
	}

}

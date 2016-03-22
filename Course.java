package myCourseSoftware.objects;
import java.util.ArrayList;
import java.util.List;

public class Course {
	ArrayList<Assignments> allAssignments = new ArrayList<Assignments>();
	Professor professor = new Professor("","","","","");
	TextBook book = new TextBook("","",0);
	private double theCourseGrade;
	private String courseName;
	/**
	 * 
	 * @param theAssignments is an arraylist of assignments involved in the Course.
	 * @param theCourseName is the name of the Course.
	 * @param theProfessor is of type Professor, and is passed as the professor of that course.
	 * @param courseGrade is the grade you earned in the course.
	 * @param theBook is of type Textbook, and is passed as the Textbook in the course.
	 */
	public Course(ArrayList<Assignments> theAssignments, String theCourseName,Professor theProfessor, double courseGrade, TextBook theBook) {
		allAssignments = theAssignments;
		theCourseGrade = courseGrade;
		professor = theProfessor;
		book = theBook;
		courseName = theCourseName;
	}
	/**
	 * 
	 * @return the professor of the course
	 */
	public Professor getProf(){
		return professor;
	}
	/**
	 * 
	 * @return the textbook of the course
	 * 
	 */
	public TextBook getBook(){
		return book;
	}
	/**
	 * 
	 * @return the name of the course as a String
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * 
	 * @param courseName is to be the new coursename
	 * Sets the course's name to the String passed
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 
	 * @return the grade as a string.
	 * Calculated by adding up all assignment grades.
	 * 
	 */
	public String getStringCourseGrade(){
		double finalGrade = 0.0;
		for(int i = 0; i < allAssignments.size(); i++){
			finalGrade+= allAssignments.get(i).getGrade();
		}
		finalGrade = finalGrade / allAssignments.size();
		return (finalGrade+"%");
	}
	/**
	 * 
	 * @return the grade of the course
	 * 
	 */
	public double getCourseGrade(){
		double finalGrade = 0.0;
		for(int i = 0; i < allAssignments.size(); i++){
			finalGrade+= allAssignments.get(i).getGrade();
		}
		finalGrade = finalGrade / allAssignments.size();
		return finalGrade;
	}
	/**
	 * 
	 * @return a simple array of all the assignments found inside the course.
	 * 
	 */
	public String[] fillAssignments(){
		List<String> assignments = new ArrayList<String>();
		for (int i = 0; i < allAssignments.size(); i++){
			assignments.add("Assignment: "+allAssignments.get(i).getAssignmentName()+". Grade: "+allAssignments.get(i).getGrade());
		}
		return assignments.toArray(new String[assignments.size()]);
	}



}

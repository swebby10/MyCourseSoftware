package myCourseSoftware.objects;

import java.util.ArrayList;

public class Person {
	public ArrayList<Semester> allSemesters = new ArrayList<Semester>();
	private int IDnumber;
	private String name;
	private double totalGPA;
	/**
	 * 
	 * @param theSemesters is an arraylist of the semesters associated with the student.
	 * @param theName is the name of the person.
	 * @param theTotalGPA is the total gpa of all the semesters.
	 * @param theIDnumber is the students ID number.
	 */
	public Person(ArrayList<Semester> theSemesters, String theName, double theTotalGPA, int theIDnumber) {
		IDnumber = theIDnumber;
		name = theName;
		totalGPA = theTotalGPA;
		allSemesters = theSemesters;
	}
	/**
	 * 
	 * @return the total GPA as a double.
	 */
	public double getTotalGPA(){
		totalGPA = 0.0;
		for(int i = 0; i < allSemesters.size(); i++){
			totalGPA += allSemesters.get(i).getGPA();
		}
		totalGPA = totalGPA / allSemesters.size();
		return totalGPA;
	}
	/**
	 * 
	 * @return the ID number of the person.
	 */
	public int getIDnumber() {
		return IDnumber;
	}
	/**
	 * 
	 * @param iDnumber is going to be the new ID number of Person.
	 * Sets the ID number of Person to the passed integer.
	 */
	public void setIDnumber(int iDnumber) {
		IDnumber = iDnumber;
	}
	/**
	 * 
	 * @return the name of the Person.
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name is going to be the new name of the Person.
	 * Sets the name of the Person to the passed string.
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
}

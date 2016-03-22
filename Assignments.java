package myCourseSoftware.objects;

public class Assignments {
private String assignmentName;
private String assignmentType;
private String assignedDate;
private String dueDate;
private double earnedGrade;
private double worth;
private double earned;
private Date DDate;
private Date ADate;
/**
 * 
 * @param theAssignmentName is the name of the Assignment
 * @param dateAssigned is the Date the Assignment was assigned.
 * @param dateDue is the Date the Assignment is due.
 * @param Type is the type of assignment. For example: Quiz, Test, Homework etc...
 * @param pointsAvailable the amount of points the assignment is worth.
 * @param pointsEarned is the amount of points the student earned out of points available.
 * @param grade is the points the student earned divided by what the assignment is worth.
 * 
 * Sets all the private variables in the class to what was passed.
 */
	public Assignments(String theAssignmentName, Date dateAssigned, Date dateDue, String Type, double pointsAvailable, double pointsEarned, double grade) {
		assignmentType = Type;
		if(dateAssigned != null){
		assignedDate = dateAssigned.getDate();
		ADate = dateAssigned;
		}
		if(dateDue != null){
		dueDate = dateDue.getDate();
		DDate = dateDue;
		}
		worth = pointsAvailable;
		earned = pointsEarned;
		earnedGrade = pointsEarned/pointsAvailable;
		assignmentName = theAssignmentName;
	}
	/**
	 * 
	 * @return the name of the Assignment
	 */
	public String getAssignmentName() {
		return assignmentName;
	}
/**
 * 
 * @param assignmentName is what the assignment's new name will be.
 * sets the assignment name to what is set as a parameter.
 */
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
/**
 * 
 * @return the date the assignment was assigned as String.
 */
	public String getDateAsssigned(){
		return assignedDate;
	}
	/**
	 * 
	 * @return the date the assignment was due as String
	 */
	public String getDueDate(){
		return dueDate;
	}
	/**
	 * 
	 * @return the type of assignment it is as String.
	 * 
	 */
	public String getAssignmentType(){
		return assignmentType;
	}
	/**
	 * 
	 * @param value is passed as the number you are trying to round.
	 * @param places is passed as the number of places you will round to.
	 * @return a double of the vaue given but rounded
	 */
	public double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	/**
	 * 
	 * @return the grade earned on the assignment
	 */
	public double getGrade(){
		return earnedGrade;
	}
	/**
	 * 
	 * @return the grade of the assignment but as a string instead of double.
	 */
	public String getStringGrade(){
		double yourGrade = earnedGrade * 100;
		return(round(yourGrade,2)+"%");
	}
	/**
	 * 
	 * @return how much the assignment is worth.
	 */
	public double getWorth(){
		return worth;
	}
	/**
	 * 
	 * @return how many points where earned on the assignment.
	 */
	public double getEarned(){
		return earned;
	}
	/**
	 * 
	 * @return the date the assignment was due.
	 */
	public Date getDue(){
		return DDate;
	}
	/**
	 * 
	 * @return the date the assignment was assigned.
	 */
	public Date getAssign(){
		return ADate;
	}

}

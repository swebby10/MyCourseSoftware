package myCourseSoftware.objects;

public class Professor {
private String name;
private String email;
private String phone;
private String office;
private String officeHours;
/**
 * 
 * @param theName is the name of the professor.
 * @param theEmail is the email of the professor.
 * @param thePhone is the phone number of the professor.
 * @param theOffice is the office number of the professor.
 * @param theOfficeHours is the available office hours of the professor.
 * Sets all the local variable to passed parameters.
 */
	public Professor(String theName, String theEmail, String thePhone, String theOffice, String theOfficeHours) {
name = theName;
email = theEmail;
phone = thePhone;
office = theOffice;
officeHours = theOfficeHours;
	}
	/**
	 * 
	 * @return the name of the professor.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the professor the String passed as a parameter.
	 * @param name is passed as the new name of the professor as a String.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return the email of the teacher.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets the email of the professor to the String passed as a parameter
	 * @param email is passed as the new email of the professor as a String.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return the phone number of the professor.
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Sets the professors phone number to the passed string.
	 * @param phone is passed as the professors new phone number.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 
	 * @return the office number of the professor.
	 */
	public String getOffice() {
		return office;
	}
	/**
	 * Sets the office number of the professor.
	 * @param office is passed as the new office number of the professor.
	 */
	public void setOffice(String office) {
		this.office = office;
	}
	/**
	 * 
	 * @return the office hours the professor has available.
	 */
	public String getOfficeHours() {
		return officeHours;
	}
	/**
	 * Sets the office hours of the professor
	 * @param officeHours is passed as the professors new office hours.
	 */
	public void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}

}

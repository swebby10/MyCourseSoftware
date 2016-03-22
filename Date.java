package myCourseSoftware.objects;

public class Date {
	private int month;
	private int day;
	private int year; 
       /**
        * 
        * @param theMonth is an integer of what month is it. 1 being January and 12 being December.
        * @param theDay is an integer of what day it is in the month.
        * @param theYear is what year it is.
        * Sets all the local variables to what was passed.
        */
	public Date(int theMonth, int theDay, int theYear) {
		month = theMonth;
		day = theDay;
		year = theYear;
	}
/**
 * 
 * @return integer of the month
 */
	public int getMonth() {
		return month;
	}
/**
 * 
 * @return integer of the day
 */
	public int getDay() {
		return day;
	}
/**
 * 
 * @return integer of the year.
 */
	public int getYear() {
		return year;
	}
	public String getMonthString(){
		String theMonth = "";
		switch (month) {
		case 1:
			theMonth = "January";
			break;
		case 2:
			theMonth = "February";
			break;
		case 3:
			theMonth = "March";
			break;
		case 4:
			theMonth = "April";
			break;
		case 5:
			theMonth = "May";
			break;
		case 6:
			theMonth = "June";
			break;
		case 7:
			theMonth = "July";
			break;
		case 8:
			theMonth = "August";
			break;
		case 9:
			theMonth = "September";
			break;
		case 10:
			theMonth = "October";
			break;
		case 11:
			theMonth = "November";
			break;
		case 12:
			theMonth = "December";
			break;
		}
		return theMonth;
	}
/**
 * 
 * @return a String of the date
 * The month is changed from int to string by switch/case.
 */
	public String getDate() {
		String theMonth = "";
		switch (month) {
		case 1:
			theMonth = "January";
			break;
		case 2:
			theMonth = "February";
			break;
		case 3:
			theMonth = "March";
			break;
		case 4:
			theMonth = "April";
			break;
		case 5:
			theMonth = "May";
			break;
		case 6:
			theMonth = "June";
			break;
		case 7:
			theMonth = "July";
			break;
		case 8:
			theMonth = "August";
			break;
		case 9:
			theMonth = "September";
			break;
		case 10:
			theMonth = "October";
			break;
		case 11:
			theMonth = "November";
			break;
		case 12:
			theMonth = "December";
			break;
		}
		return (theMonth + "/" +day + "/" +year);
}
}

package myCourseSoftware;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import myCourseSoftware.objects.Assignments;
import myCourseSoftware.objects.Course;
import myCourseSoftware.objects.Date;
import myCourseSoftware.objects.Person;
import myCourseSoftware.objects.Professor;
import myCourseSoftware.objects.Semester;
import myCourseSoftware.objects.TextBook;

public class Adder {
	public ArrayList<String> totalFile = new ArrayList<String>();
	public ArrayList<String> tempSem = new ArrayList<String>();
	public ArrayList<String> tempCourse = new ArrayList<String>();
	public ArrayList<String> tempAssignments = new ArrayList<String>();
	public ArrayList<String> getTempAssignments() {
		return tempAssignments;
	}
	public ArrayList<Person> personArray = new ArrayList<Person>();
	public ArrayList<Semester> semesterArray = new ArrayList<Semester>(); 
	public ArrayList<Course> courseArray = new ArrayList<Course>(); 
	public ArrayList<Assignments> assignmentArray = new ArrayList<Assignments>(); 
	private String personName, profName, profEmail, profPhone, profOffice,
			profOfficeHours, bookName, publisherName, semesterName, courseName;
	private static String match;
	private static String match2;
	private static String match3;
	private String assignmentName = "name";
	int occured;
	int month, day, year, month2, day2, year2 = 0;
	private String assignmentType = "type";
	private String writecoursesemName;
	private int firstID = 426435;
	private double Totalgpa, Semestergpa, coursegrade, pointsAvailable,
			pointsEarned, bookCost, grade = 0.0;
	String[] thefilelines;
	Date dateAssigned = new Date(month, day, year);
	Date dateDue = new Date(month2, day2, year2);
	Assignments assignment1 = new Assignments(assignmentName, dateAssigned,
			dateDue, assignmentType, pointsAvailable, pointsEarned, grade);
	TextBook text = new TextBook(bookName, publisherName, bookCost);
	Professor prof = new Professor(profName, profEmail, profPhone, profOffice,
			profOfficeHours);
	TextBook tempText;
	Professor tempProf;
	Assignments tempAssign;
	Course course1 = new Course(assignmentArray, courseName, prof, coursegrade, text);
	Semester semester1 = new Semester(courseArray, semesterName, Semestergpa);
	Person student1 = new Person(semesterArray, personName, Totalgpa, firstID);
	public static String nameGiven;
	public static String theFileName;
	/**
	 * 
	 * @param theNameGiven is the student name being searched for.
	 * @throws IOException
	 */
	public Adder(String theNameGiven) throws IOException {
		theNameGiven = theNameGiven.trim();
		theNameGiven = theNameGiven.toLowerCase();
		nameGiven = theNameGiven;
		theFileName = "data/"+nameGiven+".txt";
		getLines(theFileName);
		System.out.println("MATCH:"+match);
		System.out.println("MATCH2:"+match2);
	}
	/**
	 * This method fills a lot of the variables and reads the file line by line.
	 * @param fileName is the student name being search for as a file name.
	 * @return a simple array of the lines in the file.
	 * @throws IOException
	 */
	public String[] getLines(String fileName) throws IOException {
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			lines.add(line);
			if (getFirstTen(line).equalsIgnoreCase("STUDENTID")) {
				splitStudentID(line);
			} else if (getFirstTen(line).equalsIgnoreCase("NAME")){
				splitName(line);
			}else if (getFirstTen(line).equalsIgnoreCase("TOTALGPA")) {
				splitTotalgpa(line);
			} else if (getFirstTen(line).equalsIgnoreCase("SEMESTER")) {
				splitSemester(line);
			} else if (getFirstTen(line).equalsIgnoreCase("COURSE")) {
				splitCourse(line);
			} else if (getFirstTen(line).equalsIgnoreCase("PROFESSOR")) {
				splitProf(line);
				if(semesterName.equalsIgnoreCase(match)){
					if(courseName.trim().equalsIgnoreCase(match2)){
						tempProf = new Professor(profName, profEmail, profPhone, profOffice,
								profOfficeHours);
					}
					}
			} else if (getFirstTen(line).equalsIgnoreCase("TEXTBOOK")) {
				splitTextBook(line);
				if(semesterName.equalsIgnoreCase(match)){
					if(courseName.trim().equalsIgnoreCase(match2)){
						tempText = new TextBook(bookName,publisherName,bookCost);
					}
					}
			} else if (getFirstTen(line).equalsIgnoreCase("ASSIGNMENT")) {
				splitAssignment(line);
				assignmentArray.add(assignment1);
				if(semesterName.equalsIgnoreCase(match)){
				if(courseName.trim().equalsIgnoreCase(match2)){
				tempAssignments.add(assignmentName+" - "+assignmentType+" - "+grade);
				}
				}
				if(assignmentName.equalsIgnoreCase(match3)){
					tempAssign = new Assignments(assignmentName, dateAssigned,
							dateDue, assignmentType, pointsAvailable, pointsEarned, grade);
				}
			} else if (getFirstTen(line).equalsIgnoreCase("NEWCOURSE")){
				courseArray.add(course1);
				if(semesterName.equalsIgnoreCase(match)){
					tempCourse.add(courseName+" - "+coursegrade);	
				}
				course1 = new Course(null, "", null, 0.0, null);
			} else if (getFirstTen(line).equalsIgnoreCase("NEXT")){
				course1 = new Course(null, "", null, 0.0, null);
				semesterArray.add(semester1);	
				semester1 = new Semester(null, "", 0.0);
				tempSem.add(semesterName);
			} else if (getFirstTen(line).equalsIgnoreCase("END")){
					courseArray.add(course1);
					semesterArray.add(semester1);
					tempSem.add(semesterName);
					personArray.add(student1);	
			}
		}
		personArray.add(student1);
		bufferedReader.close();
		return lines.toArray(new String[lines.size()]);
	}
	/**
	 * 
	 * @param passed is the String being searched for.
	 * @param list is the list being searched.
	 * @return if the passed word is found in file, its not only one, return true.
	 * if its not found then it returns false.
	 */
	public boolean checkOccurence(String passed, List<String> list){
		int count = 0;
		for(int i = 0; i < list.size(); i ++){
			String temp = list.get(i).toUpperCase().trim();
		if(temp.startsWith(passed)){
			count++;
			System.out.println(passed+" was counted: "+count);
			}
		}
		if(count == 0){
			return false;
		}else{
			return true;
		}
	}	
	/**
	 * 
	 * @param newName is the name of the semester you are about to add
	 * @throws IOException
	 * If there is more than one semester in the file already it adds a "NEXT"
	 * If there isn't any semesters in the file, it adds the semester followed by "END"
	 * the "NEXT" and "END" are for my data's structure
	 * 
	 */
	public void WriteSemester(String newName)throws IOException{
		FileReader fileReader = new FileReader(theFileName);
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
		lines.add(line);
		}
		PrintWriter writer = new PrintWriter(theFileName);
		writer.print("");
		@SuppressWarnings("resource")
		BufferedWriter output = new BufferedWriter(new FileWriter(theFileName));
		String[] liner = lines.toArray(new String[lines.size()]);
		for(int i = 0; i < liner.length;i++){
			if(i == liner.length-1){
				if(checkOccurence("SEMESTER",lines)){
					output.write("NEXT");
					output.newLine();
					output.write("SEMESTER:"+newName.toUpperCase()+":0.0");
					output.newLine();
					output.write("END");
					output.close();
				}else{
					output.write(liner[i]);
					output.newLine();
					output.write("SEMESTER:"+newName.toUpperCase()+":0.0");
					output.newLine();
					output.write("END");
					output.close();
				}	
			}else{
				output.write(liner[i]);
				output.newLine();
			}
		}
		writer.close();
		System.out.println("Writer Finished");
	}
	/**
	 * 
	 * @param semName is the name of the semester.
	 * @param theBook is of Object Book, and is the Book in the course.
	 * @param theProf is of Object Professor, and is the Professor in the course.
	 * @param newName is going to be the new name of the course.
	 * @throws IOException
	 */
	public void WriteCourse(String semName, TextBook theBook, Professor theProf, String newName)throws IOException{
		writecoursesemName = semName;
		FileReader fileReader = new FileReader(theFileName);
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
		lines.add(line);
		}
		PrintWriter writer = new PrintWriter(theFileName);
		writer.print("");
		BufferedWriter output = new BufferedWriter(new FileWriter(theFileName));
		String[] liner = lines.toArray(new String[lines.size()]);
		ArrayList<String> semesterOnly = new ArrayList<String>();
		int startline = -1;
		int endline = -1;
		while(endline == -1){
		for(int i = 0; i < liner.length; i++){
			if(liner[i].toUpperCase().indexOf("SEMESTER:"+writecoursesemName.toUpperCase()+":")> -1){
				startline = i;
			}
			if(startline > -1){
				semesterOnly.add(liner[i]);
				if(liner[i].toUpperCase().indexOf("END")> -1){
					endline = i;
				}
				if(liner[i].toUpperCase().indexOf("NEXT")> -1){
					endline = i;
				}
			}
			
		}
	}
		for(int i = 0; i < liner.length;i++){
			if(liner[i].toUpperCase().indexOf("SEMESTER:"+writecoursesemName.toUpperCase()+":")> -1){
				startline = i;
				System.out.println("C h a n g e p o s   i = "+i);
				if(checkOccurence("COURSE",semesterOnly)){
				output.write(liner[i]);
				output.newLine();
					output.write("COURSE:"+newName.toUpperCase()+":100");
					output.newLine();
					output.write("PROFESSOR:"+theProf.getName().toUpperCase()+":"+theProf.getEmail().toUpperCase()+":"+theProf.getPhone().toUpperCase()+":"+theProf.getOffice().toUpperCase()+":"+theProf.getOfficeHours().toUpperCase());
					output.newLine();
					output.write("TEXTBOOK:"+theBook.getTitle().toUpperCase()+":"+theBook.getPublisher().toUpperCase()+":"+theBook.getPrice());
					output.newLine();
					output.write("NEWCOURSE");
					output.newLine();
					}else{
						output.write(liner[i]);
						output.newLine();
							output.write("COURSE:"+newName+":100");
							output.newLine();
							output.write("PROFESSOR:"+theProf.getName().toUpperCase()+":"+theProf.getEmail().toUpperCase()+":"+theProf.getPhone().toUpperCase()+":"+theProf.getOffice().toUpperCase()+":"+theProf.getOfficeHours().toUpperCase());
							output.newLine();
							output.write("TEXTBOOK:"+theBook.getTitle()+":"+theBook.getPublisher()+":"+theBook.getPrice());
							output.newLine();
							output.write("NEWCOURSE");
							output.newLine();
					}
			}else{
				output.write(liner[i]);
				output.newLine();
			}
		}
		output.close();
		System.out.println("Writer Finished.");
		writer.close();
	}
	/**
	 * 
	 * @param semName is the semester name passed.
	 * @param couName is the course name passed.
	 * @param newName is the new assignment name.
	 * @param due is the date due.
	 * @param assigned is the date assigned.
	 * @param type is the type of assignment it is.
	 * @param earned is the earned points.
	 * @param worth is how many points the assignment is worth.
	 * @param grade is the grade earned on the assignment.
	 * @throws IOException
	 */
	public void WriteAssignment(String semName, String couName, String newName, String due, String assigned, String type, double earned, double worth, double grade)throws IOException{
		grade = earned/worth;
		FileReader fileReader = new FileReader(theFileName);
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
		lines.add(line);
		}
		PrintWriter writer = new PrintWriter(theFileName);
		writer.print("");
		BufferedWriter output = new BufferedWriter(new FileWriter(theFileName));
		String[] liner = lines.toArray(new String[lines.size()]);
		ArrayList<String> courseOnly = new ArrayList<String>();
		int startline = -1;
		System.out.println("PASSED TO FIND: "+couName);
		for(int i = 0; i < liner.length; i++){
			if(liner[i].toUpperCase().indexOf("COURSE:"+couName.toUpperCase().trim()+":")> -1){
				startline = i+2;
				System.out.println("StartLINE: "+i);
			}
		}
		System.out.println("NEWNAME:"+newName+"  TYPE:"+type+"  GRADE:"+grade+"  ASSIGNED"+assigned+"  DUE"+due+"  EARNED"+earned+"  WORTH"+worth);
		for(int i = 0; i < liner.length;i++){
			if((i) == startline){
					output.write(liner[i]);
					output.newLine();
					output.write("ASSIGNMENT:"+newName.toUpperCase()+":"+type.toUpperCase()+":"+grade+":"+assigned.toUpperCase()+":"+due.toUpperCase()+":"+earned+":"+worth);
					output.newLine();
			}else{
				output.write(liner[i]);
				output.newLine();
			}
		}
		output.close();
		System.out.println("Writer Finished.");
		writer.close();
	}
	/**
	 * 
	 * @param oldLine is the old line being search for and then, if found, replaced.
	 * @param newLine is the new line going in the spot of the old line.
	 * @throws IOException
	 */
	public void changeLines(String oldLine, String newLine) throws IOException {
		FileReader fileReader = new FileReader(theFileName);
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
		lines.add(line);
		}
		PrintWriter writer = new PrintWriter(theFileName);
		writer.print("");
		@SuppressWarnings("resource")
		BufferedWriter output = new BufferedWriter(new FileWriter(theFileName));
		String[] liner = lines.toArray(new String[lines.size()]);
		for(int i = 0; i < liner.length; i++){
			if(liner[i].equalsIgnoreCase(oldLine)){
				System.out.println("FOUND OLD LINE!");
				liner[i]=liner[i].replace(oldLine, newLine);
				output.write(liner[i]);
				output.newLine();
			}else{
				output.write(lines.get(i));
				output.newLine();
			}
			
		}
		output.close();
	    writer.close();
		}
	/**
	 * 
	 * @param key is the key being searched for in the parameter list.
	 * @param list is list being searched to find the key.
	 * @return the line position the key param was found in the list param.
	 */
	public int getLinePos(String key, List<String> list){
		int lineNum = 0;
		String test = key.toUpperCase();
		for(int i=0; i < list.size();i++){
			if(list.get(i).toString().trim().toUpperCase().indexOf(test) > -1){
			lineNum = i;	
			}
		}
		return lineNum;
	}
	/**
	 * Sets the semester match word in Adder.
	 * @param matchWord is the word being looked for, which is a semester Name.
	 */
	public static void setMatchWord(String matchWord){
		match = matchWord;
	}
	/**
	 * Sets the course match word in Adder.
	 * @param matchWord is the word being looked for, which is a course Name.
	 */
	public static void setMatchWord2(String matchWord){
		match2 = matchWord;
	}
	/**
	 * Sets the Assignment match word in Adder.
	 * @param matchWord is the word being looked for, which is an assignment name.
	 */
	public static void setMatchWord3(String matchWord){
		match3 = matchWord;
	}
	/**
	 * 
	 * @return the temp semester ArrayList
	 */
	public ArrayList<String> getTempSem() {
		return tempSem;
	}
	/**
	 * Sets the temporary ArrayList to the given param.
	 * @param tempSem will be the new temporary semester list.
	 */
	public void setTempSem(ArrayList<String> tempSem) {
		this.tempSem = tempSem;
	}
	/**
	 * Sets the name variable of the student.
	 * @param line is the line being passed.
	 */
	public void splitName(String line) {
		String delimiter = ":";
		String temp[];
		temp = line.split(delimiter);
		personName = temp[1];
		System.out.println("NAME:"+personName);
	}
	/**
	 * Sets the variable of the students ID.
	 * @param line is the line being passed.
	 */
	public void splitStudentID(String line) {
		String delimiter = ":";
		String temp[];
		temp = line.split(delimiter);
		firstID = Integer.parseInt(temp[1]);
		System.out.println("STUDENTID:"+firstID);
	}
	/**
	 * Sets the variables of total GPA.
	 * @param line is the line being passed.
	 */
	public void splitTotalgpa(String line) {
		String delimiter = ":";
		String temp[];
		temp = line.split(delimiter);
		Totalgpa = Double.parseDouble(temp[1]);
		System.out.println("TOTALGPA:"+Totalgpa);
	}
	/**
	 * Sets all the variables of semester1.
	 * @param line is the line being passed.
	 */
	public void splitSemester(String line) {
		String delimiter = ":";
		String temp[];
		temp = line.split(delimiter);
		setSemesterName(temp[1]);
	    Semestergpa = Double.parseDouble(temp[2]);
	    setSemestergpa(Semestergpa);
		System.out.println("SemesterName: "+semesterName);
		System.out.println("Semester GPA: "+Semestergpa);
	}
	/**
	 * Sets the gpa of the semester.
	 * @param semestergpa
	 */
	private void setSemestergpa(double semestergpa) {
		this.Semestergpa = semestergpa;
		
	}
	/**
	 * Sets all the variables of course1.
	 * @param line is the line passed.
	 */
	public void splitCourse(String line) {
		String delimiter = ":";
		String temp[];
		temp = line.split(delimiter);
		setCourseName(temp[1]);
		coursegrade = Double.parseDouble(temp[2]);
		setCoursegrade(coursegrade);
		System.out.println("Course Name: "+courseName);
		System.out.println("Course GPA: "+coursegrade);
	}
	/**
	 * Sets the grade earned in the course.
	 * @param coursegrade2 is the new grade earned in the course.
	 */
	private void setCoursegrade(double coursegrade2) {
		this.coursegrade = coursegrade2;
		
	}
	/**
	 * Sets all the variables of text1.
	 * @param line is the line passed.
	 */
	public void splitTextBook(String line) {
		String delimiter = ":";
		String temp[];
		temp = line.split(delimiter);
		bookName = temp[1];
		publisherName = temp[2];
		bookCost = Double.parseDouble(temp[3]);
		System.out.println("Book: "+bookName);
		System.out.println("publisher: "+publisherName);
		System.out.println("price: "+bookCost);
	}
	/**
	 * Sets all the variables of Prof1.
	 * @param line is the line passed.
	 */
	public void splitProf(String line) {
		String delimiter = ":";
		String temp[];
		temp = line.split(delimiter);
		profName = temp[1];
		profEmail = temp[2];
		profPhone = temp[3];
		profOffice = temp[4];
		profOfficeHours = temp[5];
		System.out.println("Name: "+profName);
		System.out.println("Email: "+profEmail);
		System.out.println("phone: "+profPhone);
		System.out.println("office: "+profOffice);
		System.out.println("hours: "+profOfficeHours);
	}
	/**
	 * Sets all the variables of Assignment1
	 * @param line is the line passed.
	 */
	public void splitAssignment(String line) {
		String delimiter = ":";
		String temp[];
		temp = line.split(delimiter);
		assignmentName = temp[1];
		assignmentType = temp[2];
		grade = Double.parseDouble(temp[3]);
		String delimiter2 = "/";
		String tempAssignDate[];
		tempAssignDate = temp[4].split(delimiter2);
		month = Integer.parseInt(tempAssignDate[0]);
		day = Integer.parseInt(tempAssignDate[1]);
		year = Integer.parseInt(tempAssignDate[2]);
		String tempDueDate[];
		tempDueDate = temp[5].split(delimiter2);
		month2 = Integer.parseInt(tempDueDate[0]);
		day2 = Integer.parseInt(tempDueDate[1]);
		year2 = Integer.parseInt(tempDueDate[2]);
		pointsEarned = Double.parseDouble(temp[6]);
		pointsAvailable = Double.parseDouble(temp[7]);
		System.out.println("Name: "+assignmentName);
		System.out.println("Type: "+assignmentType);
		System.out.println("Assigned: "+month+"/"+day+"/"+year);
		System.out.println("Due: "+month2+"/"+day2+"/"+year2);
		System.out.println("Aavailable: "+pointsAvailable);
		System.out.println("Earned: "+pointsEarned);
		System.out.println("Grade: "+grade);
		
	}
	/**
	 * Reads the line and returns the first string before the colon 
	 * @param line is the line in the file being read.
	 * @return the string in the line before the first ':'.
	 */
	public String getFirstTen(String line) {
		String[] temp = line.split(":");
		String firstten = temp[0].toUpperCase();
		return firstten;
	}
	/**
	 * 
	 * @return the name of the professor.
	 */
	public String getProfName() {
		return profName;
	}
	/**
	 * 
	 * @param profName will be the new name of the professor.
	 */
	public void setProfName(String profName) {
		this.profName = profName;
	}
	/**
	 * 
	 * @return the professors email.
	 */
	public String getProfEmail() {
		return profEmail;
	}
	/**
	 * Sets the professors Email.
	 * @param profEmail will be the professors email.
	 */
	public void setProfEmail(String profEmail) {
		this.profEmail = profEmail;
	}
	/**
	 * 
	 * @return the professors phone number.
	 */
	public String getProfPhone() {
		return profPhone;
	}
	/**
	 * Sets the professors phone number.
	 * @param profPhone will be the professors new phone number.
	 */
	public void setProfPhone(String profPhone) {
		this.profPhone = profPhone;
	}
	/**
	 * 
	 * @return the office number of the professor.
	 */
	public String getProfOffice() {
		return profOffice;
	}
	/**
	 * Sets the office of the professor.
	 * @param profOffice will be the new office number of the professor.
	 */
	public void setProfOffice(String profOffice) {
		this.profOffice = profOffice;
	}
	/**
	 * 
	 * @return the office hours of a professor.
	 */
	public String getProfOfficeHours() {
		return profOfficeHours;
	}
	/**
	 * Sets the office hours of a professor.
	 * @param profOfficeHours will be the new office hours of the professor.
	 */
	public void setProfOfficeHours(String profOfficeHours) {
		this.profOfficeHours = profOfficeHours;
	}
	/**
	 * 
	 * @return the name of the book.
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * Sets the name of the book.
	 * @param bookName will be the new book name.
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * 
	 * @return the name of the publisher
	 */
	public String getPublisherName() {
		return publisherName;
	}
	/**
	 * Sets the name of the semester.
	 * @param publisherName will be the new name of the semester.
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	/**
	 * 
	 * @return the name of the semester.
	 */
	public String getSemesterName() {
		return semesterName;
	}
	/**
	 * Sets the name of a semester.
	 * @param semesterName will be the new semester name.
	 */
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	/**
	 * 
	 * @return the name of the course.
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * Sets the name of the course.
	 * @param courseName will be the new course name.
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 
	 * @return the name of the assignment.
	 */
	public String getAssignmentName() {
		return assignmentName;
	}
	/**
	 * Sets the name of an assignment.
	 * @param assignmentName will be the new assignment name.
	 */
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	/**
	 * 
	 * @return the month the assignment was assigned.
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * 
	 * @param month will be the new assignment assigned month.
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * 
	 * @return the day the assignment was assigned.
	 */
	public int getDay() {
		return day;
	}
	/**
	 * Sets the day the assignment was assigned.
	 * @param day is the day the assignment was assigned.
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * 
	 * @return an ArrayList of ONLY the courses name, for the GUI JList.
	 */
	public ArrayList<String> getTempCourse() {
		return tempCourse;
	}
	/**
	 * 
	 * @return the year of the date the assignment was assigned.
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Sets the year of the assignments assigned date.
	 * @param year will be the new year of the date assigned.
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * 
	 * @return the month of the assignments due date
	 */
	public int getMonth2() {
		return month2;
	}
	/**
	 * 
	 * @param month2 will be the new month of the due date of the assignment.
	 */
	public void setMonth2(int month2) {
		this.month2 = month2;
	}
	/**
	 * 
	 * @return the day of the month the assignment is due.
	 */
	public int getDay2() {
		return day2;
	}
	/**
	 * 
	 * @param day2 will be the day of the month the assignment is due
	 */
	public void setDay2(int day2) {
		this.day2 = day2;
	}
	/**
	 * 
	 * @return the year the assignment was due.
	 */
	public int getYear2() {
		return year2;
	}
	/**
	 * Sets the year of the assignments due date.
	 * @param year2 will be the new year of the assignment due date.
	 */
	public void setYear2(int year2) {
		this.year2 = year2;
	}
	/**
	 * 
	 * @return the type of assignment.
	 */
	public String getAssignmentType() {
		return assignmentType;
	}
	/**
	 * Sets the assignment type to the given parameter.
	 * @param assignmentType will be the new assignment type.
	 */
	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}
	/**
	 * 
	 * @return the amount of points available on the most recent assignment.
	 */
	public double getPointsAvailable() {
		return pointsAvailable;
	}
	/**
	 * Sets the most recent points available on the most recent assignment to the given parameter.
	 * @param pointsAvailable is going to be the new points available
	 */
	public void setPointsAvailable(double pointsAvailable) {
		this.pointsAvailable = pointsAvailable;
	}
	/**
	 * 
	 * @return the points earned on the most recent assignment.
	 */
	public double getPointsEarned() {
		return pointsEarned;
	}
	/**
	 * Sets the most recent points earned on an assignment to the given parameter.
	 * @param pointsEarned is going to be the new points earned.
	 */
	public void setPointsEarned(double pointsEarned) {
		this.pointsEarned = pointsEarned;
	}
	/**
	 * 
	 * @return the book cost of the most recent book.
	 */
	public double getBookCost() {
		return bookCost;
	}
	/**
	 * Sets the most recent books book price to the passed parameter.
	 * @param bookCost is going to be the new bookCost
	 * 
	 */
	public void setBookCost(double bookCost) {
		this.bookCost = bookCost;
	}
	/**
	 * 
	 * @return the ArrayList of Semesters.
	 */
	public ArrayList<Semester> getSemesterArray() {
		return semesterArray;
	}
	/**
	 * 
	 * @return the ArrayList of Courses.
	 */
	public ArrayList<Course> getCourseArray() {
		return courseArray;
	}
	/**
	 * 
	 * @return the ArrayList of Assignments.
	 */
	public ArrayList<Assignments> getAssignmentArray() {
		return assignmentArray;
	}
	/**
	 * 
	 * @return the name of the student
	 * 
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * 
	 * @return the ID of the student.
	 */
	public int getFirstID() {
		return firstID;
	}
	/**
	 * 
	 * @return the total gpa of a student.
	 */
	public double getTotalgpa() {
		return Totalgpa;
	}
	/**
	 * 
	 * @return the gpa of a certain semester.
	 */
	public double getSemestergpa() {
		return Semestergpa;
	}
	/**
	 * 
	 * @return the grade of a certain course.
	 */
	public double getCoursegrade() {
		return coursegrade;
	}
	/**
	 * 
	 * @return the grade of the student.
	 */
	public double getGrade() {
		return grade;
	}
	/**
	 * 
	 * @return the name being edited.
	 */
	public static String getNameGiven() {
		return nameGiven;
	}
	/**
	 * 
	 * @return the directory and name of file to be read.
	 */
	public static String getTheFileName() {
		return theFileName;
	}

}

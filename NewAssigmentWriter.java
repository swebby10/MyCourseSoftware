package myCourseSoftware;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import myCourseSoftware.objects.Assignments;
import myCourseSoftware.objects.Date;

public class NewAssigmentWriter implements ActionListener {
	JFrame mainScreen;
	JButton add, cancel, checkVar;
	JLabel assignName, assignType, dueDatelbl, assignDatelbl, worthlbl, earnedlbl, errormsg;
	JTextField name, worth, earned;
	JComboBox month1, month2, day1, day2, year1,year2, type;
	String stuName, semesterName, courseName;
	String assignmentName;
	double grade;
	boolean editMode;
	Assignments assignment;
	String[] assignmentTypes = {"Quiz","Test","Project","HomeWork","ClassWork","GroupProject","Attendence","Other"};
	String[] months = {"January","February","March","April","May","June","July","August","September","October","November", "December"};
	String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String[] years = {"2014","2015"};
	/**
	 * 
	 * @param student is the name of the student.
	 * @param semester is the name of the semester.
	 * @param course is the name of the course.
	 * @param assign is the name of the assignment.
	 * @param eMode is true if its in edit mode, and false if its in add mode.
	 * @throws IOException
	 */
	public NewAssigmentWriter(String student, String semester, String course, Assignments assign, boolean eMode)throws IOException {
		assignment = assign;
		editMode = eMode;
		stuName = student;
		semesterName = semester;
		courseName = course;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle("Add Assignment");
		mainScreen.setContentPane(makePanel());
		mainScreen.setLocation(250, 100);
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	/**
	 * 
	 * @return a panel and all of its components.
	 */
	public JPanel makePanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 455));
		panel.setBackground(Color.DARK_GRAY);
		assignName = new JLabel("Please enter name of asssignment.");
		assignName.setForeground(Color.WHITE);
		assignName.setBounds(25, 10, 350, 30);
		panel.add(assignName);
		name = new JTextField(25);
		name.setBounds(25, 40, 350, 30);
		assignType = new JLabel("Please Choose Assignment Type.");
		assignType.setForeground(Color.WHITE);
		assignType.setBounds(25, 75, 350, 30);
		panel.add(assignType);
		type = new JComboBox(assignmentTypes);
		type.setBounds(25, 105, 100, 30);
		panel.add(type);
		assignDatelbl = new JLabel("Please enter the date this assignment was assigned.");
		assignDatelbl.setForeground(Color.WHITE);
		assignDatelbl.setBounds(25, 140, 350, 30);
		panel.add(assignDatelbl);
		month1 = new JComboBox(months);
		day1 = new JComboBox(days);
		year1 = new JComboBox(years);
		month1.setBounds(25, 170, 100, 30);
		day1.setBounds(130, 170, 50, 30);
		year1.setBounds(185, 170, 60, 30);
		dueDatelbl = new JLabel("Please enter the date this assignment was due.");
		dueDatelbl.setForeground(Color.WHITE);
		dueDatelbl.setBounds(25, 205, 350, 30);
		panel.add(dueDatelbl);
		month2 = new JComboBox(months);
		day2 = new JComboBox(days);
		year2 = new JComboBox(years);
		month2.setBounds(25, 235, 100, 30);
		day2.setBounds(130, 235, 50, 30);
		year2.setBounds(185, 235, 60, 30);
		worthlbl = new JLabel("Enter how much assignment is WORTH:");
		worthlbl.setForeground(Color.WHITE);
		worthlbl.setBounds(25, 270, 350, 30);
		panel.add(worthlbl);
		worth = new JTextField(25);
		worth.setBounds(25, 300, 350, 30);
		earnedlbl = new JLabel("Enter Points Earned.");
		earnedlbl.setForeground(Color.WHITE);
		earnedlbl.setBounds(25, 335, 350, 30);
		panel.add(earnedlbl);
		earned = new JTextField(25);
		earned.setBounds(25, 365, 350, 30);
		errormsg = new JLabel("All Fields Required.");
		errormsg.setForeground(Color.RED);
		errormsg.setBounds(25, 400, 350, 30);
		panel.add(errormsg);
		add = new JButton("Add Assignment");
		cancel = new JButton("Cancel");
		add.setBounds(140, 425, 150, 25);
		add.addActionListener(this);
		cancel.setBounds(295, 425, 100, 25);
		cancel.addActionListener(this);
		panel.add(add);
		panel.add(cancel);
		checkVar = new JButton("PUSH ME");
		checkVar.setBounds(35, 425, 100, 25);
		checkVar.addActionListener(this);
		//panel.add(checkVar);
if(editMode == true){
	Date due = assignment.getDue();
	Date assigned = assignment.getAssign();
			name.setText(assignment.getAssignmentName());
			worth.setText(""+assignment.getWorth());
			earned.setText(""+assignment.getEarned());
			month1.setSelectedItem(assigned.getMonthString());
			day1.setSelectedItem(assigned.getDay());
			year1.setSelectedItem(assigned.getYear());
			month2.setSelectedItem(due.getMonthString());
			day2.setSelectedItem(due.getDay());
			year2.setSelectedItem(due.getYear());
	panel.add(name);
	panel.add(worth);
	panel.add(earned);
	panel.add(month2);
	panel.add(day2);
	panel.add(year2);
	panel.add(month1);
	panel.add(day1);
	panel.add(year1);
		}else{
			panel.add(name);
			panel.add(worth);
			panel.add(earned);
			panel.add(month2);
			panel.add(day2);
			panel.add(year2);
			panel.add(month1);
			panel.add(day1);
			panel.add(year1);
		}
		return panel;
	}
	/**
	 * 
	 * @param word is the name of the month
	 * @return the number of that month, for example: January = 01.
	 */
	public String getMonthNum(String word){
		String theNum = "";
		if(word.equalsIgnoreCase("JANUARY")){
			theNum = "01";
		}else if(word.equalsIgnoreCase("FEBRUARY")){
			theNum = "02";
		}else if(word.equalsIgnoreCase("MARCH")){
			theNum = "03";
		}else if(word.equalsIgnoreCase("APRIL")){
			theNum = "04";
		}else if(word.equalsIgnoreCase("MAY")){
			theNum = "05";
		}else if(word.equalsIgnoreCase("JUNE")){
			theNum = "06";
		}else if(word.equalsIgnoreCase("JULY")){
			theNum = "07";
		}else if(word.equalsIgnoreCase("AUGUST")){
			theNum = "08";
		}else if(word.equalsIgnoreCase("SEPTEMBER")){
			theNum = "09";
		}else if(word.equalsIgnoreCase("OCTOBER")){
			theNum = "10";
		}else if(word.equalsIgnoreCase("NOVEMBER")){
			theNum = "11";
		}else if(word.equalsIgnoreCase("DECEMBER")){
			theNum = "12";
		}
		return theNum;
	}
	private boolean test(String text) {
	      try {
	         Integer.parseInt(text);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	   }
	/**
	 * Controls what happens when a button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String newName = name.getText().trim().toUpperCase();
		String theType = type.getSelectedItem().toString();
		String m1 = getMonthNum(month1.getSelectedItem().toString());
		String m2 = getMonthNum(month2.getSelectedItem().toString());
		String d1 = day1.getSelectedItem().toString();
		String d2 = day2.getSelectedItem().toString();
		String y1 = year1.getSelectedItem().toString();
		String y2 = year2.getSelectedItem().toString();
		String dueDate = (m1+"/"+d1+"/"+y1);
		String assignDate = (m2+"/"+d2+"/"+y2);
		String worthPoints = worth.getText().trim();
		String earnedPoints = earned.getText().trim();
		double worthh = 0;
		double earnedd = 0;
		if(test(worthPoints)){
			if(test(earnedPoints)){
				worthh = Integer.parseInt(worthPoints);
				earnedd = Integer.parseInt(earnedPoints);
				grade = earnedd/worthh;
			}
		}
		if(e.getSource()==add){
			if(name.getText() != null || worth != null || earned != null){	
			try {
				System.out.println("Adder before");
				Adder add1 = new Adder(stuName);
				System.out.println("Adder After");
				add1.WriteAssignment(semesterName, courseName, newName, dueDate, assignDate, theType, earnedd, worthh, grade);
				mainScreen.setVisible(false);
				new EditModeCourse(semesterName, stuName, courseName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}else{
			errormsg.setText("Something is filled out incorrectly.");
		}
		}else if(e.getSource() == checkVar){
			System.out.println("STUDENT NAME: "+stuName);
			System.out.println("NAME:"+newName);
			System.out.println("TYPE:"+theType);
			System.out.println("DATES:"+dueDate);
			System.out.println("ASSIGN:"+assignDate);
			System.out.println("WORTH:"+worthPoints);
			System.out.println("EARNED:"+earnedPoints);
			System.out.println("WORTH:"+worthh);
			System.out.println("EARNED:"+earnedd);
		}else if(e.getSource() == cancel){
			try {
				new EditModeCourse(semesterName, stuName, courseName);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
		}
	}
}

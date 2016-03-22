package myCourseSoftware;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import myCourseSoftware.objects.Assignments;
public class EditModeAssignment implements ActionListener {
JFrame mainScreen;
JButton back, editAssign;
JLabel studentName, semesterName, course, assignment, dates, type, points, grade;
JList<Object> assignments;
String courseName;
String semester;
String assignmentName;
String word, stuName;
Adder theAdder;
/**
 * 
 * @param theSemester is the name of the semester.
 * @param theName is the name of the student.
 * @param theCourse is the name of the course.
 * @param theAssignment is the name of the assignment.
 * @throws IOException
 */
	public EditModeAssignment(String theSemester, String theName, String theCourse, String theAssignment) throws IOException {
		stuName = theName;
		word = theSemester;
		courseName = theCourse;
		assignmentName = theAssignment;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle(assignmentName.toLowerCase()+" - Edit Mode");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setLocation(250, 100);
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
/**
 * 
 * @return a panel and all of its components.
 * @throws IOException
 */
	public JPanel makePanel() throws IOException{
		JPanel panel = new JPanel();
		MatteBorder matted = new MatteBorder(1, 5, 1, 1, Color.white);
		Adder.setMatchWord2(courseName.trim());
		Adder.setMatchWord3(assignmentName.trim());
		theAdder = new Adder(stuName);
		panel.setPreferredSize(new Dimension(475, 380));
		panel.setLayout(null);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setBorder(matted);
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		panel3.setBorder(matted);
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.LIGHT_GRAY);
		panel4.setBorder(matted);
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.LIGHT_GRAY);
		panel5.setBorder(matted);
		panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setBounds(25, 10, 425, 35);
		panel3.setBounds(25, 50, 425, 35);
		panel4.setBounds(25, 90, 425, 35);
		panel5.setBounds(25, 130, 425, 35);
		Font font = new Font("serif",Font.BOLD, 16);
		studentName = new JLabel("Name: "+theAdder.getPersonName());
	    studentName.setFont(font);
	    panel2.add(studentName);
	    semesterName = new JLabel("Semester:  "+word);
	    semesterName.setFont(font);
	    panel3.add(semesterName);
	    course = new JLabel("Course: "+courseName);
	    course.setFont(font);
	    panel4.add(course);
	    editAssign = new JButton("Change Assignment");
	    editAssign.setBounds(25, 335, 250, 35);
	    editAssign.addActionListener(this);
	   assignment = new JLabel("Assignment: "+assignmentName);
	    assignment.setFont(font);
	    panel5.add(assignment);
	    panel.add(editAssign);
	    panel.add(panel2);
	    panel.add(panel3);
	    panel.add(panel4);
	    panel.add(panel5);
	    JPanel panel6 = new JPanel();
	    panel6.setBackground(Color.LIGHT_GRAY);
	    panel6.setBorder(matted);
	    JPanel panel7 = new JPanel();
	    panel7.setBackground(Color.LIGHT_GRAY);
	    panel7.setBorder(matted);
	    panel6.setBounds(25, 170, 425, 35);
	    JPanel panel8 = new JPanel();
	    panel8.setBackground(Color.LIGHT_GRAY);
	    panel8.setBorder(matted);
	    panel8.setBounds(25, 250, 425, 35);
	    JPanel panel9 = new JPanel();
	    panel9.setBackground(Color.LIGHT_GRAY);
	    panel9.setBorder(matted);
	    panel9.setBounds(25, 290, 425, 35);
	    panel7.setBounds(25, 210, 425, 35);
	    panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
	    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
	    dates = new JLabel("Date Assigned: "+theAdder.tempAssign.getDateAsssigned()+"  ||  Date Due: "+theAdder.tempAssign.getDueDate());
	    type = new JLabel("Assignment Type: "+theAdder.tempAssign.getAssignmentType());
	    points = new JLabel("Points Available: "+theAdder.tempAssign.getWorth()+"  ||  Points Earned: "+theAdder.tempAssign.getEarned());
	    grade = new JLabel("Grade: "+theAdder.tempAssign.getGrade());
	    panel6.add(type);
	    panel7.add(dates);
	    panel.add(panel6);
	    panel.add(panel7);
	    panel8.add(points);
	    panel9.add(grade);
	    panel8.setLayout(new FlowLayout(FlowLayout.LEFT));
	    panel9.setLayout(new FlowLayout(FlowLayout.LEFT));
	    panel.add(panel8);
	    panel.add(panel9);
	    JLabel assignment = new JLabel("Assignments: ");
	    assignment.setForeground(Color.WHITE);
		back = new JButton("Back");
		panel.setBackground(Color.DARK_GRAY);
		back.setBounds(280, 335, 100, 35);
		back.addActionListener(this);
		panel.add(back);
		return panel;
	}
	/**
	 * Controls what happens when a button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == back){
			try {
				new EditModeCourse(word, stuName, courseName);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("An errror has occured.");
			}
		}else if (e.getSource() == editAssign){
			try {
				new NewAssigmentWriter(stuName, word, courseName, theAdder.tempAssign, true);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("COULD NOT OPEN NEW ASSIGNMENT WRITER.");
				e1.printStackTrace();
			}
		}
	}

}

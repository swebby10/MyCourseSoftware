package myCourseSoftware;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import myCourseSoftware.objects.Professor;
import myCourseSoftware.objects.TextBook;
public class NewCourseWriter implements ActionListener {
JFrame mainScreen;
JButton create, cancel, addTeach, addBook;
String courseName;
JLabel first, last, id, errormsg,added, added2;
JTextField cname, lname, stuId;
String stuName, semestName;
int addedTeach, addedBook = 0;
int zeId;
double totalGPA;
TextBook text = null;
Professor prof = null;
String ccName;
boolean canContinue = false;
/**
 * 
 * @param theName is the name of the student.
 * @param semesterName is the name of the semester.
 * @param theProf is the professor of the course, Object Professor.
 * @param theBook is the book of the course, Object Book.
 * @param cName is the course name.
 */
	public NewCourseWriter(String theName, String semesterName, Professor theProf, TextBook theBook, String cName) {
		stuName = theName;
		semestName = semesterName;
		prof = theProf;
		text = theBook;
		ccName = cName;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle("Add Course:");
		mainScreen.setContentPane(makePanel());
		mainScreen.setLocation(250, 100);
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	/**
	 * 
	 * @return the panel and all of its components.
	 */
	public JPanel makePanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 320));
		panel.setBackground(Color.DARK_GRAY);
		if(prof != null){
			addedTeach++;
			added2 = new JLabel("*A Teacher has been added*");
			added2.setBounds(45,145,175,30);
			added2.setForeground(Color.GREEN);
			panel.add(added2);
		}else{
			added2 = new JLabel("*Still must add Teacher*");
			added2.setBounds(45,145,175,30);
			added2.setForeground(Color.RED);
			panel.add(added2);
		}
		if(text != null){
			addedBook++;
			added = new JLabel("*A TextBook has been added*");
			added.setBounds(45,225,175,30);
			added.setForeground(Color.GREEN);
			panel.add(added);
		}else{
			added = new JLabel("*Still must add TextBook*");
			added.setBounds(45,225,175,30);
			added.setForeground(Color.RED);
			panel.add(added);
		}
		first = new JLabel("Please Enter the Courses Name:");
		first.setForeground(Color.WHITE);
		cname = new JTextField(25);
		last = new JLabel("Please Add Teacher");
		last.setForeground(Color.WHITE);
		addTeach = new JButton("Click to Add");
		addBook = new JButton("Click to Add");
		addTeach.setBounds(30, 120, 175, 30);
		addBook.setBounds(30, 200, 175, 30);
		addTeach.addActionListener(this);
		addBook.addActionListener(this);
		panel.add(addBook);
		panel.add(addTeach);
		id = new JLabel("Please Add TextBook");
		id.setForeground(Color.WHITE);
		errormsg = new JLabel("All Fields Required.");
		errormsg.setForeground(Color.RED);
		first.setBounds(25, 10, 350, 30);
		cname.setBounds(25, 45, 350, 30);
		last.setBounds(25, 90, 350, 30);
		id.setBounds(25, 170, 350, 30);
		errormsg.setBounds(25, 250, 350, 30);
		panel.add(first);
		panel.add(cname);
		panel.add(last);
		panel.add(id);
		panel.add(errormsg);
		create = new JButton("Add Course");
		cancel = new JButton("Cancel");
		create.setBounds(125, 290, 150, 25);
		create.addActionListener(this);
		cancel.setBounds(285, 290, 100, 25);
		cancel.addActionListener(this);
		panel.add(create);
		panel.add(cancel);
		return panel;
	}
/**
 * Controls what happens when a button is pressed.
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==create){
			if(cname.getText().equalsIgnoreCase("")){
				errormsg.setText("You must fill out everything!");
			}else if(addedTeach == 0){
				errormsg.setText("You must Add Teacher");
			}else if(addedBook == 0){
				errormsg.setText("You must Add Book, or check no Book");
			}else{
			courseName = cname.getText().trim().toUpperCase();
			try {
				Adder add1 = new Adder(stuName);
				add1.WriteCourse(semestName, text, prof, courseName);
				mainScreen.setVisible(false);
				new EditModeSemester(semestName, stuName);
			} catch (IOException e1) {
				System.out.println("Error making object Adder add1");
				e1.printStackTrace();
			}
			
			mainScreen.setVisible(false);
			}
		} else if(e.getSource() == addTeach){
			new TeacherAdder(stuName, semestName, prof, text, false, ccName);	
			mainScreen.setVisible(false);
		} else if(e.getSource() == addBook){
			new TextBookAdder(stuName, semestName, prof, text, false, ccName);
			mainScreen.setVisible(false);
		} else if(e.getSource() == cancel){
			try {
				new EditModeSemester(semestName, stuName);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("Could not open Edit mode - Semester");
				e1.printStackTrace();
			}
			
		}
	}
}

package myCourseSoftware;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class NewSemesterWriter implements ActionListener {
JFrame mainScreen;
JButton create, cancel;
String semestName;
JLabel first, errormsg;
JTextField semesterName;
String stuName;
double totalGPA;
Adder theAdder;
/**
 * Creates a JFrame and fills the content pane with a panel.
 * @param theName is the student name.
 */
	public NewSemesterWriter(String theName) {
		stuName = theName;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle("Add Semester:");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setLocation(250, 100);
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
		panel.setPreferredSize(new Dimension(400, 155));
		panel.setBackground(Color.DARK_GRAY);
		first = new JLabel("Enter Semester Name:");
		first.setForeground(Color.WHITE);
		errormsg = new JLabel("All Fields Required.");
		errormsg.setForeground(Color.RED);
		first.setBounds(25, 10, 350, 30);
		semesterName = new JTextField(25);
		semesterName.setBounds(25, 45, 350, 30);
		errormsg.setBounds(25, 80, 350, 30);
		panel.add(semesterName);
		panel.add(first);
		panel.add(errormsg);
		create = new JButton("Create Semester");
		cancel = new JButton("Cancel");
		create.setBounds(90, 120, 150, 25);
		create.addActionListener(this);
		cancel.setBounds(285, 120, 100, 25);
		cancel.addActionListener(this);
		panel.add(create);
		panel.add(cancel);
		return panel;
	}
/**
 * Control swhat happens when a button is pressed.
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==create){
		 if(semesterName.getText().equalsIgnoreCase("")){
				errormsg.setText("You must fill out everything!");
			}else{
				try {
			semestName = semesterName.getText().trim();
			theAdder = new Adder(stuName);
			theAdder.WriteSemester(semestName);
			mainScreen.setVisible(false);
			new EditModeStudent(stuName);
			} catch (IOException e1) {
				System.out.println("Error creating semester.");
			}
			}
		} else if(e.getSource() == cancel){
			try {
				new EditModeStudent(stuName);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("Could not open EditModeStudent with name: "+stuName);
				e1.printStackTrace();
			}
			
		}
	}
	

	

}

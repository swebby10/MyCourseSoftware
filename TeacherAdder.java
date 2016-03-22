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
public class TeacherAdder implements ActionListener {
JFrame mainScreen;
JButton create, cancel;
String semestName, courseName;
String stuName;
Professor prof, profOld;
TextBook text;
JLabel first, profEmail, profTphone, proffice, profOHours, errormsg;
JTextField profName, profPhone, profMail, profOffice, profHours;
double totalGPA;
Adder theAdder;
boolean editMode;
/**
 * Sets the local variables to the passed variables.
 * @param student is the name of the student.
 * @param semest is the name of the semester.
 * @param prof1 is of type Professor, and is the professor being added or edited.
 * @param text1 is of type TextBook, and is the TextBook being added or edited.
 * @param edit is to check if the Professor is being added or edited.
 */
	public TeacherAdder(String student, String semest, Professor prof1, TextBook text1, Boolean edit, String cName) {
		editMode = edit;
		stuName = student;
		semestName = semest;
		if (cName != null) {
		courseName = cName;
		}
		profOld = prof1;
		prof = prof1;
		text = text1;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle("Add Professor:");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	/**
	 * 
	 * @return the panel of TecherAdder and all its components.
	 */
	public JPanel makePanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 360));
		panel.setBackground(Color.DARK_GRAY);
		first = new JLabel("Enter Professor Name:");
		first.setForeground(Color.WHITE);
		errormsg = new JLabel("All Fields Required.");
		errormsg.setForeground(Color.RED);
		first.setBounds(25, 10, 350, 30);
		profName = new JTextField(25);
		profName.setBounds(25, 45, 350, 30);
		profEmail = new JLabel("Enter Professor's Email Adress:");
		profEmail.setForeground(Color.WHITE);
		profEmail.setBounds(25, 80, 350, 30);
		panel.add(profEmail);
		profMail = new JTextField(25);
		profMail.setBounds(25, 110, 350, 30);
		profTphone = new JLabel("Enter Professors telephone number.");
		profTphone.setForeground(Color.WHITE);
		profTphone.setBounds(25, 140, 350, 30);
		panel.add(profTphone);
		profPhone = new JTextField(25);
		profPhone.setBounds(25, 170, 350, 30);
		errormsg.setBounds(25, 400, 50, 425);
		panel.add(first);
		panel.add(errormsg);
		proffice = new JLabel("Enter office Number.");
		proffice.setForeground(Color.WHITE);
		proffice.setBounds(25, 200, 350, 30);
		panel.add(proffice);
		profOffice = new JTextField(25);
		profOffice.setBounds(25, 230, 350, 30);
		profOHours = new JLabel("Enter available office Hours.");
		profOHours.setForeground(Color.WHITE);
		profOHours.setBounds(25, 260, 350, 30);
		panel.add(profOHours);
		profHours = new JTextField(25);
		profHours.setBounds(25, 290, 350, 30);
if(editMode == true){
			profName.setText(prof.getName());
			profMail.setText(prof.getEmail());
			profPhone.setText(prof.getPhone());
			profOffice.setText(prof.getOffice());
			profHours.setText(prof.getOfficeHours());
			panel.add(profName);
			panel.add(profMail);
			panel.add(profPhone);
			panel.add(profOffice);
			panel.add(profHours);
		}else{
			panel.add(profName);
			panel.add(profMail);
			panel.add(profPhone);
			panel.add(profOffice);
			panel.add(profHours);
		}
		
		create = new JButton("Add Professor");
		cancel = new JButton("Cancel");
		create.setBounds(130, 325, 150, 25);
		create.addActionListener(this);
		cancel.setBounds(285, 325, 100, 25);
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
			if(editMode == false){
			if(profName != null && profMail != null && profPhone != null && profOffice != null && profHours != null){
				String name = profName.getText().trim().toUpperCase();
				String phone = profPhone.getText().trim().toUpperCase();
				String mail = profMail.getText().trim().toUpperCase();
				String office = profOffice.getText().trim().toUpperCase();
				String hours = profHours.getText().trim().toUpperCase();
				prof = new Professor(name, mail, phone, office, hours);
				new NewCourseWriter(stuName, semestName, prof, text, courseName);
				mainScreen.setVisible(false);
				}else{
					errormsg.setText("YOU MUST FILL OUT EVERYTHING");
				}
			}else{
				if(profName != null && profMail != null && profPhone != null && profOffice != null && profHours != null){
					String name = profName.getText().trim().toUpperCase();
					String phone = profPhone.getText().trim().toUpperCase();
					String mail = profMail.getText().trim().toUpperCase();
					String office = profOffice.getText().trim().toUpperCase();
					String hours = profHours.getText().trim().toUpperCase();
					prof = new Professor(name, mail, phone, office, hours);
					try {
						Adder add1 = new Adder(stuName);
						add1.changeLines(("PROFESSOR:"+profOld.getName().toUpperCase()+":"+profOld.getEmail().toUpperCase()+":"+profOld.getPhone()+":"+profOld.getOffice()+":"+profOld.getOfficeHours()),("PROFESSOR:"+name.toUpperCase()+":"+mail.toUpperCase()+":"+phone.toUpperCase()+":"+office.toUpperCase()+":"+hours.toUpperCase()));
						new EditModeCourse(semestName, stuName, courseName);
						mainScreen.setVisible(false);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					
					}else{
						errormsg.setText("YOU MUST FILL OUT EVERYTHING");
					}
			}
		} else if(e.getSource() == cancel){
			mainScreen.setVisible(false);
		}
	}
	

	

}

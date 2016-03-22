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
public class NewStudentWriter implements ActionListener {
JFrame mainScreen;
JButton create, cancel;
String firstName, lastName;
JLabel first, last, id, errormsg;
JTextField fname, lname, stuId;
String stuName, newName;
int zeId;
double totalGPA;
/**
 * Created the JFrame and adds the panel to the content pane.
 */
	public NewStudentWriter() {
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle("Add Student:");
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
		panel.setPreferredSize(new Dimension(400, 320));
		panel.setBackground(Color.DARK_GRAY);
		first = new JLabel("Enter Student First Name:");
		first.setForeground(Color.WHITE);
		fname = new JTextField(25);
		last = new JLabel("Enter Student Last Name:");
		last.setForeground(Color.WHITE);
		lname = new JTextField(25);
		id = new JLabel("Enter desired student ID:");
		id.setForeground(Color.WHITE);
		stuId = new JTextField(8);
		errormsg = new JLabel("All Fields Required.");
		errormsg.setForeground(Color.RED);
		first.setBounds(25, 10, 350, 30);
		fname.setBounds(25, 45, 350, 30);
		last.setBounds(25, 90, 350, 30);
		lname.setBounds(25, 125, 350, 30);
		id.setBounds(25, 170, 350, 30);
		stuId.setBounds(25, 205, 350, 30);
		errormsg.setBounds(25, 250, 350, 30);
		panel.add(first);
		panel.add(fname);
		panel.add(last);
		panel.add(lname);
		panel.add(id);
		panel.add(stuId);
		panel.add(errormsg);
		create = new JButton("Create Student");
		cancel = new JButton("Cancel");
		create.setBounds(90, 290, 150, 25);
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
			if(fname.getText().equalsIgnoreCase("")){
				errormsg.setText("You must fill out everything!");
			}else if(lname.getText().equalsIgnoreCase("")){
				errormsg.setText("You must fill out everything!");
			}else if(stuId.getText().equalsIgnoreCase("")){
				errormsg.setText("You must fill out everything!");
			}else{
			lastName = lname.getText().trim();
			firstName = fname.getText().trim();
			zeId = Integer.parseInt(stuId.getText().trim());
			newFile();
			try {
				new EditModeStudent(newName);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("Could not open newly created student: "+newName);
				e1.printStackTrace();
			}
			
			}
		} else if(e.getSource() == cancel){
			new EditModeSearch();
			mainScreen.setVisible(false);
		}
	}
/**
 * Created a new file based on the students name.
 */
	public void newFile() {
		newName = firstName.toLowerCase().trim()+lastName.toLowerCase().trim();
		try {
			File file = new File("data/"+newName+".txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write("NAME:"+firstName.toUpperCase()+"_"+lastName.toUpperCase());
			output.newLine();
			output.write("STUDENTID:"+zeId);
			output.newLine();
			output.write("TOTALGPA:"+0.0);
			output.newLine();
			output.write("");
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

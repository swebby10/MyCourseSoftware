package myCourseSoftware;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
public class EditModeSearch implements ActionListener {
JFrame mainScreen;
JButton search, back, add;
JLabel directions, errorMsg;
JTextField searchBox;
String stuName, firstName, lastName;
int stuID, newStuID;
double totalGPA;

ImageIcon image = new ImageIcon("logo.jpg");
/**
 * JFrame
 */
	public EditModeSearch() {
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle("Search by Name - Edit Mode");
		mainScreen.setContentPane(makePanel());
		mainScreen.setLocation(250, 100);
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
		JLabel label1 = new JLabel(image);
		label1.setBounds(20, 60, 50, 50);
		mainScreen.add(label1);
		JLabel label2 = new JLabel(image);
		label2.setBounds(415, 60, 50, 50);
		mainScreen.add(label2);
	}
	/**
	 * 
	 * @return the panel and all of its components.
	 */
	public JPanel makePanel(){
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(475, 200));
		panel.setSize(475,175);
		panel.setLayout(null);
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel2.setBounds(25, 25, 425, 30);
		panel3.setBounds(25, panel.getHeight()-25, 425, 30);
		Font font = new Font("serif",Font.BOLD, 16);
		directions = new JLabel("Please enter a name then click search.");
	    directions.setFont(font);
	    panel2.add(directions);
	    errorMsg = new JLabel("Was the search a success?");
	    errorMsg.setFont(font);
	    panel3.add(errorMsg);
	    panel2.setBackground(Color.LIGHT_GRAY);
	    panel3.setBackground(Color.LIGHT_GRAY);
	    MatteBorder matted = new MatteBorder(1, 5, 1, 1, Color.white);
	    panel2.setBorder(matted);
	    panel3.setBorder(matted);
	    panel.add(panel2);
	    panel.add(panel3);
		search = new JButton("Search");
		back = new JButton("Back");
		add = new JButton("Add Student");
		panel.setBackground(Color.DARK_GRAY);
		add.setBounds(180, 115, 120, 25);
		add.addActionListener(this);
		panel.add(add);
		search.setBounds(70, 115, 100, 25);
		search.addActionListener(this);
		panel.add(search);
		back.setBounds(310, 115, 100, 25);
		back.addActionListener(this);
		panel.add(back);
		searchBox = new JTextField(3);
		searchBox.setSize(295, 20);
		searchBox.setLocation(90, 75);
		panel.add(searchBox);
		return panel;
	}
/**
 * Controls what happens when a button is pressed.
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search){
			try {
				String searchKey = searchBox.getText().trim();
				searchKey = searchKey.toLowerCase();
				new Adder(searchKey);
				new EditModeStudent(searchKey);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				errorMsg.setForeground(Color.RED);
				errorMsg.setText("ERROR, Could not find student: "+searchBox.getText());
			}
		} else if(e.getSource() == back){
			new LogIn();
			mainScreen.setVisible(false);
		} else if(e.getSource()== add){
			new NewStudentWriter();
			mainScreen.setVisible(false);
		}
	}


}

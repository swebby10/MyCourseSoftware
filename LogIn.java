package myCourseSoftware;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
public class LogIn implements ActionListener{
JFrame mainScreen;
JButton back, logIn;
JLabel errorLabel, attemptLabel;
JPanel attemptPanel;
String userName = "."; 
String password = ".";
JTextField userTextF;
JPasswordField passTextF;
MatteBorder border;
int attempts = 1;
/**
 * JFrame of Login Page
 */
	public LogIn() {
		mainScreen = new JFrame();
		mainScreen.setLocation(250, 100);
		mainScreen.setResizable(false);
		mainScreen.setTitle("Log in to Westfield DB");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
	}
	/**
	 * 
	 * @return the panel of the JFrame and all of its components.
	 */
	public JPanel makePanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(475, 200));
		panel.setSize(475,175);
		panel.setLayout(null);
		JPanel panelU = new JPanel();
		JPanel panelP = new JPanel();
		panelU.setBackground(Color.DARK_GRAY);
		panelP.setBackground(Color.DARK_GRAY);
		Font font = new Font("serif",Font.BOLD, 16);
		JLabel userLabel = new JLabel("Username: ");
		JLabel passLabel = new JLabel("Password");
		userLabel.setForeground(Color.WHITE);
		passLabel.setForeground(Color.WHITE);
		userLabel.setFont(font);
		passLabel.setFont(font);
		panelU.add(userLabel);
		panelP.add(passLabel);
		userTextF= new JTextField(25);
		passTextF = new JPasswordField(25);
		panelU.setBounds(30, 15, 170, 30);
		panelP.setBounds(30, 85, 170, 30);
		userTextF.setBounds(30, 50, 415, 30);
		passTextF.setBounds(30, 120, 415, 30);
		panel.add(panelP);
		panel.add(panelU);
		panel.add(userTextF);
		panel.add(passTextF);
		JPanel errorPanel = new JPanel();
		errorLabel = new JLabel("Please enter User + Pass");
		errorPanel.setBackground(Color.DARK_GRAY);
		errorPanel.setBounds(20, 160, 205, 30);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(font);
		errorPanel.add(errorLabel);
		panel.add(errorPanel);
		border = new MatteBorder(1, 3, 1, 1, Color.WHITE);
		attemptPanel = new JPanel();
		attemptLabel = new JLabel("Attempt #"+attempts+"/10");
		attemptPanel.setBackground(Color.DARK_GRAY);
		attemptPanel.setBounds(300, 10, 105, 35);
		attemptPanel.setBorder(border);
		attemptLabel.setForeground(Color.RED);
		attemptLabel.setFont(font);
		attemptPanel.add(attemptLabel);
		panel.add(attemptPanel);
		back = new JButton("Back");
		logIn = new JButton("Log In");
		panel.setBackground(Color.DARK_GRAY);
		logIn.setBounds(225, 160, 100, 30);
		back.setBounds(350, 160, 100, 30);
		back.addActionListener(this);
		panel.add(back);
		logIn.addActionListener(this);
		panel.add(logIn);
		return panel;
	}
	/**
	 * 
	 * @return true if log in info is correct. false if not.
	 */
	public boolean checkLogIn(){
		userName = userTextF.getText();
		password = new String(passTextF.getPassword());
		if(userName.equalsIgnoreCase("admin")||userName.equalsIgnoreCase("nathan")||userName.equalsIgnoreCase("steve")){
			if(password.equalsIgnoreCase("wsc123")){
			return true;
			}
			return false;
		}else{
			return false;
		}
	}
	/**
	 * Controls what happens when a button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== logIn){
			checkLogIn();
			if(checkLogIn()){
			new EditModeSearch();
			mainScreen.setVisible(false);
			}else{
				attempts++;
				attemptLabel.setText("Attempt #"+attempts+"/10");
				errorLabel.setText("Incorrect User or pass");
				userTextF.setText(null);
				passTextF.setText(null);
				if(attempts == 10){
					attemptLabel.setText(" LAST ATTEMPT ");
					attemptPanel.setBounds(300, 10, 145, 35);
					attemptPanel.setBorder(border);
				}
				if(attempts > 10){
					mainScreen.setVisible(false);
				}
			}
			
		} else if(e.getSource() == back){
			new MainMenu();
			mainScreen.setVisible(false);
		}
	}

}

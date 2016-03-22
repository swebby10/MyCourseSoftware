package myCourseSoftware;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
public class MainMenu implements ActionListener{
JFrame mainScreen;
JButton viewOnly, logIn;
JLabel viewOnlyLabel, logInLabel;
ImageIcon image = new ImageIcon("logo.jpg");
/**
 * JFrame of Main Menu
 */
	public MainMenu() {
		mainScreen = new JFrame();
		mainScreen.setLocation(250, 100); 
		mainScreen.setResizable(false);
		mainScreen.setTitle("Westfield DB");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
		JLabel label1 = new JLabel(image);
		label1.setBounds(215, 120, 50, 50);
		mainScreen.add(label1);
	}
	/**
	 * 
	 * @return panel and all of its components.
	 */
	public JPanel makePanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(475, 200));
		panel.setSize(475,175);
		panel.setLayout(null);
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel2.setBounds(25, 10, 200, 100);
		panel3.setBounds(250, 10, 200, 100);
		Font font = new Font("serif",Font.BOLD, 16);
		MatteBorder border = new MatteBorder(1, 5, 1, 1, Color.WHITE);
		MatteBorder border2 = new MatteBorder(1, 5, 1, 1, Color.WHITE);
		viewOnlyLabel = new JLabel("<html><center>Students can view their: <br>Schedual, Grades, and more!<br>[Click below]</center></html>");
	    viewOnlyLabel.setFont(font);
	    viewOnlyLabel.setLocation(25, 25);
	    panel2.add(viewOnlyLabel);
	    /*JLabel owl = new JLabel("");
	    ImageIcon iconLogo = new ImageIcon("/MyCourseSoftware/src/myCourseSoftware/logo.jpg");
	    int width = iconLogo.getIconWidth();
	    int height = iconLogo.getIconHeight();
	    owl.setIcon(iconLogo);
	    owl.setBounds(195, 125, 40, 40);
	    System.out.println(width);
	    System.out.println(height);
	    panel.add(owl);
	    */
	    panel2.setBorder(border);
	    logInLabel = new JLabel("<html><center>Edit Westfield DataBase: <br>You must log in.<br>[Click Below]<br></center></html>");
	    logInLabel.setFont(font);
	    logInLabel.setLocation(250, 25);
	    panel3.add(logInLabel);
	    panel3.setBorder(border2);
	    panel2.setBackground(Color.lightGray);
	    panel3.setBackground(Color.lightGray);
	    panel.add(panel2);
	    panel.add(panel3);
		viewOnly = new JButton("V I E W   O N L Y");
		logIn = new JButton("Log In");
		panel.setBackground(Color.DARK_GRAY);
		viewOnly.setBounds(55, 125, 140, 40);
		viewOnly.addActionListener(this);
		panel.add(viewOnly);
		logIn.setBounds(280, 125, 140, 40);
		logIn.addActionListener(this);
		panel.add(logIn);
		
		return panel;
	}
	
/**
 * MAIN STATEMENT. Program first runs main Menu
 * @param args
 */
	public static void main(String[] args) {
		new MainMenu();
	}
	/**
	 * Controls what happens when a button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==logIn){
			new LogIn();
			mainScreen.setVisible(false);
			
		} else if(e.getSource() == viewOnly){
			new ViewOnlySearch();
			mainScreen.setVisible(false);
		}
	}

}

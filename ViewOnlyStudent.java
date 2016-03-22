package myCourseSoftware;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class ViewOnlyStudent implements ActionListener {
JFrame mainScreen;
JButton view, back;
JLabel studentName, studentID, studentGPA;
JList<Object> semesters;
double totalGPA;
String stuName;
String word;
private Image image;
ImageIcon icon;
/**
 * 
 * @param theNameGiven is the student name searched for.
 * @throws IOException
 */
	public ViewOnlyStudent(String theNameGiven) throws IOException {
		stuName = theNameGiven;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setLocation(250, 100);
		mainScreen.setTitle("Semesters - VIEWER");
		mainScreen.setContentPane(makePanel());
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
		try{
            File image2 = new File("logo.jpg");
            image = ImageIO.read(image2);

        }
        catch (IOException e){
            System.out.println("COULDNT FIND THE IMAGE!");
        }
		Image newimg = image.getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		JLabel label1 = new JLabel(icon);
		label1.setBounds(325, 10, 100, 100);
		mainScreen.add(label1); 
		   
	}
	/**
	 * 
	 * @return the panel of ViewOnlyStudent with all its components.
	 * @throws IOException
	 */
	public JPanel makePanel() throws IOException{
		JPanel panel = new JPanel();
		Adder theAdder = new Adder(stuName);
		MatteBorder matted = new MatteBorder(1, 5, 1, 1, Color.white);
		MatteBorder matted2 = new MatteBorder(1, 5, 1, 1, Color.BLACK);
		panel.setPreferredSize(new Dimension(475, 350));
		panel.setLayout(null);
		JPanel panel2 = new JPanel();
		panel2.setBorder(matted);
		panel2.setBackground(Color.LIGHT_GRAY);
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.LIGHT_GRAY);
		panel3.setBorder(matted);
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.LIGHT_GRAY);
		panel4.setBorder(matted);
		panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2.setBounds(25, 10, 250, 30);
		panel3.setBounds(25, 50, 250, 30);
		panel4.setBounds(25, 90, 250, 30);
		Font font = new Font("serif",Font.BOLD, 16);
		studentName = new JLabel("Name: "+theAdder.getPersonName());
	    studentName.setFont(font);
	    panel2.add(studentName);
	    studentID = new JLabel("ID: A"+theAdder.getFirstID());
	    studentID.setFont(font);
	    panel3.add(studentID);
	    studentGPA = new JLabel("Total GPA: "+theAdder.getTotalgpa());
	    studentGPA.setFont(font);
	    panel4.add(studentGPA);
	    panel.add(panel2);
	    panel.add(panel3);
	    panel.add(panel4);
		view = new JButton("View Semester");
		back = new JButton("Back");
		panel.setBackground(Color.DARK_GRAY);
		view.setBounds(90, 300, 150, 25);
		view.addActionListener(this);
		panel.add(view);
		back.setBounds(285, 300, 100, 25);
		back.addActionListener(this);
		panel.add(back);
		String[] list = theAdder.getTempSem().toArray(new String[theAdder.getTempSem().size()]);
		semesters = new JList<Object>(list);
		semesters.setCellRenderer( new WhiteGrayCellRenderer() );
		semesters.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		semesters.setLayoutOrientation(JList.VERTICAL);
		semesters.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		    	 word = semesters.getSelectedValue().toString();
	            }
		      });
		JScrollPane listScroller = new JScrollPane(semesters);
		listScroller.setPreferredSize(new Dimension(250, 80));
		listScroller.setBounds(50, 135, 375, 155);
		listScroller.setBorder(matted2);
		panel.add(listScroller);
		return panel;
	}
	/**
	 * Controls what happens when a button on the panel is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== view){
			System.out.println("SEMESTER CHOSEN: "+word);
			try {
				new ViewOnlySemester(word,stuName);
			} catch (IOException e1) {
				System.out.println("Error");
			}
			mainScreen.setVisible(false);
		} else if(e.getSource() == back){
			new ViewOnlySearch();
			mainScreen.setVisible(false);
		}
	}
	/**
	 * 
	 * @return the word which is the name of the semester chosen.
	 */
	public String getWord(){
		String theWord = word;
		return theWord;
	}
	/**
	 * Code found online, changes every other cell to gray for easy reading.
	 * @author Other
	 *
	 */
	 private static class WhiteGrayCellRenderer extends DefaultListCellRenderer {  
		private static final long serialVersionUID = 6318915862555932240L;

			public Component getListCellRendererComponent( JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {  
	            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );  
	            if ( index % 2 == 0 ) {  
	                c.setBackground( Color.LIGHT_GRAY );  
	            }  
	            else {  
	                c.setBackground( Color.white );  
	            }  
	            return c;  
	        }  
	    }  

}

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
public class EditModeSemester implements ActionListener {
JFrame mainScreen;
JButton view, back, add;
JLabel studentName, semesterName, studentGPA;
JList<Object> courses;
String courseName;
String semester;
String word, stuName;
private Image image;
ImageIcon icon;
/**
 * 
 * @param theWord is the name of the semester.
 * @param theName is the name of the student.4
 * @throws IOException
 */
	public EditModeSemester(String theWord, String theName) throws IOException {
		stuName = theName;
		word = theWord;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setLocation(250, 100);
		mainScreen.setTitle(""+word+" - Edit Mode");
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
		label1.setBounds(325, 15, 100, 100);
		mainScreen.add(label1);
	}
	/**
	 * 
	 * @return the panel and all of its components.
	 * @throws IOException
	 */
	public JPanel makePanel() throws IOException{
		JPanel panel = new JPanel();
		MatteBorder matted = new MatteBorder(1, 5, 1, 1, Color.white);
		MatteBorder matted2 = new MatteBorder(1, 5, 1, 1, Color.BLACK);
		Adder.setMatchWord(word);
		Adder theAdder = new Adder(stuName);
		panel.setPreferredSize(new Dimension(475, 350));
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
		panel2.setBounds(25, 10, 250, 30);
		panel3.setBounds(25, 50, 250, 30);
		panel4.setBounds(25, 90, 250, 30);
		Font font = new Font("serif",Font.BOLD, 16);
		studentName = new JLabel("Name: "+theAdder.getPersonName());
	    studentName.setFont(font);
	    panel2.add(studentName);
	    semesterName = new JLabel("Semester:  "+word);
	    semesterName.setFont(font);
	    panel3.add(semesterName);
	    studentGPA = new JLabel("Total GPA: "+theAdder.getTotalgpa());
	    studentGPA.setFont(font);
	    panel4.add(studentGPA);
	    panel.add(panel2);
	    panel.add(panel3);
	    panel.add(panel4);
	    view = new JButton("Edit Course");
		back = new JButton("Back");
		add = new JButton("Add Course");
		add.setBounds(190, 300, 125, 25);
		add.addActionListener(this);
		panel.add(add);
		panel.setBackground(Color.DARK_GRAY);
		view.setBounds(50, 300, 130, 25);
		view.addActionListener(this);
		panel.add(view);
		back.setBounds(325, 300, 100, 25);
		back.addActionListener(this);
		panel.add(back);
		String[] list = theAdder.getTempCourse().toArray(new String[theAdder.getTempCourse().size()]);
		courses = new JList<Object>(list);
		courses.setCellRenderer(new WhiteGrayCellRenderer());
		courses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		courses.setLayoutOrientation(JList.VERTICAL);
		courses.setBorder(matted2);
		courses.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		    	 courseName = (String)courses.getSelectedValue();
	            }
		      });
		JScrollPane listScroller = new JScrollPane(courses);
		listScroller.setPreferredSize(new Dimension(250, 80));
		listScroller.setBounds(50, 135, 375, 155);
		panel.add(listScroller);
		return panel;
	}
	/**
	 * Controls what happens when a button is presed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== view){
			try {
				if(courseName == null){
					System.out.println("Didnt click on anything!");
				}else{
				courseName.trim();
				String temp[];
				temp = courseName.split("-");
				courseName = temp[0];
				new EditModeCourse(word, stuName, courseName);
				mainScreen.setVisible(false);
				}
			} catch (IOException e1) {
			}
		} else if(e.getSource() == back){
			try {
				new EditModeStudent(stuName);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("An errror has occured.");
			}
		} else if(e.getSource() == add){
			
			new NewCourseWriter(stuName, word,null, null,null);
			mainScreen.setVisible(false);
		}
	}
	private static class WhiteGrayCellRenderer extends DefaultListCellRenderer {  
        /**
		 * 
		 */
		private static final long serialVersionUID = 1440985507387311532L;

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

package myCourseSoftware;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultListCellRenderer;
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
import myCourseSoftware.objects.Professor;
import myCourseSoftware.objects.TextBook;
public class EditModeCourse implements ActionListener {
JFrame mainScreen;
JButton view, back, add, editBook, editTeach;
JLabel studentName, semesterName, studentGPA, courseGrade;
JList<Object> assignments;
String courseName;
String semester;
String assignmentName;
String word, stuName;
Adder theAdder;
TextBook book;
Professor prof;
/**
 * 
 * @param theSemester is the name of the semester.
 * @param theName is the name of the student.
 * @param theCourse is the name of the course.
 * @throws IOException
 */
	public EditModeCourse(String theSemester, String theName, String theCourse) throws IOException {
		stuName = theName;
		word = theSemester;
		courseName = theCourse;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle("Course: "+courseName.toLowerCase()+" - Edit Mode");
		mainScreen.setContentPane(makePanel());
		mainScreen.setLocation(250, 100);
		mainScreen.pack();
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
		MatteBorder matted2 = new MatteBorder(1, 5, 1, 1, Color.BLACK);
		Adder.setMatchWord(word.trim());
		Adder.setMatchWord2(courseName.trim());
		theAdder = new Adder(stuName);
		panel.setPreferredSize(new Dimension(475, 550));
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
		panel2.setBounds(25, 10, 425, 30);
		panel3.setBounds(25, 50, 425, 30);
		panel4.setBounds(25, 90, 425, 30);
		panel5.setBounds(25, 130, 425, 30);
		Font font = new Font("serif",Font.BOLD, 16);
		studentName = new JLabel("Name: "+theAdder.getPersonName());
	    studentName.setFont(font);
	    panel2.add(studentName);
	    semesterName = new JLabel("Semester:  "+word);
	    semesterName.setFont(font);
	    panel3.add(semesterName);
	    studentGPA = new JLabel("Course: "+courseName);
	    studentGPA.setFont(font);
	    panel4.add(studentGPA);
	    courseGrade = new JLabel("CourseGrade: "+theAdder.getCoursegrade());
	    courseGrade.setFont(font);
	    panel5.add(courseGrade);
	    panel.add(panel2);
	    panel.add(panel3);
	    panel.add(panel4);
	    panel.add(panel5);
	    JPanel panel6 = new JPanel();
	    panel6.setBackground(Color.LIGHT_GRAY);
	    panel6.setBorder(matted);
	    JPanel panel7 = new JPanel();
	    editTeach = new JButton("Edit");
	    editBook = new JButton("Edit");
	    editTeach.addActionListener(this);
	    editBook.addActionListener(this);
	    panel7.setBackground(Color.LIGHT_GRAY);
	    panel7.setBorder(matted);
	    panel6.setBounds(25, 170, 425, 80);
	    panel7.setBounds(25, 260, 425, 80);
	    panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
	    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
	    JLabel profLabel = new JLabel("Professor: "+theAdder.tempProf.getName());
	    JLabel profInfo1 = new JLabel("Phone: "+theAdder.tempProf.getPhone()+"  ||  Email: "+theAdder.tempProf.getEmail());
	    JLabel profInfo2 = new JLabel("Office: "+theAdder.tempProf.getOffice()+"  ||  Hours: "+theAdder.tempProf.getOfficeHours());
	    panel6.add(profLabel);
	    panel6.add(profInfo1);
	    panel6.add(profInfo2);
	    panel6.add(editTeach);
	    panel.add(panel6);
	    JLabel textLabel = new JLabel("TextBook Name: "+theAdder.tempText.getTitle());
	    JLabel textInfo1 = new JLabel("Publisher: "+theAdder.tempText.getPublisher()+"  ||  Cost: "+theAdder.tempText.getPrice());
	    panel7.add(textLabel);
	    panel7.add(textInfo1);
	    panel7.add(editBook);
	    panel.add(panel7);
	    JLabel assignment = new JLabel("Assignments: ");
	    assignment.setForeground(Color.WHITE);
	    JPanel panel8 = new JPanel();
	    panel8.setBounds(45, 310, 385, 20);
	    panel8.add(assignment);
	    panel8.setBackground(Color.DARK_GRAY);
	    panel.add(panel8);
	    view = new JButton("Edit Assignment");
		back = new JButton("Back");
		add = new JButton ("Add Assignment");
		add.setBounds(190, 520, 130, 25);
		add.addActionListener(this);
		panel.add(add);
		panel.setBackground(Color.DARK_GRAY);
		view.setBounds(50, 520, 130, 25);
		view.addActionListener(this);
		panel.add(view);
		back.setBounds(330, 520, 100, 25);
		back.addActionListener(this);
		panel.add(back);
		String[] list = theAdder.getTempAssignments().toArray(new String[theAdder.getTempAssignments().size()]);
		assignments = new JList<Object>(list);
		assignments.setBorder(matted2);
		assignments.setCellRenderer(new WhiteGrayCellRenderer() );
		assignments.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		assignments.setLayoutOrientation(JList.VERTICAL);
		assignments.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		    	 assignmentName = (String)assignments.getSelectedValue();
	            }
		      });
		JScrollPane listScroller = new JScrollPane(assignments);
		listScroller.setPreferredSize(new Dimension(250, 80));
		listScroller.setBounds(50, 355, 375, 155);
		panel.add(listScroller);
		return panel;
	}
	/**
	 * Controls what happens when a button is pressed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== view){
			if(assignmentName == null){
				System.out.println("Didnt click on anything!");
			}else{
			try {
				assignmentName.trim();
				String temp[];
				temp = assignmentName.split("-");
				assignmentName = temp[0];
				new EditModeAssignment(word, stuName, courseName, assignmentName);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("An errror has occured.");
			}
			}
		} else if(e.getSource() == back){
			try {
				new EditModeSemester(word,stuName);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("An errror has occured.");
			}
		}else if(e.getSource() == add){
			try {
				new NewAssigmentWriter(stuName, word, courseName, null, false);
				mainScreen.setVisible(false);
			} catch (IOException e1) {
				System.out.println("Error New Assignment Writer could not open.");
				e1.printStackTrace();
			}
		}else if(e.getSource() == editTeach){
			book = new TextBook(theAdder.tempText.getTitle(), theAdder.tempText.getPublisher(), theAdder.tempText.getPrice());
			prof = new Professor(theAdder.tempProf.getName(), theAdder.tempProf.getEmail(), theAdder.tempProf.getPhone(), theAdder.tempProf.getOffice(), theAdder.tempProf.getOfficeHours());
			new TeacherAdder(stuName, word, prof, book, true, courseName);	
			mainScreen.setVisible(false);
		}else if(e.getSource() == editBook){
			book = new TextBook(theAdder.tempText.getTitle(), theAdder.tempText.getPublisher(), theAdder.tempText.getPrice());
			prof = new Professor(theAdder.tempProf.getName(), theAdder.tempProf.getEmail(), theAdder.tempProf.getPhone(), theAdder.tempProf.getOffice(), theAdder.tempProf.getOfficeHours());
			new TextBookAdder(stuName, word, prof, book, true, courseName);	
			mainScreen.setVisible(false);	
		}
	}
	private static class WhiteGrayCellRenderer extends DefaultListCellRenderer {  
		private static final long serialVersionUID = 1L;

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

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
public class TextBookAdder implements ActionListener {
JFrame mainScreen;
JButton create, cancel;
String bookName, publisher, semName;
String stuName, semestName, courseName;
TextBook book1= null;
Professor prof1= null;
TextBook textOld;
int cost;
JLabel first, publishertxt, costtxt, errormsg;
JTextField textBookName, publisherName, bookCost;
Boolean editOnly;
/**
 * Sets the local variables to the passed variables.
 * @param student is the name of the student.
 * @param semester is the name of the semester.
 * @param prof is of type Professor and is the professor being added or edited.
 * @param book is of type Book and is the book being added or edited.
 * @param edit is to check if the textbook is being added or edited.
 */
	public TextBookAdder(String student, String semester, Professor prof, TextBook book, Boolean edit, String cName) {
		editOnly = edit;
		book1 =  book;
		prof1 = prof;
		textOld = book;
		semestName = semester;
		if(cName != null){
		courseName = cName;
		}
		stuName = student;
		mainScreen = new JFrame();
		mainScreen.setResizable(false);
		mainScreen.setTitle("Add TextBook:");
		mainScreen.setContentPane(makePanel());
		mainScreen.setLocation(250, 100);
		mainScreen.pack();
		mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainScreen.setVisible(true);
		
	}
	/**
	 * 
	 * @return the panel of TextBookAdder and all its components.
	 */
	public JPanel makePanel(){
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(400, 255));
		panel.setBackground(Color.DARK_GRAY);
		first = new JLabel("Enter TextBook Name:");
		first.setForeground(Color.WHITE);
		errormsg = new JLabel("All Fields Required.");
		errormsg.setForeground(Color.RED);
		first.setBounds(25, 10, 350, 30);
		textBookName = new JTextField(25);
		textBookName.setBounds(25, 45, 350, 30);
		publishertxt = new JLabel("Enter Publisher Name");
		publishertxt.setForeground(Color.WHITE);
		publishertxt.setBounds(25, 80, 350, 30);
		panel.add(publishertxt);
		publisherName = new JTextField(25);
		publisherName.setBounds(25, 110, 350, 30);
		
		costtxt = new JLabel("The book will cost:($)");
		costtxt.setForeground(Color.WHITE);
		costtxt.setBounds(25, 140, 350, 30);
		panel.add(costtxt);
		bookCost = new JTextField(25);
		bookCost.setBounds(25, 170, 350, 30);
		
		if(editOnly == true){
			textBookName.setText(book1.getTitle());
			publisherName.setText(book1.getPublisher());
			bookCost.setText(""+book1.getPrice());
			panel.add(textBookName);
			panel.add(publisherName);
			panel.add(bookCost);
		}else{
			panel.add(textBookName);
			panel.add(publisherName);
			panel.add(bookCost);
		}
		errormsg.setBounds(25, 400, 50, 425);
		panel.add(first);
		panel.add(errormsg);
		create = new JButton("Add TextBook");
		cancel = new JButton("Cancel");
		create.setBounds(120, 210, 150, 25);
		create.addActionListener(this);
		cancel.setBounds(275, 210, 100, 25);
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
			if(editOnly == false){
			if(textBookName != null && publisherName != null && bookCost != null){
			String name = textBookName.getText().trim().toUpperCase();
			String publis = publisherName.getText().trim().toUpperCase();
			//Double moola = Double.parseDouble(bookCost.toString().trim());
			book1 = new TextBook(name, publis, 150.75);
			new NewCourseWriter(stuName, semestName, prof1, book1, courseName);
			mainScreen.setVisible(false);
			}else{
				errormsg.setText("YOU MUST FILL OUT EVERYTHING");
			}
		}else{
			if(textBookName != null && publisherName != null && bookCost != null){
				String name = textBookName.getText().trim().toUpperCase();
				String publis = publisherName.getText().trim().toUpperCase();
				//Double moola = Double.parseDouble(bookCost.toString().trim());
				book1 = new TextBook(name, publis, 150.75);
				try {
					Adder add1 = new Adder(stuName);
					add1.changeLines(("TEXTBOOK:"+textOld.getTitle().toUpperCase()+":"+textOld.getPublisher().toUpperCase()+":"+textOld.getPrice()),("TEXTBOOK:"+name.toUpperCase()+":"+publis.toUpperCase()+":"+150.75));
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
			new NewCourseWriter(stuName, semestName, prof1, null, courseName);
			mainScreen.setVisible(false);
		}
	}
	

	

}

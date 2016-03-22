package myCourseSoftware.objects;

import java.util.ArrayList;

public class Semester {
private String semesterName;
private double GPA;
ArrayList<Course> allCourses = new ArrayList<Course>();
/**
 * 
 * @param theCourses is an arraylist of all the courses involved with the semester.
 * @param theSemesterName is the name of the semester
 * @param theGPA is the gpa earned by the student in the semester.
 */
	public Semester(ArrayList<Course> theCourses, String theSemesterName, double theGPA) {
		allCourses = theCourses;
		GPA = theGPA;
		semesterName = theSemesterName;
	}
	/**
	 * 
	 * @return the GPA on a four point scale.
	 */
	public double getGPA() {
		double gpaCalc = 0.0;
		for(int i = 0; i < allCourses.size(); i++){
			if(allCourses.get(i).getCourseGrade()>96){//A
				gpaCalc += 4.0;
			} else if (allCourses.get(i).getCourseGrade() <= 96 && allCourses.get(i).getCourseGrade()> 89){//A-
				gpaCalc += 3.7;
			}else if (allCourses.get(i).getCourseGrade() <= 89 && allCourses.get(i).getCourseGrade()> 86){//B+
				gpaCalc += 3.3;
			}else if (allCourses.get(i).getCourseGrade() <= 86 && allCourses.get(i).getCourseGrade()> 83){//B
				gpaCalc += 3.0;
			}else if (allCourses.get(i).getCourseGrade() <= 83 && allCourses.get(i).getCourseGrade()> 79){//B-
				gpaCalc += 2.7;
			}else if (allCourses.get(i).getCourseGrade() <= 79 && allCourses.get(i).getCourseGrade()> 76){//C+
				gpaCalc += 2.3;
			}else if (allCourses.get(i).getCourseGrade() <= 76 && allCourses.get(i).getCourseGrade()> 73){//C
				gpaCalc += 2.0;
			}else if (allCourses.get(i).getCourseGrade() <= 73 && allCourses.get(i).getCourseGrade()> 69){//C-
				gpaCalc += 1.7;
			}else if (allCourses.get(i).getCourseGrade() <= 69 && allCourses.get(i).getCourseGrade()> 64){//D
				gpaCalc += 1.3;
			}else if (allCourses.get(i).getCourseGrade()<=64 && allCourses.get(i).getCourseGrade()> 59){//D-
				gpaCalc += 1.0;
			}else if (allCourses.get(i).getCourseGrade()<=59){//F
				gpaCalc += 0.0;
			}
		}
		gpaCalc = gpaCalc / allCourses.size();
		return gpaCalc;
	}
	/**
	 * 
	 * @return the name of the semester.
	 */
	public String getName(){
		String name = semesterName;
		return name;
	}
	/**
	 * @return the semester name followed by, - , then followed by the GPA.
	 */
	public String toString(){
		return semesterName+" - GPA: "+GPA;
	}
}

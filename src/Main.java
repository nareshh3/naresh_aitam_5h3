import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Main {
	private static final String DATE_FORMAT = "yyyy/MM/dd";
	public static void main(String[] args) throws ParseException {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		StudentArrayOperation studentGroup = new StudentGroup(10);
		
		DateFormat format = new SimpleDateFormat(DATE_FORMAT);
		
		studentGroup.setStudents(new Student[]{
			new Student(1, "Rajeev kumar", format.parse("1997/08/13"), 80.0),
			new Student(2, "pokal jayaram", format.parse("1997/08/20"), 90.0),
			new Student(3, "vamsi krishna", format.parse("1996/06/13"), 100.0),
			new Student(4, "kiran krishna", format.parse("1995/03/06"), 90.0),
			new Student(5, "narayana rao", format.parse("1996/05/12"), 100.0)
		});
		
		// java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println);
		
		/* System.out.println(studentGroup.getStudent(0));
		
		studentGroup.setStudent(new Student(6, "sfdsfsd sdf", format.parse("1996-08-13"), 98.0), 0);
		
		System.out.println(studentGroup.getStudent(0)); */
		
		// studentGroup.add(new Student(7, "hghj ghjgj", format.parse("1997-10-26"), 78.0), 4);
		
		/* java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println);
		studentGroup.remove(3);
		System.out.println("------------------------");
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println);
		
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println);
		studentGroup.remove(studentGroup.getStudent(2));
		System.out.println("------------------------");
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println); */
		
		/* studentGroup.addFirst(new Student(6, "sfdsfsd sdf", format.parse("1996-08-13"), 98.0));
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println); */
		
		/* studentGroup.addLast(new Student(6, "sfdsfsd sdf", format.parse("1996-08-13"), 98.0));
		studentGroup.addLast(new Student(7, "sfdsfsd sdf", format.parse("1996-08-13"), 98.0));
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println); */
		
		/* studentGroup.removeFromIndex(1);
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println);
		System.out.println(studentGroup.getStudents().length); */
		
		/* studentGroup.removeFromElement(studentGroup.getStudent(4));
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println); */
		
		/* studentGroup.removeToIndex(0);
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println); */
		
		/* studentGroup.removeToElement(studentGroup.getStudent(2));
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println); */
		
		/* java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println);
		studentGroup.bubbleSort();
		java.util.Arrays.stream(studentGroup.getStudents()).forEach(System.out :: println); */
		
		// java.util.Arrays.stream(studentGroup.getByBirthDate(format.parse("1997-08-13"))).forEach(System.out :: println);
		
		// java.util.Arrays.stream(studentGroup.getBetweenBirthDates(format.parse("1997-08-12"), format.parse("1997-08-12"))).forEach(System.out :: println);
		
		/* java.util.Arrays.stream(studentGroup.getNearBirthDate(format.parse("1997/08/13"), 30))
		.forEach(System.out :: println); */
		
		// System.out.println(studentGroup.getCurrentAgeByDate(3));
		
		// java.util.Arrays.stream(studentGroup.getStudentsByAge(21)).forEach(System.out :: println);
		
		// java.util.Arrays.stream(studentGroup.getStudentsWithMaxAvgMark()).forEach(System.out :: println);
		
		System.out.println(studentGroup.getNextStudent(studentGroup.getStudent(0)));
	}

}

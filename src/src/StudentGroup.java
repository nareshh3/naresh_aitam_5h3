import java.util.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	private int size;
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		StudentGroup.requireNonNull(students);
		size = 0;
		for (Student s : students)
			size++;
		this.students = students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		StudentGroup.rangeCheck(students, index);
		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		StudentGroup.requireNonNull(student);
		StudentGroup.rangeCheck(students, index);
		
		students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		StudentGroup.requireNonNull(student);
		
		/* for (int i = 0, size = students.length; i < size; i++)
			students[i + 1] = students[i];
		students[0] = student; */
		Student[] newArray = new Student[size + 1];		
		System.arraycopy(students, 0, newArray, 1, size);
	
		newArray[0] = student;
		
		students = newArray;size++;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		StudentGroup.requireNonNull(student);
		
		/* for (int i = 0, size = students.length; i < size; i++)
			if (students[i] != null)
				students[i] = student; */
		Student[] newArray = new Student[size + 1];		
		System.arraycopy(students, 0, newArray, 0, size);
	
		newArray[size] = student;size++;

		students = newArray;	
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		StudentGroup.requireNonNull(student);
		StudentGroup.rangeCheck(students, index);
		
		Student[] newArray = null;
		
		if (students.length == size)
			newArray = new Student[size + 1];
		
		/* for (int i = 0; i < index; i++)
			newArray[i] = students[i];	 */
		System.arraycopy(students, 0, newArray, 0, index);
		newArray[index] = student;
		
		for (int i = index + 1, length = size + 1; i < length; i++)
			newArray[i] = students[i - 1];
		// System.arraycopy(students, index, newArray, index + 1, size - 1);
		
		students = newArray;size++;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		StudentGroup.rangeCheck(students, index);
		
		Student[] newArray = new Student[size - 1];
		
		if (index == 0)
			System.arraycopy(students, 1, newArray, 0, students.length-1);
		else if (index == students.length-1)
			System.arraycopy(students, 0, newArray, 0, students.length-1);
		else {
			System.arraycopy(students, 0, newArray, 0, index);
			System.arraycopy(students, index + 1, newArray, index, students.length-1 - index);
		}	
		/* for (int i = index, size = students.length; i < size; i++)
			students[i] = students[i + 1]; */
		students = newArray;size--;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		StudentGroup.requireNonNull(student);
		
		for (int i = 0, size = students.length; i < size; i++) {
			if (students[i].equals(student)) {
				remove(i);
				return;
			}
		}	
		
		throw new IllegalArgumentException("Student not exist");	
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		StudentGroup.rangeCheck(students, index);
		
		Student[] newArray = new Student[index + 1];
		System.arraycopy(students, 0, newArray, 0, index + 1);
		
		students = newArray;size = index + 1;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		StudentGroup.requireNonNull(student);
		
		for (int i = 0, size = students.length; i < size; i++) {
			if (students[i].equals(student)) {
				removeFromIndex(i);
				return;
			}
		}
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		StudentGroup.rangeCheck(students, index);
		
		int length = index + 1;// students.length - index - 1;
		Student[] newArray = new Student[length];
		System.arraycopy(students, 0, newArray, 0, length);
		
		students = newArray;size = length;
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		StudentGroup.requireNonNull(student);
		
		for (int i = 0, size = students.length; i < size; i++) {
			if (students[i].equals(student)) {
				removeToIndex(i);
				return;
			}
		}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		StudentGroup.requireNonNull(students);
		
		Student temp = null;
		
		for (int i = 0, size = students.length; i < size; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (students[j].getId() > students[j + 1].getId()) {
					temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}	
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		StudentGroup.requireNonNull(date);
		
		Date lessDate = new Date(date.getTime()- 86400000);
		
		List<Student> list = new ArrayList<>();
		
		for (int i = 0, size = students.length; i < size; i++) {
			if (students[i].getBirthDate().equals(date) || students[i].getBirthDate().equals(lessDate)) {
				list.add(students[i]);
			}
		}
		
		return StudentGroup.listToArray(list);
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		StudentGroup.requireNonNull(firstDate);
		StudentGroup.requireNonNull(lastDate);
		
		List<Student> list = new ArrayList<>();
		
		for (int i = 0, size = students.length; i < size; i++) {
			if (students[i].getBirthDate().equals(firstDate) 
				|| students[i].getBirthDate().equals(lastDate)) {
					list.add(students[i]);
			} else if (students[i].getBirthDate().after(firstDate) 
				&& students[i].getBirthDate().before(lastDate)) {
					list.add(students[i]);
			}
		}
		
		return StudentGroup.listToArray(list);
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		StudentGroup.requireNonNull(date);
		
		LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		localDateTime = localDateTime.plusDays(days);
		Date daysAfterDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());		
		
		List<Student> list = new ArrayList<>();
		
		for (int i = 0, size = students.length; i < size; i++) {
			if (students[i].getBirthDate().equals(date)) {
				list.add(students[i]);
			} else if (students[i].getBirthDate().after(date) && students[i].getBirthDate().before(daysAfterDate)) {
				list.add(students[i]);
			}
		}
		
		return StudentGroup.listToArray(list);
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if (indexOfStudent == 0)
			throw new IllegalArgumentException("index should not be zero");
		
		LocalDate currentDate = LocalDate.now();
		Date date = students[indexOfStudent].getBirthDate();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
		
		return currentDate.getYear() - localDate.getYear();
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		LocalDate currentDate = LocalDate.now();
		
		List<Student> list = new ArrayList<>();
		
		for (int i = 0, size = students.length; i < size; i++) {
			
			Date date = students[i].getBirthDate();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			if (age == (currentDate.getYear() - localDate.getYear()))
				list.add(students[i]);
		}
			
		return StudentGroup.listToArray(list);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		Arrays.sort(students, (s1, s2) -> {
			return Double.valueOf(s1.getAvgMark()).compareTo(Double.valueOf(s2.getAvgMark()));
		});
		
		List<Student> list = new ArrayList<>();
		
		double maxAvg = students[students.length-1].getAvgMark();

		for (int i = students.length - 1; i > -1; i--)
			if (maxAvg == students[i].getAvgMark())
				list.add(students[i]);
			else
				break;
		
		return StudentGroup.listToArray(list);
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		StudentGroup.requireNonNull(student);
		
		for (int i = 0, size = students.length-1; i < size; i++)
			if (students[i].equals(student))
				return students[i + 1];
		return student;
	}
	
	// Objects require non-null
	private static void requireNonNull(Object object) {
		if (object == null)
			throw new IllegalArgumentException("null objects are not allowed");
	}
	
	// check for out of range
	private static void rangeCheck(Student[] students, int index) {
		if (index < 0 || index >= students.length)
			throw new IllegalArgumentException("index out of range: " + index);
	}
	
	// convert list to student[]
	private static Student[] listToArray(List<Student> list) {
		int size = list.size();
		
		Student[] students = new Student[size];
		for (int i = 0; i < size; i++)
			students[i] = list.get(i);
		
		return students;
	}
}

package studentProcess;

import student.Student;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentProcess {
	private static final Comparator<Student> NAMES_DESC = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			int lastCmp = s1.getLastName().compareTo(s2.getLastName());
			
			return lastCmp != 0 ? -1 : 1;
		}
	};
	private static final Comparator<Student> GRADES_DESC = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			return s1.getGrade() > s2.getGrade() ? -1 : 1;
		}
	};

	public static void main(String[] args) {
		Student[] students = {
				new Student("Joel", "Kwan", 99, "AAA"),
				new Student("Homer", "Simpson", 55, "SSS"),
				new Student("Marge", "Simpson", 75, "SSS"), 
				new Student("Lisa", "Simpson", 95, "SSS"),
				new Student("Bart", "Simpson", 60, "SSS"), 
				new Student("Maggie", "Simpson", 80, "SSS"),
				new Student("Jay", "Kay", 85, "BBB"), 
				new Student("Elle", "Emm", 45, "BBB"),
				new Student("Patrick", "Star", 40, "BBB"), 
				new Student("Spongebob", "Squarepants", 65, "BBB")
		};
		
		
		// -------------------------- Task 1 ----------------------------
		List<Student> studentList = Arrays.asList(students);

		System.out.println("Task 1: \n");
		System.out.println("Complete Student List");

		studentList.forEach(System.out::println);
		System.out.print("\n");

		// -------------------------- Task 2 ----------------------------
		System.out.println("Task 2: \n");
		System.out.println("Students who got 50.0 - 100.0, sorted by grade:");
		studentList.stream().filter(student -> student.getGrade() > 50.0)
		.sorted(GRADES_DESC)
		.forEach(System.out::println);

		System.out.print("\n");

		// -------------------------- Task 3 ----------------------------
		System.out.println("Task 3: \n ");
		System.out.println("First student who got 50.0-100.0: ");

		System.out.println(studentList.stream()
				.filter(s -> s.getGrade() > 50)
				.findFirst());
		System.out.print("\n");

		// -------------------------- Task 4 ----------------------------
		System.out.println("Task 4: \n");
		System.out.println("Students sorted by names ascending: ");
		studentList.stream()
		.sorted()
		.forEach(System.out::println);
		System.out.print("\n");
		
		System.out.println("Students sorted by names descending: ");
		studentList.stream()
		.sorted(NAMES_DESC)
		.forEach(System.out::println);
		System.out.print("\n");

		// -------------------------- Task 5 ----------------------------
		System.out.println("Task 5: \n");
		System.out.println("Unique student last names: ");
		studentList.stream()
		.map(s -> s.getLastName())
		.distinct()
		.forEach(System.out::println);
		System.out.println();
		
		// -------------------------- Task 6 ----------------------------
		System.out.println("Task 6: \n");
		System.out.println("Student names in order by last name then first name:");
		
		studentList.stream()
		.sorted()
		.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));		
		System.out.println();

		// -------------------------- Task 7 ----------------------------
		System.out.println("Task 7: \n");
		System.out.println("Students by department: ");
		
		Map<String, List<Student>> studentMap = 
				studentList.stream()
				.collect(Collectors.groupingBy(Student::getDepartment));
		
		studentMap.forEach((k,v) -> {
			System.out.println(k);
			v.stream()
			.sorted()
			.forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName() 
			+ " " + s.getGrade() + " " + s.getDepartment()  ));
		});
		
		System.out.println();

		// -------------------------- Task 8 ----------------------------
		System.out.println("Task 8: \n");
		System.out.println("Count of Students by department: ");
		
		studentMap.forEach((k,v)-> {
			System.out.println(k + " has " + v.stream().count() + " Student(s)");
		});
		
		System.out.println();
	
		// -------------------------- Task 9 ----------------------------
		System.out.println("Task 9: \n");
		
		double totalGrades = studentList.stream()
		.mapToDouble(s -> s.getGrade())
		.sum();
		System.out.println("Sum of Students' grades: " + totalGrades);
		System.out.println();
		
		
		// -------------------------- Task 10 ----------------------------
		System.out.println("Task 10: \n");
		
		double avgGrades = studentList.stream()
				.mapToDouble(s -> s.getGrade())
				.average()
				.getAsDouble();
		
		System.out.println("Average of Students' grades: " + avgGrades);
		
	}
	
}

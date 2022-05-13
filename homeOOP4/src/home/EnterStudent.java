package home;

import java.awt.Window.Type;
import java.util.Scanner;

public class EnterStudent{
	Student[] student = new Student[10];
	Scanner sc = new Scanner(System.in);
	
	public Student EnterStudent() {
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¬ведите им€ . . .");
		String setName = sc.nextLine();
		student.setName(setName);
		
		System.out.println("¬видите фамилию . . .");
		String setLastName = sc.nextLine();
		student.setLastName(setLastName);
		
		System.out.println("¬видите номер группы . . .");
		String setGroupName = sc.nextLine();
		student.setGroupName(setGroupName);
		
		System.out.println("¬ведите пол . . .1-man, 2-woman");
		int gend = sc.nextInt();
		Gender gen = Gender.getTypeByOrdinal(gend);
		student.setGender(gen);
		
		
		System.out.println("¬видите id . . .");
		int id = sc.nextInt();
		student.setId(id);
		return student;
		}
	}
	
	

package home;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		EnterStudent enter = new EnterStudent();


		Student student[] = new Student[11];
	
	student[0] = new Student("NAME1", "GLASTNAME1", Gender.Man, 1, "OOP1");
	student[1] = new Student("NAME1", "GLASTNAME1", Gender.Man, 1, "OOP1");
	student[2] = new Student("NAME3", "VLASTNAME3", Gender.Man, 3, "OOP3");
	student[3] = new Student("NAME3", "BLASTNAME3", Gender.Man, 3, "OOP4");
	student[4] = new Student("NAME5", "LASTNAME4", Gender.Woman, 5, "OOP5");
	student[5] = new Student("NAME6", "NLASTNAME5", Gender.Woman, 6, "OOP6");
	student[6] = new Student("NAME7", "LASTNAME6", Gender.Man, 7, "OOP7");
	student[7] = new Student("NAME8", "VLASTNAME7", Gender.Woman, 8, "OOP8");
	student[8] = new Student("NAME9", "VLASTNAME8", Gender.Man, 9, "OOP9");
	student[9] = new Student("NAME10", "LASTNAME9", Gender.Man,10, "OOP110");
	student[10] = new Student("RWERWE10", "werwer", Gender.Man, 0, "werrew");
	
	Student student1;
	
	Group group = new Group();
	try {
	group.addStudent(student[0]);
	group.addStudent(student[1]);
	group.addStudent(student[2]);
	group.addStudent(student[3]);
	group.addStudent(student[4]);
	group.addStudent(student[5]);
	group.addStudent(student[6]);
	group.addStudent(student[7]);
	group.addStudent(student[8]);
	group.addStudent(student[9]);
	group.addStudent(student[10]);
	
	}catch(GroupOverflowException g) {
		System.out.println(g.getMessage());
	}
	try {
		group.addStudent(enter.EnterStudent());	
		}catch(GroupOverflowException g) {
			System.out.println(g.getMessage());
		}
	
	try {
		student1 = group.searchStudentByLastName("LASTNAME1");
		System.out.println(student1.getLastName()); 
		System.out.println(); 
	}catch(StudentNotFoundException s) {
		System.out.println(s.getMessage());
	}
	
	
	boolean b = group.removeStudentByID(0);
	
	System.out.println(b);
	System.out.println();
	
	b = group.removeStudentByID(0);
	System.out.println(b);
	
	group.sortStudentsByLastName();
	
	//////////////////
	Group group1 = new Group("OOP", student);
	GropeFileStorege gfs = new GropeFileStorege();
	try {
	group1.addStudent(student[0]);
	group1.addStudent(student[1]);
	group1.addStudent(student[2]);
	group1.addStudent(student[3]);
	group1.addStudent(student[4]);
	group1.addStudent(student[5]);
	group1.addStudent(student[6]);
	group1.addStudent(student[7]);
	group1.addStudent(student[8]);
	group1.addStudent(student[9]);
	//group.addStudent(student[10]);

	
	
	}catch(GroupOverflowException g) {
		System.out.println(g.getMessage());
	}
	try {
		gfs.saveGroupToCSV(group1);
	} catch (IOException e) {
		e.printStackTrace();
	}

	Group save = new Group("OOP", student);
	File file = new File("OOP.csv");

	try {
		save = gfs.loadGroupFromCSV(file);
		System.out.println(save);
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println(save);
	
	File search = new File("E:\\Prog_kiev\\homeOOP33");
	File searchResult =gfs.findFileByGroupName("OOP", search);
	if(searchResult!=null) {
	System.out.println(searchResult.getName());
	} else {
		System.out.println("not found");
	}
	

	
	group.show();

}


}
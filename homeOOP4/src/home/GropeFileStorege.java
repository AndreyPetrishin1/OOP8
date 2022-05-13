package home;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GropeFileStorege {
	Student[] student = new Student[10];

	public void saveGroupToCSV(Group group) throws IOException {
		File file = new File(group.getGroupName() + ".csv");

		try (FileWriter fw = new FileWriter(file)) {
			for (int i = 0; i < group.getStudent().length; i++) {
				if (group.getStudent()[i] != null) {
					fw.append(group.getStudent()[i].toCSV() + System.lineSeparator());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Group loadGroupFromCSV(File file) throws IOException {

		Group gr = new Group(file.getName().substring(0, file.getName().lastIndexOf(".")), student);

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			for (int i = 0; i < gr.getStudent().length; i++) {
				String stud = reader.readLine();
				if (stud != null) {
					gr.getStudent()[i] = new Student().fromCSVtoStudent(stud);
				
				}
			}
		} catch (IOException e) {
			return null;
		}
		return gr;
	}

	public File findFileByGroupName(String groupName, File searchZone) {

		File[] arr = searchZone.listFiles();
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].isFile() && arr[i].getName().equals(groupName + ".csv")) {
					return arr[i];
				}
			}
		}
		return null;
	}
}
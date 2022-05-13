package home;

import java.util.Objects;

public class Student extends Humen{

	int id;
	String groupName;
	public Student(String name, String lastName, Gender gender, int id, String groupName) {
		super(name, lastName, gender);
		this.id = id;
		this.groupName = groupName;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String toCSV() {
		String result = getName() + ";" + getLastName() + ";" + getGender() + ";" + getId();
		if (getGroupName() != null) {
			result += ";" + getGroupName();
		}
		return result;
	}

	public Student fromCSVtoStudent(String text) {
		String[] stud = text.split(";");
		Student st = new Student(stud[0], stud[1], Gender.valueOf(stud[2]), Integer.parseInt(stud[3]), stud[4]);
		if (stud.length == 5) {
			st.setGroupName(stud[4]);
		}
		return st;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", groupName = " + groupName + ", Name = " + getName() + ", LastName = " + getLastName() +", Gender = " + gender +"]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(groupName, id);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(groupName, other.groupName) && id == other.id;
	}
}

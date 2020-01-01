package Design.Builder;


public class StudentMain {

	public static void main(String[] args) {
		
		Student s1 = new StudentBuilder()
					.name("Eli")
					.buildStudent();
		
		Student s2 = new StudentBuilder()
					.name("Enver")
					.age(39)
					.motto("sample").buildStudent();

	}

}

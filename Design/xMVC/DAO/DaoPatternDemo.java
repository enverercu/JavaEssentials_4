package Design.xMVC.DAO;

import java.util.*;

class Student {
    private String name;
    private int rollNo;

    Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNo(){
    	return this.rollNo;
    }
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
interface StudentDao {
    public List<Student> getAllStudents();
    public void updateStudent(Student student);
}
class StudentDaoImpl implements StudentDao {
    //list is working as a database
    List<Student> students;
    public StudentDaoImpl(){
        students = new ArrayList<Student>();
        students.add(new Student("Robert",0));
        students.add(new Student("John",1));
    }
    @Override
    public List<Student> getAllStudents() {
        return students;
    }
    @Override
    public void updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo() + ", updated in the database");
    }
}
public class DaoPatternDemo {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        //update student
        Student student =studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    String name;
    String group;
    int course;
    List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        return grades.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }
}

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudentsWithLowAverage() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                iterator.remove();
            } else {
                student.course++;
            }
        }
    }

    public void printStudentsInCourse(int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
            }
        }
    }

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();

        studentManager.addStudent(new Student("Иван", "Группа1", 1, List.of(4, 3, 5)));
        studentManager.addStudent(new Student("Мария", "Группа2", 2, List.of(3, 2, 4)));
        studentManager.addStudent(new Student("Петр", "Группа1", 1, List.of(5, 4, 3)));

        studentManager.removeStudentsWithLowAverage();

        studentManager.printStudentsInCourse(2);
    }
}

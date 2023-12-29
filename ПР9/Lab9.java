import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lab9 {

  public static void printStudents(List<Student> students, int targetCourse) {
    Iterator<Student> iterator = students.iterator();
    while (iterator.hasNext()) {
      Student student = iterator.next();
      if (student.course() == targetCourse) {
        System.out.println(student.name());
      }
    }
  }

  public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();

    studentList.add(new Student("Іван", 1));
    studentList.add(new Student("Марія", 2));
    studentList.add(new Student("Петро", 1));
    studentList.add(new Student("Олена", 3));
    studentList.add(new Student("Андрій", 2));
    studentList.add(new Student("Наталія", 1));
    studentList.add(new Student("Василь", 3));
    studentList.add(new Student("Тетяна", 2));
    studentList.add(new Student("Олег", 1));
    studentList.add(new Student("Юлія", 3));

    int targetCourse = 2;
    System.out.println("Студенти на курсі " + targetCourse + ":");
    printStudents(studentList, targetCourse);
  }
}

package Controllers;

import Factories.CathedraFactory;
import Factories.StudentFactory;
import Models.Cathedra;
import Models.Faculty;
import Models.Student;
import app.App;
import app.DataInput;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class StudentController extends Controller
{
  public StudentController(App app) {
    super(app);
  }

  @Override
  public void create() {
    Student student = StudentFactory.create();
    if (student == null) {
      System.out.println("Відбулась помилка при створенні студента.");
    } else {
      app.repositories.studentRepository.store(student);
      String rolePrefix  = student.role == 1?"Студент":"Викладач";
      System.out.println(rolePrefix + " успішно створено!");
    }
  }

  @Override
  public void update() {
    Student student = getModelByName();
    System.out.println(student);
    if (student == null) {
      System.out.println("Студента/Викладач не визначено!");
      return;
    }
    int studentIndex = app.repositories.studentRepository.getIndex(student);
    int role;
    do {
      role = DataInput.getInt("Student/Teacher, 1 for Student, 2 for Teacher, 3 for skip> ");
    } while(role != 1 && role != 2 && role != 3);
    String rolePrefix;
    if (role == 3) {
      rolePrefix  = student.role == 1?"Student":"Teacher";
    } else {
      rolePrefix = role == 1?"Student":"Teacher";
    }
    String name = DataInput.getString(rolePrefix+"'s name, n for skip> ");
    student.name = name.equals("n") ? student.name: name;
    int course;
    do {
      course = DataInput.getInt(rolePrefix+"'s course, 0 for skip> ");

    } while(course<0 || course > 7);
    student.course = course == 0? student.course: course;
    student.role = role == 3? student.role: role;
    int group;
    do {
      group = DataInput.getInt(rolePrefix+"'s group, 0 for skip> ");

    } while(group < 0);
    student.group = group == 0?student.group:group;
    app.repositories.studentRepository.update(studentIndex, student);
    System.out.println(rolePrefix + " updated!");
  }
  private Student getModelByName()
  {
    System.out.println(Arrays.toString(app.repositories.studentRepository.all()));
    Student student = null;
    int counter = 0;
    if(app.repositories.studentRepository.all().length > 0) {
      do {
        String studentName = DataInput.getString("Student/Teacher name> ");
        student = this.app.repositories.studentRepository.get(studentName);
        counter++;
      } while (student == null && counter < 5);
    }
    return student;
  }
  @Override
  public void delete()
  {
    Student student = getModelByName();
    if (student == null) {
      System.out.println("Студента не визначено!");
      return;
    }
    if (this.app.repositories.studentRepository.delete(student)) {
      System.out.println("Студент/Вчитель успішно видалена!");
    }
  }

  @Override
  public void index() {
    int role;
    do {
      role = DataInput.getInt("Student/Teacher, 1 for Student, 2 for Teacher> ");
    } while(role != 1 && role != 2);
    System.out.print("""
        Виберіть дію:\s
        Шукати за ПІБ (1)
        Шукати за групою (2)
        Шукати за курсом (3)
        >\s""");
    int choice = DataInput.getInt();
    switch (choice) {
      case 1 -> {
        String name = DataInput.getString("ПІБ> ");
        app.repositories.studentRepository.byName(name, role);
      }
      case 2 -> {
        int group = DataInput.getInt("Група> ");
        app.repositories.studentRepository.byGroup(group, role);
      }
      case 3 -> {
        int course = DataInput.getInt("Курс> ");
        app.repositories.studentRepository.byCourse(course, role);
      }
    }
  }
}

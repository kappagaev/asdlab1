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
  public void view() {

  }

  @Override
  public void create() {
    Student student = StudentFactory.create();
    if (student == null) {
      System.out.println("Відбулась помилка при створенні студента.");
    } else {
      app.repositories.studentRepository.store(student);
      System.out.println("Студента успішно створено!");
    }
  }

  @Override
  public void update() {
    Student student = getModelByName();
    if (student == null) {
      System.out.println("Студента не визначено!");
      return;
    }
    int facultyIndex = app.repositories.studentRepository.getIndex(student);
    String newFacultyName = DataInput.getString("Cathedra name update, n for skip");
    student.name = newFacultyName.equals("n") ? newFacultyName : student.name;
    app.repositories.studentRepository.update(facultyIndex, student);
    System.out.println("Cathedra updated!");
  }
  private Student getModelByName()
  {
    Student student;
    int counter = 0;
    do {
      String studentName = DataInput.getString("Student/Teacher name> ");
      student = this.app.repositories.studentRepository.get(studentName);
      counter++;
    } while (student == null && counter < 5);
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
      role = DataInput.getInt("Student/Teacher, 1 for Student, 2 for Teacher");
    } while(role != 1 && role != 2);
    System.out.println("Виберіть дію: \n" +
            "Шукати за ПІБ (1)\n" +
            "Шукати за групою (2)\n" +
            "Шукати за курсом (3)\n" +
            "> ");
    int choice = DataInput.getInt();
    switch (choice) {
      case 1:
        String name = DataInput.getString("ПІБ");
        app.repositories.studentRepository.byName(name, role);
        break;
      case 2:
        int group = DataInput.getInt("Група");
        app.repositories.studentRepository.byGroup(group, role);
        break;
      case 3:
        int course = DataInput.getInt("Курс");
        app.repositories.studentRepository.byCourse(course, role);
        break;
    }
  }
}

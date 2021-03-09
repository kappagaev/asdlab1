package Controllers;

import Factories.CathedraFactory;
import Factories.StudentFactory;
import Models.Cathedra;
import Models.Faculty;
import Models.Student;
import app.App;
import app.DataInput;

import java.util.Arrays;

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
    Student cathedra = StudentFactory.create();
    app.repositories.studentRepository.store(cathedra);
    System.out.println("Кафедра успішно створена!");
  }

  @Override
  public void update() {
    Student student = getModelByName();
    int facultyIndex = app.repositories.studentRepository.getIndex(student);
    String newFacultyName = DataInput.getString("Cathedra name update, n for skip");
    student.name = newFacultyName.equals("n") ? newFacultyName : student.name;
    app.repositories.studentRepository.update(facultyIndex, student);
    System.out.println("Cathedra updated!");
  }
  private Student getModelByName()
  {
    Student student;
    do {
      String studentName = DataInput.getString("Student/Teacher name");
      student = this.app.repositories.studentRepository.get(studentName);
    } while (student == null);
    return student;
  }
  @Override
  public void delete()
  {
    Student student = getModelByName();
    if (this.app.repositories.studentRepository.delete(student)) {
      System.out.println("Студент/Вчитель успішно видалена!");
    }
  }

  @Override
  public void index() {
    System.out.println(Arrays.toString(this.app.repositories.studentRepository.all()));
  }
}

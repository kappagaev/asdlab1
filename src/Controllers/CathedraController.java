package Controllers;

import Factories.CathedraFactory;
import Models.Cathedra;
import Models.Faculty;
import Models.Student;
import app.App;
import app.DataInput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CathedraController extends Controller
{
    public CathedraController(App app) {
        super(app);
    }

    @Override
    public void view() {

    }

    @Override
    public void create() {
        Cathedra cathedra = CathedraFactory.create();
        app.repositories.cathedraRepository.store(cathedra);
        System.out.println("Кафедра успішно створена!");
    }

    @Override
    public void update() {
        Cathedra cathedra = getModelByName();
        int facultyIndex = app.repositories.cathedraRepository.getIndex(cathedra);
        String newFacultyName = DataInput.getString("Cathedra name update, n for skip> ");
        cathedra.name = newFacultyName.equals("n") ? newFacultyName : cathedra.name;
        app.repositories.cathedraRepository.update(facultyIndex, cathedra);
        System.out.println("Cathedra updated!");
    }
    private Cathedra getModelByName()
    {
        Cathedra cathedra;
        do {
            String cathedraName = DataInput.getString("Cathedra name> ");
            cathedra = this.app.repositories.cathedraRepository.get(cathedraName);
        } while (cathedra == null);
        return cathedra;
    }
    @Override
    public void delete()
    {
        Cathedra cathedra = getModelByName();
        if (this.app.repositories.cathedraRepository.delete(cathedra)) {
            System.out.println("Кафедра успішно видалена!");
        }
    }

    @Override
    public void index() {
        Cathedra cathedra = getModelByName();
        int facultyIndex = app.repositories.cathedraRepository.getIndex(cathedra);
        System.out.println("Виберіть дію: \n" +
            "Вивести всіх студентів кафедри впорядкованих за курсами (1)\n" +
            "Вивести всіх студентів кафедри впорядкованих за алфавітом (2)\n" +
            "Вивести всіх викладачів кафедри впорядкованих за алфавітом (3)\n" +
            "Вивести всіх студентів кафедри вказаного курсу (4)\n" +
            "Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом (5)" +
            "> ");
        int choice = DataInput.getInt();
        switch (choice) {
            case 5:
                int courseNeeded = DataInput.getInt("Вкажіть курс> ");
                var students = new LinkedList<Student>();
                for (Student student : cathedra.students) {
                    if (student.course == courseNeeded) {
                        students.add(student);
                    }
                }
                students.sort(Comparator.comparing(Student::getName));
                System.out.println(Arrays.toString(students.toArray()));
                break;
            case 4:
                courseNeeded = DataInput.getInt("Вкажіть курс> ");
                students = new LinkedList<Student>();
                for (Student student : cathedra.students) {
                    if (student.course == courseNeeded) {
                        students.add(student);
                    }
                }
                System.out.println(Arrays.toString(students.toArray()));
                break;
            case 3:
                students = new LinkedList<Student>();
                for (Student student : cathedra.students) {
                    if (student.role == 2) {
                        students.add(student);
                    }
                }
                students.sort(Comparator.comparing(Student::getName));
                System.out.println(Arrays.toString(students.toArray()));
                break;
            case 2:
                students = new LinkedList<Student>();
                for (Student student : cathedra.students) {
                    if (student.role == 1) {
                        students.add(student);
                    }
                }
                students.sort(Comparator.comparing(Student::getName));
                System.out.println(Arrays.toString(students.toArray()));
                break;
            default:
                students = cathedra.students;
                students.sort(Comparator.comparing(Student::getCourse));
                System.out.println(Arrays.toString(students.toArray()));
                break;
        }
    }
}

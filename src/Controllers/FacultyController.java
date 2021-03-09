package Controllers;

import Factories.*;
import Models.*;
import app.*;
import app.DataInput;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class FacultyController extends Controller
{

    public FacultyController(App app) {
        super(app);
    }

    @Override
    public void view() {

    }

    public void index() {
        Faculty faculty = getModelByName();
        int role = 0;
        while (role != 1 && role != 2) {
            System.out.println("Вивести студентів (1) чи викладачів (2)?> ");
            role = DataInput.getInt();
        }
        var students = new LinkedList<Student>();
        for (Cathedra cathedra : faculty.cathedras) {
            for (Student student : cathedra.students) {
                if (student.role == role) {
                    students.add(student);
                }
            }
        }
        students.sort(Comparator.comparing(Student::getName));
        System.out.println(Arrays.toString(students.toArray()));
    }

    @Override
    public void create() {
        Faculty faculty = FacultyFactory.create();
        this.app.repositories.facultyRepository.store(faculty);
        System.out.println("Факультет успішно створений!");
    }

    @Override
    public void update() {
        Faculty faculty = getModelByName();
        int facultyIndex = app.repositories.facultyRepository.getIndex(faculty);
        String newFacultyName = DataInput.getString("Faculty name update, n for skip> ");
        faculty.name = newFacultyName.equals("n") ? newFacultyName : faculty.name;
        app.repositories.facultyRepository.update(facultyIndex, faculty);
        System.out.println("Faculty updated!");
    }

    private Faculty getModelByName()
    {
        Faculty faculty;
        do {
            String facultyName = DataInput.getString("Faculty name> ");
            faculty = this.app.repositories.facultyRepository.get(facultyName);
        } while (faculty == null);
        return faculty;
    }

    @Override
    public void delete()
    {
        Faculty faculty = getModelByName();
        if (this.app.repositories.facultyRepository.delete(faculty)) {
            System.out.println("Факультет успішно видалено!");
        }
    }
}

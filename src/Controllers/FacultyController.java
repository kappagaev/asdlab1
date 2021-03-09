package Controllers;

import Factories.*;
import Models.*;
import app.*;
import app.DataInput;

import java.util.Arrays;

public class FacultyController extends Controller
{

    public FacultyController(App app) {
        super(app);
    }

    @Override
    public void view() {

    }

    public void index() {
        System.out.println(Arrays.toString(this.app.repositories.facultyRepository.all()));
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
        String newFacultyName = DataInput.getString("Faculty name update, n for skip");
        faculty.name = newFacultyName.equals("n") ? newFacultyName : faculty.name;
        app.repositories.facultyRepository.update(facultyIndex, faculty);
        System.out.println("Faculty updated!");
    }

    private Faculty getModelByName()
    {
        Faculty faculty;
        do {
            String facultyName = DataInput.getString("Faculty name");
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

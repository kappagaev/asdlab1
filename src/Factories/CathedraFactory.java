package Factories;

import Models.Cathedra;
import Models.Faculty;
import app.App;
import app.DataInput;

import java.util.Arrays;

public class CathedraFactory
{
    private static App app = App.getInstance();

    public static Cathedra create()
    {
        String name = DataInput.getString("Cathedra name> ");
        Cathedra cathedra = new Cathedra();
        cathedra.name = name;
        if (app.repositories.facultyRepository.isEmpty()) {
            System.out.println("Список факультетів пустий!");
            return null;
        }
        System.out.println(Arrays.toString(app.repositories.facultyRepository.all()));
        Faculty faculty;
        do {
            String facultyName = DataInput.getString("Faculty name> ");
            faculty = app.repositories.facultyRepository.get(facultyName);
        } while (faculty == null);
        int facultyIndex = app.repositories.facultyRepository.getIndex(faculty);
        faculty.cathedras.add(cathedra);
        app.repositories.facultyRepository.update(facultyIndex, faculty);

        return cathedra;
    }
}

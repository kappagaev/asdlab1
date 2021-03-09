package Factories;

import Models.Cathedra;
import Models.Student;
import app.App;
import app.DataInput;

import java.util.Arrays;

public class StudentFactory
{
    private static App app = App.getInstance();

    public static Student create()
    {
        int role;
        do {
            role = DataInput.getInt("Student/Teacher, 1 for Student, 2 for Teacher");
        } while(role != 1 && role != 2);
        String rolePrefix = role == 1?"Student":"Teacher";
        String name = DataInput.getString(rolePrefix+" name");
        Student student  = new Student();
        student.name = name;
        int course;
        do {
            course = DataInput.getInt(rolePrefix+"'s course");

        } while(course<0 || course > 7);
        student.course = course;

        int group;
        do {
            group = DataInput.getInt(rolePrefix+"'s group");

        } while(group< 0);
        student.group = group;

        System.out.println(Arrays.toString(app.repositories.cathedraRepository.all()));
        Cathedra cathedra;
        do {
            String cathedraName = DataInput.getString(rolePrefix+"'s Cathedra name");
            cathedra = app.repositories.cathedraRepository.get(cathedraName);
        } while (cathedra == null);
        int facultyIndex = app.repositories.cathedraRepository.getIndex(cathedra);
        student.cathedra = cathedra;
        cathedra.students.add(student);
        app.repositories.cathedraRepository.update(facultyIndex, cathedra);

        return student;
    }
}

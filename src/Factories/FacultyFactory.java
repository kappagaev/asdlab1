package Factories;

import Models.Faculty;
import app.DataInput;

public class FacultyFactory
{
    public static Faculty create()
    {
        String name = DataInput.getString("Faculty name");
        Faculty faculty = new Faculty();
        faculty.name = name;
        return faculty;
    }
}

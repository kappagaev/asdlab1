package Factories;

import Models.Faculty;
import app.DataInput;

public class FacultyFactory
{
    public static Faculty create()
    {
        String name = DataInput.getString("Faculty name");
        return new Faculty(name);
    }
}

package Repositories;

import Models.Faculty;
import Models.Model;

import java.util.LinkedList;

public class FacultyRepository extends Repository
{
    private LinkedList<Faculty> faculties = new LinkedList<Faculty>();

    public void store(Faculty model)
    {
        this.faculties.add(model);
    }

    public Faculty get(String name)
    {
        for (Faculty faculty: faculties) {
            if (faculty.name.equals(name)) {
                return faculty;
            }
        }
        return null;
    }

    public boolean delete(Faculty model)
    {
        return faculties.remove(model);
    }

    public LinkedList<Faculty> all()
    {
        return this.faculties;
    }
}

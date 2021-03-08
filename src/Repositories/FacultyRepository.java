package Repositories;

import Models.Faculty;
import Models.Model;

import java.util.LinkedList;

public class FacultyRepository extends Repository
{
    LinkedList<Faculty> faculties = new LinkedList<>();

//    public void store(Faculty model)
//    {
//        this.faculties.add(model);
//    }

    @Override
    public void store(Model model) {
        this.faculties.add((Faculty) model);
    }

    @Override
    public Faculty get(String name) {
        for (Faculty faculty: faculties) {
            if (faculty.name.equals(name)) {
                return faculty;
            }
        }
        return null;
    }

    @Override
    public boolean delete(Model model) {
        return faculties.remove(model);
    }

//    public boolean delete(Faculty model)
//    {
//        return faculties.remove(model);
//    }

    @Override
    public Faculty[] all()
    {
        return this.faculties.toArray(new Faculty[0]);
    }
}

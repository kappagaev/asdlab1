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

    public int getIndex(Faculty faculty)
    {
        return this.faculties.indexOf(faculty);
    }

    public void store(Faculty model) {
        this.faculties.add(model);
    }

    public Faculty get(String name) {
        for (Faculty faculty: faculties) {
            if (faculty.name.equals(name)) {
                return faculty;
            }
        }
        return null;
    }

    public boolean delete(Faculty model) {
        return faculties.remove(model);
    }

//    public boolean delete(Faculty model)
//    {
//        return faculties.remove(model);
//    }

    public void update(int index, Faculty faculty)
    {
        this.faculties.set(index, faculty);
    }

    public Faculty[] all()
    {
        return this.faculties.toArray(new Faculty[0]);
    }

    public boolean isEmpty() {
        return faculties.size() == 0;
    }
}

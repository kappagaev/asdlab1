package Repositories;

import Models.Faculty;
import Models.Model;

import java.util.LinkedList;

public class FacultyRepository extends Repository
{
    private LinkedList<Faculty> faculties;

    public void store(Faculty model)
    {
        this.faculties.add(model);
    }

    public Model get(int id)
    {
        return [id + 1];
    }

    public void update(int id, Faculty model)
    {
        models[]
    }

    public void delete(int id)
    {

    }
}

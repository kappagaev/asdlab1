package Repositories;

import Models.Faculty;
import Models.Model;

public class FacultyRepository extends Repository
{
    private Faculty[] models;
    private int lastIndex = 0;

    public void store(Faculty model)
    {
        this.models[lastIndex++] = model;
    }

    public Model get(int id)
    {
        return this.models[id + 1];
    }

    public void update(int id, Faculty model)
    {

    }

    public void delete(int id)
    {

    }
}

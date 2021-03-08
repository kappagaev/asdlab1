package Repositories;

import Models.Faculty;
import Models.Model;

import java.util.LinkedList;

public class CathedraRepository {

  private LinkedList<Faculty> faculties;

  public void store(Faculty model)
  {
    this.faculties.add(model);
  }

  public Model get(String name)
  {
    return null;
  }

  public void update(int id, Faculty model)
  {

  }

  public void delete(String name)
  {

  }
}

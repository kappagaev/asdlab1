package Models;

import java.util.LinkedList;

public class Cathedra extends Model{

  public String name;

  public Faculty faculty;

  public LinkedList<Student> students = new LinkedList<>();

  @Override
  public String toString()
  {
    return "Кафедра " + this.name + " факультету " + faculty.name;
  }
}

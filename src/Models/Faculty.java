package Models;

import Repositories.CathedraRepository;

import java.util.LinkedList;

public class Faculty extends Model
{
  LinkedList<Cathedra> cathedras = new LinkedList<>();

  public Faculty(String name) {
    super(name);
  }

  @Override
  public String toString()
  {
    return "факультет " + this.name;
  }
}

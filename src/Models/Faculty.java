package Models;

import java.util.LinkedList;

public class Faculty extends Model
{
  public LinkedList<Cathedra> cathedrals = new LinkedList<>();

  public String name;

  @Override
  public String toString()
  {
    return "факультет " + this.name;
  }
}

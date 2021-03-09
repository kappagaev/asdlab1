package Models;

public class Student extends Model{

  public Cathedra cathedra;

  public String name;

  public int course;

  public int group;

  public int role = 1;

  public final int TEACHER = 2;
  public final int STUDENT = 1;

  @Override
  public String toString()
  {
    String str = "";
    str += role==STUDENT?"Студент":"Викладач";
    return str + " " + name + " курс " + course;
  }
}

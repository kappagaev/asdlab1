package Models;

public class Student extends Model implements Comparable<Student> {

  public Cathedra cathedra;

  public String getName() {
    return name;
  }

  public String name;

  public int getCourse() {
    return course;
  }

  public int course;

  public int group;

  public int role = 1;

  public final int TEACHER = 2;
  public final int STUDENT = 1;

  @Override
  public String toString()
  {
    String str = role==STUDENT?"Студент":"Викладач";
    return str + " " + name + " курс " + course + " група " + group + " кафедра " + cathedra.name;
  }

  @Override
  public int compareTo(Student o) {
    if(this.course > o.course)
      return 1;
    else if (this.course == o.course)
      return 0 ;
    return -1 ;
  }
}

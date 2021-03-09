package Repositories;

import Models.*;

import java.util.LinkedList;

public class StudentRepository extends Repository {
  LinkedList<Student> students = new LinkedList<>();

  public int getIndex(Student student)
  {
    return this.students.indexOf(student);
  }

  public void store(Student student) {
    this.students.add(student);
  }

  public Student get(String name) {
    for (Student faculty: students) {
      if (faculty.name.equals(name)) {
        return faculty;
      }
    }
    return null;
  }

  public boolean delete(Student student) {
    return students.remove(student);
  }

  public void update(int index, Student student)
  {
    this.students.set(index, student);
  }

  public Student[] all()
  {
    return this.students.toArray(new Student[0]);
  }
}

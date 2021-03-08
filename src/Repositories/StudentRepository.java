package Repositories;

import Models.*;

import java.util.LinkedList;

public class StudentRepository extends Repository {

  LinkedList<Student> students = new LinkedList<>();

  @Override
  public void store(Model model) {
    this.students.add((Student) model);
  }

  @Override
  public Model get(String name) {
    for (Student student : students) {
      if (student.name.equals(name)) {
        return student;
      }
    }
    return null;
  }

  @Override
  public boolean delete(Model model) {
    return students.remove(model);
  }

  @Override
  public Model[] all() {
    return this.students.toArray(new Student[0]);
  }
}

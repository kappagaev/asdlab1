package Repositories;

import Models.Faculty;
import Models.Model;
import Models.Teacher;

import java.util.LinkedList;

public class TeacherRepository extends Repository {

  LinkedList<Teacher> teachers = new LinkedList<>();

  public void store(Model model) {
    this.teachers.add((Teacher) model);
  }

  public Model get(String name) {
    for (Teacher teacher: teachers) {
      if (teacher.name.equals(name)) {
        return teacher;
      }
    }
    return null;
  }

  public boolean delete(Model model) {
    return teachers.remove(model);
  }

  public Model[] all() {
    return this.teachers.toArray(new Teacher[0]);
  }
}

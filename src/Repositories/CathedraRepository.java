package Repositories;

import Models.Cathedra;
import Models.Faculty;
import Models.Model;

import java.util.LinkedList;

public class CathedraRepository extends Repository {

  LinkedList<Cathedra> cathedras = new LinkedList<>();

  @Override
  public void store(Model model) {
    this.cathedras.add((Cathedra) model);
  }

  @Override
  public Model get(String name)
  {
    for (var cathedra : cathedras) {
      if (cathedra.name.equals(name)) {
        return cathedra;
      }
    }
    return null;
  }

  @Override
  public boolean delete(Model model) {
    return cathedras.remove(model);
  }

  @Override
  public Model[] all() {
    return this.cathedras.toArray(new Cathedra[0]);
  }

}

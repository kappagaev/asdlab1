package Repositories;

import Models.Cathedra;

import java.util.LinkedList;

public class CathedraRepository extends Repository {

  LinkedList<Cathedra> cathedras = new LinkedList<>();


  public int getIndex(Cathedra model)
  {
    return this.cathedras.indexOf(model);
  }

  public void update(int index, Cathedra model)
  {
    this.cathedras.set(index, model);
  }

  public void store(Cathedra model) {
    this.cathedras.add(model);
  }

  public Cathedra get(String name)
  {
    for (var cathedra : cathedras) {
      if (cathedra.name.equals(name)) {
        return cathedra;
      }
    }
    return null;
  }

  public boolean delete(Cathedra model) {
    return cathedras.remove(model);
  }

  public Cathedra[] all() {
    return this.cathedras.toArray(new Cathedra[0]);
  }

  public boolean isEmpty() {
    return cathedras.size() == 0;
  }

}

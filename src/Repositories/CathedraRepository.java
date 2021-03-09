package Repositories;

import Models.Cathedra;
import Models.Faculty;
import Models.Model;

import java.util.LinkedList;

public class CathedraRepository extends Repository {

  LinkedList<Cathedra> cathedrals = new LinkedList<>();


  public int getIndex(Cathedra model)
  {
    return this.cathedrals.indexOf(model);
  }

  public void update(int index, Cathedra model)
  {
    this.cathedrals.set(index, model);
  }

  public void store(Cathedra model) {
    this.cathedrals.add(model);
  }

  public Cathedra get(String name)
  {
    for (var cathedra : cathedrals) {
      if (cathedra.name.equals(name)) {
        return cathedra;
      }
    }
    return null;
  }

  public boolean delete(Cathedra model) {
    return cathedrals.remove(model);
  }

  public Cathedra[] all() {
    return this.cathedrals.toArray(new Cathedra[0]);
  }

}

package Repositories;

import Models.*;

public abstract class Repository
{

  public abstract void store(Model model);

  public abstract Model get(String name);

  public abstract boolean delete(Model model);

  public abstract Model[] all();
}

package Models;

public class Faculty extends Model
{

  public Faculty(String name) {
    super(name);
  }

  @Override
  public String toString()
  {
    return "факультет " + this.name;
  }
}

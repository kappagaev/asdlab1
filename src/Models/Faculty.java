package Models;

public class Faculty extends Model
{
  public String name;

  @Override
  public String toString()
  {
    return "факультет " + this.name;
  }
}

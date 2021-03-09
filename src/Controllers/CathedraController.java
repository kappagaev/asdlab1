package Controllers;

import Factories.CathedraFactory;
import Models.Cathedra;
import app.App;
import app.DataInput;

import java.util.Arrays;

public class CathedraController extends Controller
{
    public CathedraController(App app) {
        super(app);
    }

    @Override
    public void view() {

    }

    @Override
    public void create() {
        Cathedra cathedra = CathedraFactory.create();
        app.repositories.cathedraRepository.store(cathedra);
        System.out.println("Кафедра успішно створена!");
    }

    @Override
    public void update() {
        Cathedra cathedra = getModelByName();
        int facultyIndex = app.repositories.cathedraRepository.getIndex(cathedra);
        String newFacultyName = DataInput.getString("Cathedra name update, n for skip");
        cathedra.name = newFacultyName.equals("n") ? newFacultyName : cathedra.name;
        app.repositories.cathedraRepository.update(facultyIndex, cathedra);
        System.out.println("Cathedra updated!");
    }
    private Cathedra getModelByName()
    {
        Cathedra cathedra;
        do {
            String cathedraName = DataInput.getString("Cathedra name");
            cathedra = this.app.repositories.cathedraRepository.get(cathedraName);
        } while (cathedra == null);
        return cathedra;
    }
    @Override
    public void delete()
    {
        Cathedra cathedra = getModelByName();
        if (this.app.repositories.cathedraRepository.delete(cathedra)) {
            System.out.println("Кафедра успішно видалена!");
        }
    }

    @Override
    public void index() {
        System.out.println(Arrays.toString(this.app.repositories.cathedraRepository.all()));
    }
}

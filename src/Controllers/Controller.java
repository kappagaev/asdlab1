package Controllers;

import app.App;

abstract public class Controller
{
    protected final App app;

    public Controller(App app) {
        this.app = app;
    }

    public void callMethod(String method)
    {
        switch (method) {
            case "view" -> this.view();
            case "create" -> this.create();
            case "update" -> this.update();
            case "delete" -> this.delete();
        }
    }

    public abstract void view();
    public abstract void create();
    public abstract void update();
    public abstract void delete();
}

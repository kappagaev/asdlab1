package app;

import Controllers.Controller;
import Controllers.FacultyController;

public class Router
{
    private final App app;

    public Router(App app)
    {
        this.app = app;
    }

    public Controller route(String name)
    {
        switch (name) {
            case "faculty" -> {
                return new FacultyController(this.app);
            }
        }
        return null;
    }
}

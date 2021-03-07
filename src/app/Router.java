package app;

import Controllers.Controller;
import Controllers.FacultyController;
import Controllers.StudentController;

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
            case "student" -> {
                return new StudentController(this.app);
            }
        }
        return null;
    }
}

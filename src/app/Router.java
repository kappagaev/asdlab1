package app;

import Controllers.*;

public class Router {
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
            case "cathedra" -> {
                return new CathedraController(this.app);
            }
        }
        return null;
    }

    public String routes()
    {
        return "faculty/student";
    }
}

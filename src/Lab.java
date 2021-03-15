import Controllers.*;
import app.*;

import java.io.IOException;

public class Lab
{
    public static void main(String[] args) {
        App app = App.getInstance();
        while (true) {
            String route = DataInput.getString("Route> ");
            Controller controller = app.router.route(route);
            while (controller == null) {
                route = DataInput.getString("Available routes: faculty, student, cathedra\nRoute> ");
                controller = app.router.route(route);
            }
            String action = DataInput.getString("Action> ");
            controller.callMethod(action);
        }
    }
}

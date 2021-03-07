import Controllers.Controller;
import app.App;
import app.DataInput;

import java.io.IOException;

public class Lab
{
    public static void main(String[] args) throws IOException {
        App app = new App();
        while (true) {
            String route = DataInput.getString();
            Controller controller = app.router.route(route);
            String action = DataInput.getString();
            controller.callMethod(action);
        }
    }
}

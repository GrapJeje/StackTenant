package nl.grapjeje.stacktenant.controllers.layout;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import nl.grapjeje.stacktenant.controllers.Controller;
import nl.grapjeje.stacktenant.views.View;
import org.springframework.stereotype.Component;

@Component
public class DashboardController extends Controller {

    @FXML
    Pane navPane;

    @FXML
    Pane contentPane;

    @FXML
    public void initialize() {
        try {
            FXMLLoader loader = View.load("Components/Nav.fxml");
            Node navComponent = loader.load();

            navPane.getChildren().setAll(navComponent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

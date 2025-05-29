package nl.grapjeje.stacktenant.controllers.layout;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import nl.grapjeje.stacktenant.controllers.Components.NavController;
import nl.grapjeje.stacktenant.controllers.Controller;
import nl.grapjeje.stacktenant.views.View;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DashboardController extends Controller {

    @FXML
    private Pane navPane;

    @FXML
    private Pane contentPane;

    private Map<String, Node> pages = new HashMap<>();

    @FXML
    public void initialize() {
        System.out.println("Initializing Dashboard...");
        try {
            // Debug pane sizes
            navPane.setStyle("-fx-border-color: red; -fx-border-width: 2;");
            contentPane.setStyle("-fx-border-color: blue; -fx-border-width: 2;");

            // Load nav
            FXMLLoader navLoader = View.load("Components/Nav.fxml");
            Node navComponent = navLoader.load();
            System.out.println("Nav loaded: " + navComponent);

            // Set fixed size
            navComponent.prefWidth(250);

            NavController navController = navLoader.getController();
            navController.setDashboardController(this);

            navPane.getChildren().add(navComponent);
            System.out.println("Nav children: " + navPane.getChildren().size());

            // Load default page
            loadPage("Dashboard/Home"); // Let op: pad moet exact overeenkomen
        } catch (Exception e) {
            System.err.println("Initialization error:");
            e.printStackTrace();
        }
    }

    public void loadPage(String pageName) {
        try {
            if (pages.containsKey(pageName)) {
                contentPane.getChildren().setAll(pages.get(pageName));
                return;
            }

            FXMLLoader loader = View.load(pageName + ".fxml");
            Node page = loader.load();
            pages.put(pageName, page);

            contentPane.getChildren().setAll(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
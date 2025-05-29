package nl.grapjeje.stacktenant.controllers.Components;

import javafx.fxml.FXML;
import lombok.Setter;
import nl.grapjeje.stacktenant.annotations.Layout;
import nl.grapjeje.stacktenant.controllers.layout.DashboardController;
import org.springframework.stereotype.Component;

@Component
@Setter
public class NavController {

    private DashboardController dashboardController;

    @FXML
    public void initialize() {
        System.out.println("NavController initialized");
    }

    @FXML
    private void goToHome() {
        dashboardController.loadPage("components.home");
    }

    @FXML
    private void goToAbout() {
        dashboardController.loadPage("about");
    }

    @FXML
    private void goToSettings() {
        dashboardController.loadPage("settings");
    }
}
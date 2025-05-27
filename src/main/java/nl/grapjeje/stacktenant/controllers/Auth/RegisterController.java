package nl.grapjeje.stacktenant.controllers.Auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import nl.grapjeje.stacktenant.controllers.Controller;
import nl.grapjeje.stacktenant.views.Views;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RegisterController extends Controller {
    @FXML
    private void handleInloggenClick(ActionEvent event) throws IOException {
        Views.switchScene(event, "auth/login.fxml", 320, 240);
    }
}

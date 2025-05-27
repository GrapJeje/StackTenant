package nl.grapjeje.stacktenant.controllers.Auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import nl.grapjeje.stacktenant.controllers.Controller;
import nl.grapjeje.stacktenant.views.Views;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginController extends Controller {
    @FXML
    private Label a;

    @FXML
    private TextField b;

    @FXML
    private void handleButtonClick() {
        String invoer = b.getText();
        a.setText("Je typte: " + invoer);
    }

    @FXML
    private void handleRegisterClick(ActionEvent event) throws IOException {
        Views.switchScene(event, "auth/register.fxml", 320, 240);
    }
}

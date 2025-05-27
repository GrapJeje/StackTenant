package nl.grapjeje.stacktenant.controllers.Auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nl.grapjeje.stacktenant.controllers.Controller;
import nl.grapjeje.stacktenant.views.View;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RegisterController extends Controller {

    @FXML
    Label error;

    @FXML
    TextField name;

    @FXML
    TextField email;

    @FXML
    PasswordField password;

    @FXML
    PasswordField secondPassword;

    @FXML
    void handleLoginClick(ActionEvent event) throws IOException {
        View view = View.switchScene(event, "auth/login.fxml", 350, 450);
        view.getStage().setMinWidth(350);
        view.getStage().setMinHeight(450);
    }

    @FXML
    void handleButtonClick() {

    }
}

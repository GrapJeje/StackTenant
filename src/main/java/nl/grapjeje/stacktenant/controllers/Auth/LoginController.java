package nl.grapjeje.stacktenant.controllers.Auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import nl.grapjeje.stacktenant.controllers.Controller;
import nl.grapjeje.stacktenant.enitity.User;
import nl.grapjeje.stacktenant.services.UserService;
import nl.grapjeje.stacktenant.utils.PassWord;
import nl.grapjeje.stacktenant.utils.Validate;
import nl.grapjeje.stacktenant.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginController extends Controller {

    @Autowired
    private UserService userService;

    @FXML
    Label error;

    @FXML
    TextField email;

    @FXML
    PasswordField password;

    @FXML
    void handleRegisterClick(ActionEvent event) throws IOException {
        View.switchScene(event, "auth/register.fxml", 400, 500, true, true);
    }

    @FXML
    void handleButtonClick() {
        error.setText("");

        String emailText = email.getText().trim();
        String passwordText = password.getText().trim();

        if (emailText.isEmpty() || passwordText.isEmpty()) {
            error.setText("Vul een email en wachtwoord in!");
            return;
        }

        if (!Validate.email(emailText)) {
            error.setText("Ongeldige email!");
            return;
        }

        User user = userService.findByEmail(emailText);
        if (user == null) {
            error.setText("De gegevens klopt niet!");
            return;
        }

        try {
            if (!PassWord.verify(passwordText, user.getPassword())) {
                error.setText("De gegevens klopt niet!");
                return;
            }
        } catch (Exception e) {
            error.setText("Fout bij wachtwoordcontrole!");
            e.printStackTrace();
            return;
        }

        error.setText("Ingelogd!");
    }

}

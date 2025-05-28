package nl.grapjeje.stacktenant.controllers.Auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import nl.grapjeje.stacktenant.controllers.Controller;
import nl.grapjeje.stacktenant.models.User;
import nl.grapjeje.stacktenant.services.UserService;
import nl.grapjeje.stacktenant.utils.PassWord;
import nl.grapjeje.stacktenant.utils.Validate;
import nl.grapjeje.stacktenant.views.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RegisterController extends Controller {

    @Autowired
    private UserService userService;

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
        View view = View.switchScene(event, "auth/login.fxml", 400, 500, true, true);
    }

    @FXML
    void handleButtonClick(ActionEvent event) {
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
        if (user != null) {
            error.setText("Deze mail word al gebruikt!");
            return;
        }

        if (!passwordText.equals(secondPassword.getText().trim())) {
            error.setText("Wachtwoorden komen niet overeen!");
            return;
        }

        try {
            User newUser = new User();
            newUser.setName(name.getText().trim());
            newUser.setEmail(emailText);
            newUser.setPassword(PassWord.hash(passwordText));
            userService.save(newUser);

            error.setText("Registratie succesvol! Je kunt nu inloggen.");
            View view = View.switchScene(event, "auth/login.fxml", 400, 500, true, true);
        } catch (Exception e) {
            error.setText("Fout bij registreren!");
            e.printStackTrace();
            return;
        }
    }
}

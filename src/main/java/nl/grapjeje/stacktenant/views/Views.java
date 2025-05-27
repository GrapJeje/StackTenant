package nl.grapjeje.stacktenant.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Views {
    @Contract("_ -> new")
    public static @NotNull FXMLLoader load(String path) {
        return new FXMLLoader(Views.class.getResource("/views/" + path));
    }

    public static void switchScene(ActionEvent event, String path) throws IOException {
        switchScene((Node) event.getSource(), path, 1920, 1080);
    }

    public static void switchScene(ActionEvent event, String path, double width, double height) throws IOException {
        switchScene((Node) event.getSource(), path, width, height);
    }

    public static void switchScene(Node source, String path) throws IOException {
        switchScene(source, path, 1920, 1080);
    }

    public static void switchScene(Node source, String path, double width, double height) throws IOException {
        Parent root = load(path).load();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(new Scene(root, width, height));
    }
}

package nl.grapjeje.stacktenant.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

@Getter
public class View {

    String Path;
    @Setter
    Scene scene;
    @Setter
    Stage stage;

    View(String path) {
        this.Path = path;
    }

    public static View switchScene(ActionEvent event, String path) throws IOException {
        return switchScene(event, path, 1920, 1080);
    }

    public static View switchScene(ActionEvent event, String path, double width, double height) throws IOException {
        return switchScene((Node) event.getSource(), path, width, height);
    }

    public static View switchScene(Node source, String path) throws IOException {
        return switchScene(source, path, 1920, 1080);
    }

//    public static View switchScene(Node source, String path, boolean setMaximized) throws IOException {
//
//    }

    public static View switchScene(Node source, String path, double width, double height) throws IOException {
        Parent root = load(path).load();
        Stage stage = (Stage) source.getScene().getWindow();
        Scene scene = new Scene(root, width, height);
        stage.setScene(scene);

        View view = new View(path);
        view.setScene(scene);
        view.setStage(stage);
        return view;
    }

    @Contract("_ -> new")
    public static @NotNull FXMLLoader load(String path) {
        return new FXMLLoader(View.class.getResource("/views/" + path));
    }
}

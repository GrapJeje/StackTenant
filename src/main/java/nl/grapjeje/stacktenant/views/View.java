package nl.grapjeje.stacktenant.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import nl.grapjeje.stacktenant.Main;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ConfigurableApplicationContext;

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

    View(String path, Scene scene, Stage stage) {
        this.Path = path;
        this.scene = scene;
        this.stage = stage;
    }

    public static View switchScene(ActionEvent event, String path) throws IOException {
        return switchScene((Node) event.getSource(), path);
    }

    public static View switchScene(ActionEvent event, String path, double width, double height, boolean whIsMin, boolean minIsMax) throws IOException {
        return switchScene((Node) event.getSource(), path, width, height, whIsMin, minIsMax, false);
    }

    public static View switchScene(Node source, String path) throws IOException {
        return switchScene(source, path, 500, 500, false, false, true);
    }

    public static View switchScene(Node source, String path, double width, double height,
                                   boolean whIsMin, boolean minIsMax, boolean maximized) throws IOException {
        ConfigurableApplicationContext context = Main.getSpringContext();
        FXMLLoader loader = load(path);
        loader.setControllerFactory(context::getBean);

        Parent root = loader.load();
        Stage stage = (Stage) source.getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);

        if (maximized) stage.setMaximized(true);
        else {
            stage.setWidth(width);
            stage.setHeight(height);

            if (whIsMin) {
                stage.setMinHeight(height);
                stage.setMinWidth(width);
            }

            if (minIsMax) {
                stage.setMaxHeight(height);
                stage.setMaxWidth(width);
            }

            stage.setMaximized(false);
        }

        return new View(path, scene, stage);
    }

    public static FXMLLoader load(String path) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(View.class.getResource("/views/" + path));
        loader.setControllerFactory(Main.getSpringContext()::getBean);
        return loader;
    }
}

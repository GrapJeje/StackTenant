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

    public static View switchScene(ActionEvent event, String path, double width, double height) throws IOException {
        return switchScene((Node) event.getSource(), path, width, height);
    }

    public static View switchScene(Node source, String path) throws IOException {
        View view = switchScene(source, path, 500, 500);
        view.getStage().setMaximized(true);
        return view;
    }

    public static View switchScene(Node source, String path, double width, double height) throws IOException {
        ConfigurableApplicationContext context = Main.getSpringContext();

        FXMLLoader loader = new FXMLLoader(Main.class.getResource(path));
        loader.setControllerFactory(context::getBean);

        Scene scene = new Scene(loader.load(), width, height);

        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(scene);

        return new View(path, scene, stage);
    }

    @Contract("_ -> new")
    public static @NotNull FXMLLoader load(String path) {
        return new FXMLLoader(View.class.getResource("/views/" + path));
    }
}

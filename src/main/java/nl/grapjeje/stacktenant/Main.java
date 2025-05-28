package nl.grapjeje.stacktenant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;
import nl.grapjeje.stacktenant.views.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {
    @Getter
    public static ConfigurableApplicationContext springContext;
    private Parent root;

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);

        FXMLLoader fxmlLoader = View.load("auth/login.fxml");
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(root, 350, 450);
        stage.setTitle("StackTenant");
        stage.setMinWidth(350);
        stage.setMinHeight(450);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

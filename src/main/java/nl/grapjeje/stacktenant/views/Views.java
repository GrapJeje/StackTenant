package nl.grapjeje.stacktenant.views;

import javafx.fxml.FXMLLoader;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class Views {
    @Contract("_ -> new")
    public static @NotNull FXMLLoader load(String path) {
        return new FXMLLoader(Views.class.getResource("/views/" + path));
    }
}

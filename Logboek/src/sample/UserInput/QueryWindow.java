package sample.UserInput;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class QueryWindow {

    public static String askString(String subject) {
        TextInputDialog dialog = new TextInputDialog(subject);
        dialog.setTitle(subject + " input");
        dialog.setHeaderText("Please enter " + subject + " ^_^");
        dialog.setContentText("Please enter " + subject + ":");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }
}

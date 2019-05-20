package sample.UserInput;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import sample.Log.Session;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
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

    public static LocalDateTime[] durationMeter() {
        LocalDateTime start = LocalDateTime.now();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Working");
        alert.setHeaderText(null);
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
        LocalDateTime end = LocalDateTime.now();
        LocalDateTime duration = end.minus(start.getHour(), ChronoUnit.HOURS).minusMinutes(start.getMinute());
        LocalDateTime list[]  = new LocalDateTime[3];
        list[0] = start;
        list[1] = end;
        list[2] = duration;
        return list;
    }
}

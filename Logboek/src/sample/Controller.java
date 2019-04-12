package sample;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller {

    public MenuItem aboutAppButton;
    public AnchorPane leftBar;
    public AnchorPane centerBar;
    public AnchorPane rightBar;



    public Controller() {

    }

    public void showAboutApp(ActionEvent actionEvent) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text("This is an application made for the purposes of keeping track of time spent on projects.\n" +
                "This application was made by Lucas Prins."));
        Scene dialogScene = new Scene(dialogVbox, 500, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}

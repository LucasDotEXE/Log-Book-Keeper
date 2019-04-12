package sample;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {

    public MenuItem aboutAppButton;
    public AnchorPane leftBar;
    public AnchorPane centerBar;
    public AnchorPane rightBar;
    public Button addProjectButton;
    public Button addSessionButton;


    public Controller() {

    }

    public void showAboutApp(ActionEvent actionEvent) {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        String info = "###ERROR WHILE LOADING INFO###";
        try {
            System.out.println(System.getProperty("user.dir") + "\\res\\TextBasedFiles\\AboutThisApp");
            Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\res\\TextBasedFiles\\AboutThisApp"));
            StringBuilder loadedInfo = new StringBuilder();
            while (scanner.hasNextLine()) {
                loadedInfo.append(scanner.nextLine() + "\n");
            }
            if (!loadedInfo.toString().isEmpty()) {
                info = loadedInfo.toString();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        dialogVbox.getChildren().add(new Text(info));
        Scene dialogScene = new Scene(dialogVbox, 500, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }


    public void addProject(ActionEvent actionEvent) {

    }

    public void addSesion(ActionEvent actionEvent) {

    }
}

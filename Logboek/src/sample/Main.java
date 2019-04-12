package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        System.out.println("0");
        primaryStage.setTitle("Log");
        System.out.println("1");
        primaryStage.setScene(new Scene(root, 300, 275));
        System.out.println("2");
        primaryStage.show();
        System.out.println("3");

    }


    public static void main(String[] args) {
        launch(args);
    }
}

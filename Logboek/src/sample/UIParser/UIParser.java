package sample.UIParser;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sample.Controller;
import sample.Log.Project;
import sample.Log.Session;

import java.text.DateFormat;

public class UIParser {

     public static Label parseProject(Project project, Controller controller) {
//         Text projectLabel = new Text(project.getName());
         Label projectLabel = new Label(project.getName());
         if (controller.getSelectedProject() != null)
             if (controller.getSelectedProject().equals(project))
                 projectLabel.setBackground(new Background(new BackgroundFill(Color.hsb(212, 1f, 1f, 0.5f), CornerRadii.EMPTY, Insets.EMPTY)));


         projectLabel.setOnMouseClicked(event -> {
             controller.setSelectedProject(project);
             controller.updateWindow();
         });
        return projectLabel;
     }

     public static Label parseSession(Session session, Controller controller) {
         Label sessionLabel = new Label(session.getName() + "\t\t" + TimeParser.dateTimeToString(session.getStart()));

         if (controller.getSelectedSession() != null)
             if (controller.getSelectedSession().equals(session))
                 sessionLabel.setBackground(new Background(new BackgroundFill(Color.hsb(212, 1f, 1f, 0.5f), CornerRadii.EMPTY, Insets.EMPTY)));

             sessionLabel.setOnMouseClicked(event -> {
                 controller.setSelectedSession(session);
                 controller.updateWindow();
             });

         return sessionLabel;
     }

     public static VBox parseProjectDetails(Project project) {
         VBox details = new VBox();



         return details;
     }

     public static VBox parseSessionDetails() {

     }

}

package sample.UIParser;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import sample.Controller;
import sample.Log.Project;
import sample.Log.Session;
import sample.UserInput.QueryWindow;

import java.text.DateFormat;
import java.time.LocalDateTime;

public class UIParser {

     public static Label parseProject(Project project, Controller controller) {
//         Text projectLabel = new Text(project.getName());
         Label projectLabel = new Label(project.getName());
         if (controller.getSelectedProject() != null)
             if (controller.getSelectedProject().equals(project))
                 projectLabel.setBackground(new Background(new BackgroundFill(Color.hsb(212, 1f, 1f, 0.5f), CornerRadii.EMPTY, Insets.EMPTY)));


         projectLabel.setOnMouseClicked(event -> {
             controller.setSelectedProject(project);
             controller.setDetailScreen(parseProjectDetails(project, controller));
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
                 controller.setDetailScreen(parseSessionDetails(session, controller));
                 controller.updateWindow();
             });

         return sessionLabel;
     }

     public static HBox parseProjectDetails(Project project, Controller controller) {
         HBox details = new HBox();
         VBox labelLine = new VBox(6);
         VBox interactLine = new VBox();

         //name line
         labelLine.getChildren().add(new Label("Name: "));
         TextField name = new TextField(project.getName());
         interactLine.getChildren().add(name);

         //accomplices
         labelLine.getChildren().addAll(new Label("Accomplices: "));
         TextArea acomplices = new TextArea(project.getAcomplices());
         acomplices.setMaxHeight(24);
         interactLine.getChildren().addAll(acomplices);
         labelLine.getChildren().addAll(new Label(""));
         //description line
         labelLine.getChildren().addAll(new Label("Description: "));
         TextArea description = new TextArea(project.getDiscription());
         interactLine.getChildren().addAll(description);

         //save line
         Button save = new Button("Save");
         save.setOnAction(event -> {
             project.setName(name.getCharacters().toString());
             project.setAcomplices(acomplices.getText());
             project.setDescription(description.getText());
             controller.updateWindow();
         });
         interactLine.getChildren().addAll(save);



         details.getChildren().addAll(labelLine, interactLine);
         return details;
     }

     public static HBox parseSessionDetails(Session session, Controller controller) {
         HBox hBox = new HBox();
         VBox labelLine = new VBox();
         VBox interactLine = new VBox();

         //name line
         labelLine.getChildren().addAll(new Label("Name: "));
         TextField name = new TextField(session.getName());
         interactLine.getChildren().addAll(name);

         //time line
         labelLine.getChildren().addAll(new Label("Start: "), new Label("Duration:"),new Label("End: "));
         interactLine.getChildren().addAll(new Label(TimeParser.dateTimeToString(session.getStart())), new Label(TimeParser.timeToSting(session.getTimeSpent())),new Label(TimeParser.dateTimeToString(session.getEnd())));

         //description line
         labelLine.getChildren().addAll(new Label("Description: "));
         TextArea description = new TextArea(session.getDiscription());
         interactLine.getChildren().addAll(description);

         //save line
         HBox buttonLine = new HBox();
         buttonLine.setSpacing(5);
         Button save = new Button("Save");
         save.setOnAction(event -> {
             session.setName(name.getCharacters().toString());
             session.setDiscription(description.getText());
             controller.updateWindow();
         });
         buttonLine.getChildren().addAll(save);

         //start line
         if (session.getTimeSpent() == null) {
             Button start_session = new Button("Start Session");
             start_session.setOnAction(event -> {
                 LocalDateTime time[] = QueryWindow.durationMeter();
                 session.setTimeSpent(time[2].toLocalTime());
                 session.setStart(time[0]);
                 session.setEnd(time[1]);
                 controller.updateWindow();
             });
             buttonLine.getChildren().add(start_session);
         }
         interactLine.getChildren().add(buttonLine);

         labelLine.setSpacing(6);
         interactLine.setSpacing(1);
         hBox.getChildren().addAll(labelLine, interactLine);
        return hBox;
     }

}

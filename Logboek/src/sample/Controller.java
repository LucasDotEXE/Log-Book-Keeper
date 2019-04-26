package sample;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Log.Project;
import sample.Log.ProjectManager;
import sample.Log.Session;
import sample.UserInput.QueryWindow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {

    public Label detailLabel;
    public Label sessionLabel;
    public Label projectLabel;

    private ProjectManager projectManager;

    public MenuItem aboutAppButton;
    public AnchorPane projectScreen;
    public AnchorPane sessionScreen;
    public AnchorPane detailScreen;
    public Button addProjectButton;
    public Button addSessionButton;

    private Project selectedProject;
    private Session selectedSession;


    public Controller() {
        this.projectManager = new ProjectManager();
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
        this.projectManager.addProject(QueryWindow.askString("Project Name"));
        updateWindow();
    }

    public void addSession(ActionEvent actionEvent) {
        if (selectedProject == null)
            return;
        this.selectedProject.addSession(QueryWindow.askString("Session Name"));
        updateWindow();
    }

    public void updateWindow() {
        this.projectScreen.getChildren().removeAll(this.projectScreen.getChildren());
        VBox projectList = this.projectManager.getProjectListUIElemnt(this);
        projectList.setLayoutX(14.0);
        projectList.setLayoutY(48.0);
        this.projectScreen.getChildren().addAll(this.projectLabel, this.addProjectButton, projectList);

        if (selectedProject != null) {
            this.sessionScreen.getChildren().removeAll(this.sessionScreen.getChildren());
            VBox sessionList = this.selectedProject.getSessionListUIElement(this);
            sessionList.setLayoutX(14.0);
            sessionList.setLayoutY(48.0);
            this.sessionScreen.getChildren().addAll(this.sessionLabel, this.addSessionButton, sessionList);
        }
    }

    public void setDetailScreen(VBox content) {
        this.detailScreen.getChildren().removeAll(this.detailScreen.getChildren());
        content.setLayoutX(14);
        content.setLayoutY(38);
        this.detailScreen.getChildren().addAll(this.detailLabel, content);
    }

    public void setSelectedProject(Project project) {
        this.selectedProject = project;
    }

    public Project getSelectedProject() {
        return this.selectedProject;
    }

    public Session getSelectedSession() {
        return selectedSession;
    }

    public void setSelectedSession(Session selectedSession) {
        this.selectedSession = selectedSession;
    }
}

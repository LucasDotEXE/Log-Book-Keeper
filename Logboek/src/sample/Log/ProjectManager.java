package sample.Log;

import javafx.scene.layout.VBox;
import sample.Controller;
import sample.UIParser.UIParser;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectManager implements Serializable {

    private ArrayList<Project> projects;

    public ProjectManager() {
        this.projects = new ArrayList<>();
    }

    public void addProject(String name) {
        this.projects.add(new Project(name));
    }

    public VBox getProjectListUIElemnt(Controller controller) {
        VBox list = new VBox();
        this.projects.forEach(project -> list.getChildren().add(UIParser.parseProject(project, controller)));
        return list;
    }
}

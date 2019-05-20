package sample.Log;

import javafx.scene.layout.VBox;
import sample.Controller;
import sample.UIParser.UIParser;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project implements Serializable {

    private String name;
    private ArrayList<Session> sessions;
    private String acomplices;
    private String description;

    public Project(String name) {
        this.name = name;
        this.sessions = new ArrayList<>();
        this.acomplices = null;
        this.description = null;
    }

    public void addSession(String name) {
        if (name != null)
            this.sessions.add(new Session(name));
    }

    public String getName() {
        return this.name;
    }

    public VBox getSessionListUIElement(Controller controller) {
        VBox sessionList = new VBox();
        this.sessions.forEach(session ->sessionList.getChildren().addAll(UIParser.parseSession(session, controller)));
        return sessionList;
    }

    public String getAcomplices() {
        return acomplices;
    }

    public void setAcomplices(String acomplices) {
        this.acomplices = acomplices;
    }

    public String getDiscription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

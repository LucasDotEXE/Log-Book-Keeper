package sample.Log;

import javafx.scene.layout.VBox;
import sample.Controller;
import sample.UIParser.UIParser;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project {

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private ArrayList<Session> sessions;
    private ArrayList<String> acomplices;

    public Project(String name) {
        this.name = name;
        this.start = LocalDateTime.now();
        this.sessions = new ArrayList<>();
        this.acomplices = new ArrayList<>();
    }

    public void addSession(String name) {
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
}

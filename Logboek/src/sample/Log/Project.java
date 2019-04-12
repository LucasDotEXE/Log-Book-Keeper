package sample.Log;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project {

    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private ArrayList<Sesion> sessions;

    public Project(String name) {
        this.name = name;
        this.start = LocalDateTime.now();
        this.sessions = new ArrayList<>();
    }

    public void addSession(String name) {
        this.sessions.add(new Sesion(name));
    }
}

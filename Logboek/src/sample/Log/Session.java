package sample.Log;

import sample.UIParser.TimeParser;

import java.time.LocalDateTime;
import java.util.Timer;

public class Session {
    private LocalDateTime start;
    private String name;
    private String discription;
    private int timeSpent;



    public Session(String name) {
        this.start = LocalDateTime.now();
        this.name = name;
        this.discription = "No Description";
        this.timeSpent = 0;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public String getDiscription() {
        return discription;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
}

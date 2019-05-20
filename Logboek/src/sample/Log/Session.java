package sample.Log;

import sample.UIParser.TimeParser;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;

public class Session implements Serializable {
    private LocalDateTime start;
    private LocalDateTime end;
    private String name;
    private String discription;
    private LocalTime timeSpent;



    public Session(String name) {
        this.start = LocalDateTime.now();
        this.name = name;
        this.discription = "No Description";
        this.timeSpent = null;
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

    public LocalTime getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(LocalTime timeSpent) {
        this.timeSpent = timeSpent;
    }


    public LocalDateTime getEnd() {
        return this.end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}

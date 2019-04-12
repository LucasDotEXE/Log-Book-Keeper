package sample.Log;

import java.time.LocalDateTime;

public class Sesion {
    private LocalDateTime start;
    private LocalDateTime end;
    private String name;
    private String discription;



    public Sesion(String name) {
        this.start = LocalDateTime.now();
        this.name = name;
    }
}

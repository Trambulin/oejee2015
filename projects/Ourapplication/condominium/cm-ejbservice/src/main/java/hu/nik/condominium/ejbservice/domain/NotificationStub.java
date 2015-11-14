package hu.nik.condominium.ejbservice.domain;


import java.sql.Date;

public class NotificationStub {
    private Long id;
    private String message;
    private Date date;
    private String answer;
    private Boolean completed;
    private String location;
    private int stairs;
    private int floors;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStairs() {
        return stairs;
    }

    public void setStairs(int stairs) {
        this.stairs = stairs;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public NotificationStub(Long id, String message, Date date, String answer, Boolean completed, String location, int stairs, int floors) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.answer = answer;
        this.completed = completed;
        this.location = location;
        this.stairs = stairs;
        this.floors = floors;
    }

    public NotificationStub(Long id, String message, Date date, String answer, Boolean completed) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.answer = answer;
        this.completed = completed;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}

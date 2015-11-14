package hu.nik.condominium.ejbservice.domain;


import java.sql.Date;

public class NotificationStub {
    private Long id;
    private String message;
    private Date date;
    private String answer;
    private Boolean completed;

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

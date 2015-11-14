package hu.nik.condominium.persistence.entity;

import hu.nik.condominium.persistence.parameter.NotificationParameter;
import hu.nik.condominium.persistence.query.NotificationQuery;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "notification")
@NamedQueries(value = {
        @NamedQuery(name = NotificationQuery.GET_BY_ID, query = "SELECT n FROM Notification n where n.id=:" + NotificationParameter.ID),
        @NamedQuery(name = NotificationQuery.GET_ALL, query = "SELECT n FROM Notification n ORDER BY n.id"),
        @NamedQuery(name = NotificationQuery.GET_BY_OWNER_ID, query = "SELECT n FROM Notification n where n.condominiumOwner.owner.id=:"+ NotificationParameter.OWNERID+" ORDER BY n.id")})
public class Notification {


    @Id
    @SequenceGenerator(name = "generatorNotification", sequenceName = "notification_notification_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorNotification")
    @Column(name = "notification_id", nullable = false, insertable = false, updatable = false)
    private Long id;


    @Column(name = "notification_message", nullable = false)
    private String message;


    @Column(name = "notification_date",nullable = false)
    private Date date;

    @Column(name = "notification_answer", nullable = false)
    private String answer;


    @Column(name = "notification_completed", nullable = false)
    private Integer completed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "condominium_owner_id", referencedColumnName = "condominium_owner_id")
    private  CondominiumOwner condominiumOwner;

    public CondominiumOwner getCondominiumOwner() {
        return condominiumOwner;
    }

    public void setCondominiumOwner(CondominiumOwner condominiumOwner) {
        this.condominiumOwner = condominiumOwner;
    }

    public void setCompleted(Integer completed) {
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

    public Boolean getCompleted() {
        return completed==1;
    }

    public void setCompleted(Boolean completed) {
        if(completed)
            this.completed=1;
        else
            this.completed=0;
    }
}

package hu.nik.condominium.persistence.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "repair")
public class Repair {

    @Id
    @SequenceGenerator(name = "generatorRepair", sequenceName = "repair_repair_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorRepair")
    @Column(name = "repair_id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @ManyToOne(targetEntity = Condominium.class)
    @JoinColumn(name = "repair_con_id", nullable = false)
    private Condominium condominium;

    @Column(name = "repair_price", nullable = false)
    private Long price;

    @Column(name = "repair_description")
    private String description;

    @Column(name = "repair_date", nullable = false)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Condominium getCondominium() {
        return condominium;
    }

    public void setCondominium(Condominium condominium) {
        this.condominium = condominium;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
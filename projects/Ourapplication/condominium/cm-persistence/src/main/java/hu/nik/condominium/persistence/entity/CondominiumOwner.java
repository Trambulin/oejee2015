package hu.nik.condominium.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "condominium_owner")
public class CondominiumOwner {

    @Id
    @SequenceGenerator(name = "generatorCondominiumOwner", sequenceName = "condominium_owner_condominium_owner_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCondominiumOwner")
    @Column(name = "condominium_owner_id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @ManyToOne(targetEntity = Owner.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "c_owner_id", nullable = false)
    private Owner owner;

    @ManyToOne(targetEntity = Condominium.class)
    @JoinColumn(name = "condominium_id", referencedColumnName = "condominium_id", nullable = false)
    private Condominium condominium;

    @Column(name = "stair", nullable = false)
    private Integer stairs;

    @Column(name = "door", nullable = false)
    private Integer doors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Condominium getCondominium() {
        return condominium;
    }

    public void setCondominium(Condominium condominium) {
        this.condominium = condominium;
    }

    public Integer getStairs() {
        return stairs;
    }

    public void setStairs(Integer stairs) {
        this.stairs = stairs;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }


}

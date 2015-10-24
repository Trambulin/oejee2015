package hu.nik.condominium.persistence.entity;

import hu.nik.condominium.persistence.parameter.OwnerParameter;
import hu.nik.condominium.persistence.query.OwnerQuery;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "c_owner")
@NamedQueries(value = {
        @NamedQuery(name = OwnerQuery.GET_BY_ID, query = "SELECT o FROM Owner o where o.id=:" + OwnerParameter.ID),
        @NamedQuery(name = OwnerQuery.GET_ALL, query = "SELECT o FROM Owner o ORDER BY o.id")})
public class Owner {

    @Id
    @SequenceGenerator(name = "generatorOwner", sequenceName = "c_owner_c_owner_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorOwner")
    @Column(name = "c_owner_id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "c_owner_name", nullable = false)
    private String name;

    @Column(name = "c_owner_birt_date")
    private Date birthDate;

    @Column(name = "c_owner_gender", nullable = false)    //TODO: change it to enumeration
    private String gender;

    @Column(name = "c_owner_phone", nullable = false)
    private String phone;

    @Column(name = "c_owner_e_mail", nullable = false)
    private String email;

    //javax.ejb.EJBTransactionRolledbackException: failed to lazily initialize a collection
    // of role: hu.nik.condominium.persistence.entity.Owner.condominiums, could not initialize proxy - no Session
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "condominium_owner",
            joinColumns = {@JoinColumn(name = "owner_id", referencedColumnName = "c_owner_id")},
            inverseJoinColumns = {@JoinColumn(name = "condominium_id", referencedColumnName = "condominium_id")})
    private List<Condominium> condominiums;

    public List<Condominium> getCondominiums() {
        return condominiums;
    }

    public void setCondominiums(List<Condominium> condominiums) {
        this.condominiums = condominiums;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

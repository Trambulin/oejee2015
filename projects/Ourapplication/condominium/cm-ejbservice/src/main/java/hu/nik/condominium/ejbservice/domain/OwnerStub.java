package hu.nik.condominium.ejbservice.domain;

import java.util.List;

public class OwnerStub {

    private List<CondominiumStub> condominiumOwnerStub;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private Long id;

    public OwnerStub(Long id,String name, String gender, String phone, String email, List<CondominiumStub> condominiumOwnerStub) {
        this.id=id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.condominiumOwnerStub=condominiumOwnerStub;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CondominiumStub> getCondominiumOwnerStub() {
        return condominiumOwnerStub;
    }

    public List<CondominiumStub> getCondominiumStub() {
        return condominiumOwnerStub;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

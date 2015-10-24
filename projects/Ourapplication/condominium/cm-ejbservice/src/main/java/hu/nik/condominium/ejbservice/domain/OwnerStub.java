package hu.nik.condominium.ejbservice.domain;

public class OwnerStub {

    public OwnerStub(String name, String gender, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    private String name;
    private String gender;
    private String phone;
    private String email;

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

package hu.nik.condominium.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "c_user")
public class User {

    @Id
    @Column(name = "c_user_login",nullable = false)
    private String loginName;

    @Column(name = "c_user_pass",nullable = false)
    private String password;

    @Column(name = "c_user_e_mail",nullable = false)
    private String email;

    @Column(name = "c_user_full_name", nullable = false)
    private String fullName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}

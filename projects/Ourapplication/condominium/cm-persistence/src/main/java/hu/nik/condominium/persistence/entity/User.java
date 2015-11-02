package hu.nik.condominium.persistence.entity;

import javax.persistence.*;

import hu.nik.condominium.persistence.parameter.OwnerParameter;
import hu.nik.condominium.persistence.parameter.UserParameter;
import hu.nik.condominium.persistence.query.OwnerQuery;
import hu.nik.condominium.persistence.query.UserQuery;

@Entity
@Table(name = "c_user")
@NamedQueries(value = {
        @NamedQuery(name = UserQuery.GET_BY_LOGIN, query = "SELECT u FROM User u where u.login=:" + UserParameter.LOGIN),
        @NamedQuery(name = UserQuery.GET_ALL, query = "SELECT u FROM User u User BY u.login")})
public class User {

	@id
    @SequenceGenerator(name = "generatorUser", sequenceName = "c_user_c_user_login_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorUser")
	
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

package hu.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import hu.persistence.parameter.CustomerParameter;
import hu.persistence.query.CustomerQuery;

@Entity
@Table(name = "customer")
@NamedQueries(value = {  //
		@NamedQuery(name = CustomerQuery.GET_BY_ID, query = "SELECT b FROM Customer b WHERE b.id=:" + CustomerParameter.ID),
		@NamedQuery(name = CustomerQuery.GET_BY_NAME, query = "SELECT b FROM Customer b WHERE b.name=:" + CustomerParameter.NAME),
		@NamedQuery(name = CustomerQuery.GET_BY_LOGIN_NAME, query = "SELECT b FROM Customer b WHERE b.login_name=:" + CustomerParameter.LOGIN_NAME),
		@NamedQuery(name = CustomerQuery.GET_ALL, query = "SELECT b FROM Customer b ORDER BY b.name")
		//
})
public class Customer implements Serializable{

	private static final long serialVersionUID = 834912717308495336L;
	
	@Id
	@Column(name = "customer_id", nullable = false, updatable = false, insertable = true)
	private Long id;
	
	@Column(name = "customer_name", nullable = false)
	private String name;

	@Column(name = "customer_login_name", nullable = false)
	private String login_name;

	@Column(name = "customer_passwd", nullable = false)
	private String passwd;
	
	public Customer() {
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

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + this.id + ", name=" + this.name + ", login name=" + this.login_name + "]";
	}
}
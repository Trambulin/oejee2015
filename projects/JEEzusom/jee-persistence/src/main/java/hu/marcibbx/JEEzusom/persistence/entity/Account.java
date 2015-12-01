package hu.marcibbx.JEEzusom.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import hu.marcibbx.JEEzusom.persistence.parameter.AccountParameter;
import hu.marcibbx.JEEzusom.persistence.query.AccountQuery;

@Entity
@Table(name = "account")
@NamedQueries(value = { //
		@NamedQuery(name = AccountQuery.COUNT_BY_EMAIL, query = "SELECT COUNT(s) FROM Account s WHERE s.email=:" + AccountParameter.EMAIL),
		@NamedQuery(name = AccountQuery.GET_BY_EMAIL, query = "SELECT s FROM Account s WHERE s.email=:" + AccountParameter.EMAIL),
		@NamedQuery(name = AccountQuery.GET_BY_ID, query = "SELECT s FROM Account s WHERE s.accountId=:" + AccountParameter.ACCOUNT_ID),
		@NamedQuery(name = AccountQuery.GET_ALL, query = "SELECT s FROM Account s ORDER BY s.name"),
		@NamedQuery(name = AccountQuery.REMOVE_BY_ID, query = "DELETE FROM Account s WHERE s.accountId=:" + AccountParameter.ACCOUNT_ID),
		@NamedQuery(name = AccountQuery.REMOVE_BY_NAME, query = "DELETE FROM Account s WHERE s.name=:" + AccountParameter.NAME)
		//
})
public class Account implements Serializable {

	private static final long serialVersionUID = -6461691410947537135L;

	@Id
	@SequenceGenerator(name = "generatorAccount", sequenceName = "account_account_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorAccount")
	@Column(name = "account_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "is_activated", nullable = false)
	private Boolean isActivated;
	
	@Column(name = "warn_count", nullable = false)
	private Integer warnCount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ban_expire", nullable = false)
	private Date banExpire;

	//@OneToMany(fetch = FetchType.LAZY, targetEntity = Mark.class, mappedBy = "student")
	//private final Set<Mark> marks;

	public Account() {
		
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*public Institute getInstitute() {
		return this.institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public Set<Mark> getMarks() {
		return this.marks;
	}*/

	@Override
	public String toString() {
		return "Account [accountId=" + this.id + ", name=" + this.name + ", email=" + this.email + "]";
	}

}
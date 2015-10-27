package hu.sas.persistance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User_account")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520261407084260103L;
	
	@Id
	@SequenceGenerator(name = "generatorUser", sequenceName = "user_user_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorUser")
	@Column(name = "UserID", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Column(name = "FirstName", nullable = false)
	private String firstName;
	
	@Column(name = "LastName", nullable = false)
	private String lastName;
	
	@Column(name = "BirthDate", nullable = false)
	private Date birthDate;
	
	@Column(name = "Height", nullable = false)
	private int height;
	
	@Column(name = "Weight", nullable = false)
	private int weight;
	
	@Column(name = "Sex", nullable = false)
	private boolean sex;
	
	public User() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "User_account [UserID=" + id + ", FirstName=" + firstName + ", LastName=" + lastName + 
				", BirthDate=" + birthDate + ", Height=" + height + ", Weight=" + weight + ", Sex=" + sex + "]";
	}
	
	
}

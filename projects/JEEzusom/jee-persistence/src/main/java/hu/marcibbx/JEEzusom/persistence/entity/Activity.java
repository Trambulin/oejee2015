package hu.marcibbx.JEEzusom.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import hu.marcibbx.JEEzusom.persistence.parameter.ActivityParameter;
//import hu.marcibbx.JEEzusom.persistence.query.ActivityQuery;

@Entity
@Table(name = "activity")

public class Activity implements Serializable {

	private static final long serialVersionUID = 6159250760580178806L;

	@Id
	@SequenceGenerator(name = "generatorActivity", sequenceName = "activity_activity_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorActivity")
	@Column(name = "activity_id", nullable = false)
	private Long id;

	@Column(name = "character_id", nullable = false)
	private Long characterId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "login_date", nullable = false)
	private Date loginDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "logout_date", nullable = false)
	private Date logoutDate;
	
	@Column(name = "ip_address", nullable = false)
	private String ipAddress;

	public Activity() {
		this(null);
	}

	public Activity(String ipAddress) {
	
		this.ipAddress = ipAddress;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCharacterId() {
		return this.characterId;
	}

	public void setCharacterId(Long characterId) {
		this.characterId = characterId;
	}

	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}




	@Override
	public String toString() {
		return "Activity [id=" + this.id + ", characterId=" + this.characterId + ", ipAddress=" + this.ipAddress + "]";
	}

}

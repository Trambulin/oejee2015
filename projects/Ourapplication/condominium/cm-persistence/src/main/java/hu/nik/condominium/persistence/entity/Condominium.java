package hu.nik.condominium.persistence.entity;

import hu.nik.condominium.persistence.parameter.CondominiumParameter;
import hu.nik.condominium.persistence.query.CondominiumQuery;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
//import java.util.Date;

@Entity
@Table(name = "condominium")
@NamedQueries(value = { //
		@NamedQuery(name = CondominiumQuery.GET_BY_FLOORS, query = "SELECT c FROM Condominium c WHERE c.floors=:" + CondominiumParameter.FLOOR),
		@NamedQuery(name = CondominiumQuery.READ_BY_FILTER, query = "SELECT c FROM Condominium c WHERE c.type.name=:" + CondominiumParameter.TYPE_NAME
				+ " AND c.floors BETWEEN :" + CondominiumParameter.MIN_FLOOR + " AND :" + CondominiumParameter.MAX_FLOOR +" AND c.type.id=:"+CondominiumParameter.ID),
		@NamedQuery(name = CondominiumQuery.GET_BY_ID, query = "SELECT c FROM Condominium c WHERE c.id=:" + CondominiumParameter.ID),
		@NamedQuery(name = CondominiumQuery.GET_ALL, query = "SELECT c FROM Condominium c ORDER BY c.id") })
//
public class Condominium implements Serializable {

	private static final long serialVersionUID = 666L;

	public Condominium() {
		// TODO Auto-generated constructor stub
	}
	public Condominium(String location, int floors, Date date, CondominiumType condominiumType){
		this.location=location;
		this.floors=floors;
		this.buildYear=date;
		this.type=condominiumType;
	}
	@Id
	@SequenceGenerator(name = "generatorCondominium", sequenceName = "condominium_condominium_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCondominium")
	@Column(name = "condominium_id", nullable = false,updatable = false, insertable = false)
	private Long id;

	@Column(name = "condominium_loc", nullable = false)
	private String location;

	@Column(name = "condominium_floors", nullable = false)
	private Integer floors;

	@Column(name = "condominium_build_year", nullable = false)
	private Date buildYear;

	@ManyToOne(targetEntity = CondominiumType.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(referencedColumnName = "c_type_id", name = "condominium_type", nullable = false)
	private CondominiumType type;

	@Override
	public String toString() {
		//return "Id: " + this.id + ", location: " + this.location + ", floors: " + this.floors + ",year of build: " + this.buildYear;
		return  "Condominium [id=" + this.id + ", type=" + this.type + ", location=" + this.location + ", floors=" + this.floors + ", year of build=" + this.buildYear + "]";
	}
	public CondominiumType getType() {
		return this.type;
	}

	public void setType(CondominiumType type) {
		this.type = type;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getFloors() {
		return this.floors;
	}

	public void setFloors(Integer floors) {
		this.floors = floors;
	}

	public Date getBuildYear() {
		return this.buildYear;
	}

	public void setBuildYear(Date buildYear) {
		this.buildYear = buildYear;
	}
}

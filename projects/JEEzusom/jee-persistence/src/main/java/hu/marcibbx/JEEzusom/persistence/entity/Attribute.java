package hu.marcibbx.JEEzusom.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.marcibbx.JEEzusom.persistence.parameter.AttributeParameter;
//import hu.marcibbx.JEEzusom.persistence.query.AttributeQuery;

@Entity
@Table(name = "attribute")

public class Attribute implements Serializable {

	private static final long serialVersionUID = -4009404864018025745L;

	@Id
	@SequenceGenerator(name = "generatorAttribute", sequenceName = "attribute_attribute_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorAttribute")
	@Column(name = "attribute_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "attribute_name", nullable = false)
	private String name;

	public Attribute() {

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

	@Override
	public String toString() {
		return "Attribute [id=" + this.id + ", name=" + this.name + "]";
	}

}

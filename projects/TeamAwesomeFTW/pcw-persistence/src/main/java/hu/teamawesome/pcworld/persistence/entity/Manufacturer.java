package hu.teamawesome.pcworld.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
public class Manufacturer implements Serializable
{
	private static final long serialVersionUID = -1744926308793163373L;
	
	@Id
	@SequenceGenerator(name = "generatorManufacturer", sequenceName = "manufacturer_mf_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorManufacturer")
	@Column(name = "mf_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Column(name = "mf_name", nullable = false)
	private String name;
	
	@Column(name = "mf_telephone", nullable = false)
	private String telephone;
	
	
	public Manufacturer() {

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

	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + this.id + ", name=" + this.name + ", telephone=" + this.telephone + "]";
	}
}

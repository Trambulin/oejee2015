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
@Table(name = "product_type")
public class Type implements Serializable
{
	private static final long serialVersionUID = -1744926308793163373L;
	
	@Id
	@SequenceGenerator(name = "generatorProductType", sequenceName = "product_type_pdt_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorProductType")
	@Column(name = "pdt_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Column(name = "pdt_name", nullable = false)
	private String name;
	
	
	public Type() {

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


	@Override
	public String toString() {
		return "ProductType [id=" + this.id + ", name=" + this.name + "]";
	}
}

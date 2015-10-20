package hu.nik.condominium.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "c_type")
public class CondominiumType {

	@Id
	@SequenceGenerator(name = "generatorCondominiumType", sequenceName = "c_type_c_type_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCondominiumType")
	@Column(name = "c_type_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "c_type_name", nullable = false)
	private String name;

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "c_type_id") public List<Condominium> condominiums;
	 */
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
}

package hu.nik.condominium.persistence.entity;

import hu.nik.condominium.persistence.parameter.CondominiumTypeParameter;
import hu.nik.condominium.persistence.query.TypeQuery;

import javax.persistence.*;

@Entity
@Table(name = "c_type")
@NamedQueries(value = {
		@NamedQuery(name = TypeQuery.GET_BY_NAME, query = "SELECT c FROM CondominiumType c where c.name=:" + CondominiumTypeParameter.NAME),
		@NamedQuery(name = TypeQuery.GET_BY_ID, query = "SELECT c FROM CondominiumType c where c.id=:" + CondominiumTypeParameter.ID)
})

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

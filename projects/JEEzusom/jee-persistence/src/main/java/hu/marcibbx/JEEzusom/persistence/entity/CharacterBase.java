package hu.marcibbx.JEEzusom.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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


import hu.marcibbx.JEEzusom.persistence.parameter.CharacterBaseParameter;
import hu.marcibbx.JEEzusom.persistence.query.CharacterBaseQuery;

@Entity
@Table(name = "character_base")
@NamedQueries(value = { //
		@NamedQuery(name = CharacterBaseQuery.COUNT_BY_ACCOUNT_ID, query = "SELECT COUNT(s) FROM CharacterBase s WHERE s.account_id=:" + CharacterBaseParameter.ACCOUNT_ID),
		@NamedQuery(name = CharacterBaseQuery.GET_BY_ACCOUNT_ID, query = "SELECT s FROM CharacterBase s WHERE s.account_id=:" + CharacterBaseParameter.ACCOUNT_ID),
		@NamedQuery(name = CharacterBaseQuery.GET_BY_NAME, query = "SELECT s FROM CharacterBase s WHERE s.name=:" + CharacterBaseParameter.NAME),
		@NamedQuery(name = CharacterBaseQuery.GET_BY_ID, query = "SELECT s FROM CharacterBase s WHERE s.character_id=:" + CharacterBaseParameter.CHARACTER_ID),
		@NamedQuery(name = CharacterBaseQuery.GET_ALL, query = "SELECT s FROM CharacterBase s ORDER BY s.name"),
		@NamedQuery(name = CharacterBaseQuery.REMOVE_BY_NAME, query = "DELETE FROM CharacterBase s WHERE s.name=:" + CharacterBaseParameter.NAME)
		//
})
public class CharacterBase implements Serializable {

	private static final long serialVersionUID = -6461691410947537135L;

	@Id
	@SequenceGenerator(name = "generatorCharacterBase", sequenceName = "character_base_character_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCharacterBase")
	@Column(name = "character_id", nullable = false, updatable = false, insertable = false)
	private Long character_id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "account_id", nullable = false)
	private Long  account_id;

	@Column(name = "money_amount", nullable = false)
	private Integer moneyAmount;

	@Column(name = "experience", nullable = false)
	private Long experience;
	
	@Column(name = "race_id", nullable = false)
	private Long raceId;
	
	@Column(name = "is_male", nullable = false)
	private Boolean isMale;
	
	
	
	public CharacterBase()
	{
		
		
	}
	public CharacterBase(String name, Long accountId, Long raceId, Boolean isMale) {

	}

	public Long getId() {
		return this.character_id;
	}

	public void setId(Long id) {
		this.account_id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAccountId() {
		return this.account_id;
	}

	public Long getRaceId() {
		return this.raceId;
	}

	public Boolean getIsMale() {
		return this.isMale;
	}

	public void setAccountId(Long account_id) {
		this.account_id = account_id;
	}
	
	public Long getExperience() {
		return this.experience;
	}

	public void setExperience(Long experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "CharacterBase [id=" + this.character_id + ", name=" + this.name + ", experience=" + this.experience + "]";
	}

}

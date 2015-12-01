package hu.marcibbx.JEEzusom.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "character_race")
public class CharacterRace implements Serializable {

	private static final long serialVersionUID = -1744926308793163373L;

	@Id
	@SequenceGenerator(name = "generatorCharacterRace", sequenceName = "character_race_character_race_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCharacterRace")
	@Column(name = "characterRace_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "bonus_attribute", nullable = false)
	private String bonusAttribute;

	public CharacterRace() {

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

	public String getBonusAttribute() {
		return this.bonusAttribute;
	}

	public void setBonusAttribute(String bonusAttribute) {
		this.bonusAttribute = bonusAttribute;
	}

	@Override
	public String toString() {
		return "CharacterRace [id=" + this.id + ", name=" + this.name + ", bonusAttribute=" + this.bonusAttribute + "]";
	}

}

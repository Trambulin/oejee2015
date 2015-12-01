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
@Table(name = "character_attr")
public class CharacterAttr implements Serializable {

	private static final long serialVersionUID = -1744926308793163373L;

	@Id
	@SequenceGenerator(name = "generatorCharacterAttr", sequenceName = "character_attr_character_attr_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorCharacterAttr")
	@Column(name = "characterAttr_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "character_id", nullable = false)
	private Long characterId;

	@Column(name = "attribute_id", nullable = false)
	private Integer attributeId;

	public CharacterAttr() {

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

	public Integer getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(Integer attributeId) {
		this.attributeId = attributeId;
	}

	@Override
	public String toString() {
		return "CharacterAttr [id=" + this.id + ", attributeId=" + this.attributeId + "]";
	}

}

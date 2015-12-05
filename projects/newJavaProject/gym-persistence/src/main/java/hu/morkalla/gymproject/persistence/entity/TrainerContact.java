package hu.morkalla.gymproject.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "trainer_contact")
public class TrainerContact {

	@Id
	@SequenceGenerator(name = "generatorTrainerContact", sequenceName = "trainer_contact_trainer_contact_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTrainerContact")
	@Column(name = "trainer_contact_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trainer_contact_trainer_id", referencedColumnName = "trainer_id", nullable = false)
	private Trainer trainer;

	@Column(name = "trainer_contact_type", nullable = false)
	private String type;

	@Column(name = "trainer_contact_value", nullable = false)
	private String value;

	@Override
	public String toString() {
		return "TrainerContact [type=" + type + ", value=" + value + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

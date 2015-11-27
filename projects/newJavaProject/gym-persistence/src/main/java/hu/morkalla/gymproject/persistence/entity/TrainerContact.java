package hu.morkalla.gymproject.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "trainer_contact_trainer_id", nullable = false)
	private String trainerId;

	@Column(name = "trainer_contact_type", nullable = false)
	private String type;

	@Column(name = "trainer_contact_value", nullable = false)
	private String value;

}

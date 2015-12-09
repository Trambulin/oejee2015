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
@Table(name = "trainer_qualification")
public class TrainerQualification {

	@Id
	@SequenceGenerator(name = "generatorTrainerQualification", sequenceName = "trainer_qualification_trainer_qualification_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTrainerQualification")
	@Column(name = "trainer_qualification_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trainer_qualification_trainer_id", referencedColumnName = "trainer_id", nullable = false)
	private Trainer trainerq;

	@Column(name = "trainer_qualification_name", nullable = false)
	private String name;

	@Column(name = "trainer_qualification_level", nullable = false)
	private String level;

	@Column(name = "trainer_qualification_year", nullable = false)
	private Integer year;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trainer getTrainerq() {
		return trainerq;
	}

	public void setTrainerq(Trainer trainerq) {
		this.trainerq = trainerq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "TrainerQualification [name=" + name + ", level=" + level + ", year=" + year + "]";
	}

}

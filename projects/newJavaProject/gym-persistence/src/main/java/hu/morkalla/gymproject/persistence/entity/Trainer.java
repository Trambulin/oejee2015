package hu.morkalla.gymproject.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import hu.morkalla.gymproject.persistence.parameter.TrainerParameter;
import hu.morkalla.gymproject.persistence.query.TrainerQuery;

@Entity
@Table(name = "trainer")
@NamedQueries(value = { //
		@NamedQuery(name = TrainerQuery.GET_BY_NAME, query = "SELECT t FROM trainer t WHERE t.name=:" + TrainerParameter.NAME),
		@NamedQuery(name = TrainerQuery.GET_BY_ID, query = "SELECT t FROM trainer t WHERE t.id=:" + TrainerParameter.ID),
		@NamedQuery(name = TrainerQuery.GET_ALL, query = "SELECT t FROM trainer t ORDER BY t.name")
		//
})
public class Trainer implements Serializable {

	private static final long serialVersionUID = 5603805760168472535L;

	@Id
	@SequenceGenerator(name = "generatorTrainer", sequenceName = "trainer_trainer_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTrainer")
	@Column(name = "trainer_id", nullable = false, updatable = false, insertable = false)
	private Long id;

	@Column(name = "trainer_name", nullable = false)
	private String name;

	@Column(name = "trainer_height", nullable = false)
	private Integer height;

	@Column(name = "trainer_weight", nullable = false)
	private Integer weight;

	public Trainer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer trainer_height) {
		this.height = trainer_height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", trainer_height=" + height + ", weight=" + weight + "]";
	}

}

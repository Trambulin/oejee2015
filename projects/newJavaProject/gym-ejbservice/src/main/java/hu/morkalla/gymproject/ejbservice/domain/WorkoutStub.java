package hu.morkalla.gymproject.ejbservice.domain;

public class WorkoutStub {

	private String name;
	private String hardness;
	private Integer people;
	private String requipment;
	private TrainerStub trainer;
	private String typeName;

	public WorkoutStub() {

	}

	public WorkoutStub(String name, String hardness, Integer people, String requipment, TrainerStub trainer, String typeName) {
		super();
		this.name = name;
		this.hardness = hardness;
		this.people = people;
		this.requipment = requipment;
		this.trainer = trainer;
		this.typeName = typeName;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHardness() {
		return hardness;
	}

	public void setHardness(String hardness) {
		this.hardness = hardness;
	}

	public Integer getPeople() {
		return people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	public String getRequipment() {
		return requipment;
	}

	public void setRequipment(String requipment) {
		this.requipment = requipment;
	}

	public TrainerStub getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerStub trainer) {
		this.trainer = trainer;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "WorkoutStub [name=" + name + ", hardness=" + hardness + ", people=" + people + ", requipment=" + requipment + ", trainer=" + trainer
				+ ", typeName=" + typeName + "]";
	}

}

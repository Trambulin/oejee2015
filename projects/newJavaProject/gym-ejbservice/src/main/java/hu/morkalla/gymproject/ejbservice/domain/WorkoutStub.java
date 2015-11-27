package hu.morkalla.gymproject.ejbservice.domain;

public class WorkoutStub {

	private String name;
	private String hardness;
	private Integer people;
	private String requipment;
	private String trainerName;
	private String typeName;

	public WorkoutStub() {

	}

	public WorkoutStub(String name, String hardness, Integer people, String requipment, String trainerName, String typeName) {
		super();
		this.name = name;
		this.hardness = hardness;
		this.people = people;
		this.requipment = requipment;
		this.trainerName = trainerName;
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

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "WorkoutStub [name=" + name + ", hardness=" + hardness + ", people=" + people + ", requipment=" + requipment + ", trainerName=" + trainerName
				+ ", typeName=" + typeName + "]";
	}

}

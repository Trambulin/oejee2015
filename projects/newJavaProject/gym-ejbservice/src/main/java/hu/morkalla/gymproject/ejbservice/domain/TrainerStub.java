package hu.morkalla.gymproject.ejbservice.domain;

import java.util.List;

public class TrainerStub {

	private String name;
	private Integer height;
	private Integer weight;
	private List<TrainerContactStub> trainerContacts;
	private List<TrainerQualificationStub> trainerQualifications;

	public TrainerStub() {

	}

	public TrainerStub(String name, Integer height, Integer weight, List<TrainerContactStub> contacts, List<TrainerQualificationStub> qualification) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.setTrainerContacts(contacts);
		this.setTrainerQualifications(qualification);
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

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<TrainerContactStub> getTrainerContacts() {
		return trainerContacts;
	}

	public void setTrainerContacts(List<TrainerContactStub> trainerContacts) {
		this.trainerContacts = trainerContacts;
	}

	public List<TrainerQualificationStub> getTrainerQualifications() {
		return trainerQualifications;
	}

	public void setTrainerQualifications(List<TrainerQualificationStub> trainerQualifications) {
		this.trainerQualifications = trainerQualifications;
	}

	@Override
	public String toString() {
		return "TrainerStub [name=" + name + ", height=" + height + ", weight=" + weight + ", trainerContacts=" + trainerContacts + ", trainerQualifications="
				+ trainerQualifications + "]";
	}

}

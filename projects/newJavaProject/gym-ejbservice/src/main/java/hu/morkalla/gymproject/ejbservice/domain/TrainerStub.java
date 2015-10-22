package hu.morkalla.gymproject.ejbservice.domain;

public class TrainerStub {

	String name;
	Integer height;
	Integer weight;

	public TrainerStub() {

	}

	public TrainerStub(String name, Integer height, Integer weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
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

	@Override
	public String toString() {
		return "TrainerStub [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}

}

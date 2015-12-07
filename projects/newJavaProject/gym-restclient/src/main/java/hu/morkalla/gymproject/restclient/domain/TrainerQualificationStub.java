package hu.morkalla.gymproject.restclient.domain;

public class TrainerQualificationStub {

	private String name;
	private String level;
	private Integer Year;

	public TrainerQualificationStub(String name, String level, Integer year) {
		super();
		this.name = name;
		this.level = level;
		Year = year;
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
		return Year;
	}

	public void setYear(Integer year) {
		Year = year;
	}

	@Override
	public String toString() {
		return "TrainerQualificationStub [name=" + name + ", level=" + level + ", Year=" + Year + "]";
	}

}

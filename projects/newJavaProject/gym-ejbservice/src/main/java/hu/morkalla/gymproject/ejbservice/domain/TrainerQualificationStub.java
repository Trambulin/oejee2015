package hu.morkalla.gymproject.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "qualification")
public class TrainerQualificationStub {

	private String name;
	private String level;
	private Integer Year;

	public TrainerQualificationStub() {
	}

	public TrainerQualificationStub(String name, String level, Integer year) {
		super();
		this.name = name;
		this.level = level;
		Year = year;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "level")
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@XmlElement(name = "year")
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

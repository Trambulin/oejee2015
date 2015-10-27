package hu.sas.persistance.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Day")

public class Day implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8617046600321992119L;
	
	@Id
	@SequenceGenerator(name = "generatorDay", sequenceName = "day_day_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorDay")
	@Column(name = "DateID", nullable = false, updatable = false, insertable = false)
	private Date id;
	
	@Column(name = "Tempreature", nullable = false)
	private int temperature;
	
	@Column(name = "FrontImpact", nullable = false)
	private String frontImpact;
	
	@Column(name = "Humidity", nullable = false)
	private int humidity;
	
	@Column(name = "Rain", nullable = false)
	private boolean rain;
	
	public Day() {}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public String getFrontImpact() {
		return frontImpact;
	}

	public void setFrontImpact(String frontImpact) {
		this.frontImpact = frontImpact;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public boolean isRain() {
		return rain;
	}

	public void setRain(boolean rain) {
		this.rain = rain;
	}

	public Date getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Day [DateID=" + id + ", Tempreature=" + temperature + ", FrontImpact=" + frontImpact + 
				", Humidity=" + humidity + ", Rain=" + rain + "]";
		
	}

}

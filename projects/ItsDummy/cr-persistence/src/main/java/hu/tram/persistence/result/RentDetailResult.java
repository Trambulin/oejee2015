package hu.tram.persistence.result;

import java.util.Date;

import hu.tram.persistence.entity.trunk.Brand;

public class RentDetailResult {

	private final Brand brand;

	private final Date year;

	private final double averagePrice;

	public RentDetailResult(Brand brand, Date year, double averagePrice) {
		this.brand = brand;
		this.year = year;
		this.averagePrice = averagePrice;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public Date getYear() {
		return this.year;
	}

	public double getAveragePrice() {
		return this.averagePrice;
	}

	@Override
	public String toString() {
		return "RentDetailResult [brand=" + this.brand + ", year=" + this.year + ", averagePrice=" + this.averagePrice + "]";
	}
}

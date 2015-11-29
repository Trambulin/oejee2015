package hu.tram.ejbservice.domain;

public class RentDetailStub {

	private final String brand;

	private final int year;

	private final double averagePrice;

	public RentDetailStub(String brand, int year, double averagePrice) {
		this.brand = brand;
		this.year = year;
		this.averagePrice = averagePrice;
	}

	public String getBrand() {
		return this.brand;
	}

	public int getYear() {
		return this.year;
	}

	public double getAveragePrice() {
		return this.averagePrice;
	}

	@Override
	public String toString() {
		return "RentDetailStub [brand=" + this.brand + ", year=" + this.year + ", averagePrice=" + this.averagePrice + "]";
	}
}

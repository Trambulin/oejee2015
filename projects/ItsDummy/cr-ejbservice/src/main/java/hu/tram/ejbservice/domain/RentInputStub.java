package hu.tram.ejbservice.domain;

public class RentInputStub {

	private final String customerLogin;
	private final int carId;
	private final Interval interval;

	public RentInputStub() {
		this(null, 0, null);
	}

	public RentInputStub(String customerLogin, int carId, Interval interval) {
		super();
		this.customerLogin = customerLogin;
		this.carId = carId;
		this.interval = interval;
	}

	public String getCustomerLogin() {
		return this.customerLogin;
	}

	public int getCarId() {
		return this.carId;
	}

	public Interval getInterval() {
		return this.interval;
	}

	@Override
	public String toString() {
		return "RentInputStub [customerLogin=" + this.customerLogin + ", carId=" + this.carId + ", interval=" + this.interval + "]";
	}
}

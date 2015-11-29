package hu.tram.ejbservice.domain;

public enum Interval {
	SHORT(1),
	MIDSHORT(3),
	MEDIUM(6),
	LONG(12),
	EXTRA(60);

	private final int value;

	private Interval(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}

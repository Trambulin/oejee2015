package hu.ejbservice.domain;

import java.sql.Date;

public class CarStub {
	private BrandStub brand;
	private String model;
    private String fuel;
    private String color;
    private double price;
    private Date production;

    public CarStub() {
        this(null, null, null, null, 0, null);
    }

    public CarStub(BrandStub brand, String model, String fuel, String color, double price, Date production) {
        super();
        this.setBrand(brand);
        this.setModel(model);
        this.setFuel(fuel);
        this.setColor(color);
        this.setPrice(price);
        this.setProduction(production);
    }

	public BrandStub getBrand() {
		return brand;
	}

	public void setBrand(BrandStub brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getProduction() {
		return production;
	}

	public void setProduction(Date production) {
		this.production = production;
	}
	
    @Override
    public String toString() {
        return "CarStub [brand=" + brand + ", model=" + model + ", fuel=" + fuel + ", color=" + color + ", price=" + price + ", production date=" + production + "]";
    }
}

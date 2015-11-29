package hu.tram.ejbservice.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "car")
public class CarStub {
	private Long id;
	private BrandStub brand;
	private String model;
    private String fuel;
    private String color;
    private double price;
    private Date production;

    public CarStub() {
        this(null, null, null, null, null, 0, null);
    }

    public CarStub(Long id, BrandStub brand, String model, String fuel, String color, double price, Date production) {
        super();
        this.setId(id);
        this.setBrand(brand);
        this.setModel(model);
        this.setFuel(fuel);
        this.setColor(color);
        this.setPrice(price);
        this.setProduction(production);
    }

    @XmlElement(name = "brand")
	public BrandStub getBrand() {
		return brand;
	}

	public void setBrand(BrandStub brand) {
		this.brand = brand;
	}

	@XmlElement(name = "model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@XmlElement(name = "fuel")
	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	@XmlElement(name = "color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@XmlElement(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@XmlElement(name = "production_date")
	public Date getProduction() {
		return production;
	}

	public void setProduction(Date production) {
		this.production = production;
	}
	
    @Override
    public String toString() {
        return "CarStub [id="+getId()+", brand=" + brand + ", model=" + model + ", fuel=" + fuel + ", color=" + color + ", price=" + price + ", production date=" + production + "]";
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

package hu.tram.ejbservice.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cartype")
public class CartypeStub {
	private BrandStub brand;
	private String model;
	
	public CartypeStub() {
        this(null, null);
    }

    public CartypeStub(BrandStub brand, String model) {
        super();
        this.setBrand(brand);
        this.setModel(model);
    }

    @XmlElement(name = "model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@XmlElement(name = "brand")
	public BrandStub getBrand() {
		return brand;
	}

	public void setBrand(BrandStub brand) {
		this.brand = brand;
	}
	
	 @Override
	 public String toString() {
	     return "CarStub [brand=" + brand + ", model=" + model + "]";
	 }
}

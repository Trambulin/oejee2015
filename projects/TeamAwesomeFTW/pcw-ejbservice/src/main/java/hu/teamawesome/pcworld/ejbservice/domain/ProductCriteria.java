package hu.teamawesome.pcworld.ejbservice.domain;

public class ProductCriteria {
	
	private String name;
    private ProductManufacturerStub manufacturer;
    private ProductTypeStub type;
    private int minimumPrice;
    private int maximumPrice;
    
    public ProductCriteria() {
    }
    
    
    // NAME (contain part of string)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // MANUFACTURER
    public ProductManufacturerStub getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(ProductManufacturerStub manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    // TYPE
    public ProductTypeStub getCategory() {
        return type;
    }
    public void setCategory(ProductTypeStub type) {
        this.type = type;
    }
    
    // PRICE MIN
    public int getMinimumPrice() {
        return minimumPrice;
    }
    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    // PRICE MAX
    public int getMaximumPrice() {
        return maximumPrice;
    }
    public void setMaximumPrice(int maximumPrice) {
        this.maximumPrice = maximumPrice;
    }

    @Override
    public String toString() {
        return "ProductCriteriaStub [name=" + name +
        		", manufacturer=" + manufacturer +
        		", type=" + type +
        		", minimumPrice=" + minimumPrice +
        		", maximumPrice=" + maximumPrice + "]";
    }

}

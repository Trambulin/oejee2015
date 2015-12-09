package hu.teamawesome.pcworld.ejbservice.domain;

public class SupplierCriteria {
	
	private String name;
    private SupplierManufacturerStub manufacturer;
    private SupplierTypeStub type;
    private int minimumPrice;
    private int maximumPrice;
    
    public SupplierCriteria() {
    }
    
    
    // NAME (contain part of string)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // MANUFACTURER
    public SupplierManufacturerStub getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(SupplierManufacturerStub manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    // TYPE
    public SupplierTypeStub getCategory() {
        return type;
    }
    public void setCategory(SupplierTypeStub type) {
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
